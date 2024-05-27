package com.eeae.Sverga.servicio;

import com.eeae.Sverga.controladorDTO.AulaRegistroDTO;
import com.eeae.Sverga.domain.Aula;
import com.eeae.Sverga.repository.AulaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AulaServicioImpl implements AulaServicio {

    private AulaRepository aulaRepository;

    //Constructor
    public AulaServicioImpl(AulaRepository aulaRepository) {
        super();
        this.aulaRepository = aulaRepository;
    }

    @Override
    public Aula guardar(AulaRegistroDTO aulaRegistroDTO) {
        Aula aula = new Aula(aulaRegistroDTO.getIdaula(), aulaRegistroDTO.getEdificio(),
                aulaRegistroDTO.getNombre(), aulaRegistroDTO.getCapacidad(), aulaRegistroDTO.getPuestos(),
                aulaRegistroDTO.getModulo(), aulaRegistroDTO.getZar(), aulaRegistroDTO.getRap(),
                aulaRegistroDTO.getRed_ossorio(), aulaRegistroDTO.getWan_pg(), aulaRegistroDTO.getProyector(),
                aulaRegistroDTO.getPizarra_digital(), aulaRegistroDTO.getExtras());
        return aulaRepository.save(aula);
    }

    @Override
    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public void eliminar(AulaRegistroDTO aulaRegistroDTO) {
        Aula aula = aulaRepository.findByIdaula(aulaRegistroDTO.getIdaula());
        if (aula != null) {
            aulaRepository.delete(aula);
        } else {
            throw new UsernameNotFoundException("Aula no encontrado");
        }
    }

    @Override
    public Aula encontrarAula(AulaRegistroDTO aulaRegistroDTO) {
        Aula aula = aulaRepository.findByIdaula(aulaRegistroDTO.getIdaula());
        if (aula != null) {
            return aula;
        } else {
            throw new UsernameNotFoundException("Aula no encontrado");
        }
    }

    @Override
    public Aula buscarAulaPorId(String idaula) {
        Aula aula = aulaRepository.findByIdaula(idaula);
        if (aula != null) {
            return aula;
        } else {
            throw new UsernameNotFoundException("Aula no encontrada");
        }
    }

    @Override
    public Aula actualizar(AulaRegistroDTO registroDTO) {
        Aula aulaEncontrada = aulaRepository.findByIdaula(registroDTO.getIdaula());
        if (aulaEncontrada != null) {
            aulaEncontrada.setEdificio(registroDTO.getEdificio());
            aulaEncontrada.setNombre(registroDTO.getNombre());
            aulaEncontrada.setCapacidad(registroDTO.getCapacidad());
            aulaEncontrada.setPuestos(registroDTO.getPuestos());
            aulaEncontrada.setModulo(registroDTO.getModulo());
            aulaEncontrada.setZar(registroDTO.getZar());
            aulaEncontrada.setRap(registroDTO.getRap());
            aulaEncontrada.setRed_ossorio(registroDTO.getRed_ossorio());
            aulaEncontrada.setWan_pg(registroDTO.getWan_pg());
            aulaEncontrada.setProyector(registroDTO.getProyector());
            aulaEncontrada.setPizarra_digital(registroDTO.getPizarra_digital());
            aulaEncontrada.setExtras(registroDTO.getExtras());
            return aulaRepository.save(aulaEncontrada);
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

    }
}
