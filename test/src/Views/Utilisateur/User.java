package Views.Utilisateur;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class User {

    private String mail = new String();
    private String nom = new String();
    private String prenom = new String();
    private String password = new String();
    private ArrayList<String> liste_bloque;
    private ArrayList<String> liste_ami;
    private ArrayList<HashMap<String, Object>> liste_post;

    
    public User(String mail, String nom, String prenom, String password, ArrayList<String> liste_bloque,
                 ArrayList<String> liste_amis , ArrayList<HashMap <String, Object>> info_liste_post) {
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.liste_bloque = liste_bloque;
        this.liste_ami = liste_amis;
        this.liste_post = info_liste_post;
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


    public ArrayList<HashMap <String, Object>> getListe_post() {
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

    public void setListe_bloque_ajout(String personne_bloquee) {
        this.liste_bloque.add(personne_bloquee);
    }

    public void setListe_bloque_retrait(String personne_debloquee) {
        this.liste_bloque.remove(personne_debloquee);
    }
    
    public void setListe_ami_ajout(String nouvel_ami) {
        this.liste_ami.add(nouvel_ami);
    }
    
    public void setListe_ami_retrait(String ancien_ami) {
        this.liste_ami.remove(ancien_ami);
    }

    public void setListe_post_ajout(HashMap<String, Object> info_nouveau_post) {
        this.liste_post.add(info_nouveau_post);
    }

    public void setListe_post_retrait(HashMap<String, Object> ancien_post) {
        this.liste_post.remove(ancien_post);
    }

    

    public String toString() {
        return "Mail : " + this.mail + " Nom : " + this.nom + " Prenom : " + this.prenom + " Password : " + this.password + " Liste des bloqués : " + this.liste_bloque + " Liste des amis : " + this.liste_ami + " Liste des posts : " + this.liste_post;
    }

    public static void main (String[] args){
        System.out.println("Test de la classe User");
        User user = new User("admin@admin.com", "Bernard", "Julie", "1234", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<HashMap <String, Object>>());
        user.setListe_ami_ajout("Angie");
        user.setListe_bloque_ajout("Garcia");
        user.setListe_bloque_ajout("Zurletto");
        user.setListe_ami_retrait("Angie");
        user.setListe_bloque_retrait("Garcia");
        Post_texte post_test = new Post_texte("Jean", "Ceci est un post de qualité", 5, new ArrayList<String>(), new Date());
        Post_texte post_test2 = new Post_texte("Jean", "Ceci est un post de qualité", 5, new ArrayList<String>(), new Date());

        user.setListe_post_ajout(post_test.dico_post());
        user.setListe_post_ajout(post_test2.dico_post());
        user.setListe_post_retrait(post_test.dico_post());
        System.out.println(user);
    }

    
    
}
