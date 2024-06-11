package com.metodos.licencias.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodos.licencias.DTO.LicenciaDTO;
import com.metodos.licencias.DTO.TitularDTO;
import com.metodos.licencias.logic.Licencia;
import com.metodos.licencias.logic.TipoLicencia;
import com.metodos.licencias.logic.Titular;
import com.metodos.licencias.repository.LicenciaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LicenciaService {

    private LicenciaRepository repository;

    // Agrega los atributos de fechas de inicio y fin de vigencia
    public Long calcularVigencia(Licencia licencia){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = licencia.getTitular().getFechaNacimiento();
        Long edadTitular = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        Long aniosVigencia = 0L;
        
        if (edadTitular < 21){
            if (existenLicenciasDe(licencia.getTitular())){
                aniosVigencia = 1L;
            }else{
                aniosVigencia = 3L;
            }
        }
        if (edadTitular < 46){
            aniosVigencia = 5L;
        }
        if (edadTitular < 60){
            aniosVigencia = 4L;   
        }
        if (edadTitular < 70){
            aniosVigencia = 3L;
        }
        if (edadTitular >= 70){
            aniosVigencia = 1L;
        }

        licencia.setInicioVigencia(fechaActual);

        if (fechaActual.getMonthValue() - fechaNacimiento.getMonthValue() > 4){
            licencia.setFinVigencia(fechaNacimiento.plusYears(edadTitular + aniosVigencia + 1));
        } else {
            licencia.setFinVigencia(fechaNacimiento.plusYears(edadTitular + aniosVigencia ));
        }

        return aniosVigencia;

    }

    public Boolean existenLicenciasDe(Titular titular){
        return repository.existsByTitular_Id(titular.getId());
    }

    public Double calcularCosto(Licencia licencia, Long aniosVigencia){
        return 8 + licencia.getTipoLicencia().getCostos().stream()
            .filter(costo -> costo.getVigencia().equals(aniosVigencia))
            .findFirst().orElseThrow().getCosto();
    }

    public Double calcularCosto(Licencia licencia){
        return calcularCosto(licencia, ChronoUnit.YEARS.between(licencia.getInicioVigencia(), licencia.getFinVigencia()));
    }

    public void guardarLicencia(LicenciaDTO licenciaDTO, TitularDTO titularDTO) {
        //guarda la licencia en la bd

        Licencia licencia = aEntidad(licenciaDTO, titularDTO);

    }

    private Licencia aEntidad(LicenciaDTO licenciaDTO, TitularDTO titularDTO) {
        
        Licencia licencia = new Licencia();
        this.calcularVigencia(licencia);
        licencia.setTipoLicencia(buscarTipoLicencia(licenciaDTO.getTipoLicencia()));

        return licencia;

    }

    private TipoLicencia buscarTipoLicencia(String tipoLicencia) {
        return TipoLicenciaService.getTipoLicencia(tipoLicencia);
    }
    
    
    public boolean edadTitularError(Date fechaNacTitular,String claseLicencia){
        LocalDate fechaNacimiento = fechaNacTitular.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(claseLicencia)
        LocalDate fechaActual = LocalDate.now().minusYears(17);


        return fechaNacimiento.isAfter(fechaActual);
    }
}