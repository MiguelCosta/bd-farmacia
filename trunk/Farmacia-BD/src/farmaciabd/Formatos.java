/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmaciabd;

import java.sql.*;

/**
 *
 * @author Grupo 10
 */
public class Formatos {

    public static ResultSet queryFormatos () throws SQLException{
        return Model.stmt.executeQuery("SELECT * FROM formatos");
    }

}
