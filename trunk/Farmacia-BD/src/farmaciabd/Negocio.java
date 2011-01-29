/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciabd;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    /****************************
     * Abrir folheto do produto *
     ****************************/
    public static void abrirFolhetoURL(String sel) throws Exception {
        //C:/BD_Farmacia_docs/Sistema_Nervoso_Central.pdf
        
        Runtime.getRuntime().exec("cmd.exe /c start " + sel);
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

    /**
     * Procura um constituinte, devolvendo o nome e recebendo o ID
     * @param sel String - codigo do constituinte
     * @return r String - nome do constituinte
     * @throws Exception
     */
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

    /**
     * Procura um constituinte, devolvendo o ID e recebendo o nome
     * @param sel String - nome do constituinte
     * @return r String - id do constituinte
     * @throws Exception
     */
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

    /**
     * Lista as faixas estarias devolvendo um ResultSet
     * @return rSet ResultSet
     * @throws Exception
     */
    public static ResultSet listarFaixasEtarias () throws Exception{
        ResultSet rSet = null;
        String sql = "SELECT nome FROM faixas_etarias";

        rSet = Model.stmt.executeQuery(sql);
        
        return rSet;

    }

    /**
     * Inserir um produto na base de dados
     * @param produto String - codigo do produto
     * @param nome_generico String
     * @param nome_medicamento Sttring
     * @param quantidade String
     * @param faixa_etaria String
     * @param reg_infarmed String
     * @param area_terapeutica String
     * @param lote String
     * @param dosagem String
     * @param temperatura String
     * @param preco String
     * @param administracao String
     * @param receita String
     * @param generico String
     * @param formato String
     * @param folheto_url String
     * @throws SQLException
     * @throws Exception
     */
    public static void insertProduto(String produto, String nome_generico, String nome_medicamento, String quantidade, String faixa_etaria, String reg_infarmed, String area_terapeutica, String lote, String dosagem, String temperatura, String preco, String administracao, String receita, String generico, String formato, String folheto_url) throws SQLException, Exception{

        String sql = "INSERT INTO produtos VALUES ("+produto+",'"+nome_generico+"','"+nome_medicamento+"','"+quantidade+"','"+faixa_etaria+"','"+reg_infarmed+"','"+area_terapeutica+"','"+lote+"','"+dosagem+"','"+temperatura+"','"+preco+"','"+administracao+"','"+receita+"','"+generico+"','"+formato+"','"+folheto_url+"')";

        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();   
    }

    /**
     * Inserir um constituinte e um produto na base de dados na tabela lista_constituintes
     * @param produto String - codigo do produto
     * @param constituinte String - codigo a inserir do novo constituinte
     * @throws SQLException
     * @throws Exception
     */
    public static void insertConstituinte(String produto, String constituinte) throws SQLException, Exception{
        String sql = "INSERT INTO lista_constituintes VALUES ("+produto+","+constituinte+")";
        System.out.println("Constituinte: "+constituinte);
        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
        
    }

    /**
     * Alterar o nome generico de um produto
     * @param produto String - codigo do produto
     * @param newNomeGenerico String - novo nome generico do medicamento
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarNomeGenerico(String produto, String newNomeGenerico) throws SQLException, Exception{
        String sql = "UPDATE produtos SET nome_generico = '"+newNomeGenerico+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar o nome do medicamento de um produto
     * @param produto String - codigo do produto
     * @param newNomeMedicamento String - novo nome do medicamento
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarNomeMedicamento(String produto, String newNomeMedicamento) throws SQLException, Exception{
        String sql = "UPDATE produtos SET nome_medicamento = '"+newNomeMedicamento+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar a quantidade de um produto
     * @param produto String - codigo do produto
     * @param newQuantidade int - nova quantidade
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarQuantidade(String produto, int newQuantidade) throws SQLException, Exception{
        String sql = "UPDATE produtos SET quantidade = '"+newQuantidade+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);
        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar o registo infarmed de um produto
     * @param produto String - codigo do produto
     * @param newRegistoInfarmed String - codigo do registo infarmed
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarRegistoInfarmed(String produto, String newRegistoInfarmed) throws SQLException, Exception{
        String sql = "UPDATE produtos SET reg_infarmed = '"+newRegistoInfarmed+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar a faixa etaria de um produto
     * @param produto String - codigo do produto
     * @param newFaixaEtaria String - codigo faixa etaria
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarFaixaEtaria(String produto, String newFaixaEtaria) throws SQLException, Exception{
        newFaixaEtaria = procurarFaixaEtariaPorNome(newFaixaEtaria);
        String sql = "UPDATE produtos SET faixa_etaria = '"+newFaixaEtaria+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar a area terapeutica de um produto
     * @param produto String - codigo do produto
     * @param newAreaTerapeutica String codigo da areaTerapeutica
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarAreaTerapeutica(String produto, String newAreaTerapeutica) throws SQLException, Exception{
        newAreaTerapeutica = procuraAreaTerapeuticaPorNOME(newAreaTerapeutica);
        String sql = "UPDATE produtos SET area_terapeutica = '"+newAreaTerapeutica+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar a dosagem de um produto
     * @param produto String - codigo do produto
     * @param newDosagem String - texto com a dosagem
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarDosagem(String produto, String newDosagem) throws SQLException, Exception{
        String sql = "UPDATE produtos SET dosagem = '"+newDosagem+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);
 
        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar a temperatura de um produto
     * @param produto String - codigo do produto
     * @param newTemperatura String - codigo da temperatura
     * @return void
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarTemperatua(String produto, String newTemperatura) throws SQLException, Exception{
        newTemperatura = procurarTemperaturaPorNome(newTemperatura);
        String sql = "UPDATE produtos SET temperatura = '"+newTemperatura+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar a administracao de um produto
     * @param produto String - codigo do produto
     * @param newAdministracao String - codigo do novo constituinte
     * @return void
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarAdministracao(String produto, String newAdministracao) throws SQLException, Exception{
        newAdministracao = procuraAdministracaoPorNOME(newAdministracao);
        String sql = "UPDATE produtos SET administracao = '"+newAdministracao+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar a receita de um produto
     * @param produto String - codigo do produto
     * @param newReceita int - 1 ou 0, caso precise de receita ou nao respectivamente
     * @return void
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarReceita(String produto, int newReceita) throws SQLException, Exception{
        String sql = "UPDATE produtos SET receita = '"+newReceita+"' WHERE produto = '"+produto+"'";
        //System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar o generico de um produto
     * @param produto String - codigo do produto
     * @param newGenerico int - 1 ou 0 caso seja generico ou nao resepctivamente
     * @return void
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarGenerico(String produto, int newGenerico) throws SQLException, Exception{
        String sql = "UPDATE produtos SET generico = '"+newGenerico+"' WHERE produto = '"+produto+"'";

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar o formato de um produto
     * @param produto String - codigo do produto
     * @param newFormato String - codigo do novo formato
     * @return void
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarFormato(String produto, String newFormato) throws SQLException, Exception{
        newFormato = procurarFormatoPorNome(newFormato);
        String sql = "UPDATE produtos SET formato = '"+newFormato+"' WHERE produto = '"+produto+"'";

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar o url de um produto recebendo o ID de um produto e a string url
     * @param produto String - codigo do produto
     * @param newURL String - novo url
     * @return void
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarURL(String produto, String newURL) throws SQLException, Exception{
        String sql = "UPDATE produtos SET folheto_url = '"+newURL+"' WHERE produto = '"+produto+"'";

        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Alterar o constituinte de um produto recebendo o ID de um produto e o nome do constituinte
     * @param produto String - codigo do produto
     * @param newConstituinte String - codigo do novo constituinte
     * @return void
     * @throws SQLException
     * @throws Exception
     */
    public static void alterarConstituinte(String produto, String newConstituinte) throws SQLException, Exception{
        newConstituinte = procurarConstituintesPorNome(newConstituinte);
        String sql = "INSERT INTO lista_constituintes VALUES ('"+produto+"','"+newConstituinte+"')";
        System.out.println(sql);
        Model.stmt.executeQuery(sql);
        commit2();
    }

    /**
     * Remove os constituintes de um produto
     * @param produto String - codigo do produto
     * @return void
     * @throws SQLException
     * @throws Exception
     */
    public static void removerConstitintes(String produto) throws SQLException, Exception{
        String sql = "DELETE FROM lista_constituintes WHERE produto = "+produto;
        Model.stmt.executeQuery(sql);
        commit2();
    }

    public static void registarStock (String sel, int stock_antigo, int stock_novo) throws SQLException, Exception{
        String sql_registar     = "INSERT INTO registo_stocks VALUES ('"+sel+"','"+stock_antigo+"','"+stock_novo+"',sysdate)";
        String sql_actualizar   = "UPDATE produtos SET quantidade = '"+stock_novo+"' WHERE produto = '"+sel+"'";

        Model.stmt.executeQuery(sql_registar);
        Model.stmt.executeQuery(sql_actualizar);
        commit2();

    }

    public static int proxNumeroVenda() throws SQLException{
        String sql      = "SELECT numero FROM vendas";
        int proxNum     = 1;
        int aux         = 0;
        ResultSet rSet  = null;

        rSet = Model.stmt.executeQuery(sql);
        while (rSet.next()){
            aux = Integer.parseInt(rSet.getObject(1).toString());
            if (aux > proxNum)
                proxNum = aux;
        }
        proxNum++;
        return proxNum;
    }

    public static float montanteMedicamento(String produto) throws SQLException{
        float montante  = 0;
        String mont     = "";
        String sql      = "SELECT * FROM produtos WHERE produto = '"+produto+"'";
        ResultSet rSet  = null;
        rSet = Model.stmt.executeQuery(sql);
        while(rSet.next()){
            mont = rSet.getObject(11).toString();
        }
        montante = Float.parseFloat(mont);
        

        return montante;
    }

    public static void registarVenda (String produto, String nome_cliente, String numeroVenda) throws SQLException, Exception{
        float montante      = montanteMedicamento(produto);
        String sql          = "INSERT INTO vendas VALUES ('"+produto+"','"+nome_cliente+"','"+numeroVenda+"','"+montante+"',sysdate)";
        Model.stmt.executeQuery(sql);
        commit2();

    }

    public static ResultSet procurarProdutos (String procura) throws SQLException{
        ResultSet rSet  = null;
        String sql      = "SELECT * FROM produtos WHERE produto LIKE '%"+procura+"%'";
        sql             = sql + " OR nome_medicamento LIKE '%"+procura+"%'";
        
        rSet = Model.stmt.executeQuery(sql);

        return rSet;

    }

    public static ResultSet topProdMais () throws SQLException {

        ResultSet rSet = null;
        String sql = "SELECT * FROM (SELECT produto, count(*) as refs FROM (SELECT PRODUTO FROM VENDAS) GROUP BY PRODUTO ORDER BY refs DESC) WHERE ROWNUM <=10";
        rSet = Model.stmt.executeQuery(sql);
        return rSet;
    }

    public static ResultSet topProdMenos () throws SQLException {

        ResultSet rSet = null;
        String sql = "SELECT * FROM (SELECT produto, count(*) as refs FROM (SELECT PRODUTO FROM VENDAS) GROUP BY PRODUTO ORDER BY refs ASC) WHERE ROWNUM <=10";
        rSet = Model.stmt.executeQuery(sql);
        return rSet;
    }

    public static ResultSet topVendasMais () throws SQLException {

        ResultSet rSet = null;
        String sql = "SELECT * FROM (SELECT NUMERO, SUM(TO_NUMBER(MONTANTE_TOTAL))as montante FROM VENDAS GROUP BY NUMERO ORDER BY montante DESC) WHERE ROWNUM <=10";
        rSet = Model.stmt.executeQuery(sql);
        return rSet;
    }

    public static ResultSet lisCli () throws SQLException {

        ResultSet rSet = null;
        String sql = "SELECT * FROM CLIENTES";
        rSet = Model.stmt.executeQuery(sql);
        return rSet;
    }



    public static ResultSet topVendasMenos () throws SQLException {

        ResultSet rSet = null;
        String sql = "SELECT * FROM (SELECT NUMERO, SUM(TO_NUMBER(MONTANTE_TOTAL))as montante FROM VENDAS GROUP BY NUMERO ORDER BY montante ASC) WHERE ROWNUM <=10";
        rSet = Model.stmt.executeQuery(sql);
        return rSet;
    }
    

}


