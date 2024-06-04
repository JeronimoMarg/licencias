package com.metodos.licencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metodos.licencias.logic.TipoLicencia;

@Repository
public interface TipoLicenciaRepository extends JpaRepository<TipoLicencia, Long> {
    
}
