package com.sena.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-17T12:44:32")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Date> facFechaEmision;
    public static volatile SingularAttribute<Factura, Long> facValor;
    public static volatile SingularAttribute<Factura, Integer> facNumero;
    public static volatile SingularAttribute<Factura, String> linNumeroLinea;

}