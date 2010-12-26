/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciabd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Miguel
 */
public class Negocio {

    

    /*********************************
     * Fazer commit da Base de Dados *
     *********************************/
    public static void commit2() throws Exception {
        Model.stmt.executeQuery("commit");
    }

    /******************************************************************************************
     * Faz o select de um produto recebendo um produto (codigo) e devolve uma linha da tabela *
     ******************************************************************************************/
    public static ResultSet selProduto(String sel) throws Exception {
        String sql = "SELECT * FROM produtos Where produto='";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        return rSet;
    }

    /***************************************************
     * Verifica se um produto já existe recebendo o ID *
     ***************************************************/
    public static boolean verificarProdutoExiste(String produto) throws Exception{
        String sql = "SELECT * FROM produtos WHERE produto ='";
        Boolean r = false;
        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + produto + "'");
        
        while(rSet.next()){
            r = produto.equalsIgnoreCase(rSet.getString(1));
        }
        return r;
    }

     /***************************************************
     * Verifica se um produto já existe recebendo o ID *
     ***************************************************/
    public static boolean verificarRegInfarmedExiste(String reg_infarmed) throws Exception{
        String sql = "SELECT * FROM produtos WHERE reg_infarmed ='";
        Boolean r = false;
        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + reg_infarmed + "'");

        while(rSet.next()){
            r = reg_infarmed.equalsIgnoreCase(rSet.getString(6));
            System.out.println("Resul: "+r);
        }
        return r;
    }

    /*****************************************************************************************
     * Faz o select de um produto recebendo o nome_medicamento e devolve uma linha da tabela *
     *****************************************************************************************/
    public static ResultSet selProdutoNome(String sel) throws Exception {
        String sql = "SELECT * FROM produtos WHERE nome_medicamento=";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery("SELECT * FROM produtos WHERE nome_medicamento ='" + sel + "'");

        return rSet;
    }

    /************************************************************
     * Abrir documentos pdf com a descrição da área terapeutica *
     ************************************************************/
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

    /********************************************************************
     * Procura pelo ID a AreaTerapeutica de um produto e devolve o nome *
     ********************************************************************/
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

    /********************************************************************
     * Procura pelo nome a AreaTerapeutica de um produto e devolve o ID *
     ********************************************************************/
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

    /******************************************************************
     * Procura pelo ID a Administracao de um produto e devolve o nome *
     ******************************************************************/
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

    /******************************************************************
     * Procura pelo nome a Administracao de um produto e devolve o id *
     ******************************************************************/
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

    /***************************************************
     * Procura pelo ID da temperatura e devolve o nome *
     ***************************************************/
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

    /***************************************************
     * Procura pelo nome da temperatura e devolve o ID *
     ***************************************************/
    public static String procurarTemperaturaPorNome(String sel) throws Exception {
        String sql = "SELECT * FROM temperaturas WHERE nome = '";
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
    
    /************************************************************
     * Procura pelo id o Formato de um produto e devolve o nome *
     ************************************************************/
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

    /************************************************************
     * Procura pelo nome o Formato de um produto e devolve o id *
     ************************************************************/
    public static String procurarFormatoPorNome(String sel) throws Exception {
        String sql = "SELECT * FROM formatos WHERE nome = '";
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

    /*****************************************************************
     * Procura pelo id a faixa etaria de um produto e devolve o nome *
     *****************************************************************/
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

    /*****************************************************************
     * Procura pelo nome a faixa etaria de um produto e devolve o id *
     *****************************************************************/
    public static String procurarFaixaEtariaPorNome(String sel) throws Exception {
        String sql = "SELECT faixa_etaria FROM faixas_etarias WHERE nome = '";
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

    /***************************************************************************************
     * Recebe um produto e vai listar todos os constituintes dele, dando o nome e não o ID *
     ***************************************************************************************/
    public static ResultSet procurarListaConstituintes(String sel) throws Exception {
        ResultSet rSet = null;
        String sql = "SELECT constituintes.nome FROM lista_constituintes, constituintes, produtos WHERE lista_constituintes.produto = produtos.produto AND constituintes.constituinte = lista_constituintes.constituinte AND produtos.produto = '";

        rSet = Model.stmt.executeQuery(sql + sel + "'");



        return rSet;
    }

    /***************************************************************
     * Procura um constituinte, devolvendo o nome e recebendo o ID *
     ***************************************************************/
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

    /***************************************************************
     * Procura um constituinte, devolvendo o ID e recebendo o nome *
     ***************************************************************/
    public static String procurarConstituintesPorNome(String sel) throws Exception {
        ResultSet rSet = null;
        String sql = "SELECT * FROM constituintes WHERE nome = '";
        String r = null;

        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while (rSet.next()) {
            r = rSet.getString(1);
            System.out.println("Constituinte: " + r);
        }

        return r;
    }

    /****************************************************
     * Lista as faixas estarias devolvendo um ResultSet *
     ****************************************************/
    public static ResultSet listarFaixasEtarias () throws Exception{
        ResultSet rSet = null;
        String sql = "SELECT nome FROM faixas_etarias";

        rSet = Model.stmt.executeQuery(sql);
        
        return rSet;

    }

    /***************************************
     * Inserir um produto na base de dados *
     ***************************************/
    public static void insertProduto(String produto, String nome_generico, String nome_medicamento, String quantidade, String faixa_etaria, String reg_infarmed, String area_terapeutica, String lote, String dosagem, String temperatura, String preco, String administracao, String receita, String generico, String formato, String folheto_url) throws SQLException, Exception{

        String sql = "INSERT INTO produtos VALUES ("+produto+",'"+nome_generico+"','"+nome_medicamento+"','"+quantidade+"','"+faixa_etaria+"','"+reg_infarmed+"','"+area_terapeutica+"','"+lote+"','"+dosagem+"','"+temperatura+"','"+preco+"','"+administracao+"','"+receita+"','"+generico+"','"+formato+"','"+folheto_url+"')";

        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();   
    }

    /***************************************************************************************
     * Inserir um constituinte e um produto na base de dados na tabela lista_constituintes *
     ***************************************************************************************/
    public static void insertConstituinte(String produto, String constituinte) throws SQLException, Exception{
        String sql = "INSERT INTO lista_constituintes VALUES ("+produto+","+constituinte+")";
        System.out.println("Constituinte: "+constituinte);
        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
        
    }

    /*****************************************
     * Alterar o nome generico de um produto *
     *****************************************/
    public static void alterarNomeGenerico(String produto, String newNomeGenerico) throws SQLException, Exception{
        String sql = "UPDATE produtos SET nome_generico = '"+newNomeGenerico+"' WHERE produto = '"+produto+"'";
        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /***********************************************
     * Alterar o nome do medicamento de um produto *
     ***********************************************/
    public static void alterarNomeMedicamento(String produto, String newNomeMedicamento) throws SQLException, Exception{
        String sql = "UPDATE produtos SET nome_medicamento = '"+newNomeMedicamento+"' WHERE produto = '"+produto+"'";
        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**************************************
     * Alterar a quantidade de um produto *
     **************************************/
    public static void alterarQuantidade(String produto, int newQuantidade) throws SQLException, Exception{
        String sql = "UPDATE produtos SET quantidade = '"+newQuantidade+"' WHERE produto = '"+produto+"'";
        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /********************************************
     * Alterar o registo infarmed de um produto *
     *******************************************/
    public static void alterarRegistoInfarmed(String produto, String newRegistoInfarmed) throws SQLException, Exception{
        String sql = "UPDATE produtos SET quantidade = '"+newRegistoInfarmed+"' WHERE produto = '"+produto+"'";
        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }


    }


