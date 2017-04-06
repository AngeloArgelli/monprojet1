package domaine;

/** 
 * Entité représentant une Fonction
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.0
 */
public class Fonction {

    /* Attributs */
    private int noFonc; /* Identifiant */
    private String nomFonc;

    /* Accesseurs */
    public int getNoFonc () {return noFonc;}
    public void setNomFonc (String nomFonc) {this.nomFonc = nomFonc;}
    public String getNomFonc () {return nomFonc;}

    /* Constructeur */
    public Fonction (int noFonc, String nomFonc) {
        this.noFonc = noFonc;
        this.nomFonc = nomFonc;
    } // Constructeur

    public boolean equals (Object o) {return noFonc == ((Fonction)o).noFonc;}
    public String toString () {return "[NoFonc=" + noFonc + " ; NomFonc=\"" + nomFonc + "\"]";}

} // Fonction