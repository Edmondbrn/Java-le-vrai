package Views.Utilisateur;

import java.util.ArrayList;

public class Post_video extends Post_texte{

    private String duree = new String();
    private String resolution = new String();

    public Post_video(){
        super();
        duree = "";
        resolution = "";
    }

    public Post_video(String nom_auteur, int like, ArrayList<String> commentaire, String temps, String qualite){
        super(nom_auteur,like, commentaire);
        duree = temps;
        resolution = qualite;

    }

    public String getDuree(){
        return this.duree;
    }

    public String getResolution(){
        return this.resolution;
    }

    

}
