
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.stage.Stage;
import Views.viewLogin;
import Views.viewPrincipal;
import Views.viewSignin;
import Views.Global;
import Views.Interface_scene;

import java.io.IOException;



public class Vrai_appli extends Application implements Interface_scene{
    
    // Importation et accès aux variables globales de la fenêtre
    Global global = new Global(); 
    String TITRE_FENETRE = global.get_TITRE_FENETRE();
    double LARGEUR_FENETRE  = global.get_LARGEUR_FENETRE();
    double LONGUEUR_FENETRE  = global.get_LONGUEUR_FENETRE();

    
    
    public void start(Stage primaryStage) throws IOException {
        viewLogin viewconnexion = new viewLogin(5, primaryStage);
        Scene sceneconnexion = new Scene(viewconnexion);
        viewPrincipal viewprincipal = new viewPrincipal(primaryStage);
        Scene sceneprincipal = new Scene(viewprincipal);
        
        viewSignin viewinscription = new viewSignin(primaryStage);
        Scene sceneinscription = new Scene(viewinscription);
        
        primaryStage.setScene(sceneconnexion);
        primaryStage.setTitle(TITRE_FENETRE); // Définitions des détails de le fenetre avec des variables globales
        primaryStage.setWidth(LARGEUR_FENETRE);
        primaryStage.setHeight(LONGUEUR_FENETRE);
        primaryStage.show();

        viewconnexion.btn_inscription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setscene_visible(primaryStage, sceneinscription);
            }
        });

        viewconnexion.btn_valider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               setscene_visible(primaryStage, sceneprincipal);
            }
        });

          // Gère le Bouton retour lorsque l'on est sur la page d'inscription
          viewinscription.bouton_retour_inscription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               setscene_visible(primaryStage, sceneconnexion);
            }
        });

        //  Gère le bouton de déconnexion
        viewprincipal.bouton_deconnexion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setscene_visible(primaryStage, sceneconnexion);
            }
        });

        
      
        // primaryStage.setFullScreen(true);
    }


    public static void main (String[] args){
        launch(args);
    }

    public void setscene_visible(Stage unStage, Scene uneScene){
        unStage.setScene(uneScene);
        unStage.sizeToScene(); // force actualisation de la scène
        unStage.setWidth(LARGEUR_FENETRE); // la redimensionne
        unStage.setHeight(LONGUEUR_FENETRE);
    }
    
}
