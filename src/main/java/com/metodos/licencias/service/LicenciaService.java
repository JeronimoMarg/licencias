package com.metodos.licencias.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Date;
import org.springframework.stereotype.Service;
import com.metodos.licencias.util.Item;
import com.metodos.licencias.DTO.LicenciaDTO;
import com.metodos.licencias.DTO.TitularDTO;
import com.metodos.licencias.logic.Licencia;
import com.metodos.licencias.logic.TipoLicencia;
import com.metodos.licencias.logic.TipoTramite;
import com.metodos.licencias.logic.Titular;
import com.metodos.licencias.logic.Tramite;
import com.metodos.licencias.repository.LicenciaRepository;
import com.metodos.licencias.repository.TipoLicenciaRepository;
import com.metodos.licencias.repository.TramiteRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@Service
@AllArgsConstructor
public class LicenciaService {

    private LicenciaRepository repository;
    private TramiteRepository tRepository;
    private TipoLicenciaRepository tipoLicenciaRepository;
    private TitularService titularService;

    // Agrega los atributos de fechas de inicio y fin de vigencia
    public Long calcularVigencia(Licencia licencia){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = licencia.getTitular().getFechaNacimiento();
        Long edadTitular = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        Long aniosVigencia = 0L;
        
        if (edadTitular < 21){
            if (existenLicenciasDe(licencia.getTitular())){
                aniosVigencia = 3L;
            }else{
                aniosVigencia = 1L;
            }
        } else 
        if (edadTitular < 46){
            aniosVigencia = 5L;
        } else
        if (edadTitular < 61){
            aniosVigencia = 4L;   
        } else
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
            .filter(costo -> Long.valueOf(costo.getVigencia()).equals(aniosVigencia))
            .findFirst().orElseThrow().getCosto();
    }

    public Double calcularCosto(Licencia licencia){
        return calcularCosto(licencia, ChronoUnit.YEARS.between(licencia.getInicioVigencia(), licencia.getFinVigencia()));
    }

    public LicenciaDTO guardarLicencia(LicenciaDTO licenciaDTO, TitularDTO titularDTO) {
        //guarda la licencia en la bd
        Licencia licencia = aEntidad(licenciaDTO, titularDTO);
        repository.save(licencia);
        //guardar tramite
        nuevoTramite(licencia,TipoTramite.EMISION);
        return (aDTO(licencia));    //se retorna el DTO para poder actualizarlo y que muestre los datos correctamente.
    }

    private LicenciaDTO aDTO(Licencia licencia) {
        return new LicenciaDTO(
            licencia.getNumeroLicencia(),
            Date.from(licencia.getInicioVigencia().atStartOfDay(ZoneId.systemDefault()).toInstant()),
            Date.from(licencia.getFinVigencia().atStartOfDay(ZoneId.systemDefault()).toInstant()),
            new Item(licencia.getTipoLicencia().getLetraClase(), Long.toString(licencia.getTipoLicencia().getId())),
            licencia.getObservaciones(),
            licencia.getNumeroCopia()
        );
    }

    private Licencia aEntidad(LicenciaDTO licenciaDTO, TitularDTO titularDTO) {
        //ESTE METODO SOLO SE USA CUANDO SE QUIERE CREAR UNA LICENCIA POR PRIMERA VEZ
        
        Licencia licencia = new Licencia();
        licencia.setTitular(titularService.findByDNI_entidad(titularDTO.getNumDNI()));
        licencia.setTipoLicencia(buscarTipoLicencia(licenciaDTO.getTipoLicencia()));
        licencia.setObservaciones(licenciaDTO.getObservaciones());
        licencia.setNumeroCopia(0);                              //en este caso es cero porque este metodo se utiliza solamente cuando se va a guardar una entidad por primera vez
        licencia.setHabilitadaRenovacion(false);        //habilitadaRenovacion sera solamente true cuando se modifique el titular
        licencia.setObsoleta(false);                                //sera solamente true cuando se haya renovado
        this.calcularVigencia(licencia);
        return licencia;
    }

