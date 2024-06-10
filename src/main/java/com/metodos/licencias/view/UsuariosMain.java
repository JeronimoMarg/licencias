/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.view;

import com.metodos.licencias.DTO.UsuarioDTO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author valec
 */
@Component
public class UsuariosMain extends JPanel{
    
    CardLayout cl;
    Usuarios usuarios;
    UsuarioSeleccionado usuarioSeleccionado;
    
    @Autowired
    public UsuariosMain(Usuarios usuarios, UsuarioSeleccionado usuarioSeleccionado) {
        this.usuarios = usuarios;
        this.usuarios.setMain(this);
        this.usuarioSeleccionado = usuarioSeleccionado;
        this.usuarioSeleccionado.setMain(this);
        this.setLayout(new CardLayout());
        cl = (CardLayout) (this.getLayout());
        
        // Add the cards to the panel with identifiers
        add(this.usuarios, "Usuarios");
        add(this.usuarioSeleccionado, "UsuarioSeleccionado");
    }
    
    public void switchScreen (String pantalla) {    
       cl.show(this, pantalla);
       revalidate();
       
    }                                        
 
    public void cargarUsuarioSeleccionado(UsuarioDTO usuario){
        usuarioSeleccionado.cargarUsuario(usuario);
    }
    
    
}
