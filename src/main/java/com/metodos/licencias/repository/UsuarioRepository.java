package com.metodos.licencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.metodos.licencias.logic.TipoDocumento;
import com.metodos.licencias.logic.Usuario;import jakarta.transaction.Transactional;
;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario,Long>, JpaSpecificationExecutor<Usuario>{

    Usuario findByNombreUsuario(String name);

    Usuario findFirstByNombreUsuario(String nombreUsuario);

    Usuario findFirstByTipoDocumentoAndNroDocumento(TipoDocumento tipoDocumento, String nroDocumento);

    Usuario findFirstByNombreUsuarioAndContrasenia(String nombreUsuario, String contrasenia);

    Usuario findFirstByNroDocumento(String numDoc);
    
}
