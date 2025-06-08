package com.appnelsonpaula.notasapi.service;

import com.appnelsonpaula.notasapi.model.NotaModel;
import org.springframework.data.domain.Sort;
import java.util.List;

public interface NotaService extends CrudService<NotaModel, Long> {
    List<NotaModel> findByUsuarioId(Long usuarioId, Sort sort);
}