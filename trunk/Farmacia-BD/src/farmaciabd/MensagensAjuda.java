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
}
