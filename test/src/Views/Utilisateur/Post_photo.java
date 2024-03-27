package Views.Utilisateur;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Post_photo extends Post_texte{ // classe qui hérite de Post_texte car ils partagent des caractéristiques

    private String format_image = new String();
    private String image;

    // public Post_photo(String nom_auteur, String titre_image, int like, ArrayList<String> commentaire, String format_photo, String url_image, Date date_image){
    //     super(nom_auteur, titre_image, like, commentaire, date_image);
    //     format_image = format_photo;
    //     this.image = url_image;

    // }

    public String getFormat_image(){
        return this.format_image;
    }

    public String getImage(){
        return this.image;
    }

    public void setFormat_image(String nouveau_format){
        this.format_image = nouveau_format;
    }

    public void setImage(String nouveau_url){
        this.format_image = nouveau_url;
    }

    @Override
    public HashMap<String, Object> dico_post() {
    HashMap<String, Object> dico = super.dico_post();
    dico.put("url_image", this.getImage());
    dico.put("format_image", this.getFormat_image());
    return dico;
}

    
}
