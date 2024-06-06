package com.metodos.licencias.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.metodos.licencias.DTO.TitularDTO;
import com.metodos.licencias.logic.TipoDocumento;
import com.metodos.licencias.logic.Titular;
import com.metodos.licencias.repository.TitularRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TitularService {
    private TitularRepository titularRepository; 
    
    public boolean dniExistente(String nroDni){
        Titular titular = titularRepository.findByNumeroDocumento(Long.parseLong(nroDni));
        if(titular == null) return false;
        return true;
    }
    public boolean formatErrorDni(String nroDni){
        if(nroDni !=null && nroDni.matches("\\d+")) return false; 
        return true;
    }
    public boolean formatErrorNombre(String nombre){
        //falta probar expresión regular.
        if(nombre !=null && nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) return false; 
        return true;
    }
    public boolean formatErrorApellido(String apellido){
        //falta probar expresión regular.
        if(apellido !=null && apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) return false; 
        return true;
    }
    public boolean formatErrorCalle(String calle){
        //falta expresión regular
        if(calle != null) return false; 
        return true;
    }
    public boolean formatErrorAltura(String altura){
        if(altura !=null && altura.matches("\\d+")) return false; 
        return true;
    }
    public boolean invalidFechaNac(Date fechaNac){
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaNacimiento = Calendar.getInstance();

        fechaNacimiento.setTime(fechaNac);
        fechaActual.add(Calendar.YEAR, -18);
        
        return !fechaNacimiento.before(fechaActual.getTime());
    }
    public void guardarTitular(TitularDTO titularDTO) {
        Titular titular = this.aDto(titularDTO);
        titularRepository.save(titular);
    }
    public Titular aDto(TitularDTO titularDTO){
        return new Titular();
        //IMPLEMENTAR!!
    }
    public List<TitularDTO> getBusqueda(String nombre, String apellido, String tipoDoc, String numeroDoc) {
        
        TipoDocumento tipoDocEnum = TipoDocumento.valueOf(tipoDoc);

        
        /* PARA HACER EL SELECTOR DE LA QUERY
         * Enlace GPT
         * https://chatgpt.com/share/cada92fd-603f-439c-b2e6-3d88acee98b8
         */

        return new ArrayList<TitularDTO>();
    }
}