    private TipoLicencia buscarTipoLicencia(Item tipoLicencia) {
        TipoLicencia retorno = tipoLicenciaRepository.findById(Long.parseLong(tipoLicencia.getAtributo2())).stream().findFirst().orElse(null);
        //System.out.println(retorno.getLetraClase());
        return retorno;
    }
    
    
    public boolean edadTitularError(Date fechaNacTitular,String claseLicencia){
        LocalDate fechaNacimiento = fechaNacTitular.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fechaActual = LocalDate.now();
        boolean edadMinima; 
        boolean edadMaxima = false; 

        if(claseLicencia.equals("C") || claseLicencia.equals("D") || claseLicencia.equals("E")){
            
            edadMinima = fechaNacimiento.isAfter(fechaActual.minusYears(21));
            edadMaxima = fechaNacimiento.isBefore(fechaActual.minusYears(65));

        }
        else{
            edadMinima = fechaNacimiento.isAfter(fechaActual.minusYears(17));
        }
    
        return edadMinima || edadMaxima;    
    }

    public boolean claseBError(String dniTitular, String claseLicenciaSolicitada){
        List<Licencia> listadoLicencias = repository.findByTitular_Id(Long.parseLong(dniTitular));
        boolean tiempoMinimoClaseB = true; 
        LocalDate fechaActual = LocalDate.now();
        boolean pasa = true;

        if(claseLicenciaSolicitada.equals("C") || claseLicenciaSolicitada.equals("D") || claseLicenciaSolicitada.equals("E")){
            /*
            for(Licencia unaLicencia:listadoLicencias){
                if(unaLicencia.getTipoLicencia().getLetraClase().equals("B") && unaLicencia.getInicioVigencia().isBefore(fechaActual.minusYears(1))){
                    tiempoMinimoClaseB = false; 
                    return tiempoMinimoClaseB;
                }
            }
            */
            pasa = listadoLicencias
            .stream()
            .filter(l -> l.getTipoLicencia().getLetraClase().equals("B") && l.getInicioVigencia().isBefore(fechaActual.minusYears(1)))
            .count() > 0;
        }
        
        return !pasa;
        
    }

    public boolean tieneLicenciaActiva(Item tipoLicencia, String numDNI) {
        List<Licencia> licenciasTipo = repository.findByTipoLicencia_Id(Long.parseLong(tipoLicencia.getAtributo2()));
        boolean retorno = 
        licenciasTipo.stream()
        .filter(l -> l.getFinVigencia().isAfter(LocalDate.now()))   //me quedo con las licencias activas
        .map(l -> l.getTitular().getNumeroDocumento())              //mapeo a num de documento de titulares
        .filter(n -> n == Long.parseLong(numDNI))                   //filtro con el titular pasado como parametro
        .anyMatch(p -> true);                                       //si tiene elementos retorna true (hay licencia activa para ese tipo y para ese titular)
        return retorno;
    }

    public List<LicenciaDTO> buscarLicenciasAsociadas(TitularDTO titularSeleccionado) {
        //busca las licencias asociadas segun el numero de documento de un titular.
        List<Licencia> licencias = repository.findByTitular_NumeroDocumento(Long.parseLong(titularSeleccionado.getNumDNI()));
        return licencias.stream().filter(l -> !l.isObsoleta()).map(l -> aDTO(l)).toList();
    }

    public boolean esActiva(LicenciaDTO lic) {
        return lic.getFinVigencia().after(lic.getInicioVigencia());
    }

    public LicenciaDTO emitirCopia(Long numLicencia) {
        //PRIMERO BUSCA LA LICENCIA A EMITIR COPIA
        Licencia licenciaACopiar = repository.findByNumeroLicencia(numLicencia);
        //AUMENTA EL NUMERO DE LA COPIA
        licenciaACopiar.aumentarNumCopia();
        //LO GUARDA
        repository.save(licenciaACopiar);
        
        //agregar el nuevo tramite
        nuevoTramite(licenciaACopiar, TipoTramite.EMISION_COPIA);
        
        //DEVUELVE EL DTO (para que se puedan mostrar los datos)
        return aDTO(licenciaACopiar);
    }

    public void habilitarRenovacionLicencias(TitularDTO titularSeleccionado) {
        //busca todas las licencias asociadas al titular y las habilita para renovacion
        List<Licencia> licencias = repository.findByTitular_NumeroDocumento(Long.parseLong(titularSeleccionado.getNumDNI()));
        licencias.stream().forEach(l -> l.setHabilitadaRenovacion(true));
        repository.saveAll(licencias);
    }

