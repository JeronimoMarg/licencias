/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.controller;

import com.metodos.licencias.DTO.UsuarioDTO;
import com.metodos.licencias.logic.Rol;
import com.metodos.licencias.logic.TipoDocumento;
import com.metodos.licencias.view.Usuarios;
import com.metodos.licencias.service.UsuarioService;
import com.metodos.licencias.logic.Usuario;
import jakarta.annotation.PostConstruct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



/**
 *
 * @author valec
 */
 @Controller
public class UsuariosController{
    
    @Autowired
    private UsuarioService usuarioService;
    
    private Usuarios usuarioView;

    
    public UsuariosController(UsuarioService userService, Usuarios usuarioView) {
        this.usuarioService = userService;
        this.usuarioView = usuarioView;

        
    }

    @PostConstruct
    private void init(){

        this.usuarioView.addSaveButtonListener(new SaveButtonListener());
        
    }
    
    private void validarUsuario(UsuarioDTO usuario) throws UsuarioDNIExistenteException, UsuarioExistenteException, DNIExistenteException{
        //falta manejor exceptions
        /*
        if(usuarioService.usuarioExistente(usuario.getUsuario()) && usuarioService.dniExistente(usuario.getNroDocumento(),stringToTipoDocumento(usuario.getTipoDocumento()))){
           throw new UsuarioDNIExistenteException("El usuario y el documento ya estan registrados en el sistema."); 
        }
        
        if(usuarioService.usuarioExistente(usuario.getUsuario())){
            throw new UsuarioExistenteException("El usuario ya esta registrado en el sistema.");
        }
        if(usuarioService.dniExistente(usuario.getNroDocumento(),stringToTipoDocumento(usuario.getTipoDocumento()))){
            throw new DNIExistenteException("El documento ya esta registrado en el sistema.");
        }
        */
        
    }
    
    private Usuario crearUsuario(UsuarioDTO usuario){        
        return new Usuario(usuario.getUsuario(),usuario.getContrasenia(),stringToTipoDocumento(usuario.getTipoDocumento()),usuario.getNroDocumento(),stringToRol(usuario.getRol()));
    }
    
    private Rol stringToRol(String string){
        return Rol.valueOf(string);
    }
    
    private TipoDocumento stringToTipoDocumento(String string){
        return TipoDocumento.valueOf(string);
    }
    
    public class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){

            UsuarioDTO usuario = usuarioView.getUsuarioDTO();
            
            try {
                //validacion
                validarUsuario(usuario);
                //usuarioService.guardarUsuario(crearUsuario(usuario));
                usuarioView.usuarioCreado();
            }catch (UsuarioDNIExistenteException ex1) {
                usuarioView.nombreDniExistentes(ex1.getMessage());
            }catch (UsuarioExistenteException ex2) {
                usuarioView.nombreUsuarioExistente(ex2.getMessage());
            }catch (DNIExistenteException ex3){
                usuarioView.dniExistente(ex3.getMessage());
            }
        }
    }
    
    public class UsuarioDNIExistenteException extends Exception {
    public UsuarioDNIExistenteException(String message) {
        super(message);
    }
}

    public class UsuarioExistenteException extends Exception {
        public UsuarioExistenteException(String message) {
            super(message);
        }
    }

    public class DNIExistenteException extends Exception {
        public DNIExistenteException(String message) {
            super(message);
        }
    }


}
