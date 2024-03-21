package Views;


import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import Views.Utilisateur.Personne;

public class Tableau_bloque extends Application {

   // Créer une nouvelle fenêtre
   Stage nouvelle_fenetre = new Stage();

    
   // Créer une TableView
   TableView<Personne> tableView = new TableView<>();

   // Créer une colonne pour le nom de l'ami
   TableColumn<Personne, String> nomColonne = new TableColumn<>("Utilisateur bloqués");

   // Créer une colonne pour le nom de l'utilisateur bloqué

   ObservableList<Personne> data_personne = FXCollections.observableArrayList();
   
   Button fermerBouton = new Button("Fermer");

   // Supposons que currentUser est l'utilisateur actuellement sélectionné
   ArrayList<String> liste_personne = new ArrayList<>();
   // Créer une VBox pour contenir la TableView et le bouton
   VBox vbox = new VBox(tableView, fermerBouton);

   // Créer une nouvelle scène
   Scene scene = new Scene(vbox, 200, 200);

   public void start(Stage primaryStage) {


       // Ajouter des noms d'amis à la liste
       liste_personne.addAll(Arrays.asList("Bloqué 1", "Bloqué 2", "Bloqué 3", "Bloqué 4", "Bloqué 5"));
       
       
       // Parcourir la liste des amis
       for (String ami : liste_personne) {
           // Créer un nouvel objet Ami avec le nom de l'ami
           Personne individus = new Personne(ami);
           // Ajouter l'ami à la liste
           data_personne.add(individus);
       }

       // ajout des colonnes
       nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
       
       // Ajouter les colonnes à la TableView
       tableView.getColumns().add(nomColonne);
       
       
       // Ajouter la liste à la TableView
       tableView.setItems(data_personne);
               

       // Créer un bouton pour fermer la fenêtre
       fermerBouton.setOnAction(e -> nouvelle_fenetre.close());

       // Appeler la méthode pour gérer le blocage de l'utilisateur
       this.gestionUtilisateurBloque();


       // Ajouter la scène à la nouvelle fenêtre
       nouvelle_fenetre.setScene(scene);

       // Configurer la nouvelle fenêtre
       nouvelle_fenetre.setTitle("Liste des utilisateurs bloqués");
       nouvelle_fenetre.setX(primaryStage.getX() + 200);
       nouvelle_fenetre.setY(primaryStage.getY() + 100);

       // Afficher la nouvelle fenêtre
       nouvelle_fenetre.show();
   }
   
   public static void main(String[] args) {
       launch(args);
   }
   
   private void gestionUtilisateurBloque() {
       /*
        * Méthode qui crée et ajoute un élément de menu lors du clique droit sur un nom d'utilisateur
        * 
        */
       // Définition des éléments du meni contextuel
       ContextMenu contextMenu = new ContextMenu();
       MenuItem bloquerItem = new MenuItem("Débloquer cet utilisateur ?");

       // Ajouter un écouteur d'événements pour l'élément de menu
           bloquerItem.setOnAction(e -> {
               Personne selectedPersonne = tableView.getSelectionModel().getSelectedItem();
               if (selectedPersonne != null) {
                   // Ici, vous pouvez ajouter le code pour bloquer l'utilisateur
                   System.out.println("test");
               }
           });
 
       // Ajouter l'élément de menu au menu contextuel
       contextMenu.getItems().add(bloquerItem);

       // Ajouter le menu contextuel à la TableView
       tableView.setContextMenu(contextMenu);
   }


   


}