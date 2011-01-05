/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmaciabd;

/**
 *
 * @author Miguel
 */
public class MensagensAjuda {

    public static String ajudaProcura(){
        String msg = "Insira neste campo o produto que deseja procurar\nTerá de inserir conforme o que está seleccionado (Codigo Produto ou Nome de Produto)";
        return msg;
    }

    public static String ajudaGeral(){
        String autor1 = "Miguel Pinto da Costa";
        String autor2 = "Ana Isabel";
        String autor3 = "Catarina Campos";
        String autor4 = "Hugo Frade";
        String msg = "Software criado para gerir medicamentos de uma farmácia\n\nCriado por:\nMiguel\nIsa\nCajanelas\nHugo";
        return msg;
    }

    public static String ajudaFichaMedicamentos(){
        String msg  = "Aqui pode ver os detalhes de todos os produtos e,";
        msg         = msg + "utilizando os respectivos butões, adicionar e/ou";
        msg         = msg + "alterar produtos.";

        return msg;
    }

    public static String ajudaGestaoStocks(){
        String msg  = "Aqui pode gerir o stock da farmacia,";
        msg         = msg + "adicionando ou removendo `quantidades existentes";

        return msg;
    }

}
