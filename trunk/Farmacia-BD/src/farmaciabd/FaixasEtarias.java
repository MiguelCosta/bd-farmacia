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
public class FaixasEtarias extends Model{
    public static ResultSet queryFaixasEtarias () throws SQLException {
        return Model.stmt.executeQuery("SELECT nome FROM faixas_etarias");
    }

}
