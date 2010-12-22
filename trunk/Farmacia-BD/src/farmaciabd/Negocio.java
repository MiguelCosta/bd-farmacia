/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciabd;

import java.sql.ResultSet;
import javax.swing.DefaultListModel;

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
     * Faz o select de um produto recebendo um produto (codigo) e devolve uma linha da tabela
     */
    public static ResultSet selProduto(String sel) throws Exception {
        String sql = "SELECT * FROM produtos Where produto='";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        return rSet;
    }

    /*
     * Faz o select de um produto recebendo o nome_medicamento e devolve uma linha da tabela
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

    /*
     * Procura pelo ID a AreaTerapeutica de um produto e devolve o nome
     */
    public static String procuraAreaTerapeuticaPorID(String sel) throws Exception {
        String sql = "SELECT * FROM areas_terapeuticas WHERE areaterapeutica = '";
        ResultSet rSet = null;
        String r = null;
        /*
        if (sel.equalsIgnoreCase("<vazio>")) {
        return "<vazio>";
        }
         */
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(2);
            //System.out.println("resultado: " + r);
        }
        return r;
    }

    /*
     * Procura pelo nome a AreaTerapeutica de um produto e devolve o ID
     */
    public static String procuraAreaTerapeuticaPorNOME(String sel) throws Exception {
        String sql = "SELECT * FROM areas_terapeuticas WHERE nome = '";
        ResultSet rSet = null;
        String r = null;
        /*
        if (sel.equalsIgnoreCase("<vazio>")) {
        return "<vazio>";
        }
         */
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(1);
            //System.out.println("resultado: " + r);
        }
        return r;
    }

    /*
     * Procura pelo ID a Administracao de um produto e devolve o nome
     */
    public static String procuraAdministracaoPorID(String sel) throws Exception {
        String sql = "SELECT * FROM administracoes WHERE administracao = '";
        ResultSet rSet = null;
        String r = null;

        //if (sel.equalsIgnoreCase("<vazio>")) return "0";

        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(2);
            //System.out.println("resultado: " + r);
        }
        return r;
    }

    /*
     * Procura pelo nome a Administracao de um produto e devolve o id
     */
    public static String procuraAdministracaoPorNOME(String sel) throws Exception {
        String sql = "SELECT * FROM administracoes WHERE nome = '";
        ResultSet rSet = null;
        String r = null;

        //if (sel.equalsIgnoreCase("<vazio>")) return "0";
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(1);
            //System.out.println("resultado: " + r);
        }
        return r;
    }

    public static String procurarTemperaturaPorID(String sel) throws Exception {
        String sql = "SELECT * FROM temperaturas WHERE temperatura = '";
        ResultSet rSet = null;
        String r = null;

        //if (sel.equalsIgnoreCase("<vazio>")) return "0";
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(2);
            //System.out.println("resultado: " + r);
        }
        return r;
    }


    /*
     * Procura pelo id o Formato de um produto e devolve o nome
     */
    public static String procurarFormatoPorID(String sel) throws Exception {
        String sql = "SELECT * FROM formatos WHERE formato = '";
        ResultSet rSet = null;
        String r = null;

        //if (sel.equalsIgnoreCase("<vazio>")) return "0";
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(2);
            //System.out.println("resultado: " + r);
        }
        return r;
    }

    /*
     * Procura pelo id o Formato de um produto e devolve o nome
     */
    public static String procurarFaixaEtariaPorID(String sel) throws Exception {
        String sql = "SELECT * FROM faixas_etarias WHERE faixa_etaria = '";
        ResultSet rSet = null;
        String r = null;

        //if (sel.equalsIgnoreCase("<vazio>")) return "0";
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(2);
            //System.out.println("resultado: " + r);
        }
        return r;
    }

    /*
     * Recebe um produto e vai listar todos os constituintes dele, dando o nome e não o ID
     */
    public static ResultSet procurarListaConstituintes(String sel) throws Exception {
        ResultSet rSet = null;
        String sql = "SELECT constituintes.nome FROM lista_constituintes, constituintes, produtos WHERE lista_constituintes.produto = produtos.produto AND constituintes.constituinte = lista_constituintes.constituinte AND produtos.produto = '";

        rSet = Model.stmt.executeQuery(sql + sel + "'");



        return rSet;
    }

    public static String procurarConstituintes(String sel) throws Exception {
        ResultSet rSet = null;
        String sql = "SELECT * FROM constituintes WHERE constituinte = '";
        String r = null;

        rSet = Model.stmt.executeQuery(sql + sel + "'");


        rSet = Produtos.queryProdutos();
        DefaultListModel model = new DefaultListModel();
        while (rSet.next()) {
            model.addElement(rSet.getObject(1).toString());
        }

        
        while (rSet.next()) {
            r = rSet.getString(2);
        }

        return r;

    }
}
