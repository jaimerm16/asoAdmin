package com.proyecto.asoAdmin.repositories;


import com.proyecto.asoAdmin.entities.Carnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long> {
    Optional<Carnet> findBySocioId(Long idSocio);
}