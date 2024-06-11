package com.metodos.licencias.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metodos.licencias.logic.TipoLicencia;
import com.metodos.licencias.repository.TipoLicenciaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoLicenciaService {

    private TipoLicenciaRepository TipoLicenciaRepository;

    
    public List<TipoLicencia> getAllTipoLicencia() {
        return TipoLicenciaRepository.findAll();
    }

    public TipoLicencia getTipoLicencia(){
        //
    }
    
}
