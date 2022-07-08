/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import modele.Carte;
import modele.Compte;
import modele.RegistreCompte;
import utils.BaseDeDonnee;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

/**
 * @author lafon
 */
public class FenCarteID extends javax.swing.JFrame {
    RegistreCompte listing;
    private String trouver;
    static private String courriel;
    static private LocalDate today;
    static private double depot;
    static private double retrait;

    /**
     * Creates new form FenCarteID
     */
    public FenCarteID() {
        initComponents();
        chargerPage();


//        try {
//            trouverCompte(txtNom.getText());
//        } catch (SQLException e) {
//            e.getStackTrace();
//        }
//Compte compte = new Compte();
//compte.setEmail(trouverCompte(txtNom.getText()));
//        System.out.println(trouverCompte(txtNom.getText()));


    }

    public FenCarteID(RegistreCompte listing) {
        this();
        this.listing = listing;

        for (Compte tmp : listing.getRegistre()
        ) {
            courriel = tmp.getEmail();
            System.out.println("Le email egal " + tmp.getEmail());
        }
        //---------------------------------------------------rechercher client courant par email
        try {
            BaseDeDonnee.seConnecter();
            rechercheByEmail(courriel);
            BaseDeDonnee.seDeconnecter();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        //---------------------------------------------------

        //---------------------------------------------------afficher la liste des compte par courriel
        try {
            BaseDeDonnee.seConnecter();
            afficherListeCompte(courriel);
            BaseDeDonnee.seDeconnecter();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //---------------------------------------------------

        //---------------------------------------------------on setter la date d'expiration today + 5 ans
        setDateExpiration();

    }

    private void afficherListeCompte(String courriel) throws SQLException {
        BaseDeDonnee.query = "SELECT * FROM carte WHERE email = '" + courriel + "'";
        BaseDeDonnee.prepareStatement = BaseDeDonnee.connection.prepareStatement(BaseDeDonnee.query);
        ResultSet resultSet = BaseDeDonnee.prepareStatement.executeQuery(BaseDeDonnee.query);
        while (resultSet.next()) {

            long noCarte = resultSet.getLong(2);
            Date dateExp = resultSet.getDate(3);
            String emailClient = resultSet.getString(4);
            String typeCompte = resultSet.getString(5);
            double total = resultSet.getDouble(6);

            System.out.println(noCarte + "" + dateExp + "" + emailClient + "" + typeCompte + "" + total);

            lblSomme.setText(String.valueOf(total));


            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{noCarte, dateExp, emailClient, typeCompte, total});
        }
        resultSet.close();
    }


    public void rechercheByEmail(String para_email) throws SQLException {

        BaseDeDonnee.query = "SELECT * FROM compte WHERE email = '" + para_email + "'";

        BaseDeDonnee.prepareStatement = BaseDeDonnee.connection.prepareStatement(BaseDeDonnee.query);
        ResultSet resultSet = BaseDeDonnee.prepareStatement.executeQuery(BaseDeDonnee.query);


        while (resultSet.next()) {

            Compte compte = new Compte();
            compte.setEmail(resultSet.getString(1));
            compte.setTypeCompte(resultSet.getString(2));
            compte.setTitulaire(resultSet.getString(3));
            compte.setNomClient(resultSet.getString(4));
            compte.setPrenomClient(resultSet.getString(5));
            compte.setJourNaissance(resultSet.getInt(6));
            compte.setMoisNaissance(resultSet.getInt(7));
            compte.setAnneeNaissance(resultSet.getInt(8));
            compte.setPays(resultSet.getString(9));
            compte.setMotDePasse(resultSet.getString(10));
            compte.setVille(resultSet.getString(11));
            compte.setTelephone(resultSet.getString(12));
            compte.setAdresse(resultSet.getString(13));


            txtPrenom.setText(compte.getPrenomClient());
            txtNom.setText(compte.getNomClient());
            lblNomClient.setText(compte.getPrenomClient() + " " + compte.getNomClient());
            txtTypeCompte.setText(compte.getTypeCompte());

            lblNomClient3.setText(compte.getPrenomClient() + " " + compte.getNomClient());
            lblNomClient4.setText(compte.getAdresse());
            lblNomClient5.setText(compte.getVille());
            lblNomClient6.setText(compte.getEmail());
        }
        resultSet.close();
    }

    private void chargerPage() {
        txtTypeCompte.setForeground(Color.GRAY);
        txtTypeCompte.setText("Epargne");

        txtMontant.setForeground(Color.GRAY);
        txtMontant.setText("00");

        txtDepot.setForeground(Color.GRAY);
        txtDepot.setText("Depot");

        txtRetrait.setForeground(Color.GRAY);
        txtRetrait.setText("Retrait");

        lblNomClient.setForeground(Color.GRAY);
        lblNomClient.setText(txtPrenom.getText() + " " + txtNom.getText());

        txtNumeroCarte.setText("0000 0000 0000 0000");
        //txtDateExpiration.setText("00/00");


        txtNumeroCarte1.setText("0000 0000 0000 0000");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTypeCompte = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSomme = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        txtMontant = new javax.swing.JTextField();
        btnActiver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtDepot = new javax.swing.JTextField();
        txtRetrait = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        txtDateExpiration = new javax.swing.JFormattedTextField();
        txtNumeroCarte = new javax.swing.JFormattedTextField();
        txtNumeroCarte1 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        chkDepot = new javax.swing.JCheckBox();
        chkRetrait = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        txtDateExpAffichage = new javax.swing.JFormattedTextField();
        txtNumeroCompteAffichage = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblNomClient = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnRetour = new javax.swing.JButton();
        btnRafraichir = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lblNomClient3 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblNomClient4 = new javax.swing.JLabel();
        lblNomClient5 = new javax.swing.JLabel();
        lblNomClient6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setText("Votre Compte bancaire");

        jLabel3.setFont(new java.awt.Font("SimSun", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 0));
        jLabel3.setText("CHEZ QUEBEC BANQUE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("Facile, rapide, sécurisé");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Vos informations personnelles");

        jSeparator1.setForeground(new java.awt.Color(0, 51, 51));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Type du compte :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Dépot de 50$ pour activer le compte");

        txtTypeCompte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTypeCompte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTypeCompte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTypeCompteFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTypeCompteFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Faire une transaction :");

        jSeparator2.setForeground(new java.awt.Color(51, 0, 51));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("- 00");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 0));
        jLabel10.setText("$");

