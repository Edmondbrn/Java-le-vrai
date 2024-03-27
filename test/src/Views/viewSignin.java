package Views;


import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;


public class viewSignin extends StackPane{
        // Définition des variables
    
        Global global = new Global(); 
        String TITRE_FENETRE = global.get_TITRE_FENETRE();
        double LARGEUR_FENETRE = global.get_LARGEUR_FENETRE();
        double LONGUEUR_FENETRE = global.get_LONGUEUR_FENETRE();
        int TAILLE_FIELD_TEXTE = 400;
        
        Label titre_fenetre = new Label("Inscription");
        
        Label Titre_nom = new Label("Entrer votre nom");
        TextField slot_nom = new TextField();

        Label Titre_prenom = new Label("Entrer votre prénom");
        TextField slot_prenom = new TextField();

        Label Titre_anniverssaire = new Label("Entrer votre date d'anniversaire");
        DatePicker date_anniversaire = new DatePicker();
    
        Label titre_mdp = new Label("Entrer votre mot de passe");
        PasswordField slot_mdp = new PasswordField();

        Label Titre_password2 = new Label("Entrer votre mot de passe une nouvelle fois");
        PasswordField slot_password2 = new PasswordField();

     

        Rectangle rectangle = new Rectangle (500, 500);

        public Button btn_valider_inscription = new Button("Valider");
        public Button bouton_retour_inscription = new Button("Retour");

        VBox vbox = new VBox(10);
        ObservableList<Node> components = this.getChildren(); 
        ImageView backgroundImage = new ImageView(new Image("background.png"));


        public viewSignin(Stage un_autrestage) {
            super(); 
            backgroundImage.fitWidthProperty().bind(this.widthProperty()); // Règle les dimensions de l'image
            backgroundImage.fitHeightProperty().bind(this.heightProperty());
            // Fixe la taille de la police de caractère
            titre_fenetre.setFont(Font.font(20));
    
            titre_mdp.setFont(Font.font(15));

            Titre_password2.setFont(Font.font(15));
    
            slot_mdp.setMaxWidth(400);
            slot_password2.setMaxWidth(400);
    
      
    
            Titre_nom.setFont(Font.font(15));
            Titre_prenom.setFont(Font.font(15));

            slot_nom.setMaxWidth(400); // Défini la longueur de l'espace dédié au champs
            slot_prenom.setMaxWidth(400);

            Titre_anniverssaire.setFont(Font.font(15));
            
            btn_valider_inscription.setMaxWidth(100);
            bouton_retour_inscription.setMaxWidth(120);
            
            
            rectangle.setFill(Color.web("white", 0.7));  // Définit la couleur du rectangle en blanc avec 60% de transparence
            rectangle.setStroke(Color.web("black", 0.6)); // Définit la couleur de la bordure du rectangle en noir avec 60% de transparence
            rectangle.setArcHeight(50);
            rectangle.setArcWidth(50);
            this.setAlignment(Pos.CENTER);

            vbox.setAlignment(Pos.CENTER); // Alignez les éléments au centre verticalement

            // Ajout éléments à Vbox pour qu'ils soient alignés automatiquement
            vbox.getChildren().addAll(titre_fenetre, Titre_nom, slot_nom,Titre_prenom, slot_prenom, 
                                            titre_mdp, slot_mdp, Titre_password2, slot_password2, Titre_anniverssaire , 
                                            date_anniversaire, btn_valider_inscription, bouton_retour_inscription);
    
            components.addAll(backgroundImage, rectangle, vbox);


        }

       
}
