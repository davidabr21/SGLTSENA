/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sena.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByFacNumero", query = "SELECT f FROM Factura f WHERE f.facNumero = :facNumero")
    , @NamedQuery(name = "Factura.findByLinNumeroLinea", query = "SELECT f FROM Factura f WHERE f.linNumeroLinea = :linNumeroLinea")
    , @NamedQuery(name = "Factura.findByFacFechaEmision", query = "SELECT f FROM Factura f WHERE f.facFechaEmision = :facFechaEmision")
    , @NamedQuery(name = "Factura.findByMinFacFechaEmision", query = "SELECT f FROM Factura f WHERE f.linNumeroLinea = :linNumeroLinea AND f.facFechaEmision > :facFechaEmision")
    , @NamedQuery(name = "Factura.findByFacValor", query = "SELECT f FROM Factura f WHERE f.facValor = :facValor")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "facNumero")
    private Integer facNumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "linNumeroLinea")
    private String linNumeroLinea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "facFechaEmision")
    @Temporal(TemporalType.DATE)
    private Date facFechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "facValor")
    private long facValor;

    public Factura() {
    }

    public Factura(Integer facNumero) {
        this.facNumero = facNumero;
    }

    public Factura(Integer facNumero, String linNumeroLinea, Date facFechaEmision, long facValor) {
        this.facNumero = facNumero;
        this.linNumeroLinea = linNumeroLinea;
        this.facFechaEmision = facFechaEmision;
        this.facValor = facValor;
    }

    public Integer getFacNumero() {
        return facNumero;
    }

    public void setFacNumero(Integer facNumero) {
        this.facNumero = facNumero;
    }

    public String getLinNumeroLinea() {
        return linNumeroLinea;
    }

    public void setLinNumeroLinea(String linNumeroLinea) {
        this.linNumeroLinea = linNumeroLinea;
    }

    public Date getFacFechaEmision() {
        return facFechaEmision;
    }

    public void setFacFechaEmision(Date facFechaEmision) {
        this.facFechaEmision = facFechaEmision;
    }

    public long getFacValor() {
        return facValor;
    }

    public void setFacValor(long facValor) {
        this.facValor = facValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facNumero != null ? facNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facNumero == null && other.facNumero != null) || (this.facNumero != null && !this.facNumero.equals(other.facNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sena.entities.Factura[ facNumero=" + facNumero + " ]";
    }
    
}
