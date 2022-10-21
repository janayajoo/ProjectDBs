/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTION;

import MODELO.Programa;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SERGIO PC
 */
public class gestionPrograma {
    Programa programa;
    private String rutaPrograma;
    
    
    
    public gestionPrograma(){
        this.rutaPrograma = "./ARCHIVOS/programa.txt";
        this.verificarArchivoPrograma();
    }
    
    public void guardarPrograma(Programa pro){
 
        try{
            File file = new File(this.rutaPrograma);
            FileWriter fr = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fr);
            pw.println(pro.toString());
            pw.close();
//            JOptionPane.showMessageDialog(null, "El programa a sido guardado exitosamente...");
        }

        catch(IOException ex){
            System.out.println("No se pudo guardar el programa...");
        }
    }

    public boolean verificarArchivoPrograma(){
        boolean verify = false;
        try{
            File filex = new File(this.rutaPrograma); //si no existe la ruta
            if(!filex.exists()){
                filex.createNewFile(); // lo creo
                verify = true;
            }
        }

        catch (IOException ex){
            System.out.println("Problema con la ruta creando archivo...");
        }

        return verify;
    }
    
    public ArrayList<Programa> get_todos(){
        ArrayList<Programa> libro = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;
        int i = 0;

        try{
            file = new FileReader(this.rutaPrograma);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                Programa lib = new Programa(campos[0], campos[1], Boolean.parseBoolean(campos[2]), Boolean.parseBoolean(campos[3]), Boolean.parseBoolean(campos[4]));
                libro.add(lib);
               
               
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return libro;
    }
    
    
    public Programa getPrograma (String id){
        FileReader file;
        BufferedReader br;
        String registro;
        Programa carre = null;
        
        try{
            file = new FileReader(this.rutaPrograma);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                
                if(campos[0].equals(id)){
                    carre = new Programa(campos[0], campos[1], Boolean.parseBoolean(campos[2]), Boolean.parseBoolean(campos[3]), Boolean.parseBoolean(campos[4]));
                    break;
                }
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return carre;
    }
    
    public void modificarPrograma(String oldid, Programa laNueva){
        ArrayList<Programa> carres = this.get_todos();
        int i=0;
        for (Programa carre: carres){
            if (carre.getId().equals(oldid)){
                carres.set(i, laNueva);
                this.reemplazarArchivo(carres);
                break;
            }
            i++;
        }
     }
    
    public boolean eliminarProgramaID(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Programa> carres = this.get_todos();
            for(Programa carre:carres){
                if(carre.getId().equals(id)){
                    carres.remove(carre);
                    this.reemplazarArchivo(carres);
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
    
    public boolean eliminarProgramaNombre(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Programa> carres = this.get_todos();
            for(Programa carre:carres){
                if(carre.getNombrePrograma().equals(id)){
                    carres.remove(carre);
                    this.reemplazarArchivo(carres);
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
    
    public boolean verificaNombre (String name){
        boolean esta=false;
        ArrayList<Programa> carres=this.get_todos();
        for (Programa carre:carres){
            if (carre.getNombrePrograma().equals (name)){
                esta=true;
            }
        }
        return esta;
    }
    
    public boolean verificaCodigo (String code){
        boolean existe=false;
        ArrayList<Programa> carres = this.get_todos();
        for (Programa carre:carres){
            if (carre.getId().equals (code)){
                existe=true;
            }
        }
        return existe;
    }

    private void reemplazarArchivo(ArrayList<Programa> carres) {
        try{
            File file = new File(this.rutaPrograma);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw);
            for(Programa carre: carres){
                pw.println(carre.toString());
            }
            pw.close();
        }

        catch(IOException ex) {
            System.out.println("No se puede reemplazar el archivo...");
        }
    }
    
}
