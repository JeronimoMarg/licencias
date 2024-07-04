package com.metodos.licencias.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import com.metodos.licencias.logic.Licencia;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LicenciaRepository.class)
@ContextConfiguration(classes = {LicenciaRepository.class})
public class LicenciaRepositoryTest {

    @Autowired
    private LicenciaRepository repository;

    @Test
    public void LicenciaRepository_save_DevuelveLicenciaGuardada(){
        
        Licencia licencia = new Licencia(

        );

        Licencia licenciaGuardada = repository.save(licencia);

        Assert.notNull(licenciaGuardada, "La licencia guardada es Null");
    }
    
}
