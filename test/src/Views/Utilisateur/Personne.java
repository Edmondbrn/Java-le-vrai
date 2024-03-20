package Views.Utilisateur;

import javafx.beans.property.SimpleStringProperty;

public class Personne {
    private final SimpleStringProperty nom;

    public Personne(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }
}