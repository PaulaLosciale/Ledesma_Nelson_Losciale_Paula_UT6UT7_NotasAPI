package com.appnelsonpaula.notasapi.service;

import com.appnelsonpaula.notasapi.model.UsuarioModel;
import com.appnelsonpaula.notasapi.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends AbstractCrudService<UsuarioModel, Long, UsuarioRepository> implements UsuarioService {
    
    public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
    }

    @Override
    public Optional<UsuarioModel> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}