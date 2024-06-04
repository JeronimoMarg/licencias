/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;

import com.metodos.licencias.DTO.TitularDTO;
import com.metodos.licencias.logic.FactorSanguíneo;
import com.metodos.licencias.logic.Licencia;
import com.metodos.licencias.logic.TipoDocumento;
import com.metodos.licencias.logic.TipoLicencia;
import com.metodos.licencias.service.TipoLicenciaService;
import com.metodos.licencias.service.TitularService;
import com.metodos.licencias.view.InfoTitular;
import com.metodos.licencias.view.Titulares;

/**
 *
 * @author JeroM
 */

public class TitularesController implements ActionListener, KeyListener, MouseListener{

    private Titulares titularesGUI;
    private TitularDTO titularDTO;
    private TitularService titularService; 
    private TipoLicenciaService tipoLicenciaService;

    public TitularesController(Titulares GUI){
        this.titularesGUI = GUI;

        //agregar eventos de escucha a botones
        this.titularesGUI.Alta_titular_guardarBtn.addActionListener(this);

        //agregar validaciones a los campos

        //evento de escucha a la tabla

        //inicializar comboboxes
        inicializar_cmbx();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == titularesGUI.Alta_titular_guardarBtn){
            titularDTO = titularesGUI.getTitularDTO();
            try {
                validarTitular(titularDTO);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        }
    }

    private void validarTitular(TitularDTO titularDTO) throws Exception{
        if(titularService.dniExistente(titularDTO.getNumDNI()) || titularService.formatErrorDni(titularDTO.getNumDNI())){
            throw new Exception(); 
        }
        if(titularService.formatErrorNombre(titularDTO.getNombre())){
            throw new Exception();
        }
        if(titularService.formatErrorApellido(titularDTO.getApellido())){
            throw new Exception();
        }
        if(titularService.formatErrorCalle(titularDTO.getCalle())){
            throw new Exception();
        }
        if(titularService.formatErrorAltura(titularDTO.getAltura())){
            throw new Exception();
        }
    }
    
    public void inicializar_cmbx(){

        //combo de tipo de documentos
        TipoDocumento[] documentos = TipoDocumento.values();
        for(TipoDocumento documento:documentos){
            titularesGUI.Alta_titular_tipodni.addItem(documento.toString());
        }

        //combo de tipo de factores
        FactorSanguíneo[] factores = FactorSanguíneo.values();
        for(FactorSanguíneo factor:factores){
            titularesGUI.Alta_titular_gruposanguineo.addItem(factor.toString());
        }

        //combo de tipo de licencias
        List<TipoLicencia> tipos = tipoLicenciaService.getAllTipoLicencia();
        for(TipoLicencia tipo: tipos){
            titularesGUI.Alta_titular_clase.addItem(tipo.getLetraClase());
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
    
}
