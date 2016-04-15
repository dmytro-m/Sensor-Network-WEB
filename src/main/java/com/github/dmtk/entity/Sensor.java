package com.github.dmtk.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "sensors")
public class Sensor implements Serializable {

    
    @Id
    private Integer id;
    
    private String name = "Name";
    private String measuredQuantity = "Temperature";
    private String coapURI="";
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Sensor() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.setId((Integer) id);
    }

    
    public String getMeasuredQuantity() {
        return measuredQuantity;
    }

    public void setMeasuredQuantity(String measuredQuantity) {
        this.measuredQuantity = measuredQuantity;
    }

    public String getCoapURI() {
        return coapURI;
    }

    public void setCoapURI(String coapURI) {
        this.coapURI = coapURI;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.dmtk.NewEntity[ id=" + id + " ]";
    }

}
