package base;

import domaine.Departement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Gestion des accès à la base de données pour l'entité Departement.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version Version 2.0
*/
public class DepartementDao {
  
    /** Retourne la liste complète des Departements dans l'ordre des noms, null en cas d'erreur */
    public static ArrayList getDepartements () {
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoDept, NomDept, NoLieu FROM Departement ORDER BY NomDept");
            while (rs.next()) {
                Departement d = new Departement(rs.getInt("NoDept"), rs.getString("NomDept"), LieuDao.getLieu(rs.getInt("NoLieu")));
                liste.add(d);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("DepartementDao.getDepartements(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getDepartements

    /** Retourne le Departement d'identifiant noDept, null en cas d'erreur */
    public static Departement getDepartement (int noDept) {
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoDept, NomDept, NoLieu FROM Departement WHERE NoDept = " + noDept);
            rs.next();
            Departement d = new Departement(rs.getInt("NoDept"), rs.getString("NomDept"), LieuDao.getLieu(rs.getInt("NoLieu")));
            stmt.close();
            return d;
        }
        catch (SQLException e) {System.out.println("DepartementDao.getDepartement(): " + e.getMessage()); e.printStackTrace(); return null;}
    } // getDepartement

} // DepartementDao
