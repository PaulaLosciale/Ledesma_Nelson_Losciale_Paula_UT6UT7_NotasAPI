package com.appnelsonpaula.notasapi.repository;

import com.appnelsonpaula.notasapi.model.NotaModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<NotaModel, Long> {
    List<NotaModel> findByUsuarioId(Long usuarioId, Sort sort);
}