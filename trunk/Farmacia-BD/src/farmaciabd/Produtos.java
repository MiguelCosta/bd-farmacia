/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmaciabd;

import java.sql.*;

/**
 * @author Grupo 10
 */
public class Produtos extends Ligacao{
    public static ResultSet queryProdutos () throws SQLException {
        return Ligacao.stmt.executeQuery("SELECT * FROM produtos");
    }
}