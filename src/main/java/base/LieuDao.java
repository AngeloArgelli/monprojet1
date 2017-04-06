package base;

import domaine.Lieu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gestion des accès à la base de données pour l'entité Lieu.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version Version 1.0
*/
public class LieuDao {
  
    /** Retourne le Lieu d'identifiant noLieu, null en cas d'erreur */
    public static Lieu getLieu (int noLieu) {
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoLieu, NomLieu FROM Lieu WHERE NoLieu = " + noLieu);
            rs.next();
            Lieu l = new Lieu(rs.getInt("NoLieu"), rs.getString("NomLieu"));
            stmt.close();
            return l;
        }
        catch (SQLException e) {System.out.println("LieuDao.getLieu(): " + e.getMessage()); e.printStackTrace(); return null;}
    } // getLieu
  
} // LieuDao
