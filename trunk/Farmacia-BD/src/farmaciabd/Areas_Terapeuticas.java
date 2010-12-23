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
public class Areas_Terapeuticas extends Model {

    public static ResultSet queryAreasTerapeuticas () throws SQLException {
        return Model.stmt.executeQuery("SELECT nome FROM areas_terapeuticas");
    }

}
