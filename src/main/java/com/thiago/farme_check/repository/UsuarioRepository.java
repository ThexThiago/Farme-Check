package com.thiago.farme_check.repository;

import com.thiago.farme_check.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    Usuario findByEmail(String email);
}



