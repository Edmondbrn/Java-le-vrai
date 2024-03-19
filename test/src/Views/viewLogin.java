package Views;

import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.collections.ObservableList;


public class viewLogin extends StackPane{

    Global global = new Global(); 
    
    String TITRE_FENETRE = global.get_TITRE_FENETRE();
    double LARGEUR_FENETRE = global.get_LARGEUR_FENETRE();
    double LONGUEUR_FENETRE = global.get_LONGUEUR_FENETRE();
    int TAILLE_FIELD_TEXTE = 400;
    VBox vbox = new VBox(10);
    ObservableList<Node> components = this.getChildren(); 
    
    Label titre_fenetre = new Label("Veuillez entrer vos identifiants pour vous connecter");
    Label titre_mdp = new Label("Mot de passe");
    Label titre_id = new Label("Email");
    Label titre_inscription = new Label("Pas encore inscrit ?");
    PasswordField slot_mdp = new PasswordField();
    TextField slot_id = new TextField();
    public Button btn_inscription = new Button("S'inscrire");
    public Button btn_valider = new Button("Valider");
    ImageView backgroundImage = new ImageView(new Image("background.png"));
    Rectangle rectangle = new Rectangle (550, 300);
    
    public viewLogin(double spacing, Stage unStage) {
        super(); // constructeur de Stackplane
        
        backgroundImage.fitWidthProperty().bind(this.widthProperty()); // Règle les dimensions de l'image
        backgroundImage.fitHeightProperty().bind(this.heightProperty());
        
        // Règle la taille du texte, taille des champs etc...
        
        titre_fenetre.setFont(Font.font(20));
        
        titre_mdp.setFont(Font.font(15));
        
        slot_mdp.setMaxWidth(400);
        
        titre_id.setFont(Font.font(15));

        slot_id.setMaxWidth(400);

        titre_inscription.setFont(Font.font(15));

        btn_inscription.setMaxWidth(100);
        btn_valider.setMaxWidth(100);
        rectangle.setFill(Color.web("white", 0.7));  // Définit la couleur du rectangle en blanc avec 60% de transparence
        rectangle.setStroke(Color.web("black", 0.6)); // Définit la couleur de la bordure du rectangle en noir avec 60% de transparence
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        this.setAlignment(Pos.CENTER); // Place le rectangle au centre de la fenêtre
        
        vbox.setAlignment(Pos.CENTER); // Alignez les éléments au centre verticalement

        // Ajout éléments à Vbox pour qu'ils soient alignés automatiquement
        vbox.getChildren().addAll(titre_fenetre, titre_id, slot_id, titre_mdp, slot_mdp, btn_valider, titre_inscription, btn_inscription);

        // Ajout image de fond et la VBox à la liste des éléments du StackPane
        components.addAll(backgroundImage, rectangle, vbox);
        
        
        // Gère ce que fait le bouton S'inscrire
        
        

      
        

    }
    
    // Mutateur de la liste contenant les élements de la scène pour passer d'une page à une autre
   
    // Accesseur qui renvoie la liste des éléments de la page d'origine pour la recharger au cas où
    public VBox getVbox(){
        return this.vbox;
    }
    
    


}
