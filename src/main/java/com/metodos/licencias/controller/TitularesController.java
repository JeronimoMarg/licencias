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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.metodos.licencias.DTO.TitularDTO;
import com.metodos.licencias.logic.FactorSanguineo;
import com.metodos.licencias.logic.TipoDocumento;
import com.metodos.licencias.logic.TipoLicencia;
import com.metodos.licencias.service.TipoLicenciaService;
import com.metodos.licencias.service.TitularService;
import com.metodos.licencias.view.InfoTitular;
import com.metodos.licencias.view.Titulares;

import jakarta.annotation.PostConstruct;

/**
 *
 * @author JeroM
 */

 @Controller
public class TitularesController implements ActionListener, KeyListener, MouseListener{

    private Titulares titularesGUI;
    private InfoTitular infoTitular;

    private TitularDTO titularDTO;
    private DefaultTableModel tabla;

    @Autowired
    private TitularService titularService;
    @Autowired
    private TipoLicenciaService tipoLicenciaService;

    @Autowired
    public TitularesController(Titulares titulares, InfoTitular infoTitular){
        this.titularesGUI = titulares;
        this.infoTitular = infoTitular;
    }

    @PostConstruct
    private void init(){

        tabla = new DefaultTableModel();

        //listener para el boton guardar alta titular
        this.titularesGUI.Alta_titular_guardarBtn.addActionListener(this);

        //listener para el boton busqueda titular
        this.titularesGUI.Busqueda_titular_buscarBtn.addActionListener(this);

        //listener del click en la tabla
        this.titularesGUI.Busqueda_titular_tabla.addMouseListener(this);

        //listener para el boton editar
        this.infoTitular.Mod_titular_editar.addActionListener(this);

        //listener para el boton volver
        this.infoTitular.Mod_titular_volver.addActionListener(this);

        inicializar_cmbx();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == titularesGUI.Alta_titular_guardarBtn){
            titularDTO = titularesGUI.getTitularDTO();
            try {
                validarTitular(titularDTO);
                titularService.guardarTitular(titularDTO);
                JOptionPane.showMessageDialog(null, "Titular guardado con exito!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        } else if(e.getSource() == titularesGUI.Busqueda_titular_buscarBtn){
            String nombre = titularesGUI.Busqueda_titular_nombre.getText().toString().trim();
            String apellido = titularesGUI.Busqueda_titular_apellido.getText().toString().trim();
            String tipoDoc = titularesGUI.Busqueda_titular_tipodni.getSelectedItem().toString().trim();
            String numeroDoc = titularesGUI.Busqueda_titular_numerodni.getText().toString().trim();
            try {
                validarCamposBusqueda(nombre, apellido, tipoDoc, numeroDoc);
                List<TitularDTO> resultados = titularService.getBusqueda(nombre, apellido, tipoDoc, numeroDoc);
                listarTitulares(resultados);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        } else if(e.getSource() == infoTitular.Mod_titular_editar){
            titularDTO = infoTitular.getTitularDTO();
            try {
                validarTitularEdicion(titularDTO);
                titularService.editarTitular(titularDTO);
                JOptionPane.showMessageDialog(null, "Titular editado con exito!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        } else if(e.getSource() == infoTitular.Mod_titular_volver){
            this.titularesGUI.getTitularesMain().switchScreen("Titulares");
        }
    }

    private void listarTitulares(List<TitularDTO> titulares) {

        tabla.setRowCount(0);
        tabla = (DefaultTableModel) titularesGUI.Busqueda_titular_tabla.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < titulares.size(); i++) {
            row[0] = titulares.get(i).getNombre();
            row[1] = titulares.get(i).getApellido();
            row[2] = titulares.get(i).getTipoDoc();
            row[3] = titulares.get(i).getNumDNI();
            tabla.addRow(row);
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
        if(titularService.invalidFechaNac(titularDTO.getFechaNacimiento())){
            throw new Exception();
        }
        
    }

    private void validarTitularEdicion(TitularDTO titularDTO2) throws Exception{
                
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

    private void validarCamposBusqueda(String nombre, String apellido, String tipoDoc, String numeroDoc) throws Exception{
        //metodo de validacion de los campos de busqueda de titular
    }
    
    public void inicializar_cmbx(){

        //combo de tipo de documentos
        TipoDocumento[] documentos = TipoDocumento.values();
        for(TipoDocumento documento:documentos){
            titularesGUI.Alta_titular_tipodni.addItem(documento.toString());
            titularesGUI.Busqueda_titular_tipodni.addItem(documento.toString());
            infoTitular.Mod_titular_tipodni.addItem(documento.toString());
        }

        //combo de tipo de factores
        FactorSanguineo[] factores = FactorSanguineo.values();
        for(FactorSanguineo factor:factores){
            titularesGUI.Alta_titular_gruposanguineo.addItem(factor.toString());
            infoTitular.Mod_titular_gruposanguineo.addItem(factor.toString());
        }

        //combo de tipo de licencias
        List<TipoLicencia> tipos = tipoLicenciaService.getAllTipoLicencia();
        for(TipoLicencia tipo: tipos){
            titularesGUI.Alta_titular_clase.addItem(tipo.getLetraClase());
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == titularesGUI.Busqueda_titular_tabla){
            try {
                if (e.getClickCount() >= 2) {
                    int row = titularesGUI.Busqueda_titular_tabla.getSelectedRow();
                    if(row >= 0){
                        //buscar los datos completos del titular
                        String numDNI = (String) titularesGUI.Busqueda_titular_tabla.getValueAt(row, 3);
                        TitularDTO seleccionado = titularService.findByDNI(numDNI);
                        //inicializar interfaz siguiente
                        infoTitular.setTitular(seleccionado);
                        JOptionPane.showMessageDialog(null, "Usuario seleccionado");
                        //MOSTRAR INTERFAZ
                        titularesGUI.getTitularesMain().switchScreen("InfoTitular");
                    }
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        } 
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

    public void setTitularesGUI(Titulares titulares) {
        this.titularesGUI=titulares;
    }
    
}
