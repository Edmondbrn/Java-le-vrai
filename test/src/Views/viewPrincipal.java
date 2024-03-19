package Views;


import java.io.File;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;




public class viewPrincipal extends ScrollPane {

    Global global = new Global(); 
    StackPane fond = new StackPane(); // crée un stackpane pour accueillir le fond d'écran
    ObservableList<Node> composant = this.getChildren(); // Crée la liste des composants de la page en utilisant le ScrollPane en référence
    VBox vbox_principal = new VBox(); // Crée une Vbox pour accueillir les éléments de la pas de sorte à ce qu'ils soient ordonés
    HBox topBar = new HBox(); // box pour gérer la barre de recherche et les boutons de navigation

    String TITRE_FENETRE = global.get_TITRE_FENETRE();
    double LARGEUR_FENETRE = global.get_LARGEUR_FENETRE();
    double LONGUEUR_FENETRE = global.get_LONGUEUR_FENETRE();
    int TAILLE_FIELD_TEXTE = 400;

    // Enonciation des variables pour le fond d'écran
    ImageView backgroundImage = new ImageView(new Image("background3.png"));
    ImageView backgroundImage2 = new ImageView(new Image("background3.png"));
    ImageView backgroundImage3 = new ImageView(new Image("background3.png"));
    ImageView backgroundImage4 = new ImageView(new Image("background3.png"));
    ImageView backgroundImage5 = new ImageView(new Image("background3.png"));

    VBox vbox_topbar = new VBox();
    Line separateur_top_barre = new Line();
    public Button bouton_deconnexion = new Button("Déconnexion");
    Label titre_fenetre_principal = new Label("Page personnel de XXX");
    TextField barre_recherche = new TextField();
    Label titre_recherche = new Label("Rechercher une page");
    VBox vbox_recherche = new VBox();
    ChoiceBox<String> type_post = new ChoiceBox<String>();
    Label titre_post = new Label("Sélection du type de post");
    VBox vbox_choix_post = new VBox();
    static VBox vbox_post = new VBox(20);
    VBox vbox_fond = new VBox();

    public Button bouton_poster = new Button("Poster");

