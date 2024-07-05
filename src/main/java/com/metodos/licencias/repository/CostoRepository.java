package com.metodos.licencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metodos.licencias.logic.Costo;
import java.util.List;


@Repository
public interface CostoRepository extends JpaRepository<Costo, Long> {

    List<Costo> findByLicenciaPerteneciente_Id(Long id);
}
