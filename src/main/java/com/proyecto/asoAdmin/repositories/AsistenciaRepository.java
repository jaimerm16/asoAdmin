package com.proyecto.asoAdmin.repositories;

import com.proyecto.asoAdmin.entities.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
    boolean existsBySocioIdAndEventoId(Long idSocio, Long idEvento);

    long countByEventoId(Long idEvento);

    List<Asistencia> findBySocioIdOrderByFechaEventoDesc(Long idSocio);
}