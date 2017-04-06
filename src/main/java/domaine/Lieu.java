package domaine;

/** 
 * Entité représentant un Lieu
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.0
 */
public class Lieu {

    /* Attributs */
    private int noLieu; /* Identifiant */
    private String nomLieu;

    /* Accesseurs */
    public int getNoLieu () {return noLieu;}
    public void setNomLieu (String nomLieu) {this.nomLieu = nomLieu;}
    public String getNomLieu () {return nomLieu;}

    /* Constructeur */
    public Lieu (int noLieu, String nomLieu) {
        this.noLieu = noLieu;
        this.nomLieu = nomLieu;
    } // Constructeur

    public boolean equals (Object o) {return noLieu == ((Lieu)o).noLieu;}
    public String toString () {return "[NoLieu=" + noLieu + " ; NomLieu=\"" + nomLieu + "\"]";}

} // Lieu