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
import com.metodos.licencias.logic.UsuarioLogeado;
import com.metodos.licencias.view.LoginFrame;
import com.metodos.licencias.view.UsuarioSeleccionado;
import jakarta.annotation.PostConstruct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.String;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



/**
 *
 * @author valec
 */
 @Controller
public class UsuariosController{  
    
    private UsuarioService usuarioService;
    private Usuarios usuarioView;
    private LoginFrame loginView;
    private UsuarioSeleccionado usuarioSeleccionadoView;

    @Autowired
    public UsuariosController(UsuarioService userService, Usuarios usuarioView, LoginFrame login, UsuarioSeleccionado usuarioSeleccionado) {
        this.usuarioService = userService;
        this.usuarioView = usuarioView;
        this.loginView = login;
        this.usuarioSeleccionadoView = usuarioSeleccionado;
    }

    @PostConstruct
    private void init(){

        this.usuarioView.addSaveButtonListener(new SaveButtonListener());
        this.usuarioView.addSearchButtonListener(new SearchButtonListener());
        this.setupTableDoubleClick();
        this.loginView.addLoginButtonListener(new LoginButtonListener());
        
        //combo de tipo de documentos
        TipoDocumento[] documentos = TipoDocumento.values();
        for(TipoDocumento documento:documentos){
            usuarioView.setAltaTipoDNI(documento.toString());
            usuarioView.setBusquedaTipoDNI(documento.toString());
        }
        
        Rol[] roles = Rol.values();
        for(Rol r:roles){
            usuarioView.setBusquedaRol(r.toString());
        }
        
        this.usuarioSeleccionadoView.addEditarButtonListener(new EditarButtonListener());
        this.usuarioSeleccionadoView.addEliminarButtonListener(new EliminarButtonListener());
    }
    
    private void validarUsuario(UsuarioDTO usuario) throws UsuarioDNIExistenteException, UsuarioExistenteException, DNIExistenteException, Exception{
        //falta manejor exceptions

        if(usuario.getContrasenia().isEmpty() || usuario.getNroDocumento().isEmpty() || usuario.getUsuario().isEmpty()){
            throw new Exception("No se permiten entradas vacías");
        }
        
        try{
            if(usuarioService.usuarioExistente(usuario.getUsuario()) && usuarioService.dniExistente(usuario.getNroDocumento(),usuario.getTipoDocumento())){
                throw new UsuarioDNIExistenteException("El usuario y el documento ya estan registrados en el sistema."); 
             }
             
             if(usuarioService.usuarioExistente(usuario.getUsuario())){
                 throw new UsuarioExistenteException("El usuario ya esta registrado en el sistema.");
             }
             if(usuarioService.dniExistente(usuario.getNroDocumento(),usuario.getTipoDocumento())){
                 throw new DNIExistenteException("El documento ya esta registrado en el sistema.");
             }
        } catch(Exception e){
            throw e;
        };
    }
    
    public class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){

            UsuarioDTO usuario = usuarioView.getUsuarioDTO();
            
            try {
                //validacion
                validarUsuario(usuario);
                usuarioService.guardarUsuario(usuario);
                usuarioView.usuarioCreado();
            }catch (UsuarioDNIExistenteException ex1) {
                usuarioView.nombreDniExistentes(ex1.getMessage());
            }catch (UsuarioExistenteException ex2) {
                usuarioView.nombreUsuarioExistente(ex2.getMessage());
            }catch (DNIExistenteException ex3){
                usuarioView.dniExistente(ex3.getMessage());
            }catch(Exception ex4){
                usuarioView.ventanaError(ex4.getMessage());
            }
        }
    }
    
    public class SearchButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            //validacion
            //validarUsuario(usuario);
            List<UsuarioDTO> listaUsuarios;
            listaUsuarios = usuarioService.busquedaFiltrosUsuario(usuarioView.getBusquedaNombreUsuario(),usuarioView.getBusquedaRol(),usuarioView.getBusquedaTipoDocumento(),usuarioView.getBusquedaNroDocumento());
            usuarioView.clearTable();
            llenarTabla(listaUsuarios);
        }
    }
    
    public class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            UsuarioDTO usuarioIngresado = loginView.getUsuarioDTO();
            try {
                if (usuarioIngresado.getUsuario().isEmpty() || usuarioIngresado.getContrasenia().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se permiten valores nulos");
                } else if (usuarioService.usuarioExistente(usuarioIngresado.getUsuario())) {
                    Usuario usuarioLogeado = usuarioService.validarContrasenia(usuarioIngresado.getUsuario(), usuarioIngresado.getContrasenia());
                    if (usuarioLogeado != null) {
                        UsuarioLogeado.setUsuarioLogeado(usuarioLogeado);
                        loginView.mostrarMenuPrincipal();
                    } else {
                        JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ingresado no existe");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
            }
        }
    }
    
    public class EditarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
                UsuarioDTO usuario = usuarioSeleccionadoView.getUsuarioDTO();
                try{
                    usuarioService.editarUsuario(usuario);
                    usuarioView.clearTable();
                    JOptionPane.showMessageDialog(null, "El usuario se modificó exitosamente.");
                }catch(Exception exc){
                    System.out.println("[!!!!!] "+exc.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al guardar los datos editados en la base de datos.");
                }
        }
    }
    
    public class EliminarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            UsuarioDTO usuario = usuarioSeleccionadoView.getUsuarioDTO();
    
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el usuario seleccionado?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    usuarioService.eliminarUsuario(usuario);
                    usuarioView.clearTable();
                    usuarioSeleccionadoView.volver();
                    JOptionPane.showMessageDialog(null, "El usuario se eliminó exitosamente.");
                } catch (Exception exc) {
                    System.out.println("[!!!!!] "+exc.getMessage());
                    JOptionPane.showMessageDialog(null, "Error al eliminar el usuario de la base de datos.");
                }
            }
            
            
        }
    }
    
    private void setupTableDoubleClick() {
        usuarioView.addTableMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = usuarioView.getSelectedRow();
                    // Perform actions on double-clicked row
                    String usuario = usuarioView.getRowData(row, 0);
                    UsuarioDTO usuarioObtenido = usuarioService.buscarUsuario(usuario);
                    usuarioView.cargarUsuarioSeleccionado(usuarioObtenido);
                    usuarioView.mostrarUsuarioSeleccionado();
                }
            }
        });
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
    
    private void llenarTabla(List<UsuarioDTO> listaUsuarios){
        for(UsuarioDTO usuario : listaUsuarios){
            usuarioView.cargarTabla(usuario);
        }
    }

    public void actualizarUsuario(UsuarioDTO usuario) throws Exception{
        usuarioService.actualizarUsuario(usuario);
    }


}
