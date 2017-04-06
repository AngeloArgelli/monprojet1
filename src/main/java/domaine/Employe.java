package domaine;

import java.util.Date;

/** 
 * Entité représentant un Employe
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.0
 */
public class Employe implements Comparable {

    /* Attributs */
    private int noEmpl; /* Identifiant */
    private String nomEmpl, prenomEmpl;
    private Fonction fonction;
    private Date dateEmpl;
    private Departement departement;

    /* Accesseurs */
    public void setNoEmpl (int noEmpl) {this.noEmpl = noEmpl;}
    public int getNoEmpl () {return noEmpl;}
    public String getNomEmpl () {return nomEmpl;}
    public void setNomEmpl (String nomEmpl) {this.nomEmpl = nomEmpl;}
    public String getPrenomEmpl () {return prenomEmpl;}
    public void setPrenomEmpl (String prenomEmpl) {this.prenomEmpl = prenomEmpl;}
    public Fonction getFonction () {return fonction;}
    public void setFonction (Fonction fonction) {this.fonction = fonction;}
    public Date getDateEmpl () {return dateEmpl;}
    public void setDateEmpl (Date dateEmpl) {this.dateEmpl = dateEmpl;}
    public Departement getDepartement () {return departement;}
    public void setDepartement (Departement departement) {this.departement = departement;}

    /* Constructeurs */
    public Employe (int noEmpl, String nomEmpl, String prenomEmpl, Fonction fonction, Date dateEmpl, Departement departement) {
        this.noEmpl = noEmpl;
        this.nomEmpl = nomEmpl;
        this.prenomEmpl = prenomEmpl;
        this.fonction = fonction;
        this.dateEmpl = dateEmpl;
        this.departement = departement;
    } // Constructeur

    public Employe (String nomEmpl, String prenomEmpl, Fonction fonction, Date dateEmpl, Departement departement) {
        this(0, nomEmpl, prenomEmpl, fonction, dateEmpl, departement);
    } // Constructeur

    public boolean equals (Object o) {return noEmpl == ((Employe)o).noEmpl;}
    public String toString () {return "[NoEmpl=" + noEmpl + " ; NomEmpl=\"" + nomEmpl + "\" ; PrenomEmpl=\"" + prenomEmpl
                                    + "\" ; Fonction=" + fonction + " ; DateEmpl=" + dateEmpl + " ; Departement=" + departement + "]";}
    
    /** Compare this et e dans l'ordre lexicographique (nomEmpl; prenomEmpl; noEmpl); 
        si this < e, retour < 0, si this == e, retour = 0, sinon retour > 0 */
    public int compareTo (Object o) {
        Employe e = (Employe)o;
        int res = nomEmpl.compareTo(e.getNomEmpl());
        if (res != 0) {return res;}
        res = prenomEmpl.compareTo(e.getPrenomEmpl());
        return res != 0 ? res : noEmpl - e.getNoEmpl();
    } // compareTo

} // Employe