package com.appnelsonpaula.notasapi.service;

import com.appnelsonpaula.notasapi.model.UsuarioModel;
import java.util.Optional;

public interface UsuarioService extends CrudService<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmail(String email);
}