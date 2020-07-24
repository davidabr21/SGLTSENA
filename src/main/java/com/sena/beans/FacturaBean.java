package com.sena.beans;


import com.sena.dao.FacturaDAO;
import com.sena.dao.LineaDAO;
import com.sena.dao.PersonaDAO;
import com.sena.entities.Factura;
import com.sena.entities.Linea;
import com.sena.entities.Persona;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author User
 */
@ManagedBean(name = "factura")
@SessionScoped
public class FacturaBean implements Serializable {
    
    @EJB
    private FacturaDAO facturaService;
    
    @EJB
    private PersonaDAO personaService;
    
    @EJB
    private LineaDAO lineaService;
    
    private Factura objectRegister;
    
    private Persona personObject = new Persona();
    
    private String fechaEmision = "";
    
    private String lineaTelefonica = "";
    
    private Integer perId;
    
    private List<Factura> facturasResult = new ArrayList<Factura>();    
    
    public FacturaBean (){
        objectRegister = new Factura();
        personObject = new Persona();
    }
    
    public List<Factura> getAll() {
        return this.facturaService.getAll();
    }

    public Factura findById(Long id) {
        return this.facturaService.findById(id);
    }

    public void update(Factura factura) {
        this.facturaService.update(factura);
    }

    public void create() throws Exception {
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(fechaEmision);
        objectRegister.setFacFechaEmision(date);
        this.facturaService.create(objectRegister);
    }

    public void delete(Factura factura) {
        this.facturaService.delete(factura);
    }
    
    public void filterFacturas() {
        personObject = this.personaService.findById(perId);
        Linea linea = this.lineaService.getByPerId(personObject.getPerId());
        lineaTelefonica = linea.getLinNumeroLinea();
        

        
    }

    public Factura getObjectRegister() {
        return objectRegister;
    }

    public void setObjectRegister(Factura objectRegister) {
        this.objectRegister = objectRegister;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Persona getPersonObject() {
        return personObject;
    }

    public void setPersonObject(Persona personObject) {
        this.personObject = personObject;
    }

    public List<Factura> getFacturasResult() {
        return facturasResult;
    }

    public void setFacturasResult(List<Factura> facturasResult) {
        this.facturasResult = facturasResult;
    }

    public String getLineaTelefonica() {
        return lineaTelefonica;
    }

    public void setLineaTelefonica(String lineaTelefonica) {
        this.lineaTelefonica = lineaTelefonica;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }
    
}
