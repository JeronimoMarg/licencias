/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.logic;

/**
 *
 * @author valec
 */
public class UsuarioLogeado {
    
    private static Usuario usuarioLogeado;
    
    public static Usuario getUsuarioLogeado(){
        return usuarioLogeado;
    }
    
    public static void setUsuarioLogeado(Usuario usuario){
        if(usuarioLogeado == null){
            usuarioLogeado = usuario;
        }
    }
    
}
