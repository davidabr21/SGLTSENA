package com.sena.beans;

import com.sena.dao.EquipoDAO;
import com.sena.entities.Equipo;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class EquipoBean {
    
    @EJB
    private EquipoDAO equipoService;
    
    public EquipoBean (){
        
    }
    
    public List<Equipo> getAll() {
        return this.equipoService.getAll();
    }

    public Equipo findById(Long id) {
        return this.equipoService.findById(id);
    }

    public void update(Equipo equipo) {
        this.equipoService.update(equipo);
    }

    public void create(Equipo equipo) {
        this.equipoService.create(equipo);
    }

    public void delete(Equipo equipo) {
        this.equipoService.delete(equipo);
    }
}
