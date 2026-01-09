package com.proyecto.asoAdmin.services;


import com.proyecto.asoAdmin.entities.Evento;
import com.proyecto.asoAdmin.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> obtenerProximosEventos() {
        return eventoRepository.findByFechaAfter(LocalDate.now().minusDays(1));
    }

    public Evento crearEvento(Evento evento) {
        return eventoRepository.save(evento);
    }
}
