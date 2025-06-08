package com.appnelsonpaula.notasapi.controller.v2;

import com.appnelsonpaula.notasapi.model.UsuarioModel;
import com.appnelsonpaula.notasapi.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController("usuarioControllerV2")
@RequestMapping("/api/v2")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Map<String, Object>> signIn(@Valid @RequestBody UsuarioModel usuario) {
        if (usuarioService.findByEmail(usuario.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El email ya está registrado");
        }
        
        UsuarioModel savedUsuario = usuarioService.save(usuario);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuario registrado exitosamente");
        response.put("usuario", savedUsuario);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}