    public viewPrincipal(Stage un_autre_Stage){ // user à rajouter
        vbox_principal.setAlignment(Pos.TOP_CENTER); // Centre les élémenst de la page
        topBar.setAlignment(Pos.TOP_CENTER);
        topBar.setSpacing(40);

        backgroundImage.fitWidthProperty().bind(this.widthProperty()); // Règle les dimensions de l'image
        backgroundImage.fitHeightProperty().bind(this.heightProperty());
        backgroundImage2.fitWidthProperty().bind(this.widthProperty()); // Règle les dimensions de l'image
        backgroundImage2.fitHeightProperty().bind(this.heightProperty());
        backgroundImage3.fitWidthProperty().bind(this.widthProperty()); // Règle les dimensions de l'image
        backgroundImage3.fitHeightProperty().bind(this.heightProperty());
        backgroundImage4.fitWidthProperty().bind(this.widthProperty()); // Règle les dimensions de l'image
        backgroundImage4.fitHeightProperty().bind(this.heightProperty());
        backgroundImage5.fitWidthProperty().bind(this.widthProperty()); // Règle les dimensions de l'image
        backgroundImage5.fitHeightProperty().bind(this.heightProperty());
        
        titre_fenetre_principal.setFont(Font.font(20)); // fixe la police d'écriture
        titre_fenetre_principal.setTranslateY(40); // Centre le titre de la page
        titre_fenetre_principal.setFont(Font.font("System", FontWeight.BOLD, 20)); // change la police d'écriture et la passe en gras

        bouton_deconnexion.setMaxWidth(120); // Place le bouton dans le coin en haut à gauche
        bouton_deconnexion.setTranslateY(40);

        barre_recherche.setPrefWidth(400); // Règle la taille de la barre de recherche
        titre_recherche.setLabelFor(barre_recherche);
        titre_recherche.setFont(Font.font("System", FontWeight.BOLD, 15)); // change la police d'écriture et la passe en gras
        vbox_recherche.setAlignment(Pos.CENTER);
        vbox_recherche.getChildren().addAll(titre_recherche, barre_recherche); // Ajoute les éléments à la barre de recherche

        type_post.getItems().addAll("Texte", "Image", "Vidéo"); // Ajoute les éléments à la liste déroulante
        titre_post.setLabelFor(type_post);
        titre_post.setFont(Font.font("System", FontWeight.BOLD, 15)); // change la police d'écriture et la passe en gras
        vbox_choix_post.getChildren().addAll(titre_post, type_post, bouton_poster); // Ajoute les éléments à la liste déroulante
        vbox_choix_post.setAlignment(Pos.CENTER);
        vbox_choix_post.setSpacing(5);

        vbox_post.setAlignment(Pos.CENTER); // Permet de centrer les pots et de les aligner à la verticale
        
        topBar.getChildren().addAll(vbox_recherche ,titre_fenetre_principal, vbox_choix_post, bouton_deconnexion); // Ajoute les éléments à la barre de recherche
        
        // Gestion du séparateur de l'en tête
        separateur_top_barre.setStartX(0.0f); // Point de départ
        separateur_top_barre.setStartY(0.0f);
        separateur_top_barre.setEndX(LARGEUR_FENETRE); // Défini la longueur du séparateur
        separateur_top_barre.setEndY(0.0f);
        separateur_top_barre.setStrokeWidth(3.0f); 
        separateur_top_barre.setStroke(Color.BLACK); // Change la couleur de la ligne en noir

        vbox_topbar.getChildren().addAll(topBar, separateur_top_barre); 
        vbox_topbar.setSpacing(10); // Ajoute un espacement entre les éléments de l'en tête

        // Ajout de tous les fonds à la vbox pour créer le fond d'écran (les aligne à la verticale)
        vbox_fond.getChildren().addAll(backgroundImage, backgroundImage2,  backgroundImage3,  backgroundImage4,  backgroundImage5); 
       
        vbox_principal.getChildren().addAll(vbox_topbar, vbox_post); // Ajoute le fond et l'en tête à la page
        vbox_principal.setSpacing(20); // Ajoute un espacement entre les éléments de la page

        fond.getChildren().addAll( vbox_fond,vbox_principal); // le stack pane recupère la vbox et ajoute le fond
        
        this.setContent(fond); // le scrollpane récupère le stackpane et affiche la scrollbar

        // gère le bouton poster
        this.bouton_poster.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String choix_du_post = new String(type_post.getValue()); // récupère le choix de l'utilisateur pour son post
                
                // Gère le cas où l'utilisateur a choisi de poster une Image
                if (choix_du_post.equals("Image")){ 
                    // Définition de la boite de dialogue pour choisir un fichier image 
                    FileChooser choix_fichier = new FileChooser();
                    // Filtre les fichiers sélectionnables
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.png, *.gif)", "*.png", "*.gif");
                    choix_fichier.getExtensionFilters().add(extFilter);
                    File fichier_choisi = choix_fichier.showOpenDialog(un_autre_Stage); // affiche la boite de dialogue
                    
                    if(fichier_choisi == null)
                        ; // ne fait rien si l'utilisateur n'a rien sélectionné
                    
                    else {
                        // Récupération du chemin du fichier image
                        String chemin = new String(fichier_choisi.getAbsolutePath());
                        ImageView image = new ImageView(new Image("file:///" + chemin));
    
                        image.setFitWidth(600); // Règle les dimensions de l'image
                        image.setFitHeight(400);
                        image.setPreserveRatio(true); // Garde les proportions de l'image

                        mise_en_page_post(image, false); // affiche les posts avec les boutons like, commenter et supprimer
                        
                    }
                }

