/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import model.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Bilan;

import model.Commentaire;
import model.Exercice;

/**
 *
 * @author RHAW
 */
public class Bd {

    /**
     * Connexion.
     */
    private static Connection cx;

    //données de connexion
    private final static String url = "jdbc:mysql://np903346ltnyr11z:dsbumc5602c2y8ky@m60mxazb4g6sb4nn.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/fupu8i1nlz5lkcc8";

    /**
     * BD Connexion.
     *
     * @throws Exception Exception
     */
    private static void connexion() throws Exception {

        //Chargement du driver JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new Exception("Problème de chargement du driver - "
                    + ex.getMessage());
        }

        //Création de la connexion
        try {
            Bd.cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            throw new Exception("Problème de connexion à la BD - "
                    + ex.getMessage());
        }

    }

    /**
     * Saisir un utilisateur.
     *
     * @param u utilisateur
     * @throws Exception Exception
     */
    public final void saisirUtilisateur(final Utilisateur u) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        String sqlsaisir = "insert into utilisateur(CODEU,NOMU,PRENOMU,DATEDENAISSANCEU,EMAILU,TELU,STATUTS,PASSWORD,TYPE,OBJECTIF) values('"
                + u.getCodeu()
                + "','"
                + u.getNomu()
                + "','"
                + u.getPrenomu()
                + "','"
                + u.getDatenaissanceu()
                + "','"
                + u.getEmailu()
                + "','"
                + u.getTelu()
                + "','"
                + u.getStatus()
                + "','"
                + u.getPassword()
                + "','"
                + u.getType()
                + "','"
                + u.getObjectif()
                + "')";
        try {
            statement.executeUpdate(sqlsaisir);
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }

    }

    /**
     * mise à jour un utilisateur.
     *
     * @param u utilisateur
     * @throws Exception Exception
     */
    public static void updateUtilisateur(final String nom, final String prenom, final String date, final String mail, final String tel, final String password) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlsaisir = "update utilisateur set NOMU = '" + nom + "', PRENOMU= '" + prenom + "', "
                + "DATEDENAISSANCEU='" + date + "', TELU='" + tel + "' ,PASSWORD='" + password + "' where EMAILU='" + mail + "'";
        try {
            statement.executeUpdate(sqlsaisir);
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }

    }

    /**
     * mise à jour une exercice.
     *
     * @param u utilisateur
     * @throws Exception Exception
     */
    public static void updateExercice(final String nome, final String description, final String tempsrepetition, final String nbrepetition, final String lienimage) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlupdate = "update exercice set DUREEE = '" + tempsrepetition + "', LIENIMAGE= '" + lienimage + "', "
                + "REPETE='" + nbrepetition + "', DESCRIPTIONE='" + description + "' where LIBELLEE='" + nome + "'";
        try {
            statement.executeUpdate(sqlupdate);
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }

    }

    /**
     * ajouter une exercice.
     *
     * @param u utilisateur
     * @throws Exception Exception
     */
    public static void insererExercice(final String nome, final String description, final String tempsrepetition, final String nbrepetition, final String lienimage) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlinserer = "insert into exercice (LIBELLEE,DUREEE,LIENIMAGE,REPETE,DESCRIPTIONE) "
                + "values('" + nome + "','" + tempsrepetition + "','" + lienimage + "','" + nbrepetition + "','" + description + "')";
        try {
            statement.executeUpdate(sqlinserer);
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }

    }

    /**
     * supprimer une exercice.
     *
     * @param u utilisateur
     * @throws Exception Exception
     */
    public static void deleteExercice(final String nome) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqldelete = "delete from exercice where LIBELLEE='" + nome + "'";
        try {
            statement.executeUpdate(sqldelete);
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }

    }

    /**
     * chercher le code d'exercise
     *
     * @param nome nom d'exercises
     * @return
     * @throws Exception Exception
     */
    public static int cherchecodeexercise(final String nome) throws Exception {
        int codee = 0;

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlcode = "SELECT CODEE FROM exercice WHERE LIBELLEE='" + nome + "'";
        try {
            ResultSet rs = statement.executeQuery(sqlcode);
            while (rs.next()) {
                codee = rs.getInt("CODEE");

            }
            rs.close();
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
        return codee;

    }

    /**
     * chercher le code d'exercise
     *
     * @param nome nom d'exercises
     * @return
     * @throws Exception Exception
     */
    public ArrayList<String> nomexercise() throws Exception {
        ArrayList<String> arrayex = new ArrayList<String>();

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlnomexercice = "SELECT LIBELLEE FROM exercice";
        try {
            ResultSet rs = statement.executeQuery(sqlnomexercice);
            while (rs.next()) {
                arrayex.add(rs.getString("LIBELLEE"));

            }
            rs.close();
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
        return arrayex;

    }

    /**
     * chercher le code d'exercise
     *
     * @param bi
     * @throws Exception Exception
     */
    public static void insererBilan(int codeu, String libelle, String numsemaine, String commentaire, String fcallogee, String fcflexions, String fcrepos) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlbilan = "insert into bilan (CODEU, LIBELLEB, NUMSEMAINEB, COMMENTAIRECOACHB, FCALLONGEE, FCFLEXIONS, FCREPOS, DATEB) values ('" + codeu + "','" + libelle + "','" + numsemaine + "','" + commentaire + "','" + fcallogee + "','" + fcflexions + "','" + fcrepos + "',NOW())";
        try {
            statement.executeUpdate(sqlbilan);
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
    }

    /**
     * Inserer le relation attacher
     *
     * @param bi
     * @throws Exception Exception
     */
    public static void insererAttacher(int codeb, int codee, String ordre, String maxtemps, String numrepetition) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlbilan = "insert into attacher values (" + codeb + ","
                + codee + ",NOW(),'"
                + ordre + "','"
                + maxtemps + "','"
                + numrepetition + "')";
        try {
            statement.executeUpdate(sqlbilan);
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
    }

    /**
     * chercher le code de bilan
     *
     * @param codeu
     * @return
     * @throws Exception Exception
     */
    public static int consulterBilan(int codeu) throws Exception {
        int codeb = 0;

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlbilan = "select CODEB from bilan where CODEU='" + codeu + "' and NUMSEMAINEB = '0'";
        try {
            ResultSet rs = statement.executeQuery(sqlbilan);
            while (rs.next()) {
                codeb = rs.getInt("CODEB");
            }
            rs.close();
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
        return codeb;
    }

    /**
     * chercher le code d'exercice
     *
     * @param libellee
     * @return
     * @throws Exception Exception
     */
    public static int consulterexercice(String libellee) throws Exception {
        int codee = 0;

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlbilan = "select CODEE from bilan where LIBELLEE='" + libellee + "'";
        try {
            ResultSet rs = statement.executeQuery(sqlbilan);
            while (rs.next()) {
                codee = rs.getInt("CODEE");
            }
            rs.close();
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
        return codee;
    }

    /**
     * chercher le code de premierbilan
     *
     * @param libellee
     * @return
     * @throws Exception Exception
     */
    public static int chercherfirstbilan(int codeu) throws Exception {
        int codee = 0;

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlbilan = "select CODEB from bilan where LIBELLEE= 'firstbilan' and CODEU='" + codeu + "'";
        try {
            ResultSet rs = statement.executeQuery(sqlbilan);
            while (rs.next()) {
                codee = rs.getInt("CODEE");
            }
            rs.close();
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
        return codee;
    }

    /**
     * mise à jour un utilisateur.
     *
     * @param u utilisateur
     * @throws Exception Exception
     */
    public static void insererMesuration(final int codeu, final String poids, final String bras,
            final String poitrine, final String taille, final String hanches, final String cuisses) throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlmesuration = "insert into mesuration(DATEMESURE,LIBELLEM,POIDS,BRAS,POITRINE,TAILLE,HANCHES,CUISSES,CODEU) values ( NOW(),'mesuration','"
                + poids + "','" + bras + "','" + poitrine + "','" + taille + "','" + hanches + "','" + cuisses + "','" + codeu + "')";
        try {
            statement.executeUpdate(sqlmesuration);
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }

    }

    /**
     * Retour d'un admin.
     *
     * @param mail mail du user
     * @param pwd password du user
     * @return boolean
     * @throws Exception Exception
     */
    public static boolean getAdmin(final String mail, final String pwd)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;
        String query = "SELECT COUNT(*) as rowcount "
                + "FROM UTILISATEUR "
                + "WHERE EMAILU='"
                + mail
                + "'"
                + "AND PASSWORD='"
                + pwd
                + "'"
                + "AND TYPE='admin'"
                + ";";

        /* Execution de la requête */
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                if (rs.getInt("rowcount") == 1) {
                    requestOK = true;
                }
            }
            rs.close();
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
        return requestOK;
    }

    /**
     * Recupération d'un utilisateur.
     *
     * @param codeu Code utilisateur
     * @return un utilisateur
     * @throws Exception Exception
     */
    public static Utilisateur getUser(final String codeu)
            throws Exception {

        Utilisateur user = null;

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement to handle query
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        String query = "SELECT * "
                + "FROM UTILISATEUR "
                + "WHERE CODEU='"
                + codeu
                + "' "
                + ";";

        /* Execution de la requête */
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                user = new Utilisateur(
                        rs.getInt("CODEU"),
                        rs.getString("NOMU"),
                        rs.getString("PRENOMU"),
                        rs.getString("DATEDENAISSANCEU"),
                        rs.getString("EMAILU"),
                        rs.getString("TELU"),
                        rs.getString("STATUTS"),
                        rs.getString("PASSWORD"),
                        rs.getString("TYPE"),
                        rs.getString("OBJECTIF"));
            }
            rs.close();
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Problème avec récupération de la requête : "
                    + ex.getMessage());
        }
        return user;
    }

    /**
     * Changement de mail Admin.
     *
     * @param newmailadmin new mail
     * @return booléen
     * @throws Exception Exception
     */
    public static boolean changementMailAdmin(final String newmailadmin)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;

        /* Requête */
        String sqlupdateadmin = "UPDATE UTILISATEUR SET EMAILU ='"
                + newmailadmin
                + "' "
                + "WHERE TYPE='admin'";

        try {
            statement.executeUpdate(sqlupdateadmin);
            requestOK = true;
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Erreur execution requête "
                    + ex.getMessage());
        }
        return requestOK;
    }

    /**
     * Changement de mail de coaching.
     *
     * @param newmailcoach
     * @return booléen
     * @throws Exception Exception
     */
    public static boolean changementMailCoach(final String newmailcoach)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }

        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;

        /* Requête */
        String sqlupdateadmin = "UPDATE UTILISATEUR SET EMAILU = '"
                + newmailcoach
                + "' "
                + "WHERE TYPE='coach'";

        /* Execution de la requête */
        try {
            statement.executeUpdate(sqlupdateadmin);
            requestOK = true;
            statement.close();
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Erreur execution requête "
                    + ex.getMessage());
        }
        return requestOK;
    }

    /**
     * Retour des utilisateurs de la BD.
     *
     * @return ArrayList d'utilisateurs
     * @throws Exception Exception
     */
    public static ArrayList<Utilisateur> getUtilisateurs()
            throws Exception {

        // ArrayList pour stocker les utilisateurs
        ArrayList<Utilisateur> users = new ArrayList();
        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        /* Requête ajout des abonnés */
        String sqlabonne = "Select CODEU, NOMU, PRENOMU, DATEDENAISSANCEU, EMAILU, TELU, STATUTS, PASSWORD, TYPE, OBJECTIF FROM UTILISATEUR ORDER BY NOMU ASC";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                ResultSet rs = st.executeQuery(sqlabonne);
                /* Adding messages to the ArrayList */
                while (rs.next()) {

                    users.add(new Utilisateur(
                            rs.getInt("CODEU"),
                            rs.getString("NOMU"),
                            rs.getString("PRENOMU"),
                            rs.getString("DATEDENAISSANCEU"),
                            rs.getString("EMAILU"),
                            rs.getString("TELU"),
                            rs.getString("STATUTS"),
                            rs.getString("PASSWORD"),
                            rs.getString("TYPE"),
                            rs.getString("OBJECTIF")));
                }
                rs.close();
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return users;
    }

    /**
     * Passage d'un prospect en attente.
     *
     * @param codeu code utilisateur
     * @return boolean
     * @throws Exception Exception
     */
    public static boolean enAttente(final String codeu)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;

        /* Requête */
        String sqlupdateEnAttente = "UPDATE UTILISATEUR SET STATUTS ='En attente'"
                + "WHERE CODEU='"
                + codeu
                + "' ";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                st.executeUpdate(sqlupdateEnAttente);
                requestOK = true;
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return requestOK;
    }

    /**
     * Passage à un statut validé.
     *
     * @param codeu code utilisateur
     * @return boolean
     * @throws Exception Exception
     */
    public static boolean passageValide(final String codeu)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;

        /* Requête */
        String sqlupdateValide = "UPDATE UTILISATEUR SET STATUTS ='Valide'"
                + "WHERE CODEU='"
                + codeu
                + "' ";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                st.executeUpdate(sqlupdateValide);
                requestOK = true;
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return requestOK;
    }

    /**
     * Ajout d'un commentaire sur un utilisateur.
     *
     * @param codeu code utilisateur
     * @param com contenu du commentaire
     * @return Boolean
     * @throws Exception Exception
     */
    public static boolean addCommentaire(final String codeu, final String com)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;

        /* Requête */
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String sqlajoutinfopersos = "INSERT INTO COMMENTAIRE(CONTENUCOM, DATECOM, CODEU) "
                + "values ('"
                + com
                + "', '"
                + dateFormat.format(date)
                + "', '"
                + codeu
                + "')";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                st.executeUpdate(sqlajoutinfopersos);
                requestOK = true;
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return requestOK;
    }

    /**
     * Suppression d'un commentaire sur un utilisateur.
     *
     * @param codecom code utilisateur
     * @return Boolean
     * @throws Exception Exception
     */
    public static boolean supprimerCommentaire(final int codecom)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;

        /* Requête */
        String sqlsupprimcoms = "DELETE FROM COMMENTAIRE WHERE CODECOM='"
                + codecom
                + "'";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                st.executeUpdate(sqlsupprimcoms);
                requestOK = true;
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return requestOK;
    }

    /**
     * Suppression d'un utilisateur.
     *
     * @param codeu code utilisateur
     * @return Boolean
     * @throws Exception Exception
     */
    public static boolean supprimerClient(final int codeu)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }
        boolean requestOK = false;

        /* Requête */
        String sqlsupprimerclient = "DELETE FROM UTILISATEUR WHERE CODEU='"
                + codeu
                + "'";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                st.executeUpdate(sqlsupprimerclient);
                requestOK = true;
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return requestOK;
    }

    /**
     * Retourne tous les commentaires d'un utilisateur.
     *
     * @param codeu code utilisateur
     * @return ArrayList
     * @throws Exception Zxception
     */
    public static ArrayList<Commentaire> getCommentaires(final String codeu)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }

        ArrayList<Commentaire> commentaires = new ArrayList();

        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        /* Requête */
        String sqlgetinfopersos
                = "SELECT * FROM COMMENTAIRE WHERE CODEU='"
                + codeu
                + "' ";

        try {

            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                ResultSet rs = st.executeQuery(sqlgetinfopersos);
                /* Adding messages to the String[] */
                while (rs.next()) {
                    commentaires.add(new Commentaire((Integer) rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            (Integer) rs.getInt(4)));
                }
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return commentaires;
    }

    /*
    *pour vérifier le mot de passe correspondant à mail et récupérer statuts
     */
    public static String[] consulterUtilisateur(String mail) throws Exception {
        String[] info = new String[3];
        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlpassword = "select PASSWORD,TYPE, CODEU from utilisateur where EMAILU ='" + mail + "'";
        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                ResultSet rs = st.executeQuery(sqlpassword);
                /* Adding messages to the ArrayList */
                while (rs.next()) {
                    info[0] = rs.getString("PASSWORD");
                    //System.out.println(info[0]);
                    info[1] = rs.getString("TYPE");
                    info[2] = String.valueOf(rs.getInt("CODEU"));
                    //System.out.println(info[1]);
                }
                rs.close();
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return info;

    }

    /*
    *pour récupérer les données d'un utilisateur
     */
    public static Utilisateur donneeUtilisateur(final String mail)
            throws Exception {
        Utilisateur u = new Utilisateur(-1, "", "", "", "", "", "", "", "", "");
        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlutilisateur = "select * from utilisateur where EMAILU ='" + mail + "'";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                ResultSet rs = st.executeQuery(sqlutilisateur);
                /* Adding messages to the ArrayList */
                while (rs.next()) {

                    u = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                }
                rs.close();
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return u;

    }

    /*
    *pour récupérer les données d'une exercice
     */
    public static Exercice donneeExercice(final String nomexercice)
            throws Exception {
        Exercice e = new Exercice("", "", "", "", "");
        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlutilisateur = "select * from exercice where LIBELLEE ='" + nomexercice + "'";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                ResultSet rs = st.executeQuery(sqlutilisateur);
                /* Adding messages to the ArrayList */
                while (rs.next()) {

                    e = new Exercice(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                }
                rs.close();
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return e;

    }

    /*
    *pour vérifier le mail n'exist pas dans BD quand faire inscription
     */
    public static Integer verifierMail(final String mail) throws Exception {
        Integer num = null;
        if (Bd.cx == null) {
            Bd.connexion();
        }
        // Statement pour effectuer la requête
        Statement statement;
        //Ouverture de la connexion
        try {
            cx = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }
        try {
            statement = cx.createStatement();
        } catch (SQLException error) {
            throw new Exception("Problème avec création du statement : "
                    + error.getMessage());
        }

        String sqlmail = "select count(EMAILU) from utilisateur where EMAILU ='" + mail + "'";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                ResultSet rs = st.executeQuery(sqlmail);
                /* Adding messages to the ArrayList */
                while (rs.next()) {

                    num = rs.getInt(1);
                }
                rs.close();
                st.close();
                cx.close();
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return num;

    }

// Request testing
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException, Exception {

        Bd.supprimerCommentaire(2);
    }
}
