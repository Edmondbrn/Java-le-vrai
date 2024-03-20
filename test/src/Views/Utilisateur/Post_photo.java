package Views.Utilisateur;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Post_photo extends Post_texte{ // classe qui hérite de Post_texte car ils partagent des caractéristiques

    private String format_image = new String();
    Image image;

    public Post_photo(String nom_auteur, int like, ArrayList<String> commentaire, String format_photo, Image image){
        super(nom_auteur, like, commentaire);
        format_image = format_photo;
        this.image = image;

    }


    public String getFormat_image(){
        return this.format_image;
    }

    public void setFormat_image( String nouveau_format){
        this.format_image = nouveau_format;
    }
}
