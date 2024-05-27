package com.eeae.Sverga.repository;

import com.eeae.Sverga.domain.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AulaRepository extends JpaRepository<Aula, String> {

    public Aula findByIdaula(String idaula);
}