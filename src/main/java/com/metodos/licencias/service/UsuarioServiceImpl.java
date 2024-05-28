package com.metodos.licencias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodos.licencias.logic.Usuario;
import com.metodos.licencias.repository.UsuarioRepository;

@Service

public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> obtenerTodosLosUsuarios(){
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepo.findById(id).get();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }    
    
}
