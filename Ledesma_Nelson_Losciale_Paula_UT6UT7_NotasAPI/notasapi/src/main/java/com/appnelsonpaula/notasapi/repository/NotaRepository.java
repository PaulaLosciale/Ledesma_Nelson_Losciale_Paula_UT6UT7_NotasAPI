package com.appnelsonpaula.notasapi.repository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appnelsonpaula.notasapi.model.NotaModel;

@Repository
public interface NotaRepository extends JpaRepository<NotaModel, Long> {
    List<NotaModel> findByUsuarioId(Long usuarioId, Sort sort);
}