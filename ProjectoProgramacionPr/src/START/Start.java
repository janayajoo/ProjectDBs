/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package START;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 */
public class Start extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
   

    @Override
    public void start(Stage Ventana) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/VISTA/menuPrincipal.fxml"));
        
        Scene scene =  new Scene(root);
        
        Ventana.setScene(scene);
        
        Ventana.setTitle("MENU PRINCIPAL");
        
        //Ventana.SetOnCloserequest(event -> )
        Ventana.setResizable(false);
        
        Ventana.show();
        
        //______________________IMAGENES____________________________________
        
        
    }
    
    
    
}
