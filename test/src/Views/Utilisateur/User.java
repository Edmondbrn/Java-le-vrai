package Views.Utilisateur;
import java.util.ArrayList;


public class User {

    private String mail = new String();
    private String nom = new String();
    private String prenom = new String();
    private String password = new String();
    private ArrayList<String> liste_bloque;
    private ArrayList<String> liste_ami;
    private ArrayList<Post_texte> liste_post;

    
    public User(String mail, String nom, String prenom, String password, ArrayList<String> liste_bloque,
                 ArrayList<String> liste_amis ,ArrayList<Post_texte> liste_post) {
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.liste_bloque = liste_bloque;
        this.liste_ami = liste_amis;
        this.liste_post = liste_post;
    }

    

    // Accesseur
    public String getMail() {
        return this.mail;
    }


    public String getNom() {
        return this.nom;
    }


    public String getPrenom() {
        return this.prenom;
    }


    public String getPassword() {
        return this.password;
    }


    public ArrayList<String> getListe_bloque() {
        return this.liste_bloque;
    }

    public ArrayList<String> getListe_ami() {
        return this.liste_ami;
    }


    public ArrayList<Post_texte> getListe_post() {
        return this.liste_post;
    }

    // Mutateurs
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setListe_bloque(ArrayList<String> liste_bloque) {
        this.liste_bloque = liste_bloque;
    }

    public void setListe_ami(ArrayList<String> liste_ami) {
        this.liste_ami = liste_ami;
    }

    public void setListe_post(ArrayList<Post_texte> liste_post) {
        this.liste_post = liste_post;
    }



    
    
}
