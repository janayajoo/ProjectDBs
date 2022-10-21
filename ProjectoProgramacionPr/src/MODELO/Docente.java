/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.util.Objects;

/**
 *
 * @author SERGIO PC
 */
public class Docente extends Persona {
    private String categoria, foto;
    
    public Docente(){
        super();
        this.categoria = "";
        this.foto = "";
        
    }
    
    public Docente(String id, String nombres, String categoria, String foto){
        super(id,nombres);
        this.categoria = categoria;
        this.foto = foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.getId() + ";"+ super.getName()+ ";"+this.categoria+";"+this.foto;
    }

    
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(super.getId());
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (this == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final Docente other = (Docente) obj;
        if(!Objects.equals(super.getId(), other)){
            return false;
        }
        return true;
         
    }
}
