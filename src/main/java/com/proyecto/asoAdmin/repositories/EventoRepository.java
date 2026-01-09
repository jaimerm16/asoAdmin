package com.proyecto.asoAdmin.repositories;

import com.proyecto.asoAdmin.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByFechaAfter(LocalDate fecha);

    List<Evento> findByFechaBefore(LocalDate fecha);
}