package com.metodos.licencias.service;

import com.metodos.licencias.DTO.UsuarioDTO;
import com.metodos.licencias.logic.Rol;
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
            System.out.println("UsuarioService usuarioExistente");
            throw new Exception("Error en la base de datos, vuelva a intentarlo");
        }        
    };

    public void guardarUsuario(UsuarioDTO usuario) throws Exception{

        try {
            uRepository.save(crearUsuario(usuario));
        } catch (Exception e) {
            throw new Exception("Error en la base de datos al intentar crear el usuario");
        }

    }
    
      private Usuario crearUsuario(UsuarioDTO usuario){        
        return new Usuario(usuario.getUsuario(),usuario.getContrasenia(),stringToTipoDocumento(usuario.getTipoDocumento()),usuario.getNroDocumento(),Rol.ADMINISTRATIVO);
    }
      

    private TipoDocumento stringToTipoDocumento(String string){
        return TipoDocumento.valueOf(string);
    }  
      
    public boolean dniExistente (String nroDocumento, String tipoDocumento) throws Exception {
        try {

            Usuario user = uRepository.findFirstByTipoDocumentoAndNroDocumento(stringToTipoDocumento(tipoDocumento),nroDocumento);
            return (user != null);

        } catch (Exception e) {
            System.out.println("UsuarioService dniExistente");
            throw new Exception("Error en la base de datos, vuelva a intentarlo");
        }    
    }

    
}
