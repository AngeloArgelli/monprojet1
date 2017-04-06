package base;

import domaine.Fonction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Gestion des accès à la base de données pour l'entité Fonction.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version Version 2.0
*/
public class FonctionDao {
  
    /** Retourne la liste complète des Fonctions dans l'ordre des noms, null en cas d'erreur */
    public static ArrayList getFonctions () {
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoFonc, NomFonc FROM Fonction ORDER BY NomFonc");
            while (rs.next()) {
                Fonction f = new Fonction(rs.getInt("NoFonc"), rs.getString("NomFonc"));
                liste.add(f);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("FonctionDao.getFonctions(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getFonctions
  
    /** Retourne la Fonction d'identifiant noFonc, null en cas d'erreur */
    public static Fonction getFonction (int noFonc) {
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoFonc, NomFonc FROM Fonction WHERE NoFonc = " + noFonc);
            rs.next();
            Fonction f = new Fonction(rs.getInt("NoFonc"), rs.getString("NomFonc"));
            stmt.close();
            return f;
        }
        catch (SQLException e) {System.out.println("FonctionDao.getFonction(): " + e.getMessage()); e.printStackTrace(); return null;}
    } // getFonction
  
} // FonctionDao
