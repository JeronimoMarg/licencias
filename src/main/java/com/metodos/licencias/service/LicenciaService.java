package com.metodos.licencias.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metodos.licencias.util.Item;
import com.metodos.licencias.DTO.LicenciaDTO;
import com.metodos.licencias.DTO.TitularDTO;
import com.metodos.licencias.logic.Licencia;
import com.metodos.licencias.logic.TipoLicencia;
import com.metodos.licencias.logic.Titular;
import com.metodos.licencias.logic.Tramite;
import com.metodos.licencias.repository.LicenciaRepository;
import com.metodos.licencias.repository.TipoLicenciaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LicenciaService {

    private LicenciaRepository repository;
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

    public LicenciaDTO guardarLicencia(LicenciaDTO licenciaDTO, TitularDTO titularDTO) {
        //guarda la licencia en la bd
        Licencia licencia = aEntidad(licenciaDTO, titularDTO);
        repository.save(licencia);
        return (aDTO(licencia));    //se retorna el DTO para poder actualizarlo y que muestre los datos correctamente.
    }

    private LicenciaDTO aDTO(Licencia licencia) {
        return new LicenciaDTO(
            licencia.getNumeroLicencia(),
            Date.from(licencia.getInicioVigencia().atStartOfDay(ZoneId.systemDefault()).toInstant()),
            Date.from(licencia.getFinVigencia().atStartOfDay(ZoneId.systemDefault()).toInstant()),
            licencia.getVigente(),
            new Item(licencia.getTipoLicencia().getLetraClase(), Long.toString(licencia.getTipoLicencia().getId())),
            licencia.getObservaciones(),
            licencia.getNumeroCopia()
        );
    }

    private Licencia aEntidad(LicenciaDTO licenciaDTO, TitularDTO titularDTO) {
        
        Licencia licencia = new Licencia();
        licencia.setTitular(titularService.findByDNI_entidad(titularDTO.getNumDNI()));
        licencia.setTipoLicencia(buscarTipoLicencia(licenciaDTO.getTipoLicencia()));
        licencia.setEmitidaPor(new Tramite());
        licencia.setObservaciones(licenciaDTO.getObservaciones());
        licencia.setNumeroCopia(0);     //en este caso es cero porque este metodo se utiliza solamente cuando se va a guardar una entidad por primera vez
        this.calcularVigencia(licencia);
        licencia.setVigente(licenciaDTO.getVigente());
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
        .filter(l -> l.getFinVigencia().isAfter(LocalDate.now()) && l.getVigente())   //me quedo con las licencias activas
        .map(l -> l.getTitular().getNumeroDocumento())              //mapeo a num de documento de titulares
        .filter(n -> n == Long.parseLong(numDNI))                   //filtro con el titular pasado como parametro
        .anyMatch(p -> true);                                       //si tiene elementos retorna true (hay licencia activa para ese tipo y para ese titular)
        return retorno;
    }

    public List<LicenciaDTO> buscarLicenciasAsociadas(TitularDTO titularSeleccionado) {
        //busca las licencias asociadas segun el numero de documento de un titular.
        List<Licencia> licencias = repository.findByTitular_NumeroDocumento(Long.parseLong(titularSeleccionado.getNumDNI()));
        return licencias.stream().map(l -> aDTO(l)).toList();
    }

    public boolean esActiva(LicenciaDTO lic) {
        return lic.getFinVigencia().after(lic.getInicioVigencia()) && lic.getVigente();
    }

    public LicenciaDTO emitirCopia(Long numLicencia) {
        //PRIMERO BUSCA LA LICENCIA A EMITIR COPIA
        Licencia licenciaACopiar = repository.findByNumeroLicencia(numLicencia);
        //AUMENTA EL NUMERO DE LA COPIA
        licenciaACopiar.aumentarNumCopia();
        //LO GUARDA
        repository.save(licenciaACopiar);
        //DEVUELVE EL DTO (para que se puedan mostrar los datos)
        return aDTO(licenciaACopiar);
    }

    public Licencia renovarLicencia(Licencia licencia){
        Licencia nuevaLicencia = new Licencia();
        // copiar datos
        nuevaLicencia.setEmitidaPor(licencia.getEmitidaPor());
        nuevaLicencia.setNumeroCopia(1);
        nuevaLicencia.setObservaciones(licencia.getObservaciones());
        nuevaLicencia.setTipoLicencia(licencia.getTipoLicencia());
        nuevaLicencia.setTitular(licencia.getTitular());
        nuevaLicencia.setVigente(true);
        calcularVigencia(nuevaLicencia);

        repository.save(nuevaLicencia);
        return nuevaLicencia;
    }

    public List<Licencia> findByTitular_IdAndNoVigente(Long titularId){
        return repository.findByTitular_IdAndVigente(titularId, false);
    }
}