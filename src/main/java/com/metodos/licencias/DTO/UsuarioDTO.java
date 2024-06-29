/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.DTO;

import com.metodos.licencias.logic.Rol;
import lombok.Data;

/**
 *
 * @author valec
 */

@Data
public class UsuarioDTO {
    
    private Long id;
    private String tipoDocumento;
    private String nroDocumento;
    private String usuario;
    private String contrasenia;
    private String rol;

    public UsuarioDTO(String tipoDocumento, String nroDocumento, String usuario, String contrasenia, String rol) {
        
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        
        
    }
    
     public UsuarioDTO(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
     
    
}
