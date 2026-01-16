package com.proyecto.asoAdmin.services;

import com.proyecto.asoAdmin.entities.Socio;
import com.proyecto.asoAdmin.entities.TipoSocio;
import com.proyecto.asoAdmin.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private EmailService emailService;

    public Socio guardarSocio(Socio socio) {
        Socio nuevoSocio = socioRepository.save(socio);

        if (nuevoSocio.isRecibeNotificaciones()) {
            emailService.enviarCorreo(
                    nuevoSocio.getEmail(),
                    "Bienvenido al Club",
                    "Hola " + nuevoSocio.getNombre() + ", gracias por unirte."
            );
        }
        return nuevoSocio;
    }

    public Socio cambiarCategoria(Long idSocio, TipoSocio nuevoTipo) {
        Socio socio = socioRepository.findById(idSocio)
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        socio.setTipoSocio(nuevoTipo); // Usamos Setter
        Socio actualizado = socioRepository.save(socio);

        if (socio.isRecibeNotificaciones()) {
            emailService.enviarCorreo(
                    socio.getEmail(),
                    "Actualización de Membresía",
                    "Tu nivel ahora es: " + nuevoTipo
            );
        }
        return actualizado;
    }

    public List<Socio> buscarPorNombre(String nombre) {
        return socioRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Socio> listarTodos() { return socioRepository.findAll(); }

    public Socio obtenerPorId(Long id) { return socioRepository.findById(id).orElse(null); }
}