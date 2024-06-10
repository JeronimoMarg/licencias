package com.metodos.licencias.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.metodos.licencias.DTO.TitularDTO;
import com.metodos.licencias.logic.Domicilio;
import com.metodos.licencias.logic.FactorSanguíneo;
import com.metodos.licencias.logic.TipoDocumento;
import com.metodos.licencias.logic.Titular;
import com.metodos.licencias.repository.TitularRepository;

import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TitularService {

    @Autowired
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
        if(nombre !=null && nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) return false; 
        return true;
    }
    public boolean formatErrorApellido(String apellido){
        if(apellido !=null && apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) return false; 
        return true;
    }
    public boolean formatErrorCalle(String calle){
        if(calle != null && calle.matches("^[a-zA-Z0-9\\s]+$")) return false; 
        return true;
    }
    public boolean formatErrorAltura(String altura){
        if(altura !=null && altura.matches("\\d+")) return false; 
        return true;
    }
    public boolean invalidFechaNac(Date fechaNac){
        LocalDate fechaNacimiento = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        LocalDate fechaActual = LocalDate.now().minusYears(18);

        return fechaNacimiento.isAfter(fechaActual);
    }
    public void guardarTitular(TitularDTO titularDTO) {
        Titular titular = this.aEntidad(titularDTO);
        titularRepository.save(titular);
    }

    public Titular aEntidad(TitularDTO titularDTO){

        Domicilio domicilio = new Domicilio(
            titularDTO.getCalle(),
            titularDTO.getAltura()
        );

        //Pasaje de DATE a LOCALDATE
        Instant instant = titularDTO.getFechaNacimiento().toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localdate = instant.atZone(zoneId).toLocalDate();

        return new Titular(
            titularDTO.getNombre(),
            titularDTO.getApellido(),
            localdate,
            FactorSanguíneo.valueOf(titularDTO.getGrupoSanguineo()),
            TipoDocumento.valueOf(titularDTO.getTipoDoc()),
            titularDTO.getNumDNI(),
            titularDTO.isDonante(),
            domicilio
        );
    }

    public TitularDTO aDTO(Titular titular){

        return new TitularDTO(
            titular.getNombre(), 
            titular.getApellido(), 
            titular.getTipoDocumento().toString(), 
            Long.toString(titular.getNumeroDocumento()), 
            titular.getFactorSanguíneo().toString(), 
            Date.from(titular.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()),
            titular.getDonanteDeOrganos(),
            titular.getDomicilio().getNombreCalle(), 
            titular.getDomicilio().getNumeroCalle());

    }

    public List<TitularDTO> getBusqueda(String nombre, String apellido, String tipoDoc, String numeroDoc){

        List<Titular> titulares = searchEntidades(nombre, apellido, tipoDoc, numeroDoc);
        return titulares.stream().map(t -> aDTO(t)).toList();
        
    }

    public List<Titular> searchEntidades(String nombre, String apellido, String tipoDoc, String numeroDoc) {
        
        TipoDocumento tipoDocEnum = TipoDocumento.valueOf(tipoDoc);

        Specification<Titular> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nombre != null && !nombre.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
            }
            if (apellido != null && !apellido.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("apellido")), "%" + apellido.toLowerCase() + "%"));
            }
            if (tipoDoc != null && !tipoDoc.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("tipoDocumento"), tipoDocEnum));
            }
            if (numeroDoc != null && !numeroDoc.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("numeroDoc"), numeroDoc));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<Titular> resultado = titularRepository.findAll(specification);
        if (resultado.isEmpty()){
            throw new NoResultException("No se han encontrado resultados para los campos indicados.");
        }
        return resultado;
    }

    public TitularDTO findByDNI(String dni){
        Titular titular = titularRepository.findByNumeroDocumento(Long.parseLong(dni));
        return aDTO(titular);
    }

}
