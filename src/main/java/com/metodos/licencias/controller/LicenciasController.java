package com.metodos.licencias.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.metodos.licencias.DTO.LicenciaDTO;
import com.metodos.licencias.DTO.TitularDTO;
import com.metodos.licencias.logic.TipoLicencia;
import com.metodos.licencias.service.LicenciaService;
import com.metodos.licencias.service.TipoLicenciaService;
import com.metodos.licencias.view.InfoTitular;
import com.metodos.licencias.util.Item;

import jakarta.annotation.PostConstruct;

@Controller
public class LicenciasController implements ActionListener, KeyListener, MouseListener{

    private InfoTitular infoTitular;

    @Autowired
    private LicenciaService licenciaService;
    @Autowired
    private TipoLicenciaService tipoLicenciaService;

    private DefaultTableModel tabla;
    private LicenciaDTO licenciaDTO;
    private TitularDTO titularDTO;

    @Autowired
    public LicenciasController(InfoTitular infoTitular){
        this.infoTitular = infoTitular;
    }

    @PostConstruct
    private void init(){

        tabla = new DefaultTableModel();

        //listener del boton de emitir
        this.infoTitular.Licencias_emitir_btn.addActionListener(this);

        inicializar_cmbx();

    }

    private void inicializar_cmbx() {
        //combo de tipo de licencias (clase)
        List<TipoLicencia> tipos = tipoLicenciaService.getAllTipoLicencia();
        for(TipoLicencia tipo: tipos){
            infoTitular.Licencias_emitir_clase.addItem(new Item(tipo.getLetraClase(), Long.toString(tipo.getId())));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.infoTitular.Licencias_emitirCopia_btn){
            licenciaDTO = infoTitular.getLicenciaDTO();
            titularDTO = infoTitular.getTitularDTO();
             try{
                validarLicencia(licenciaDTO, titularDTO);
                licenciaService.guardarLicencia(licenciaDTO, titularDTO);
            }
        }

    }

    private void validarLicencia(LicenciaDTO licenciaDTO2, TitularDTO titularDTO2) throws Exception{
        //Valida edad de acuerdo a la clase
        //si licencia Para clases C, D, y E la edad mínima es 21 años, para el resto de licencias es 17. El máximo para de edad para clases C, D y E.
        if(licenciaService.edadTitularError(titularDTO2.getFechaNacimiento(),licenciaDTO2.getTipoLicencia())){
            throw new Exception();
        }
        //Para licencias C, D y E se necesita una licencia clase B al menos un año antes y no se pueden entregar a mayores de 65 años
        if(licenciaService.claseBError(titularDTO2.getNumDNI())){
            throw new Exception();
        } 
    }
    
}
