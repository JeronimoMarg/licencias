package com.metodos.licencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.metodos.licencias.logic.Titular;
@Repository
public interface TitularRepository extends JpaRepository<Titular,Long>, JpaSpecificationExecutor<Titular>{
    Titular findByNumeroDocumento(Long dni);

}