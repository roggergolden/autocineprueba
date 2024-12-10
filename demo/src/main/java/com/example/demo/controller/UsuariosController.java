package com.example.demo.controller;

import com.example.demo.model.UsuariosModel;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuariosRepository; 
    
    @GetMapping
    public List<UsuariosModel> obtenerUsuarios() {
        return usuariosRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<UsuariosModel> obtenerUsuarioPorId(@PathVariable Integer id) {
        Optional<UsuariosModel> usuarioOpt = usuariosRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok(usuarioOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @PostMapping
    public UsuariosModel crearUsuario(@RequestBody UsuariosModel usuario) {
        return usuariosRepository.save(usuario);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<UsuariosModel> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuariosModel detallesUsuario) {
        Optional<UsuariosModel> usuarioOpt = usuariosRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            UsuariosModel usuario = usuarioOpt.get();
            usuario.setNombre(detallesUsuario.getNombre());
            usuario.setEmail(detallesUsuario.getEmail());
            usuario.setPassword(detallesUsuario.getPassword());
            usuario.setTipo_usuario(detallesUsuario.getTipo_usuario());
            UsuariosModel usuarioActualizado = usuariosRepository.save(usuario);
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        Optional<UsuariosModel> usuarioOpt = usuariosRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            usuariosRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
