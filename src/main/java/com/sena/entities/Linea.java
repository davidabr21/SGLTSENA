/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "linea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linea.findAll", query = "SELECT l FROM Linea l")
    , @NamedQuery(name = "Linea.findByLinNumeroLinea", query = "SELECT l FROM Linea l WHERE l.linNumeroLinea = :linNumeroLinea")
    , @NamedQuery(name = "Linea.findByPerId", query = "SELECT l FROM Linea l WHERE l.perId = :perId")
    , @NamedQuery(name = "Linea.findByLinEstado", query = "SELECT l FROM Linea l WHERE l.linEstado = :linEstado")})
public class Linea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "linNumeroLinea")
    private String linNumeroLinea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "perId")
    private int perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "linEstado")
    private String linEstado;

    public Linea() {
    }

    public Linea(String linNumeroLinea) {
        this.linNumeroLinea = linNumeroLinea;
    }

    public Linea(String linNumeroLinea, int perId, String linEstado) {
        this.linNumeroLinea = linNumeroLinea;
        this.perId = perId;
        this.linEstado = linEstado;
    }

    public String getLinNumeroLinea() {
        return linNumeroLinea;
    }

    public void setLinNumeroLinea(String linNumeroLinea) {
        this.linNumeroLinea = linNumeroLinea;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getLinEstado() {
        return linEstado;
    }

    public void setLinEstado(String linEstado) {
        this.linEstado = linEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linNumeroLinea != null ? linNumeroLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linea)) {
            return false;
        }
        Linea other = (Linea) object;
        if ((this.linNumeroLinea == null && other.linNumeroLinea != null) || (this.linNumeroLinea != null && !this.linNumeroLinea.equals(other.linNumeroLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sena.entities.Linea[ linNumeroLinea=" + linNumeroLinea + " ]";
    }
    
}
