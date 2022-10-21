/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author SERGIO PC
 */
public class Persona {
    private String id;
    private String name;
    
    public Persona(){
        this.id = "";
        this.name = "";
        
    }
    
    public Persona(String id, String name){
        
        this.id = id;
        this.name = name;
          
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
     
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + ";" + this.name;
    }
    
    
    
    
    
    
}
