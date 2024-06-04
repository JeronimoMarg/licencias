package com.metodos.licencias.service;

import org.springframework.stereotype.Service;

import com.metodos.licencias.logic.Titular;
import com.metodos.licencias.repository.TitularRepository;

@Service
public class TitularService {
    private TitularRepository titularRepository; 
    
    public boolean dniExistente(String nroDni){
        Titular titular = titularRepository.findByDni(Long.parseLong(nroDni));
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
}
