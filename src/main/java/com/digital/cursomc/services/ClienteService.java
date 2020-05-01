package com.digital.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.digital.cursomc.domain.Cidade;
import com.digital.cursomc.domain.Cliente;
import com.digital.cursomc.domain.Endereco;
import com.digital.cursomc.domain.enums.Perfil;
import com.digital.cursomc.dto.ClienteNewDTO;
import com.digital.cursomc.repositories.CidadeRepository;
import com.digital.cursomc.repositories.ClienteRepository;
import com.digital.cursomc.repositories.EnderecoRepository;
import com.digital.cursomc.security.UserSS;
import com.digital.cursomc.services.exceptions.AuthorizationException;
import com.digital.cursomc.services.exceptions.DataIntegrityException;
import com.digital.cursomc.services.util.UtilParameter;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder be;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Cliente find(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Cliente obj = repo.findById(id).get();
		if (obj == null) {
			throw new com.digital.cursomc.services.exceptions.ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		
		obj = repo.save(obj);
 		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(find(id));
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {
		Optional<Cidade> cid = cidadeRepository.findById(objDto.getCidadeId());
		Endereco endereco = (Endereco) UtilParameter.clonarentity(objDto, new Endereco(),
				new String[] { "contato", "logradouro", "numero", "complemento", "bairro", "cep" });
		
		endereco.setCidade(cid.get());

		Cliente cli = (Cliente) UtilParameter.clonarentity(objDto, new Cliente(),
				new String[] { "nome", "email", "tipo", });
		cli.setSenha(be.encode(objDto.getSenha()));
		endereco.setCliente(cli);
		cli.getEnderecos().add(endereco);

		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;

	}


	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

//	public URI uploadProfilePicture(MultipartFile multipartFile) {
//
//		UserSS user = UserService.authenticated();
//		if (user == null) {
//			throw new AuthorizationException("Acesso negado");
//		}
//
//		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
//		jpgImage = imageService.cropSquare(jpgImage);
//		jpgImage = imageService.resize(jpgImage, size);
//
//		String fileName = prefix + user.getId() + ".jpg";
//
//		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
//	}

}
