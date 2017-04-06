package domaine;

/** 
 * Entité représentant un Departement
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.0
 */
public class Departement {

    /* Attributs */
    private int noDept; /* Identifiant */
    private String nomDept;
    private Lieu lieu;

    /* Accesseurs */
    public int getNoDept () {return noDept;}
    public void setNomDept (String nomDept) {this.nomDept = nomDept;}
    public String getNomDept () {return nomDept;}
    public Lieu getLieu () {return lieu;}
    public void setLieu (Lieu lieu) {this.lieu = lieu;}

    /* Constructeur */
    public Departement (int noDept, String nomDept, Lieu lieu) {
        this.noDept = noDept;
        this.nomDept = nomDept;
        this.lieu = lieu;
    } // Constructeur

    public boolean equals (Object o) {return noDept == ((Departement)o).noDept;}
    public String toString () {return "[NoDept=" + noDept + " ; NomDept=\"" + nomDept + "\" ; Lieu=" + lieu + "]";}

} // Departement