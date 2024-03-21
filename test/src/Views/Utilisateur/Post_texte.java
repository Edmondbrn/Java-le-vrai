package Views.Utilisateur;

import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Post_texte {

    protected String auteur = new String();
    protected String contenu = new String();
    protected int nbr_like;
    protected ArrayList <String> liste_commentaire;
    protected Date date_post;
    protected DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT); // prepare la forme de la date jour/mois/année

    // Constructeur de base de l'objet Post_texte
    public Post_texte(){
        auteur = "";
        contenu = "";
        nbr_like = 0;
        liste_commentaire = new ArrayList<>();
        date_post = new Date();

    }
    // Constructeur élaboré de l'objet Post_texte
    public Post_texte(String nom_auteur, String texte_du_post, int like, ArrayList<String> commentaire, Date date_origine_post){
        auteur = nom_auteur;
        contenu = texte_du_post;
        nbr_like = like;
        liste_commentaire = new ArrayList<String>(commentaire);
        date_post = date_origine_post;
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

    public String getContenu(){
        return this.contenu;
    }
    

    // Mutateurs
    public void setAuteur(String name){
        this.auteur = name;
    }

    public void setLike_ajout(){
        this.nbr_like ++;
    }

    public void setLike_retrait(){
        this.nbr_like --;
    }

    public void setCommentaire(String un_commentaire){
        this.liste_commentaire.add(un_commentaire);
    }

    public void setCommentaire_retrait(String un_commentaire){
        this.liste_commentaire.remove(un_commentaire);
    }

    public HashMap<String, Object> dico_post(){
        HashMap<String, Object> post = new HashMap<String, Object>();
        post.put("auteur", this.getAuteur());
        post.put("contenu", this.getContenu());
        post.put("nbr_like", this.getLike());
        post.put("liste_commentaire", this.getCommentaire());
        post.put("date_post", this.getDate());
        return post;
    }

    public String toString(){
        return "Auteur : " + this.auteur + " Contenu : " + this.contenu + " Nombre de like : " + this.nbr_like + " Commentaire : " + this.liste_commentaire + " Date : " + getDate();
    }
    public static void main (String[] args){
        Post_texte post = new Post_texte("Jean", "Ceci est mon post",5, new ArrayList<String>(), new Date());
        System.out.println(post);
        System.out.println(post.dico_post());
    }
 
}
