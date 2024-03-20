package Views;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import Views.Utilisateur.Personne;

public class Tableau_follower extends Application {

   

    public void start(Stage primaryStage) {
        // Créer une nouvelle fenêtre
        Stage nouvelle_fenetre = new Stage();

        // Créer une TableView
        TableView<Personne> tableView = new TableView<>();

        // Créer une colonne pour le nom de l'ami
        TableColumn<Personne, String> nomColonne = new TableColumn<>("Amis");

        // Créer une colonne pour le nom de l'utilisateur bloqué

        ObservableList<Personne> data_personne = FXCollections.observableArrayList();
        

        // Supposons que currentUser est l'utilisateur actuellement sélectionné
        ArrayList<String> liste_personne = new ArrayList<>();

        // Ajouter des noms d'amis à la liste
        
        liste_personne.addAll(Arrays.asList("Ami 1", "Ami 2", "Ami 3", "Ami 4", "Ami 5"));
        


        // Parcourir la liste des amis
        for (String ami : liste_personne) {
            // Créer un nouvel objet Ami avec le nom de l'ami
            Personne individus = new Personne(ami);
            // Ajouter l'ami à la liste
            data_personne.add(individus);
        }


        nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));

        // Ajouter les colonnes à la TableView
        tableView.getColumns().add(nomColonne);


        // Ajouter la liste à la TableView
        tableView.setItems(data_personne);

        // Créer un bouton pour fermer la fenêtre
        Button fermerBouton = new Button("Fermer");
        fermerBouton.setOnAction(e -> nouvelle_fenetre.close());

        // Créer une VBox pour contenir la TableView et le bouton
        VBox vbox = new VBox(tableView, fermerBouton);

        // Créer une nouvelle scène
        Scene scene = new Scene(vbox, 200, 200);

        // Ajouter la scène à la nouvelle fenêtre
        nouvelle_fenetre.setScene(scene);

        // Configurer la nouvelle fenêtre
        nouvelle_fenetre.setTitle("Liste de vos amis");
        nouvelle_fenetre.setX(primaryStage.getX() + 200);
        nouvelle_fenetre.setY(primaryStage.getY() + 100);

        // Afficher la nouvelle fenêtre
        nouvelle_fenetre.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    


}