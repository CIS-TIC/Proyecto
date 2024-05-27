package com.eeae.Sverga.servicio;

import com.eeae.Sverga.controladorDTO.AulaRegistroDTO;
import com.eeae.Sverga.domain.Aula;
import java.util.List;

public interface AulaServicio {

    public List<Aula> listarAulas();
    
    public Aula guardar(AulaRegistroDTO registroDTO);

    public void eliminar(AulaRegistroDTO registroDTO);
    
    public Aula actualizar(AulaRegistroDTO registroDTO);

    public Aula encontrarAula(AulaRegistroDTO registroDTO);
    
    public Aula buscarAulaPorId(String idaula);
}
