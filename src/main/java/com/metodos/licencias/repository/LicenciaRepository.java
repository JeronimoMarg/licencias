package com.metodos.licencias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.metodos.licencias.logic.Licencia;
@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Long> {
    boolean existsByTitular_Id(Long titularId);
    List<Licencia> findByTitular_Id(Long titularId);
    List<Licencia> findByTipoLicencia_Id(Long id);
}
