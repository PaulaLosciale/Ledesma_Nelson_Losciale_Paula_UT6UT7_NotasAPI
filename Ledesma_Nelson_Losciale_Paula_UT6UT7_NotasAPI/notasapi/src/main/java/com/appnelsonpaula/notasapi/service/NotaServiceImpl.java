package com.appnelsonpaula.notasapi.service;

import com.appnelsonpaula.notasapi.model.NotaModel;
import com.appnelsonpaula.notasapi.repository.NotaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotaServiceImpl extends AbstractCrudService<NotaModel, Long, NotaRepository> implements NotaService {
    
    public NotaServiceImpl(NotaRepository repository) {
        super(repository);
    }

    @Override
    public List<NotaModel> findByUsuarioId(Long usuarioId, Sort sort) {
        return repository.findByUsuarioId(usuarioId, sort);
    }
}