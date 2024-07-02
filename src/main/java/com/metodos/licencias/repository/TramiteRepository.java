/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.metodos.licencias.repository;

import com.metodos.licencias.logic.Tramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author valec
 */
@Repository
public interface TramiteRepository extends JpaRepository<Tramite,Long>, JpaSpecificationExecutor<Tramite>{
    
    
    
}
