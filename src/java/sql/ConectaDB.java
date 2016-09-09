/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SENCICO
 */
public class ConectaDB {
    private final String driver;
    private final String url;
    private final String usuario;
    private final String password;

    public ConectaDB() {
        this.driver = "oracle.jdbc.driver.OracleDriver";
        this.url = "jdbc:oracle:thin:@localhost:1521:XE";
        this.usuario = "parainfo";
        this.password = "parainfo";
    }

    public ConectaDB(String db) {
        String strDriver = null;
        String strUrl = null;
        String strUsuario = null;
        String strPassword = null;

        if (db.equals("mysql")) {
            strDriver = "com.mysql.jdbc.Driver";
            strUrl = "jdbc:mysql://localhost:3306/parainfo";
            strUsuario = "root";
            strPassword = "mysql";
        } else if (db.equals("postgres")) {
            strDriver = "org.postgresql.Driver";
            strUrl = "jdbc:postgresql://localhost:5432/Trabajo";
            strUsuario = "postgres";
            strPassword = "postgres";
        }

        this.driver = strDriver;
        this.url = strUrl;
        this.usuario = strUsuario;
        this.password = strPassword;
    }

    public Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            //System.out.println(ex.getMessage());
        }
        return cn;
    }

}
