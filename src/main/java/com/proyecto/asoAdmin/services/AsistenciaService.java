package com.proyecto.asoAdmin.services;

import com.proyecto.asoAdmin.entities.Asistencia;
import com.proyecto.asoAdmin.entities.Evento;
import com.proyecto.asoAdmin.entities.Socio;
import com.proyecto.asoAdmin.repositories.AsistenciaRepository;
import com.proyecto.asoAdmin.repositories.EventoRepository;
import com.proyecto.asoAdmin.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private EventoRepository eventoRepository;

    public Asistencia registrarAsistenciaSegura(Long idSocio, Long idEvento) {
        if (asistenciaRepository.existsBySocioIdAndEventoId(idSocio, idEvento)) {
            throw new RuntimeException("El socio ya está registrado en este evento.");
        }

        Socio socio = socioRepository.findById(idSocio)
                .orElseThrow(() -> new RuntimeException("Socio no existe"));
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new RuntimeException("Evento no existe"));

        if (evento.getFecha().isBefore(LocalDate.now())) {
            throw new RuntimeException("El evento ya ha pasado.");
        }

        Asistencia asistencia = new Asistencia();
        asistencia.setSocio(socio);
        asistencia.setEvento(evento);
        asistencia.setFechaEvento(LocalDate.now());

        return asistenciaRepository.save(asistencia);
    }

    public long contarAsistentes(Long idEvento) {
        return asistenciaRepository.countByEventoId(idEvento);
    }
}