        lblSomme.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblSomme.setForeground(new java.awt.Color(0, 204, 0));
        lblSomme.setText("+ 00,00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("$");

        txtNom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomFocusLost(evt);
            }
        });

        txtPrenom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrenom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPrenom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrenomFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrenomFocusLost(evt);
            }
        });

        txtMontant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMontant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMontant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMontant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMontantFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontantFocusLost(evt);
            }
        });

        btnActiver.setBackground(new java.awt.Color(0, 204, 0));
        btnActiver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActiver.setForeground(new java.awt.Color(0, 51, 51));
        btnActiver.setText("Activer");
        btnActiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActiverActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Numéro Carte", "Date ", "Email Client", "Type", "Total"
                }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
        }

        txtDepot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDepot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDepot.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDepotFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDepotFocusLost(evt);
            }
        });
        txtDepot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepotActionPerformed(evt);
            }
        });

        txtRetrait.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRetrait.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRetrait.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRetraitFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRetraitFocusLost(evt);
            }
        });
        txtRetrait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRetraitActionPerformed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(0, 204, 0));
        btnOk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnOk.setForeground(new java.awt.Color(0, 51, 51));
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        txtDateExpiration.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM/YY"))));
        txtDateExpiration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDateExpiration.setText(" /");
        txtDateExpiration.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNumeroCarte.setBackground(new java.awt.Color(240, 240, 240));
        txtNumeroCarte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNumeroCarte.setForeground(new java.awt.Color(255, 102, 102));
        try {
            txtNumeroCarte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumeroCarte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroCarte.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumeroCarte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroCarteFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroCarteFocusLost(evt);
            }
        });

        txtNumeroCarte1.setBackground(new java.awt.Color(240, 240, 240));
        txtNumeroCarte1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNumeroCarte1.setForeground(new java.awt.Color(255, 102, 102));
        try {
            txtNumeroCarte1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumeroCarte1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroCarte1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNumeroCarte1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroCarte1FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroCarte1FocusLost(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Sommaire");

        chkDepot.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkDepot.setText("Dépot");
        chkDepot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDepotActionPerformed(evt);
            }
        });

        chkRetrait.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chkRetrait.setText("Retrait");
        chkRetrait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRetraitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(72, 72, 72))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtTypeCompte, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addGap(47, 47, 47)
                                                                .addComponent(btnActiver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(txtMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtNumeroCarte)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(txtDateExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(8, 8, 8)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(36, 36, 36)
                                                .addComponent(lblSomme)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(txtNumeroCarte1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(chkDepot)
                                                                .addGap(24, 24, 24)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(chkRetrait)
                                                        .addComponent(txtRetrait, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(165, 165, 165))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel8)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtTypeCompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(btnActiver))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNumeroCarte, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDateExpiration))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSomme)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(chkDepot)
                                        .addComponent(chkRetrait))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNumeroCarte1)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtDepot, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtRetrait, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        txtDateExpAffichage.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat(""))));
        txtDateExpAffichage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDateExpAffichage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateExpAffichageActionPerformed(evt);
            }
        });

        txtNumeroCompteAffichage.setForeground(new java.awt.Color(255, 102, 102));
        try {
            txtNumeroCompteAffichage.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#### #### #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumeroCompteAffichage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroCompteAffichage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-visa-48.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-puce-de-carte-sim-40.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-paiement-sans-contact-24.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 0));
        jLabel11.setText("CHEZ QUEBEC BANQUE");

        jLabel17.setText("Expiration:");

        lblNomClient.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNomClient.setText("Prenom Nom");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/card.jpeg"))); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/card.jpeg"))); // NOI18N

        jLayeredPane2.setLayer(txtDateExpAffichage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtNumeroCompteAffichage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lblNomClient, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11)
                                                .addComponent(txtNumeroCompteAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel16))
                                                                        .addComponent(lblNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(69, 69, 69))
                                                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                                .addComponent(jLabel17)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtDateExpAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                                        .addContainerGap(20, Short.MAX_VALUE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
        );
        jLayeredPane2Layout.setVerticalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroCompteAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                                .addComponent(lblNomClient)
                                                .addGap(18, 18, 18)
                                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtDateExpAffichage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel17)))
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(130, 130, 130))
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel19)
                                        .addContainerGap(54, Short.MAX_VALUE)))
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel20)
                                        .addContainerGap(65, Short.MAX_VALUE)))
        );

        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane1Layout.setVerticalGroup(
                jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jLayeredPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRetour.setBackground(new java.awt.Color(0, 204, 0));
        btnRetour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRetour.setText("Retour");
        btnRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetourActionPerformed(evt);
            }
        });

        btnRafraichir.setBackground(new java.awt.Color(0, 204, 0));
        btnRafraichir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRafraichir.setForeground(new java.awt.Color(0, 51, 51));
        btnRafraichir.setText("Rafraîchir");
        btnRafraichir.setToolTipText("");
        btnRafraichir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRafraichirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnRafraichir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRetour)
                                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRetour)
                                        .addComponent(btnRafraichir))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-visa-48.png"))); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-puce-de-carte-sim-40.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 204, 0));
        jLabel34.setText("QUEBEC BANQUE");

        lblNomClient3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNomClient3.setText("Prenom Nom");

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/card.jpeg"))); // NOI18N

        lblNomClient4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNomClient4.setText("Prenom Nom");

        lblNomClient5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNomClient5.setText("Prenom Nom");

        lblNomClient6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNomClient6.setText("Prenom Nom");

        jLayeredPane5.setLayer(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel32, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(lblNomClient3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel37, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(lblNomClient4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(lblNomClient5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(lblNomClient6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
                jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                .addComponent(lblNomClient6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNomClient5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNomClient4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNomClient3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(118, 118, 118))
                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(jLabel34)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                                        .addContainerGap(20, Short.MAX_VALUE)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
        );
        jLayeredPane5Layout.setVerticalGroup(
                jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                .addContainerGap(53, Short.MAX_VALUE)
                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomClient3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomClient4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNomClient5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNomClient6)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(130, 130, 130))
                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel37)
                                        .addContainerGap(65, Short.MAX_VALUE)))
        );

        jLayeredPane3.setLayer(jLayeredPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
                jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
                jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(185, 185, 185))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetourActionPerformed
        this.dispose();
        FenSeConnecter fenSeConnecter = new FenSeConnecter();
        fenSeConnecter.setVisible(true);
    }//GEN-LAST:event_btnRetourActionPerformed

    private void txtTypeCompteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeCompteFocusGained
        if (txtTypeCompte.getText().equals("Epargne")) {
            txtTypeCompte.setText("");
            txtTypeCompte.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtTypeCompteFocusGained

    private void txtTypeCompteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeCompteFocusLost
        if (txtTypeCompte.getText().isEmpty()) {
            txtTypeCompte.setForeground(Color.GRAY);
            txtTypeCompte.setText("Epargne");
        }
    }//GEN-LAST:event_txtTypeCompteFocusLost

    private void txtPrenomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrenomFocusGained
        if (txtPrenom.getText().equals("Charles")) {
            txtPrenom.setText("");
            txtPrenom.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtPrenomFocusGained

    private void txtPrenomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrenomFocusLost
        if (txtPrenom.getText().isEmpty()) {
            txtPrenom.setForeground(Color.GRAY);
            txtPrenom.setText("Charles");
        }
    }//GEN-LAST:event_txtPrenomFocusLost

    private void txtNomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomFocusGained
        if (txtNom.getText().equals("Beaudelaire")) {
            txtNom.setText("");
            txtNom.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtNomFocusGained

    private void txtNomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomFocusLost
        if (txtNom.getText().isEmpty()) {
            txtNom.setForeground(Color.GRAY);
            txtNom.setText("Beaudelaire");
        }
    }//GEN-LAST:event_txtNomFocusLost

    private void txtMontantFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontantFocusGained
        if (txtMontant.getText().equals("00")) {
            txtMontant.setText("");
            txtMontant.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtMontantFocusGained

    private void txtMontantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontantFocusLost
        if (txtMontant.getText().isEmpty()) {
            txtMontant.setForeground(Color.GRAY);
            txtMontant.setText("00");
        }
    }//GEN-LAST:event_txtMontantFocusLost

    private void txtDepotFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDepotFocusGained
        if (txtDepot.getText().equals("Depot")) {
            txtDepot.setText("");
            txtDepot.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtDepotFocusGained

    private void txtDepotFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDepotFocusLost
        if (txtDepot.getText().isEmpty()) {
            txtDepot.setForeground(Color.GRAY);
            txtDepot.setText("Depot");
        }
    }//GEN-LAST:event_txtDepotFocusLost

    private void txtRetraitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRetraitFocusGained
        if (txtRetrait.getText().equals("Retrait")) {
            txtRetrait.setText("");
            txtRetrait.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtRetraitFocusGained

    private void txtRetraitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRetraitFocusLost
        if (txtRetrait.getText().isEmpty()) {
            txtRetrait.setForeground(Color.GRAY);
            txtRetrait.setText("Retrait");
        }
    }//GEN-LAST:event_txtRetraitFocusLost

    private void btnActiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActiverActionPerformed
        String dateEx = txtDateExpiration.getText();
        int depot = Integer.parseInt(txtMontant.getText());
        if (depot < 50) {
            JOptionPane.showMessageDialog(null, "Il faut ajouter plus d'argent pour activer");
        } else {
            JOptionPane.showMessageDialog(null, "Félicitation");
            try {
                creationsID();
                String compte = txtNumeroCarte.getText();
                txtNumeroCompteAffichage.setText(compte);
                txtDateExpAffichage.setText(dateEx);
                txtNumeroCarte1.setText(compte);

                Carte carte = new Carte();
                carte.setIdCarte(0);
                String nombre1 = compte.substring(0, 4);
                String nombre2 = compte.substring(5, 9);
                String nombre3 = compte.substring(10, 14);
                String nombre4 = compte.substring(15);

                long compteSubString = Long.parseLong(nombre1 + nombre2 + nombre3 + nombre4);

                System.out.println(nombre1 + nombre2 + nombre3 + nombre4);

                carte.setNoCarte(compteSubString);

                carte.setDateExp(dateEx);
                carte.setEmail(courriel);
                carte.setTypeCompte(txtTypeCompte.getText());
                carte.setTotal(Double.parseDouble(txtMontant.getText()));

                System.out.println("Voici la dateExp " + dateEx);


                try {
                    BaseDeDonnee.seConnecter();
                    ajouterCarte(compteSubString, courriel, txtTypeCompte.getText(), Double.parseDouble(txtMontant.getText()));
                    BaseDeDonnee.seDeconnecter();
                    JOptionPane.showMessageDialog(null, ", Félicitation votre carte a été créé avec succès \n"
                            , "Succès", JOptionPane.INFORMATION_MESSAGE);


                } catch (SQLException e) {
                    //e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur de création de carte \n"
                            , "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                } finally {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    try {
                        BaseDeDonnee.seConnecter();
                        setBtnRafraichir();
                        BaseDeDonnee.seDeconnecter();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erreur de création de carte \n"
                        , "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnActiverActionPerformed

    private void setDateExpiration() {

        ZoneId zonedId = ZoneId.of("America/Montreal");
        today = LocalDate.now(zonedId);
        //trouverDateJour(today);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        try {
            //Définir la date
            cal.setTime(sdf.parse(String.valueOf(today)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Nombre de jours à ajouter
        cal.add(Calendar.DAY_OF_MONTH, 1826);
        //Date après avoir ajouté les jours à la date indiquée
        String d2 = sdf.format(cal.getTime());
        System.out.println("Date après l'addition: " + d2);
        today = LocalDate.parse(d2);
        System.out.println("Voici la date today " + today);

        int mois = Integer.parseInt(today.toString().substring(5, 7));
        int annnee = Integer.parseInt(today.toString().substring(2, 4));

        txtDateExpiration.setText(mois + "/" + annnee);
    }

    private void ajouterCarte(long no_carte, String email, String type_compte, double total) throws SQLException {
        System.out.println("Insertion effectuée...");
        BaseDeDonnee.query = "INSERT INTO carte (no_carte,date_exp, email, " +
                "type_compte,total) VALUES" +
                "(" + no_carte + ",'" + today + "','" + email + "'," +
                " '" + type_compte + "', " + total + ")";
        BaseDeDonnee.prepareStatement = BaseDeDonnee.connection.prepareStatement(BaseDeDonnee.query);
        BaseDeDonnee.prepareStatement.executeUpdate(BaseDeDonnee.query);
    }


    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (chkDepot.isSelected()) {
            String numeroCarte = txtNumeroCarte1.getText();

            String nombre1 = numeroCarte.substring(0, 4);
            String nombre2 = numeroCarte.substring(5, 9);
            String nombre3 = numeroCarte.substring(10, 14);
            String nombre4 = numeroCarte.substring(15);
            long compteSubString = Long.parseLong(nombre1 + nombre2 + nombre3 + nombre4);

            try {
                depot = Double.parseDouble(txtDepot.getText());
            } catch (NumberFormatException e) {
                e.getStackTrace();
                JOptionPane.showMessageDialog(null, "entrer un montant pour un dépot  \n"
                        , "Erreur", JOptionPane.ERROR_MESSAGE);

            }
            try {
                BaseDeDonnee.seConnecter();
                ajouterMontantCarte(depot, compteSubString);
                BaseDeDonnee.seDeconnecter();
                JOptionPane.showMessageDialog(null, ", Félicitation vous avez ajouté : " + depot + " $ à votre compte\n"
                        , "Succès", JOptionPane.INFORMATION_MESSAGE);

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                try {
                    BaseDeDonnee.seConnecter();
                    setBtnRafraichir();
                    BaseDeDonnee.seDeconnecter();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur d'ajout d'un montant \n"
                        , "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (chkRetrait.isSelected()) {
            double retrait = Double.parseDouble(txtRetrait.getText());
            String numeroCarte = txtNumeroCarte1.getText();

            String nombre1 = numeroCarte.substring(0, 4);
            String nombre2 = numeroCarte.substring(5, 9);
            String nombre3 = numeroCarte.substring(10, 14);
            String nombre4 = numeroCarte.substring(15);
            long compteSubString = Long.parseLong(nombre1 + nombre2 + nombre3 + nombre4);

            try {
                retrait = Double.parseDouble(txtRetrait.getText());
            } catch (NumberFormatException e) {
                e.getStackTrace();
                JOptionPane.showMessageDialog(null, "entrer un montant pour un retrait  \n"
                        , "Erreur", JOptionPane.ERROR_MESSAGE);

            }
            try {
                BaseDeDonnee.seConnecter();
                retirerMontantCarte(retrait, compteSubString);
                BaseDeDonnee.seDeconnecter();
                JOptionPane.showMessageDialog(null, ", Vous venez de retirer  : " + retrait + " $ à votre compte\n"
                        , "Succès", JOptionPane.INFORMATION_MESSAGE);

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                try {
                    BaseDeDonnee.seConnecter();
                    setBtnRafraichir();
                    BaseDeDonnee.seDeconnecter();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erreur d'ajout d'un montant \n"
                        , "Erreur", JOptionPane.ERROR_MESSAGE);
            }


        }


    }//GEN-LAST:event_btnOkActionPerformed

    private void retirerMontantCarte(double retrait, long numeroCarte) throws SQLException {
        System.out.println("Update d'un enregistrement");
        BaseDeDonnee.query = "UPDATE carte set total = total-" + retrait + " WHERE no_carte = " + numeroCarte + " ";
        BaseDeDonnee.prepareStatement = BaseDeDonnee.connection.prepareStatement(BaseDeDonnee.query);
        BaseDeDonnee.prepareStatement.executeUpdate(BaseDeDonnee.query);
        System.out.println("Mise a jour effectuée : " + BaseDeDonnee.prepareStatement);
    }

    private void ajouterMontantCarte(double depot, long numeroCarte) throws SQLException {
        System.out.println("Update d'un enregistrement");
        BaseDeDonnee.query = "UPDATE carte set total = total+" + depot + " WHERE no_carte = " + numeroCarte + " ";
        BaseDeDonnee.prepareStatement = BaseDeDonnee.connection.prepareStatement(BaseDeDonnee.query);
        BaseDeDonnee.prepareStatement.executeUpdate(BaseDeDonnee.query);
        System.out.println("Mise a jour effectuée : " + BaseDeDonnee.prepareStatement);
    }

    private void txtNumeroCarteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroCarteFocusGained
        if (txtNumeroCarte.getText().equals("0000 0000 0000 0000")) {
            txtNumeroCarte.setText("");
        }
    }//GEN-LAST:event_txtNumeroCarteFocusGained

    private void txtNumeroCarteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroCarteFocusLost
        if (txtNumeroCarte.getText().isEmpty()) {
            txtNumeroCarte.setText("0000 0000 0000 0000");
        }
    }//GEN-LAST:event_txtNumeroCarteFocusLost

    private void txtDateExpAffichageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateExpAffichageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateExpAffichageActionPerformed

    private void txtNumeroCarte1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroCarte1FocusGained
        if (txtNumeroCarte1.getText().equals("0000 0000 0000 0000")) {
            txtNumeroCarte1.setText("");
        }
    }//GEN-LAST:event_txtNumeroCarte1FocusGained

    private void txtNumeroCarte1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroCarte1FocusLost
        if (txtNumeroCarte1.getText().isEmpty()) {
            txtNumeroCarte1.setText("0000 0000 0000 0000");
        }
    }//GEN-LAST:event_txtNumeroCarte1FocusLost

    private void btnRafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRafraichirActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        chargerPage();
        setDateExpiration();

        try {
            BaseDeDonnee.seConnecter();
            setBtnRafraichir();
            BaseDeDonnee.seDeconnecter();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnRafraichirActionPerformed

    private void txtDepotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepotActionPerformed
        txtRetrait.setEnabled(false);
    }//GEN-LAST:event_txtDepotActionPerformed

    private void txtRetraitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRetraitActionPerformed
        txtDepot.setEnabled(false);
    }//GEN-LAST:event_txtRetraitActionPerformed

    private void chkDepotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDepotActionPerformed
        if (chkDepot.isSelected()) {
            chkRetrait.setEnabled(false);
        }
        if (!chkDepot.isSelected()) {
            chkDepot.setEnabled(true);
            chkRetrait.setEnabled(true);
        }
    }//GEN-LAST:event_chkDepotActionPerformed

    private void chkRetraitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRetraitActionPerformed
        if (chkRetrait.isSelected()) {
            chkDepot.setEnabled(false);
        }
        if (!chkRetrait.isSelected()) {
            chkDepot.setEnabled(true);
            chkRetrait.setEnabled(true);
        }
    }//GEN-LAST:event_chkRetraitActionPerformed


    private void setBtnRafraichir() throws SQLException {
        chkDepot.setEnabled(true);
        chkDepot.setSelected(false);
        chkRetrait.setEnabled(true);
        chkRetrait.setSelected(false);
        chargerPage();

        BaseDeDonnee.query = "SELECT * FROM carte WHERE email = '" + courriel + "'";
        BaseDeDonnee.prepareStatement = BaseDeDonnee.connection.prepareStatement(BaseDeDonnee.query);
        ResultSet resultSet = BaseDeDonnee.prepareStatement.executeQuery(BaseDeDonnee.query);
        while (resultSet.next()) {

            long noCarte = resultSet.getLong(2);
            Date dateExp = resultSet.getDate(3);
            String emailClient = resultSet.getString(4);
            String typeCompte = resultSet.getString(5);
            double total = resultSet.getDouble(6);

            System.out.println(noCarte + "" + dateExp + "" + emailClient + "" + typeCompte + "" + total);

            lblSomme.setText(String.valueOf(total));


            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{noCarte, dateExp, emailClient, typeCompte, total});

        }
    }

    private void creationsID() {
        long first16 = (long) (Math.random() * 10000000000000000L);
        txtNumeroCarte.setText(String.valueOf(first16));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActiver;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnRafraichir;
    private javax.swing.JButton btnRetour;
    private javax.swing.JCheckBox chkDepot;
    private javax.swing.JCheckBox chkRetrait;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblNomClient;
    private javax.swing.JLabel lblNomClient3;
    private javax.swing.JLabel lblNomClient4;
    private javax.swing.JLabel lblNomClient5;
    private javax.swing.JLabel lblNomClient6;
    private javax.swing.JLabel lblSomme;
    private javax.swing.JFormattedTextField txtDateExpAffichage;
    private javax.swing.JFormattedTextField txtDateExpiration;
    private javax.swing.JTextField txtDepot;
    private javax.swing.JTextField txtMontant;
    private javax.swing.JTextField txtNom;
    private javax.swing.JFormattedTextField txtNumeroCarte;
    private javax.swing.JFormattedTextField txtNumeroCarte1;
    private javax.swing.JFormattedTextField txtNumeroCompteAffichage;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtRetrait;
    private javax.swing.JTextField txtTypeCompte;
    // End of variables declaration//GEN-END:variables
}
