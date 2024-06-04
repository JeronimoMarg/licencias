package com.metodos.licencias.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.metodos.licencias.logic.Licencia;
import com.metodos.licencias.logic.Titular;
import com.metodos.licencias.repository.LicenciaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LicenciaService {

    private LicenciaRepository repository;

    // Agrega los atributos de fechas de inicio y fin de vigencia
    public Licencia calcularVigencia(Licencia licencia){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = licencia.getTitular().getFechaNacimiento();
        Long edadTitular = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        Integer aniosVigencia = 0;
        
        if (edadTitular < 21){
            if (existenLicenciasDe(licencia.getTitular())){
                aniosVigencia = 1;
            }else{
                aniosVigencia = 3;
            }
        }
        if (edadTitular < 46){
            aniosVigencia = 5;
        }
        if (edadTitular < 60){
            aniosVigencia = 4;   
        }
        if (edadTitular < 70){
            aniosVigencia = 3;
        }
        if (edadTitular >= 70){
            aniosVigencia = 1;
        }

        if (Math.abs(fechaActual.getMonthValue() - fechaNacimiento.getMonthValue()) > 4){
            aniosVigencia += 1;
        }

        licencia.setInicioVigencia(fechaActual);
        licencia.setFinVigencia(fechaNacimiento.plusYears(edadTitular + aniosVigencia));

        return licencia;

    }

    public Boolean existenLicenciasDe(Titular titular){
        return repository.existsByTitular_Id(titular.getId());
    }
    
}
