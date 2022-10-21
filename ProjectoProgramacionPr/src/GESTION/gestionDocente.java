/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GESTION;

import MODELO.Docente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author SERGIO PC
 */
public class gestionDocente {
   Docente Docente;
   private String rutaDocente;

   public gestionDocente(){
        this.rutaDocente = "./ARCHIVOS/docente.txt";
        this.verificarArchivoDocente();
   }
   
   public void guardarDocente(Docente pro){
       
        try{
            File file = new File(this.rutaDocente);
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
   
   public boolean verificarArchivoDocente(){
        boolean verify = false;
        try{
            File filex = new File(this.rutaDocente); //si no existe la ruta
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
   
    public ArrayList<Docente> getTodos(){
        ArrayList<Docente> libroDoc = new ArrayList();
        FileReader file;
        BufferedReader br;
        String registro;

        try{
            file = new FileReader(this.rutaDocente);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                Docente lib = new Docente(campos[0], campos[1], campos[2], campos[3]);
                libroDoc.add(lib);
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return libroDoc;
    }
    
    
    public Docente getDocente(String id){
        FileReader file;
        BufferedReader br;
        String registro;
        Docente carre = null;
        
        try{
            file = new FileReader(this.rutaDocente);
            br = new BufferedReader(file);
            while((registro = br.readLine()) != null){
                String[] campos = registro.split(";");
                
                if(campos[0].equals(id)){
                    carre = new Docente(campos[0], campos[1],  campos[2], campos[3]);
                    break;
                }
            }
        }

        catch(IOException ex){
            System.out.println("Fallo buscando libro...");
        }
        return carre;
    }
    
    public void modificarDocente(String oldid, Docente laNueva){
        ArrayList<Docente> carres = this.getTodos();
        int i=0;
        for (Docente carre: carres){
            if (carre.getId().equals(oldid)){
                carres.set(i, laNueva);
                this.reemplazarArchivo(carres);
                break;
            }
            i++;
        }
    }
    
    public boolean eliminarDocenteId(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Docente> estu = this.getTodos();
            for(Docente carre:estu){
                if(carre.getId().equals(id)){
                    estu.remove(carre);
                    this.reemplazarArchivo(estu);
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
    
    public boolean eliminarDocenteNombre(String id){
        boolean existe = false;
        
        if(this.verificaCodigo(id)){
            ArrayList<Docente> carres = this.getTodos();
            for(Docente carre:carres){
                if(carre.getName().equals(id)){
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
        
        ArrayList<Docente> estu=this.getTodos();
        for (Docente carre:estu){
            if (carre.getName().equals(name)){
                esta=true;
            }
        }
        return esta;
    }
    
    public boolean verificaCodigo (String code){
        boolean existe=false;
        ArrayList<Docente> carres = this.getTodos();
        for (Docente carre:carres){
            if (carre.getId().equals (code)){
                existe=true;
            }
        }
        return existe;
    }
    
    private void reemplazarArchivo(ArrayList<Docente> carres) {
        try{
            File file = new File(this.rutaDocente);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw);
            for(Docente carre: carres){
                pw.println(carre.toString());
            }
            pw.close();
        }

        catch(IOException ex) {
            System.out.println("No se puede reemplazar el archivo...");
        }
    }
    
   
   
   
   
     
}
