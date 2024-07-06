package com.metodos.licencias.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.metodos.licencias.logic.Licencia;
import com.metodos.licencias.logic.TipoLicencia;
import com.metodos.licencias.logic.Titular;
import com.metodos.licencias.repository.LicenciaRepository;
import com.metodos.licencias.repository.TipoLicenciaRepository;
import com.metodos.licencias.repository.TramiteRepository;

@ExtendWith(MockitoExtension.class)
public class LicenciaServiceTest {

    @InjectMocks
    private LicenciaService licenciaService;

    @Mock
    private LicenciaRepository licenciaRepository;
    @Mock
    private TramiteRepository tramiteRepository;
    @Mock
    private TipoLicenciaRepository tipoLicenciaRepository;
    @Mock
    private TitularService titularService;

    // esAptoProfesional/claseBError
    // clase C y tiene licencia B de mas de un anio
    @Test
    public void claseCConBMasUnAnioDevuelveFalse(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        TipoLicencia tipo = new TipoLicencia();
        titular.setFechaNacimiento(LocalDate.now().minusYears(25));
        titular.setId(1L);
        licencia.setTitular(titular);
        tipo.setLetraClase("B");
        licencia.setTipoLicencia(tipo);
        licencia.setInicioVigencia(LocalDate.now().minusYears(2));

        // Lista con una licencia clase B con mas de un anio de vigencia
        List<Licencia> lista = new ArrayList<>();
        lista.add(licencia);

        when(licenciaRepository.findByTitular_Id(Mockito.anyLong())).thenReturn(lista);

        boolean resultado = licenciaService.claseBError("123", "C");

        Assertions.assertThat(resultado).isFalse();
    }
    
    // clase D y tiene licencia B de menos de un anio
    @Test
    public void claseCConBMasUnAnioDevuelveTrue(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        TipoLicencia tipo = new TipoLicencia();
        titular.setFechaNacimiento(LocalDate.now().minusYears(25));
        titular.setId(1L);
        licencia.setTitular(titular);
        tipo.setLetraClase("B");
        licencia.setTipoLicencia(tipo);
        licencia.setInicioVigencia(LocalDate.now());

        // Lista con una licencia clase B con mas de un anio de vigencia
        List<Licencia> lista = new ArrayList<>();
        lista.add(licencia);

        when(licenciaRepository.findByTitular_NumeroDocumento(Mockito.anyLong())).thenReturn(lista);

        boolean resultado = licenciaService.claseBError("123", "C");

        Assertions.assertThat(resultado).isTrue();
    }


    // Calcular vigencia
    // mes y dia de vencimiento iguales a los de fecha de nacimiento
    @Test
    public void diaMesNacimientoIgualADiaMesVencimiento(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(25));
        titular.setId(1L);
        licencia.setTitular(titular);

        licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(licencia.getFinVigencia().getDayOfMonth()).isEqualTo(licencia.getTitular().getFechaNacimiento().getDayOfMonth());
        Assertions.assertThat(licencia.getFinVigencia().getMonthValue()).isEqualTo(licencia.getTitular().getFechaNacimiento().getMonthValue());
    }

    // menor a 21 -> 3
    @Test
    public void menorA21ConLicenciaDevuelve3(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(20));
        titular.setId(1L);
        licencia.setTitular(titular);

        // Existe licencia del titular
        when(licenciaRepository.existsByTitular_Id(Mockito.anyLong())).thenReturn(true);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(3));
    }

    @Test
    public void igualA21ConLicenciaDevuelve5(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(21));
        titular.setId(1L);
        licencia.setTitular(titular);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(5));
    }
        
        
    @Test
    public void menorA21SinLicenciaDevuelve3(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(20));
        titular.setId(2L);
        licencia.setTitular(titular);

        // Existe licencia del titular
        when(licenciaRepository.existsByTitular_Id(Mockito.anyLong())).thenReturn(false);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(1));
    }


    // menor a 46 -> 5
    @Test
    public void menorA46Devuelve5(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(45));
        titular.setId(2L);
        licencia.setTitular(titular);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(5));
    }

    @Test
    public void igualA46Devuelve4(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(46));
        titular.setId(2L);
        licencia.setTitular(titular);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(4));
    }

    // menor a 61 -> 4
    @Test
    public void menorA61Devuelve4(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(60));
        titular.setId(2L);
        licencia.setTitular(titular);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(4));
    }

    @Test
    public void igualA61Devuelve3(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(61));
        titular.setId(2L);
        licencia.setTitular(titular);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(3));
    }

    // menor a 70 -> 3
    @Test
    public void menorA70Devuelve3(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(69));
        titular.setId(2L);
        licencia.setTitular(titular);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(3));
    }

    @Test
    public void igualA70Devuelve1(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(70));
        titular.setId(2L);
        licencia.setTitular(titular);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(1));
    }

    // 70 o mayor -> 1
    @Test
    public void mayorA70Devuelve1(){
        Licencia licencia = new Licencia();
        Titular titular = new Titular();
        titular.setFechaNacimiento(LocalDate.now().minusYears(70));
        titular.setId(2L);
        licencia.setTitular(titular);

        Long vigencia = licenciaService.calcularVigencia(licencia);

        Assertions.assertThat(vigencia).isEqualTo(Long.valueOf(1));
    }
    // puedeRenovarse


    // licencia que fue habilitada para la renovacion
    @Test
    public void licenciaHabilitadaDevuelveTrue(){
        Licencia licencia = new Licencia();
        licencia.setHabilitadaRenovacion(true);

        // Existe licencia del titular
        when(licenciaRepository.findByNumeroLicencia(Mockito.anyLong())).thenReturn(licencia);

        boolean resultado = licenciaService.puedeRenovarse(Long.valueOf(12));

        Assertions.assertThat(resultado).isTrue();
    }

    // licencia que ha vencido
    @Test
    public void licenciaFechaVencidaDevuelveTrue(){
        Licencia licencia = new Licencia();
        licencia.setFinVigencia(LocalDate.now().minusDays(1));

        // Existe licencia del titular
        when(licenciaRepository.findByNumeroLicencia(Mockito.anyLong())).thenReturn(licencia);

        boolean resultado = licenciaService.puedeRenovarse(Long.valueOf(12));

        Assertions.assertThat(resultado).isTrue();
    }

    // licencia que no requiere renovacion
    @Test
    public void licenciaValidaDevuelveFalse(){
        Licencia licencia = new Licencia();
        licencia.setFinVigencia(LocalDate.now().plusDays(20));
        licencia.setHabilitadaRenovacion(false);

        // Existe licencia del titular
        when(licenciaRepository.findByNumeroLicencia(Mockito.anyLong())).thenReturn(licencia);

        boolean resultado = licenciaService.puedeRenovarse(Long.valueOf(12));

        Assertions.assertThat(resultado).isFalse();
    }
}
