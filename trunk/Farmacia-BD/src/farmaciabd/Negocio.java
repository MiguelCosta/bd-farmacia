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
        String sql = "SELECT * FROM produtos Where produto='";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        return rSet;
    }

    /*
     * Faz o select de um produto recebendo o nome_medicamento
     */
    public static ResultSet selProdutoNome(String sel) throws Exception {
        String sql = "SELECT * FROM produtos WHERE nome_medicamento=";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery("SELECT * FROM produtos WHERE nome_medicamento ='" + sel + "'");

        return rSet;
    }

    /*
     * Abrir documentos pdf com a descrição da área terapeutica
     */
    public static void abrirPDF(String sel) throws Exception {
        //C:/BD_Farmacia_docs/Sistema_Nervoso_Central.pdf
        ResultSet rSet = null;
        String r = null;
        String sql = "SELECT * FROM areas_terapeuticas WHERE nome ='";

        rSet = Model.stmt.executeQuery(sql + sel + "'");
        System.out.println("resultado1: " + r);

        while (rSet.next()) {
            r = rSet.getString(3);
            //System.out.println("resultado: "+ r + rSet.getString(1));
        }
        Runtime.getRuntime().exec("cmd.exe /c start " + r);
    }

    public static String procuraAreaTerapeuticaPorID(String sel) throws Exception {
        String sql = "SELECT * FROM areas_terapeuticas WHERE areaterapeutica = '";
        ResultSet rSet = null;
        String r = null;

        if (sel.equalsIgnoreCase("<vazio>")) {
            return "<vazio>";
        }

        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(2);
            //System.out.println("resultado: " + r);
        }
        return r;
    }
}
