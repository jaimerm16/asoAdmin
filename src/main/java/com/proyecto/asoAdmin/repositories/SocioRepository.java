package com.proyecto.asoAdmin.repositories;

import com.proyecto.asoAdmin.entities.Socio;
import com.proyecto.asoAdmin.entities.TipoSocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
    List<Socio> findByTipoSocio(TipoSocio tipoSocio);

    List<Socio> findByNombreContainingIgnoreCase(String nombre);

    boolean existsByEmail(String email);

    long countByTSocio(TipoSocio tSocio);
}