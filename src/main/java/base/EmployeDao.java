package base;

import domaine.Departement;
import domaine.Employe;
import domaine.Fonction;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Gestion des accès à la base de données pour l'entité Employe.
 *
 * @author Peter DAEHNE - HEG-Genève
 * @version Version 2.0
*/
public class EmployeDao {
  
    /** Retourne la liste complète des Employes dans l'ordre des nom et prénom, null en cas d'erreur */
    public static ArrayList getEmployes () {
        ArrayList liste = new ArrayList();
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoDept FROM Employe ORDER BY NomEmpl, PrenomEmpl");
            while (rs.next()) {
                Fonction f = FonctionDao.getFonction(rs.getInt("NoFonc"));
                Departement d = DepartementDao.getDepartement(rs.getInt("NoDept"));
                Employe e = new Employe(rs.getInt("NoEmpl"), rs.getString("NomEmpl"), rs.getString("PrenomEmpl"), f, rs.getDate("DateEmpl"), d);
                liste.add(e);
            }
            stmt.close();
        }
        catch (SQLException e) {System.out.println("EmployeDao.getEmployes(): " + e.getMessage()); e.printStackTrace(); return null;}
        return liste;
    } // getEmployes

    /** Supprime l'employé d'identifiant noEmpl */
    public static void delEmploye (int noEmpl) {
        try {
            Connection con = ConnexionBase.get();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM Employe WHERE NoEmpl = " + noEmpl);
            stmt.close();
        }
        catch (SQLException e) {System.out.println("EmployeDao.delEmploye(): " + e.getMessage()); e.printStackTrace();}
    } // delEmploye

    /** Ajoute l'employé emp et retourne l'identifiant qui lui a été attribué automatiquement */
    public static int addEmploye (Employe emp) {
        int id = -1;
        try {
            Connection con = ConnexionBase.get();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Employe (NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoDept) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, emp.getNomEmpl());
            stmt.setString(2, emp.getPrenomEmpl());
            stmt.setInt(3, emp.getFonction().getNoFonc());
            stmt.setDate(4, new Date(emp.getDateEmpl().getTime()));
            stmt.setInt(5, emp.getDepartement().getNoDept());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); id = rs.getInt(1);
            stmt.close();
        }
        catch (SQLException e) {System.out.println("EmployeDao.addEmploye(): " + e.getMessage()); e.printStackTrace();}
        return id;
    } // addEmploye
  
} // EmployeDao
