package com.sena.beans;

import com.sena.dao.PersonaDAO;
import com.sena.entities.Persona;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author User
 */
@ManagedBean(name = "persona")
@SessionScoped
public class PersonaBean {
    
    private Persona registerObject;
    
    @EJB
    private PersonaDAO personaService;
    
    public PersonaBean (){
        registerObject = new Persona();
    }
    
    public List<Persona> getAll() {
        return this.personaService.getAll();
    }

    public Persona findById(Integer id) {
        return this.personaService.findById(id);
    }

    public void update(Persona persona) {
        this.personaService.update(persona);
    }

    public void create() {
        if(this.personaService.personaExists(registerObject.getPerCedula())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La persona con cédula '" + registerObject.getPerCedula() + "' ya existe."));
        } else {
            this.personaService.create(registerObject);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La persona " + registerObject.getPerNombre() + " fue creada exitosamente."));
        }
    }

    public void delete(Persona persona) {
        this.personaService.delete(persona);
    }

    public Persona getRegisterObject() {
        return registerObject;
    }

    public void setRegisterObject(Persona registerObject) {
        this.registerObject = registerObject;
    }
    
    
}
