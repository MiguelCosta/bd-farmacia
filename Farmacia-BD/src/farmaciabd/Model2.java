/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmaciabd;

import java.sql.*;
import java.util.Observable;

/**
 *
 * @author Miguel
 */
public class Model2 extends Observable {
    public static Statement stmt;

    public static void connect () throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MIGUEL", "433433");
        conn.setAutoCommit(false);
        stmt = conn.createStatement();
    }

    public static void disconnect() throws SQLException {
        stmt.close();
    }
/*
    public static String arrayToString(char[] a) {
        if (a == null) return null;

        StringBuilder result = new StringBuilder();
        if (a.length > 0) {
            result.append(a[0]);
            for (int i=1; i < a.length; i++)
                result.append(a[i]);
        }
        return result.toString();
    }
 * 
 */


}
