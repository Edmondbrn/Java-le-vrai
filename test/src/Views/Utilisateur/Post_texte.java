package Views.Utilisateur;

import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;

public class Post_texte {

    protected String auteur = new String();
    protected int nbr_like;
    protected ArrayList <String> liste_commentaire;
    protected Date date_post;
    protected DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT); // prepare la forme de la date jour/mois/année

    // Constructeur de base de l'objet Post_texte
    public Post_texte(){
        auteur = "";
        nbr_like = 0;
        liste_commentaire = new ArrayList<>();
        date_post = new Date();

    }
    // Constructeur élaboré de l'objet Post_texte
    public Post_texte(String nom_auteur, int like, ArrayList<String> commentaire){
        auteur = nom_auteur;
        nbr_like = like;
        liste_commentaire = new ArrayList<String>(commentaire);
        date_post = new Date();
    }

    // Accesseur
    public String getAuteur(){
        return this.auteur;
    }

    public int getLike(){
        return this.nbr_like;
    }

    public ArrayList<String> getCommentaire(){
        return this.liste_commentaire;
    }

    public String getDate(){ // renvoie la date mise en forme 
        return shortDateFormat.format(this.date_post);
    }
    

    // Mutateur

    public void setAuteur(String name){
        this.auteur = name;
    }

    public void setLike(int j_aime){
        this.nbr_like = j_aime;
    }

    public void setCommentaire(String un_commentaire){
        this.liste_commentaire.add(un_commentaire);
    }



  
}