                else if (choix_du_post.equals("Texte")){ // Gère le cas où l'utilisateur a choisi de poster du texte
                    TextArea champ_texte = new TextArea(); // Définition de la zone d'édition du texte
                    Label texte_du_post = new Label(); // futur variable qui va contenir le texte
                    Button bouton_valider_post = new Button("Poster");
                    champ_texte.setPrefWidth(TAILLE_FIELD_TEXTE); // Fixe la taille de la zone d'édition
                    champ_texte.setPromptText("Ecrivez votre Poste ici");
                    vbox_post.getChildren().addAll(champ_texte, bouton_valider_post); // Ajoute le champ de texte à la page
                    
                    // gère ce que fait le bouton valider
                    bouton_valider_post.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            texte_du_post.setText(champ_texte.getText()); // Crée un texte à partir du champ de texte
                            vbox_post.getChildren().remove(champ_texte); // Retire le champ de texte de la page
                            vbox_post.getChildren().remove(bouton_valider_post); // Supprime le bouton valider de la page
                            
                            mise_en_page_post(texte_du_post, true); // affiche les posts avec les boutons like, commenter et supprimer
                            
                        }

                    });
                }
                
                else if (choix_du_post.equals("Vidéo")){ // Gère le cas où l'utilisateur a choisi de poster une vidéo
                // Définition de la boite de dialogue pour choisir un fichier vidéo
                // FileChooser choix_fichier = new FileChooser();
                // FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Video files (*.mp4, *.flv, *.webv)", "*.mp4", "*.flv");
                // choix_fichier.getExtensionFilters().add(extFilter);
                // File fichier_choisi = choix_fichier.showOpenDialog(un_autre_Stage);
                
                // if(fichier_choisi == null)
                //     ; // ne fait rien si l'utilisateur n'a rien sélectionné
                
                // else {
                    //     // Utilise selectedDirectory
                    //     String chemin = new String(fichier_choisi.getAbsolutePath());
                    //   // Créez un objet Media
                    // EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
                    // EmbeddedMediaPlayer mediaPlayer = mediaPlayerComponent.mediaPlayer();
                    
                    // mediaPlayer.media().play("file:///" + chemin);
                    
                    // // Créez un objet MediaView
                    // MediaView mediaView = new MediaView(mediaPlayer);
                    // mediaView.setFitWidth(600); // Règle la largeur de la vidéo à 600 pixels
                    // mediaView.setFitHeight(400); // Règle la hauteur de la vidéo à 400 pixels
                    
                    // // Ajoutez le MediaView à votre VBox
                    // vbox_post.getChildren().add(mediaView);
                    
                    // // Lancez la vidéo
                    // mediaPlayer.play();t.getChildren().add(mediaView); // ajout de l'image à la vbox et donc à la page
                    // }
                }
                

                
                
            }
        });
    }
    
    
    public static StackPane mise_en_page_texte(Node node){
        /*
         * Méthode statique qui met en forme un texte reçu d'une textearea
         * 
         */
            StackPane mise_en_forme_texte = new StackPane(); // Création du stackpane pour mettre en forme le texte et le rectangle
            Rectangle rectangle_texte = new Rectangle();
            Label labelNode = (Label) node; // cast de node en label pour récupérer la largeur et la hauteur du texte
           
            //Bout de code généré par Copilat de github
            // Ajoute un ChangeListener à la propriété widthProperty du label
            labelNode.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                // Met à jour la largeur du rectangle pour correspondre à la largeur du label
                rectangle_texte.setWidth(newValue.doubleValue() + 20);
            });

            // Ajoute un ChangeListener à la propriété heightProperty du label
            labelNode.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                // Met à jour la hauteur du rectangle pour correspondre à la hauteur du label
                rectangle_texte.setHeight(newValue.doubleValue() + 20);
            });
    

            rectangle_texte.setFill(Color.web("white", 0.8));  // Définit la couleur du rectangle en blanc avec 60% de transparence
            rectangle_texte.setStroke(Color.web("black", 0.6)); // Définit la couleur de la bordure du rectangle en noir avec 60% de transparence
            rectangle_texte.setArcHeight(30); // Arrondi les angles du carré
            rectangle_texte.setArcWidth(30);
            mise_en_forme_texte.getChildren().addAll(rectangle_texte, node); // Ajout du rectangle et du texte au stackpane

            return mise_en_forme_texte;
        }

        public static void mise_en_page_post(Node node, boolean texte){ // les images et les texte de javafx héritent de la classe Node
            /*
            * Méthode statiques pour met en forme tous les posts avec les boutons like, commenter et supprimer
            * 
            */
            VBox vbox_mise_en_forme_post = new VBox();
            HBox hbox_boutons_action_post = new HBox(15);
            Button bouton_like = new Button("J'aime");
            Button bouton_commenter = new Button("Commenter");
            Button bouton_supprimer = new Button("Supprimer");
            
            vbox_mise_en_forme_post.setAlignment(Pos.CENTER); // Mise en forme des vbox et hbox
            hbox_boutons_action_post.setAlignment(Pos.CENTER);
            hbox_boutons_action_post.getChildren().addAll(bouton_like, bouton_commenter, bouton_supprimer); // ajout des boutons
            
            if (texte){ // si le post est un texte
                StackPane mise_en_forme_du_texte = mise_en_page_texte(node); // récupère le texte et le met en forme
                vbox_mise_en_forme_post.getChildren().addAll(mise_en_forme_du_texte, hbox_boutons_action_post); // ajout des boutons et du texte
                vbox_post.getChildren().add(vbox_mise_en_forme_post);
                    
        }
        
            else{ // si le post est une image
                vbox_mise_en_forme_post.getChildren().addAll(node, hbox_boutons_action_post);
                vbox_post.getChildren().add(vbox_mise_en_forme_post);
            }
    }
    
}
