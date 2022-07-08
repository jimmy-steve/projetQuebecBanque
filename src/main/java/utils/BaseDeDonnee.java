package utils;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class BaseDeDonnee {
    public static Connection connection = null;
    public static PreparedStatement prepareStatement = null;
    public static String query = null;
    static ResultSet resultSet = null;

    public static void seConnecter() throws SQLException {
        System.out.println("Connexion établie avec succès avec la bd MySQL ....\n");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compte", "root",
                "MOTDEPASSE");
    }

    public static void afficherVraiDonner() throws SQLException {
        System.out.println("- Voici le sommaire de tous les comptes de vos client  \n");
        query = "SELECT * FROM compte";
        prepareStatement = connection.prepareStatement(query);
        ResultSet resultSet = prepareStatement.executeQuery(query);
        while (resultSet.next()) {
            //Retrouver  par le nom de la colonne
            String email = resultSet.getString(1);
            String type_compte = resultSet.getString(2);
            String titulaire = resultSet.getString(3);
            String nomClient = resultSet.getString(4);
            String prenomClient = resultSet.getString(5);
            int jourNaissance = resultSet.getInt(6);
            int moisNaissance = resultSet.getInt(7);
            int anneeNaissance = resultSet.getInt(8);
            String pays = resultSet.getString(9);
            String motDePasse = resultSet.getString(10);
            String ville = resultSet.getString(11);
            String telephone = resultSet.getString(12);
            String adresse = resultSet.getString(13);


            System.out.printf("%s, %s, %s,%s,%s,%d,%d,%d,%s,%s,%s,%s,%s\n", email, type_compte, titulaire, nomClient,
                    prenomClient, jourNaissance, moisNaissance, anneeNaissance, pays, motDePasse, ville, telephone, adresse);

        }
        resultSet.close();
    }

    public static void afficherListeCompte() throws SQLException {
        query = "SELECT * FROM carte WHERE email = 'email@gmail.com'";
        prepareStatement = connection.prepareStatement(query);
        ResultSet resultSet = prepareStatement.executeQuery(query);
        while (resultSet.next()) {

            long noCarte = resultSet.getLong(2);
            Date dateExp = resultSet.getDate(3);
            String emailClient = resultSet.getString(4);
            String typeCompte = resultSet.getString(5);
            double total = resultSet.getDouble(6);

            System.out.println(noCarte + "" + dateExp + "" + emailClient + "" + typeCompte + "" + total);
        }
        resultSet.close();
    }

    public static void seDeconnecter() throws SQLException {
        System.out.println("\nFermeture de la connexion...");
        prepareStatement.close();
        connection.close();
    }


}
