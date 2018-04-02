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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String sqlsaisir = "insert into utilisateur(CODEU,NOMU,PRENOMU,DATEDENAISSANCEU,EMAILU,TELU,STATUTS,PASSWORD,TYPE) values('"
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
     * mise à jour un utilisateur.
     *
     * @param u utilisateur
     * @throws Exception Exception
     */
    public static void insererMesuration(final String poids, final String bras,
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");//
        System.out.println(dateFormat.format(new Date()));

        String sqlmesuration = "insert into mesuration(DATEMESURE,LIBELLEM,POIDS,BRAS,POITRINE,TAILLE,HANCHES,CUISSES) values ( NOW(),'mesuration','"
                + poids + "','" + bras + "','" + poitrine + "','" + taille + "','" + hanches + "','" + cuisses + "')";
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
        String sqlupdateValide = "UPDATE UTILISATEUR SET STATUTS ='Validé'"
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
     * Ajout d'informations sur un utilisateur.
     * @param codeu code utilisateur
     * @param info informations personnelles
     * @return Boolean
     * @throws Exception Exception
     */
    public static boolean addInformation(final String codeu, final String info)
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
        String sqlajoutinfopersos = "INSERT INTO ENVOYER(CODEU, CODEU_1, DATEENVOIE, CONTENU, ETAT) values ()";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                st.executeQuery(sqlajoutinfopersos);
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
     * Suppression d'informations personnelles sur un utilisateur.
     * @param codeu code utilisateur
     * @param info infos personnelles
     * @return Boolean
     * @throws Exception Exception
     */
    public static boolean supprimerInformation(final String codeu, final String info)
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
        String sqlajoutinfopersos = "INSERT INTO ENVOYER(CODEU, CODEU_1, DATEENVOIE, CONTENU, ETAT) values ()";

        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                st.executeQuery(sqlajoutinfopersos);
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
     * Retourne toutes les informations d'un utilisateur.
     * @param codeu code utilisateur
     * @return ArrayList
     * @throws Exception Zxception
     */
public static String[] getInformations(final String codeu)
            throws Exception {

        if (Bd.cx == null) {
            Bd.connexion();
        }

       String[] infospersos = new String[2];

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
        String sqlgetinfopersos =
                    "SELECT * FROM ENVOYER WHERE CODEU='"
                    + codeu
                    + "' "
                    + "AND ETAT=null";

        try {

            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                ResultSet rs = st.executeQuery(sqlgetinfopersos);
                /* Adding messages to the String[] */
                while (rs.next()) {
                    infospersos[0] = rs.getString("CONTENU");
                    infospersos[1] = rs.getString("DATEENVOIE");
                }
            } catch (SQLException ex) {
                System.out.println("Erreur execution requête "
                        + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de SQL statement "
                    + ex.getMessage());
        }
        return infospersos;
    }

    /*
    *pour vérifier le mot de passe correspondant à mail et récupérer statuts
     */
    public static String[] consulterUtilisateur(String mail) throws Exception {
        String[] info = new String[2];
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

        String sqlpassword = "select PASSWORD,TYPE from utilisateur where EMAILU ='" + mail + "'";
        try {
            Statement st = cx.createStatement();
            /* Execution de la requête */
            try {
                ResultSet rs = st.executeQuery(sqlpassword);
                /* Adding messages to the ArrayList */
                while (rs.next()) {
                    info[0] = rs.getString("PASSWORD");
                    System.out.println(info[0]);
                    info[1] = rs.getString("TYPE");
                    System.out.println(info[1]);
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

// Request test
/*public static void main(String[] args)
        throws ClassNotFoundException, SQLException, Exception {
        
        Bd.changementMailCoach("coach@coach.com");
}*/
}
