package presentation;

import domaine.Departement;
import domaine.Employe;
import domaine.Fonction;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import metier.ListeDepartements;
import metier.ListeFonctions;

/**
 * Fenêtre de saisie d'un nouvel employé.
 * 
 * Singleton.
 *
 * @author Peter DAEHNE - HEG Genève
 * @version 2.0
 */
public class FrmNouveau extends java.awt.Frame {
  
    private static FrmNouveau instance; /* L'unique instance */
    private static FrmMain frmMain;     /* Référence à la fenêtre principale */

    private ListeFonctions listeFonctions;       /* Liste des fonctions dans l'ordre des noms (modèle) */
    private ListeDepartements listeDepartements; /* Liste des départements dans l'ordre des noms (modèle) */

    private static final SimpleDateFormat DATE_FORM = new SimpleDateFormat("dd.MM.yy"); /* Formateur de dates */

    /* Constructeur */
    private FrmNouveau () {
        initComponents();
        chargerFonctions();
        chargerDepartements();
        gereEtatBouton();
        DATE_FORM.setLenient(false);
    } // Constructeur

    /** Retour de l'unique instance */
    public static FrmNouveau getInstance (FrmMain frm) {
        if (instance == null) {frmMain = frm; instance = new FrmNouveau();}
        return instance;
    } // getInstance

    /* Charger listeFonctions (modèle) et chFonctions (vue) avec la liste des Fonctions */
    private void chargerFonctions () {
        listeFonctions = new ListeFonctions();
        for (int k = 0; k < listeFonctions.size(); k++) {
            Fonction f = listeFonctions.getFonction(k);
            chFonctions.add(f.getNomFonc());
        }
        if (listeFonctions.size() > 0) {listeFonctions.setPos(0);}
    } // chargerFonctions

    /* Charger listeDepartements (modèle) et chDepartements (vue) avec la liste des Fonctions */
    private void chargerDepartements () {
        listeDepartements = new ListeDepartements();
        for (int k = 0; k < listeDepartements.size(); k++) {
            Departement d = listeDepartements.getDepartement(k);
            chDepartements.add(d.getNomDept());
        }
        if (listeDepartements.size() > 0) {listeDepartements.setPos(0);}
    } // chargerDepartements

    /* Gestion de l'état d'activation du bouton btnEnregistrer */
    private void gereEtatBouton () {
        btnEnregistrer.setEnabled(tfNom.getText().trim().length() != 0 && tfPrenom.getText().trim().length() != 0 && strToDate(tfDateEngagement.getText()) != null);
    } // gereEtatBouton

    /* Retourne la Date correspondante si le String s est une date valide et qu'il s'agit d'une date du passé, null sinon */
    private Date strToDate (String s) {
        Date today = Calendar.getInstance().getTime();
        try {
            Date date = DATE_FORM.parse(s);
            if (!date.after(today)) {return date;} else {return null;} /* Aujourd'hui est également valide */
        }
        catch (ParseException e) {return null;}
    } // strToDate

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        java.awt.Label label1 = new java.awt.Label();
        tfNom = new java.awt.TextField();
        java.awt.Label label2 = new java.awt.Label();
        tfPrenom = new java.awt.TextField();
        lblDateEngagement = new java.awt.Label();
        tfDateEngagement = new java.awt.TextField();
        java.awt.Label label4 = new java.awt.Label();
        chFonctions = new java.awt.Choice();
        java.awt.Label label5 = new java.awt.Label();
        chDepartements = new java.awt.Choice();
        btnEnregistrer = new java.awt.Button();

        setResizable(false);
        setTitle("Saisie d'un employé");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        label1.setText("Nom");

        tfNom.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                infoEmplTextValueChanged(evt);
            }
        });

        label2.setText("Prénom");

        tfPrenom.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                infoEmplTextValueChanged(evt);
            }
        });

        lblDateEngagement.setText("Date d'engagement");

        tfDateEngagement.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                tfDateEngagementTextValueChanged(evt);
                infoEmplTextValueChanged(evt);
            }
        });

        label4.setText("Fonction");

        chFonctions.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chFonctionsItemStateChanged(evt);
            }
        });

        label5.setText("Département");

        chDepartements.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chDepartementsItemStateChanged(evt);
            }
        });

        btnEnregistrer.setLabel("Enregistrer");
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNom, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(tfPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDateEngagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDateEngagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chFonctions, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(chDepartements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDateEngagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDateEngagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chFonctions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chDepartements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btnEnregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* La fenêtre a été fermée */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        instance.dispose();
    }//GEN-LAST:event_formWindowClosing

    /* La liste des fonctions a changé de sélection */
    private void chFonctionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chFonctionsItemStateChanged
        listeFonctions.setPos(chFonctions.getSelectedIndex());
    }//GEN-LAST:event_chFonctionsItemStateChanged

    /* La liste des départements a changé de sélection */
    private void chDepartementsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chDepartementsItemStateChanged
        listeDepartements.setPos(chDepartements.getSelectedIndex());
    }//GEN-LAST:event_chDepartementsItemStateChanged

    /* La date d'engagement a changé: la valider. Mettre le libellé en rouge si la date est invalide. */
    private void tfDateEngagementTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_tfDateEngagementTextValueChanged
        String s = tfDateEngagement.getText().trim();
        lblDateEngagement.setForeground(s.length() == 0 || strToDate(s) != null ? Color.BLACK : Color.RED);
    }//GEN-LAST:event_tfDateEngagementTextValueChanged

    /* L'un des champs de saisie a été modifié: gérer l'état du bouton btnEnregistrer */
    private void infoEmplTextValueChanged(java.awt.event.TextEvent evt) {//GEN-FIRST:event_infoEmplTextValueChanged
        gereEtatBouton();
    }//GEN-LAST:event_infoEmplTextValueChanged

    /* Appui sur le bouton btnEnregistrer: enregistrer les informations. */
    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed
        Employe e = new Employe(tfNom.getText().trim(), tfPrenom.getText().trim(), listeFonctions.getFonctionCourante(), strToDate(tfDateEngagement.getText()), listeDepartements.getDepartementCourant());
        frmMain.addEmploye(e);
        tfNom.setText(""); tfPrenom.setText(""); tfDateEngagement.setText("");
        chFonctions.select(0); chDepartements.select(0);
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnEnregistrer;
    private java.awt.Choice chDepartements;
    private java.awt.Choice chFonctions;
    private java.awt.Label lblDateEngagement;
    private java.awt.TextField tfDateEngagement;
    private java.awt.TextField tfNom;
    private java.awt.TextField tfPrenom;
    // End of variables declaration//GEN-END:variables

} // FrmNouveau