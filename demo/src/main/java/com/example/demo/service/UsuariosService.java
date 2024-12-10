package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.UsuariosModel;
import com.example.demo.repository.UsuariosRepository;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuarioRepository;

    
    public Optional<UsuariosModel> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    
    public UsuariosModel guardarUsuario(UsuariosModel usuario) {
        return usuarioRepository.save(usuario);
    }

   
}