    public boolean puedeRenovarse(Long numLicencia) {
        //sera true (podra renovarse) si:
        //  1. la licencia esta vencida
        //  2. la licencia esta habilitada para la renovacion
        Licencia licencia = repository.findByNumeroLicencia(numLicencia);
        boolean retorno = licencia.isHabilitadaRenovacion() || LocalDate.now().isAfter(licencia.getFinVigencia());
        return retorno;
    }

    public LicenciaDTO renovarLicencia(Long numLicencia) {
        Licencia licencia = repository.findByNumeroLicencia(numLicencia);
        Licencia nuevaLicencia = new Licencia();
        nuevaLicencia.setNumeroCopia(0);
        nuevaLicencia.setObservaciones(licencia.getObservaciones());
        nuevaLicencia.setTipoLicencia(licencia.getTipoLicencia());
        nuevaLicencia.setTitular(licencia.getTitular());
        nuevaLicencia.setHabilitadaRenovacion(false);
        calcularVigencia(nuevaLicencia);
        repository.save(nuevaLicencia);

        licencia.setObsoleta(true);
        repository.save(licencia);
        
        //guardar nuevo tramite
        nuevoTramite(nuevaLicencia, TipoTramite.RENOVACION);
        
        return aDTO(nuevaLicencia);
    }

    private void nuevoTramite(Licencia licencia, TipoTramite tipoTramite) {
        
        Tramite tramite = new Tramite(tipoTramite);
        tramite.setLicenciaAsociada(licencia);
        System.out.println(tramite.getTipoTramite());
        tRepository.save(tramite);
        
    }

    public List<LicenciaDTO> busquedaFiltrosLicencia( String nombre, String apellido, String gs, String esDonante, boolean vigente) {
        
        List<Licencia> licenciasEncontradas = repository.findAll(search(nombre, apellido, gs, esDonante, vigente));
        return ListaLicenciasADTO(licenciasEncontradas);

    }
    
    private Specification<Licencia> search(String nombre, String apellido, String grupoSanguineo, String esDonante, boolean vigencia) {
    return (root, query, criteriaBuilder) -> {
        List<Predicate> predicates = new ArrayList<>();

        // Join para acceder a la entidad Titular desde Licencia
        Join<Licencia, Titular> titularJoin = root.join("titular");

        
        if (nombre != null && !nombre.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(titularJoin.get("nombre")), "%" + nombre.toLowerCase() + "%"));
        }

        if (apellido != null && !apellido.isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(titularJoin.get("apellido")), "%" + apellido.toLowerCase() + "%"));
        }
        
        if (grupoSanguineo != null && !grupoSanguineo.isEmpty() && grupoSanguineo != "Todos") {
            predicates.add(criteriaBuilder.equal(titularJoin.get("factorSanguíneo"), grupoSanguineo));
        }
        
        if (esDonante != "Todos") {
            if(esDonante == "Es donante"){
                predicates.add(criteriaBuilder.equal(titularJoin.get("donanteDeOrganos"), true));
            } else  {
                predicates.add(criteriaBuilder.equal(titularJoin.get("donanteDeOrganos"), false));
            }
        }
        
        Predicate vigenciaPredicate;
        if (vigencia) {
            // Fecha de fin de vigencia mayor a la fecha actual y no habilitadaRenovacion
            vigenciaPredicate = criteriaBuilder.and(
                criteriaBuilder.greaterThanOrEqualTo(root.get("finVigencia"), LocalDate.now()),
                criteriaBuilder.equal(root.get("habilitadaRenovacion"), false)
            );
        } else {
            // Fecha de fin de vigencia menor o igual a la fecha actual o habilitadaRenovacion
            vigenciaPredicate = criteriaBuilder.or(
                criteriaBuilder.lessThan(root.get("finVigencia"), LocalDate.now()),
                criteriaBuilder.equal(root.get("habilitadaRenovacion"), true)
            );
        }

        predicates.add(vigenciaPredicate);
        

        // Crear la condición final con AND
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
}

    private List<LicenciaDTO> ListaLicenciasADTO(List<Licencia> licenciasEncontradas) {
        LicenciaDTO licenciaDTO;
        List<LicenciaDTO> licenciaDTOs = new ArrayList();
        for (Licencia licencia : licenciasEncontradas) {
            licenciaDTO = aDTO(licencia);
            licenciaDTO.setApellidoTitular(licencia.getTitular().getApellido());
            licenciaDTO.setNombreTitular(licencia.getTitular().getNombre());
            licenciaDTOs.add(licenciaDTO);
        }

        return licenciaDTOs;

    }
    
}