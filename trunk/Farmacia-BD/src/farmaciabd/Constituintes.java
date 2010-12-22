/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciabd;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class Constituintes extends Model {
    public static ResultSet queryProdutos() throws SQLException {
        return Model.stmt.executeQuery("SELECT * FROM constituintes");
    }
}
