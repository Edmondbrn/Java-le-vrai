package Views.Utilisateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Post_video extends Post_texte{

    private String duree = new String();
    private String video = new String();

    public Post_video(){
        super();
        this.duree = "";
        this.video = "";
    }

    // public Post_video(String nom_auteur, String titre_image, int like, ArrayList<String> commentaire, String url_video, Date date_image, String temps){
    //     super(nom_auteur, titre_image, like, commentaire, date_image);
    //     this.duree = temps;
    //     this.video = url_video;

    // }

    public String getDuree(){
        return this.duree;
    }

    public String getVideo(){
        return this.video;
    }

    public void setVideo(String nouveau_url){
        this.video = nouveau_url;
    }

    @Override
    public HashMap<String, Object> dico_post() {
    HashMap<String, Object> dico = super.dico_post();
    dico.put(" url_video : ", this.getVideo());
    dico.put(" Duree de la vidéo : ", this.getDuree());
    return dico;
}
   
    

}
