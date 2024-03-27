package Views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Requete {
     Connection c = null;
     Statement stmt = null;
    
    public Requete() {
        /*
         * Constructeur de la classe Requete qui crée le lien avec la base de données
         * 
         */
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/home/edmond/Documents/Projet_java2/Java-le-vrai/test/src/myLink.db");

            stmt = c.createStatement();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private  ResultSet selection_sql(String sql) {
        /*
         * 
         * Fonction qui permet de selectionner des données dans la base de données à l'aide d'une requête SQL en argument
         */
        try {
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName());
            return null;
        }
    }

    public  void fermer() {
        /*
         * Méthode qui permet de fermer la connexion avec la base de données
         * 
         */
        try {
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName());
        }
    }

    public void insertion_sql(String sql) {
        /*
         * Méthode qui permet d'insérer des données dans la base de données à l'aide d'une requête SQL en argument
         * 
         */
        try {
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.err.println(e.getClass().getName());
        }
    }

    public  ArrayList<String> parcoursTableSQL(String requete, String nom_colonne) {
        /*
         * Méthode qui permet de récupérer les informations dans une colonne de la table sélectionnée
         * 
         */
        ArrayList<String> liste_colonne = new ArrayList<String>();
        ResultSet rs = selection_sql(requete);
        try {
            while (rs.next()) {
                liste_colonne.add(rs.getString(nom_colonne));
            }
            rs.close();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName());
        }
        return liste_colonne;

    }


}
