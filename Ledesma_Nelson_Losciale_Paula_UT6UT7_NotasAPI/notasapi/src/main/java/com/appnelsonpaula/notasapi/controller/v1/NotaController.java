package com.appnelsonpaula.notasapi.controller.v1;

import com.appnelsonpaula.notasapi.model.NotaModel;
import com.appnelsonpaula.notasapi.service.NotaService;
import com.appnelsonpaula.notasapi.service.UsuarioService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notas")
public class NotaController {
    private final NotaService notaService;
    private final UsuarioService usuarioService;

    public NotaController(NotaService notaService, UsuarioService usuarioService) {
        this.notaService = notaService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<NotaModel>> getNotas(
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(defaultValue = "asc") String order) {
        Sort sort = Sort.by(order.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, "fechaCreacion");
        List<NotaModel> notas = usuarioId != null ? 
            notaService.findByUsuarioId(usuarioId, sort) : notaService.getAll();
        return ResponseEntity.ok(notas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaModel> getNotaById(@PathVariable Long id) {
        return notaService.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada"));
    }

    @PostMapping
    public ResponseEntity<NotaModel> createNota(
            @RequestParam Long usuarioId,
            @Valid @RequestBody NotaModel nota) {
        return usuarioService.getById(usuarioId)
            .map(usuario -> {
                nota.setUsuario(usuario);
                return ResponseEntity.status(HttpStatus.CREATED).body(notaService.save(nota));
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaModel> updateNota(@PathVariable Long id, @Valid @RequestBody NotaModel nota) {
        if (!notaService.getById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada");
        }
        nota.setId(id);
        NotaModel updatedNota = notaService.update(id, nota);
        return ResponseEntity.ok(updatedNota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        if (!notaService.getById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nota no encontrada");
        }
        notaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}