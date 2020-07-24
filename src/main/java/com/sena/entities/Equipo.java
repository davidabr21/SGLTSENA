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
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
    , @NamedQuery(name = "Equipo.findByEquSerial", query = "SELECT e FROM Equipo e WHERE e.equSerial = :equSerial")
    , @NamedQuery(name = "Equipo.findByLinNumeroLinea", query = "SELECT e FROM Equipo e WHERE e.linNumeroLinea = :linNumeroLinea")
    , @NamedQuery(name = "Equipo.findByEquMarca", query = "SELECT e FROM Equipo e WHERE e.equMarca = :equMarca")
    , @NamedQuery(name = "Equipo.findByEquDescripcion", query = "SELECT e FROM Equipo e WHERE e.equDescripcion = :equDescripcion")
    , @NamedQuery(name = "Equipo.findByEquEstado", query = "SELECT e FROM Equipo e WHERE e.equEstado = :equEstado")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "equSerial")
    private Integer equSerial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "linNumeroLinea")
    private String linNumeroLinea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "equMarca")
    private String equMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "equDescripcion")
    private String equDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "equEstado")
    private String equEstado;

    public Equipo() {
    }

    public Equipo(Integer equSerial) {
        this.equSerial = equSerial;
    }

    public Equipo(Integer equSerial, String linNumeroLinea, String equMarca, String equDescripcion, String equEstado) {
        this.equSerial = equSerial;
        this.linNumeroLinea = linNumeroLinea;
        this.equMarca = equMarca;
        this.equDescripcion = equDescripcion;
        this.equEstado = equEstado;
    }

    public Integer getEquSerial() {
        return equSerial;
    }

    public void setEquSerial(Integer equSerial) {
        this.equSerial = equSerial;
    }

    public String getLinNumeroLinea() {
        return linNumeroLinea;
    }

    public void setLinNumeroLinea(String linNumeroLinea) {
        this.linNumeroLinea = linNumeroLinea;
    }

    public String getEquMarca() {
        return equMarca;
    }

    public void setEquMarca(String equMarca) {
        this.equMarca = equMarca;
    }

    public String getEquDescripcion() {
        return equDescripcion;
    }

    public void setEquDescripcion(String equDescripcion) {
        this.equDescripcion = equDescripcion;
    }

    public String getEquEstado() {
        return equEstado;
    }

    public void setEquEstado(String equEstado) {
        this.equEstado = equEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equSerial != null ? equSerial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.equSerial == null && other.equSerial != null) || (this.equSerial != null && !this.equSerial.equals(other.equSerial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sena.entities.Equipo[ equSerial=" + equSerial + " ]";
    }
    
}
