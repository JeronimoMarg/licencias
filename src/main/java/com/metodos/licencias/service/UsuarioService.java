package com.metodos.licencias.service;

import com.metodos.licencias.logic.TipoDocumento;
import com.metodos.licencias.logic.Usuario;
import com.metodos.licencias.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepository uRepository;

    public boolean usuarioExistente(String nombreUsuario) throws Exception{

        try {

            Usuario user = uRepository.findFirstByNombreUsuario(nombreUsuario);
            return (user != null);

        } catch (Exception e) {
            throw new Exception("Error en la base de datos, vuelva a intentarlo");
        }        
    };

    public void guardarUsuario(Usuario crearUsuario) throws Exception{

        try {
            uRepository.save(crearUsuario);
        } catch (Exception e) {
            throw new Exception("Error en la base de datos al intentar crear el usuario");
        }

    }

    public boolean dniExistente (String nroDocumento, TipoDocumento tipoDocumento) throws Exception {
        try {

            Usuario user = uRepository.findFirstByTipoDocumentoAndNroDocumento(tipoDocumento,nroDocumento);
            return (user != null);

        } catch (Exception e) {
            throw new Exception("Error en la base de datos, vuelva a intentarlo");
        }    
    }

    
}
