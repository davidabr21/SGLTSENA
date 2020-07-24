package com.sena.beans;

import com.sena.dao.EquipoDAO;
import com.sena.dao.LineaDAO;
import com.sena.entities.Equipo;
import com.sena.entities.Linea;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class LineaBean {
    
    private Linea registerObject;
    private Equipo equipoObject = new Equipo();;
    
    @EJB
    private LineaDAO lineaService;
    
    @EJB
    private EquipoDAO equipoService;
    
    public LineaBean (){
        
    }
    
    @PostConstruct
    public void init() {
        registerObject = new Linea();
    }
    
    public List<Linea> getAll() {
        return this.lineaService.getAll();
    }

    public Linea findById(Long id) {
        return this.lineaService.findById(id);
    }

    public void update(Linea linea) {
        this.lineaService.update(linea);
    }

    public void create() {
        if(this.lineaService.lineaExists(registerObject.getLinNumeroLinea())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El número de línea ya existe."));
        } else {
            this.equipoObject.setLinNumeroLinea(registerObject.getLinNumeroLinea());
            this.lineaService.create(registerObject);
            this.equipoService.create(equipoObject);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha creado el usuario exitosamente."));
        }
    }

    public void delete(Linea linea) {
        this.lineaService.delete(linea);
    }

    public Linea getRegisterObject() {
        return registerObject;
    }

    public void setRegisterObject(Linea registerObject) {
        this.registerObject = registerObject;
    }

    public Equipo getEquipoObject() {
        return equipoObject;
    }

    public void setEquipoObject(Equipo equipoObject) {
        this.equipoObject = equipoObject;
    }
    
    
}
