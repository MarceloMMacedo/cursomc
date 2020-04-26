package com.digital.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.cursomc.domain.Produto;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Long> {
 
}
