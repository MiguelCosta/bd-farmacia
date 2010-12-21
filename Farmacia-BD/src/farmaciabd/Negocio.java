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

    /*
     * Fazer commit da Base de Dados
     */
    public static void commit() throws Exception {
        Model.stmt.executeQuery("commit");
    }


    /*
     * Faz o select de um produto recebendo um produto (codigo)
     */
    public static ResultSet selProduto(String sel) throws Exception {
        String sql = "SELECT * FROM produtos Where produto=";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery("SELECT * FROM produtos WHERE produto = '" + sel + "'");

        return rSet;
    }

    /*
     * Faz o select de um produto recebendo o nome_medicamento
     */
    public static ResultSet selProdutoNome(String sel) throws Exception {
        String sql = "SELECT * FROM produtos Where nome_medicamento=";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery("SELECT * FROM produtos WHERE nome_medicamento ='" + sel + "'");

        return rSet;
    }

    public static void abrirPDF(String sel) throws Exception {
        //C:/BD_Farmacia_docs/Sistema_Nervoso_Central.pdf
        Runtime.getRuntime().exec("cmd.exe /c start "+sel);
    }

}
