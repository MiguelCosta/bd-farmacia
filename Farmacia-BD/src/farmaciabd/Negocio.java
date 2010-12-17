/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmaciabd;

import java.sql.ResultSet;

/**
 *
 * @author Miguel
 */
public class Negocio {


    public static ResultSet selProduto (String sel) throws Exception{
        String sql = "SELECT * FROM produtos Where produto=";
        
        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery("SELECT * FROM produtos WHERE produto =" + sel);

        return rSet;
    }

}
