package com.metodos.licencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.metodos.licencias.logic.Usuario;;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    Usuario findByNombre(String name);
    
}
