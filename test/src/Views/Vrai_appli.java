package Views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import Views.Utilisateur.User;



public class Vrai_appli extends Application implements Interface_scene{
    
    // Importation et accès aux variables globales de la fenêtre
    Global global = new Global(); 
    String TITRE_FENETRE = global.get_TITRE_FENETRE();
    double LARGEUR_FENETRE  = global.get_LARGEUR_FENETRE();
    double LONGUEUR_FENETRE  = global.get_LONGUEUR_FENETRE();
    Requete moteur_de_Requete = new Requete();
    User user = new User();

    
    
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
                String identifiant = new String(viewconnexion.slot_id.getText());
                String mdp = new String(viewconnexion.slot_mdp.getText());
                try {  // bloc try catch pour gérer les erreurs de connexion
                    // On teste si l'identifiant est dans la base de données
                    if (moteur_de_Requete.parcoursTableSQL("SELECT * FROM USERS;", "login").contains(identifiant)) {
                        // On regarde si le mdp correspond à l'identifiant
                        if (moteur_de_Requete.parcoursTableSQL("SELECT * FROM USERS WHERE login = '" + identifiant + "'", "mdp").contains(mdp)) {
                            setscene_visible(primaryStage, sceneprincipal); // Accès au mur 
                        }

                        else // une exception est levée si le mot de passe est incorrect
                            throw new Exception("Mot de passe incorrect");
                    }
                    else // idem pour l'identifiant
                        throw new Exception("Identifiant inconnu");
    
                } catch (Exception e) { // bloc catch qui afficher un message d'erreur
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur de connexion");
                    alert.setHeaderText(null);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();

                }
            // Gestion du mur et des ses posts
            user = viewprincipal.creation_USER(viewconnexion);
            viewprincipal.info_post_mur(user, moteur_de_Requete);
        }});

          // Gère le Bouton retour lorsque l'on est sur la page d'inscription
          viewinscription.bouton_retour_inscription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setscene_visible(primaryStage, sceneconnexion);
            }
        });

        // Gère le bouton de validation de l'inscription
            viewinscription.btn_valider_inscription.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nom = new String(viewinscription.slot_nom.getText());
                String prenom = new String(viewinscription.slot_prenom.getText());
                String identifiant = new String(creationID(nom, prenom));
                String mdp = new String(viewinscription.slot_mdp.getText());
                String mdp2 = new String(viewinscription.slot_password2.getText());
                LocalDate date_anniversaire = viewinscription.date_anniversaire.getValue(); // convertit la date en string

                
                try {

                    if (nom.isBlank() || prenom.isBlank() || mdp.isBlank() || mdp2.isBlank() || date_anniversaire == null) {
                        throw new Exception("Veuillez remplir tous les champs");
                    }
                    
                    // On teste si l'identifiant est déjà dans la base de données
                    else if (moteur_de_Requete.parcoursTableSQL("SELECT * FROM USERS;", "login").contains(identifiant)) {
                        throw new Exception("Identifiant déjà utilisé");
                    }

                    // On teste si les deux mots de passe sont identiques
                    else if (!mdp.equals(mdp2)) {
                        throw new Exception("Les mots de passe ne correspondent pas");
                    }

                    else {
                        moteur_de_Requete.insertion_sql("INSERT INTO USERS (login, mdp, nom, prenom, dateNaiss) VALUES ('" + identifiant + "', '" + mdp + "', '" + nom.toUpperCase()  + "' , '" + prenom + "' , '" + date_anniversaire + "');");
                        System.out.println("Inscription réussie");
                        setscene_visible(primaryStage, sceneconnexion);
                    }  

                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur d'inscription");
                    alert.setHeaderText(null);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
        });


        //  Gère le bouton de déconnexion
        viewprincipal.menu_deconnexion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setscene_visible(primaryStage, sceneconnexion);
                viewprincipal.vbox_post.getChildren().clear();
            }
        });
 
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

    private String creationID(String nom, String prenom){
        return String.valueOf(prenom.toLowerCase().charAt(0))  + String.valueOf(nom.toLowerCase().charAt(0));
    }

    
    
}
