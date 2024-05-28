package com.metodos.licencias.service;

import java.util.List;

import com.metodos.licencias.logic.Usuario;

public interface UsuarioService {

    public List<Usuario> obtenerTodosLosUsuarios();

    public Usuario obtenerPorId(Long id);

    public Usuario guardarUsuario(Usuario usuario);
    
}
