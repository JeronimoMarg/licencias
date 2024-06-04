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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;



/**
 *
 * @author valec
 */
public class UsuariosController{
    
    private UsuarioService usuarioService;
    private Usuarios usuarioView;

    public UsuariosController(UsuarioService userService, Usuarios usuarioView) {
        this.usuarioService = userService;
        this.usuarioView = usuarioView;

        this.usuarioView.addSaveButtonListener(new SaveButtonListener());
    }

    
    private void validarUsuario(UsuarioDTO usuario) throws Exception{
        //falta manejor exceptions
        
        if(usuarioService.usuarioExistente(usuario.getUsuario()) && usuarioService.dniExistente(usuario.getNroDocumento(),stringToTipoDocumento(usuario.getTipoDocumento()))){
           throw new Exception(); 
        }
        
        if(usuarioService.usuarioExistente(usuario.getUsuario())){
            throw new Exception();
        }
        if(usuarioService.dniExistente(usuario.getNroDocumento(),stringToTipoDocumento(usuario.getTipoDocumento()))){
            throw new Exception();
        }
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
                usuarioService.guardarUsuario(crearUsuario(usuario));
                usuarioView.usuarioCreado();
            }catch (Exception ex1) {
                //falta manejo exceptions
                usuarioView.nombreUsuarioExistente();
            }
        }
    }
    
}
