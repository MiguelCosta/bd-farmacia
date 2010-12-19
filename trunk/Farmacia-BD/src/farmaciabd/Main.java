/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciabd;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import oracle.jdbc.pool.OracleDataSource;

/**
 * @author grupo 10
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Model.connect();
        JPrincipal jPrincipal = new JPrincipal();
        JPrincipal.main(args);

        /*
        Connection con;
        String url;
        String user;
        String password;

        url = "jdbc:oracle:thin:@localhost";
        user = "MIGUEL";
        password = "433433";

        try {
            OracleDataSource ds = new OracleDataSource();
            ds.setURL(url);
            ds.getConnection(user, password);

            con = ds.getConnection(user, password);

            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT formato,nome FROM FORMATOS");

            System.out.println("Exibindo os registrosn\nFORMATO\tNOME");
            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getObject(1).toString() + "\t"
                        + rs.getObject(2).toString());
            }
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro" + e.getMessage());
            System.exit(0);
        }
         * */
    }
}
