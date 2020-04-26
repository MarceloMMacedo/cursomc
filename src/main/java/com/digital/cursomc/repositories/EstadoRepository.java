package com.digital.cursomc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
 
//	Estado findById(long id);
}
