/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogAlterProduto.java
 *
 * Created on 24/Dez/2010, 15:03:08
 */

package farmaciabd;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Miguel
 */
public class JDialogAlterProduto extends java.awt.Dialog {
    ResultSet rSet = null;
    String prod = null;

    /** Creates new form JDialogAlterProduto */
    public JDialogAlterProduto(java.awt.Frame parent,String codProduto, boolean modal) throws SQLException, Exception {
        super(parent, modal);
        initComponents();
        centerOnScreen(this);
        jTextFieldCodProdutoIns.setEnabled(false);


        String sel              = codProduto;
        String produto          = null;
        String areaTerapeutica  = null;
        String administracao    = null;
        String temperatura      = null;
        String formato          = null;
        String faixa_etaria     = null;
        String folheto_url      = null;
        String quantidade       = null;
        String receita          = null;
        String generico         = null;
        
                rSet = Negocio.selProduto(sel);     // procura por id


            /***************************************************************
             * Colocar os campos da tabela produtos nos campos respectivos *
             ***************************************************************/
            while (rSet.next()) {
                produto = vazio(rSet.getString(1));
                jTextFieldNomeGenIns.setText(vazio(rSet.getString(2)));
                jTextFieldNomeDoMedicamentoIns.setText(vazio(rSet.getString(3)));
                jSpinnerQuantidadeIns.setValue(Integer.valueOf(rSet.getString(4)));
                faixa_etaria = vazio(rSet.getString(5));
                jTextFieldRegistoInfarmedIns.setText(vazio(rSet.getString(6)));
                areaTerapeutica = vazio(rSet.getString(7)); //devolde o id
                jTextFieldLoteIns.setText(vazio(rSet.getString(8)));
                jTextFieldDosagemIns.setText(vazio(rSet.getString(9)));
                temperatura = vazio(rSet.getString(10));
                jTextFieldPrecoIns.setText(vazio(rSet.getString(11)));
                administracao = vazio(rSet.getString(12)); // devolve o id
                receita = (sim_nao(vazio(rSet.getString(13))));
                generico = (sim_nao(vazio(rSet.getString(14))));
                formato = vazio(rSet.getString(15));
                jTextFieldFolhetoURLIns.setText(vazio(rSet.getString(16)));
            }
            
            jTextFieldCodProdutoIns.setText(produto);
            jComboBoxAdministracaoIns.setSelectedIndex(Integer.parseInt(administracao));
            jComboBoxAreaTerapeuticaIns.setSelectedIndex(Integer.parseInt(areaTerapeutica));
            jComboBoxTemperaturaIns.setSelectedIndex(Integer.parseInt(temperatura));
            jComboBoxFormatoIns.setSelectedIndex(Integer.parseInt(formato)-1);
            jComboBoxFaixaEtaria.setSelectedIndex(Integer.parseInt(faixa_etaria));

            
            if (receita.equalsIgnoreCase("Sim")) jRadioButtonReceitaSimIns.setSelected(true);
            if (receita.equalsIgnoreCase("Não")) jRadioButtonReceitaNaoIns.setSelected(true);
            if (generico.equalsIgnoreCase("Sim")) jRadioButtonGenericoSim.setSelected(true);
            if (generico.equalsIgnoreCase("Não")) jRadioButtonGenericoNao.setSelected(true);

            /*****************
             * Constituintes *
             *****************/
            
            ResultSet rSetConstituintes = null;

            rSetConstituintes = Negocio.procurarListaConstituintes(sel);

            //System.out.println(produto);
            DefaultListModel modelConstituintes = new DefaultListModel();
            while (rSetConstituintes.next()) {
                modelConstituintes.addElement(rSetConstituintes.getString(1));

            }

           int tamanhoListaConstituintes = modelConstituintes.getSize();
           System.out.println("Tamanho dalista de constituintes: "+tamanhoListaConstituintes);
           
           //constituinte1
           if (tamanhoListaConstituintes>=1){
                String constituinte1_string = modelConstituintes.get(0).toString();
                int constituinte1_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte1_string));
                if (constituinte1_int != 1) jComboBoxConstituintes1.setSelectedIndex(constituinte1_int-1);
           }
           
           //constituinte2
           if (tamanhoListaConstituintes>=2){
                String constituinte2_string = modelConstituintes.get(1).toString();
                int constituinte2_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte2_string));
                if (constituinte2_int != 1) jComboBoxConstituintes2.setSelectedIndex(constituinte2_int-1);
            }

           //constituinte3
           if (tamanhoListaConstituintes>=3){
                String constituinte3_string = modelConstituintes.get(2).toString();
                int constituinte3_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte3_string));
                if (constituinte3_int != 1) jComboBoxConstituintes3.setSelectedIndex(constituinte3_int-1);
            }

           //constituinte4
           if (tamanhoListaConstituintes>=4){
                String constituinte4_string = modelConstituintes.get(3).toString();
                int constituinte4_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte4_string));
                if (constituinte4_int != 1) jComboBoxConstituintes4.setSelectedIndex(constituinte4_int-1);
           }
           
           //constituinte5
           if (tamanhoListaConstituintes>=5){
                String constituinte5_string = modelConstituintes.get(4).toString();
                int constituinte5_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte5_string));
                if (constituinte5_int != 1) jComboBoxConstituintes5.setSelectedIndex(constituinte5_int-1);
           }

           //constituinte6
           if (tamanhoListaConstituintes>=6){
                String constituinte6_string = modelConstituintes.get(5).toString();
                int constituinte6_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte6_string));
                if (constituinte6_int != 1) jComboBoxConstituintes6.setSelectedIndex(constituinte6_int-1);
           }
           
           //constituinte7
           if (tamanhoListaConstituintes>=7){
                String constituinte7_string = modelConstituintes.get(6).toString();
                int constituinte7_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte7_string));
                if (constituinte7_int != 1) jComboBoxConstituintes7.setSelectedIndex(constituinte7_int-1);
           }

           //constituinte8
           if (tamanhoListaConstituintes>=8){
                String constituinte8_string = modelConstituintes.get(7).toString();
                int constituinte8_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte8_string));
                if (constituinte8_int != 1) jComboBoxConstituintes8.setSelectedIndex(constituinte8_int-1);
           }
           
           //constituinte9
           if (tamanhoListaConstituintes>=9){
                String constituinte9_string = modelConstituintes.get(8).toString();
                int constituinte9_int = Integer.parseInt(Negocio.procurarConstituintesPorNome(constituinte9_string));
                if (constituinte9_int != 1) jComboBoxConstituintes9.setSelectedIndex(constituinte9_int-1);
           }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelinserirProduto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxConstituintes1 = new javax.swing.JComboBox();
        jComboBoxConstituintes2 = new javax.swing.JComboBox();
        jComboBoxConstituintes3 = new javax.swing.JComboBox();
        jComboBoxConstituintes4 = new javax.swing.JComboBox();
        jComboBoxConstituintes5 = new javax.swing.JComboBox();
        jComboBoxConstituintes6 = new javax.swing.JComboBox();
        jComboBoxConstituintes7 = new javax.swing.JComboBox();
        jComboBoxConstituintes8 = new javax.swing.JComboBox();
        jComboBoxConstituintes9 = new javax.swing.JComboBox();
        jPanelLote = new javax.swing.JPanel();
        jLabelCodProdutoIns = new javax.swing.JLabel();
        jTextFieldCodProdutoIns = new javax.swing.JTextField();
        jLabelNomeGenIns = new javax.swing.JLabel();
        jTextFieldNomeGenIns = new javax.swing.JTextField();
        jLabelNomeMedicamentoIns = new javax.swing.JLabel();
        jTextFieldNomeDoMedicamentoIns = new javax.swing.JTextField();
        jLabelQuantidadeIns = new javax.swing.JLabel();
        jLabelFaixaEtariaIns = new javax.swing.JLabel();
        jLabelRegistoInfarmedIns = new javax.swing.JLabel();
        jLabelAreaTerapeuticaIns = new javax.swing.JLabel();
        jComboBoxAreaTerapeuticaIns = new javax.swing.JComboBox();
        jLabelLoteIns = new javax.swing.JLabel();
        jTextFieldLoteIns = new javax.swing.JTextField();
        jLabelDosagemIns = new javax.swing.JLabel();
        jTextFieldDosagemIns = new javax.swing.JTextField();
        jLabelTemperaturaIns = new javax.swing.JLabel();
        jComboBoxTemperaturaIns = new javax.swing.JComboBox();
        jLabelPrecoIns = new javax.swing.JLabel();
        jTextFieldPrecoIns = new javax.swing.JTextField();
        jLabelAdministracao = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldRegistoInfarmedIns = new javax.swing.JTextField();
        jComboBoxFaixaEtaria = new javax.swing.JComboBox();
        jComboBoxAdministracaoIns = new javax.swing.JComboBox();
        jSpinnerQuantidadeIns = new javax.swing.JSpinner();
        jRadioButtonReceitaSimIns = new javax.swing.JRadioButton();
        jRadioButtonReceitaNaoIns = new javax.swing.JRadioButton();
        jRadioButtonGenericoSim = new javax.swing.JRadioButton();
        jRadioButtonGenericoNao = new javax.swing.JRadioButton();
        jComboBoxFormatoIns = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldFolhetoURLIns = new javax.swing.JTextField();
        jButtonLimparCamposInsertproduto = new javax.swing.JButton();
        jButtonAdicionarProduto = new javax.swing.JButton();
        jButtonCancelarIns = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanelinserirProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALTERAR PRODUTO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Constituintes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes1.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes2.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes3.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes4.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes5.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes6.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes7.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes8.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Constituintes.queryConstituintes(); 

            while (rSet.next())         
            jComboBoxConstituintes9.addItem(rSet.getString(2));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBoxConstituintes1, 0, 292, Short.MAX_VALUE)
            .addComponent(jComboBoxConstituintes2, 0, 292, Short.MAX_VALUE)
            .addComponent(jComboBoxConstituintes3, 0, 292, Short.MAX_VALUE)
            .addComponent(jComboBoxConstituintes4, 0, 292, Short.MAX_VALUE)
            .addComponent(jComboBoxConstituintes5, 0, 292, Short.MAX_VALUE)
            .addComponent(jComboBoxConstituintes6, 0, 292, Short.MAX_VALUE)
            .addComponent(jComboBoxConstituintes7, 0, 292, Short.MAX_VALUE)
            .addComponent(jComboBoxConstituintes8, 0, 292, Short.MAX_VALUE)
            .addComponent(jComboBoxConstituintes9, 0, 292, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBoxConstituintes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConstituintes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConstituintes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConstituintes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConstituintes5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConstituintes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConstituintes7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConstituintes8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConstituintes9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelLote.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ficha do Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabelCodProdutoIns.setText("Código do Produto");

        jLabelNomeGenIns.setText("Nome Genérico");

        jLabelNomeMedicamentoIns.setText("Nome do Medicamento");

        jLabelQuantidadeIns.setText("Quantidade");

        jLabelFaixaEtariaIns.setText("Faixa Etaria");

        jLabelRegistoInfarmedIns.setText("Registo Infarmed");

        jLabelAreaTerapeuticaIns.setText("Área Terapeutica");

        try {     
            rSet = Areas_Terapeuticas.queryAreasTerapeuticas(); 

            //DefaultListModel model = new DefaultListModel();     

            while (rSet.next())         
            jComboBoxAreaTerapeuticaIns.addItem(rSet.getString(1));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        jLabelLoteIns.setText("Lote");

        jLabelDosagemIns.setText("Dosagem");

        jLabelTemperaturaIns.setText("Temperatura");

        try {     
            rSet = Temperaturas.queryTemperaturas(); 

            while (rSet.next())         
            jComboBoxTemperaturaIns.addItem(rSet.getString(1));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        jLabelPrecoIns.setText("Preço (€)");

        jLabelAdministracao.setText("Administração");

        jLabel13.setText("Precisa de Receita?");

        jLabel14.setText("É Genérico?");

        jLabel15.setText("Formato");

        try {     
            rSet = FaixasEtarias.queryFaixasEtarias(); 

            //DefaultListModel model = new DefaultListModel();     

            while (rSet.next())         
            jComboBoxFaixaEtaria.addItem(rSet.getString(1));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        try {     
            rSet = Administracoes.queryAdministracoes(); 

            while (rSet.next())         
            jComboBoxAdministracaoIns.addItem(rSet.getString(1));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        jRadioButtonReceitaSimIns.setText("Sim");
        jRadioButtonReceitaSimIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonReceitaSimInsActionPerformed(evt);
            }
        });

        jRadioButtonReceitaNaoIns.setText("Não");
        jRadioButtonReceitaNaoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonReceitaNaoInsActionPerformed(evt);
            }
        });

        jRadioButtonGenericoSim.setText("Sim");
        jRadioButtonGenericoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGenericoSimActionPerformed(evt);
            }
        });

        jRadioButtonGenericoNao.setText("Não");
        jRadioButtonGenericoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGenericoNaoActionPerformed(evt);
            }
        });

        try {     
            rSet = Formatos.queryFormatos(); 

            while (rSet.next())         
            jComboBoxFormatoIns.addItem(rSet.getString(1));     
        }

        catch (SQLException ex) { 
            Logger.getLogger(JPrincipal.class.getName()).log(Level.SEVERE, null, ex); 
        }

        javax.swing.GroupLayout jPanelLoteLayout = new javax.swing.GroupLayout(jPanelLote);
        jPanelLote.setLayout(jPanelLoteLayout);
        jPanelLoteLayout.setHorizontalGroup(
            jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoteLayout.createSequentialGroup()
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNomeMedicamentoIns)
                    .addComponent(jLabelCodProdutoIns)
                    .addComponent(jLabelNomeGenIns)
                    .addComponent(jLabelQuantidadeIns)
                    .addComponent(jLabelFaixaEtariaIns)
                    .addComponent(jLabelRegistoInfarmedIns)
                    .addComponent(jLabelAreaTerapeuticaIns)
                    .addComponent(jLabelLoteIns)
                    .addComponent(jLabelDosagemIns)
                    .addComponent(jLabelTemperaturaIns)
                    .addComponent(jLabelPrecoIns)
                    .addComponent(jLabelAdministracao)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFormatoIns, 0, 303, Short.MAX_VALUE)
                    .addComponent(jComboBoxAdministracaoIns, 0, 303, Short.MAX_VALUE)
                    .addComponent(jComboBoxFaixaEtaria, 0, 303, Short.MAX_VALUE)
                    .addComponent(jTextFieldRegistoInfarmedIns, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jTextFieldPrecoIns, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jComboBoxTemperaturaIns, 0, 303, Short.MAX_VALUE)
                    .addComponent(jTextFieldDosagemIns, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jTextFieldLoteIns, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jComboBoxAreaTerapeuticaIns, 0, 303, Short.MAX_VALUE)
                    .addComponent(jTextFieldCodProdutoIns, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomeGenIns, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomeDoMedicamentoIns, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addGroup(jPanelLoteLayout.createSequentialGroup()
                        .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLoteLayout.createSequentialGroup()
                                .addComponent(jRadioButtonReceitaSimIns)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLoteLayout.createSequentialGroup()
                                .addComponent(jRadioButtonGenericoSim)
                                .addGap(26, 26, 26)))
                        .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonGenericoNao)
                            .addComponent(jRadioButtonReceitaNaoIns))
                        .addGap(143, 143, 143))
                    .addGroup(jPanelLoteLayout.createSequentialGroup()
                        .addComponent(jSpinnerQuantidadeIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanelLoteLayout.setVerticalGroup(
            jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoteLayout.createSequentialGroup()
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodProdutoIns)
                    .addComponent(jTextFieldCodProdutoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeGenIns)
                    .addComponent(jTextFieldNomeGenIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNomeMedicamentoIns)
                    .addComponent(jTextFieldNomeDoMedicamentoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidadeIns)
                    .addComponent(jSpinnerQuantidadeIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFaixaEtariaIns)
                    .addComponent(jComboBoxFaixaEtaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRegistoInfarmedIns)
                    .addComponent(jTextFieldRegistoInfarmedIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAreaTerapeuticaIns)
                    .addComponent(jComboBoxAreaTerapeuticaIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLoteIns)
                    .addComponent(jTextFieldLoteIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDosagemIns)
                    .addComponent(jTextFieldDosagemIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTemperaturaIns)
                    .addComponent(jComboBoxTemperaturaIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrecoIns)
                    .addComponent(jTextFieldPrecoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdministracao)
                    .addComponent(jComboBoxAdministracaoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jRadioButtonReceitaSimIns)
                    .addComponent(jRadioButtonReceitaNaoIns))
                .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLoteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanelLoteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonGenericoSim)
                            .addComponent(jRadioButtonGenericoNao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBoxFormatoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mais Informações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        jTextFieldFolhetoURLIns.setBorder(javax.swing.BorderFactory.createTitledBorder("URL do Folheto Informativo"));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldFolhetoURLIns, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTextFieldFolhetoURLIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonLimparCamposInsertproduto.setText("Limpar Campos");
        jButtonLimparCamposInsertproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparCamposInsertprodutoActionPerformed(evt);
            }
        });

        jButtonAdicionarProduto.setText("Alterar Produto");
        jButtonAdicionarProduto.setActionCommand("Adicionar");
        jButtonAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarProdutoActionPerformed(evt);
            }
        });

        jButtonCancelarIns.setText("Cancelar");
        jButtonCancelarIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarInsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelinserirProdutoLayout = new javax.swing.GroupLayout(jPanelinserirProduto);
        jPanelinserirProduto.setLayout(jPanelinserirProdutoLayout);
        jPanelinserirProdutoLayout.setHorizontalGroup(
            jPanelinserirProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelinserirProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelinserirProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelinserirProdutoLayout.createSequentialGroup()
                        .addComponent(jPanelLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelinserirProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelinserirProdutoLayout.createSequentialGroup()
                        .addComponent(jButtonLimparCamposInsertproduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
                        .addComponent(jButtonCancelarIns)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionarProduto))))
        );
        jPanelinserirProdutoLayout.setVerticalGroup(
            jPanelinserirProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelinserirProdutoLayout.createSequentialGroup()
                .addGroup(jPanelinserirProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelinserirProdutoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelinserirProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimparCamposInsertproduto)
                    .addComponent(jButtonAdicionarProduto)
                    .addComponent(jButtonCancelarIns))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        add(jPanelinserirProduto, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jRadioButtonReceitaSimInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonReceitaSimInsActionPerformed
        jRadioButtonReceitaNaoIns.setSelected(false);
}//GEN-LAST:event_jRadioButtonReceitaSimInsActionPerformed

    private void jRadioButtonReceitaNaoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonReceitaNaoInsActionPerformed
        jRadioButtonReceitaSimIns.setSelected(false);
}//GEN-LAST:event_jRadioButtonReceitaNaoInsActionPerformed

    private void jRadioButtonGenericoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenericoSimActionPerformed
        jRadioButtonGenericoNao.setSelected(false);
}//GEN-LAST:event_jRadioButtonGenericoSimActionPerformed

    private void jRadioButtonGenericoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenericoNaoActionPerformed
        jRadioButtonGenericoSim.setSelected(false);
}//GEN-LAST:event_jRadioButtonGenericoNaoActionPerformed

    private void jButtonLimparCamposInsertprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparCamposInsertprodutoActionPerformed
        jTextFieldCodProdutoIns.setText(null);
        jTextFieldNomeGenIns.setText(null);
        jTextFieldNomeDoMedicamentoIns.setText(null);
        jSpinnerQuantidadeIns.setValue(Integer.valueOf(0));
        jComboBoxFaixaEtaria.setSelectedIndex(0);
        jTextFieldRegistoInfarmedIns.setText(null);
        jComboBoxAreaTerapeuticaIns.setSelectedIndex(0);
        jTextFieldLoteIns.setText(null);
        jTextFieldDosagemIns.setText(null);
        jComboBoxTemperaturaIns.setSelectedIndex(0);
        jTextFieldPrecoIns.setText(null);
        jComboBoxAdministracaoIns.setSelectedIndex(0);
        jRadioButtonGenericoNao.setSelected(false);
        jRadioButtonGenericoSim.setSelected(false);
        jRadioButtonReceitaNaoIns.setSelected(false);
        jRadioButtonReceitaSimIns.setSelected(false);
        jComboBoxFormatoIns.setSelectedIndex(0);
        jComboBoxConstituintes1.setSelectedIndex(0);
        jComboBoxConstituintes2.setSelectedIndex(0);
        jComboBoxConstituintes3.setSelectedIndex(0);
        jComboBoxConstituintes4.setSelectedIndex(0);
        jComboBoxConstituintes5.setSelectedIndex(0);
        jComboBoxConstituintes6.setSelectedIndex(0);
        jComboBoxConstituintes7.setSelectedIndex(0);
        jComboBoxConstituintes8.setSelectedIndex(0);
        jComboBoxConstituintes9.setSelectedIndex(0);
        jTextFieldFolhetoURLIns.setText(null);
}//GEN-LAST:event_jButtonLimparCamposInsertprodutoActionPerformed

    private void jButtonAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarProdutoActionPerformed
        try {
            String produto              = jTextFieldCodProdutoIns.getText();
            SpinnerNumberModel model    = (SpinnerNumberModel) jSpinnerQuantidadeIns.getModel();
            int quantidade              = model.getNumber().intValue();
            int receita = 0;
            if(jRadioButtonReceitaSimIns.isSelected()) receita = 1;
            int generico = 0;
            if (jRadioButtonGenericoSim.isSelected()) generico = 1;
            
            Negocio.alterarNomeGenerico(produto, jTextFieldNomeGenIns.getText());
            Negocio.alterarNomeMedicamento(produto, jTextFieldNomeDoMedicamentoIns.getText());
            Negocio.alterarQuantidade(produto, quantidade);
            Negocio.alterarRegistoInfarmed(produto, jTextFieldRegistoInfarmedIns.getText());
            Negocio.alterarFaixaEtaria(produto, jComboBoxFaixaEtaria.getSelectedItem().toString());
            Negocio.alterarDosagem(produto, jTextFieldDosagemIns.getText());
            Negocio.alterarTemperatua(produto, jComboBoxTemperaturaIns.getSelectedItem().toString());
            Negocio.alterarAdministracao(produto, jComboBoxAdministracaoIns.getSelectedItem().toString());
            Negocio.alterarReceita(produto, receita);
            Negocio.alterarGenerico(produto, generico);
            Negocio.alterarFormato(produto, jComboBoxFormatoIns.getSelectedItem().toString());
            Negocio.alterarURL(produto, jTextFieldFolhetoURLIns.getText());
            

        } catch (SQLException ex) {
            Logger.getLogger(JDialogAlterProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JDialogAlterProduto.class.getName()).log(Level.SEVERE, null, ex);
        }




            /*
            try {
            String produto              = jTextFieldCodProdutoIns.getText();
            String nome_generico        = jTextFieldNomeGenIns.getText();
            String nome_medicamento     = jTextFieldNomeDoMedicamentoIns.getText();
            SpinnerNumberModel model    = (SpinnerNumberModel) jSpinnerQuantidadeIns.getModel();
            int quantidade              = model.getNumber().intValue();
            String faixa_etaria         = jComboBoxFaixaEtaria.getSelectedItem().toString();
            String reg_infarmed         = jTextFieldRegistoInfarmedIns.getText();
            String area_terapeutica     = jComboBoxAreaTerapeuticaIns.getSelectedItem().toString();
            String lote                 = jTextFieldLoteIns.getText();
            String dosagem              = jTextFieldDosagemIns.getText();
            String temperatura          = jComboBoxTemperaturaIns.getSelectedItem().toString();
            String preco                = jTextFieldPrecoIns.getText();
            String administracao        = jComboBoxAdministracaoIns.getSelectedItem().toString();
            String receita              = null;
            String generico             = null;
            String formato              = jComboBoxFormatoIns.getSelectedItem().toString();
            String folheto_url          = jTextFieldFolhetoURLIns.getText();
            String constituinte1        = jComboBoxConstituintes1.getSelectedItem().toString();
            String constituinte2        = jComboBoxConstituintes2.getSelectedItem().toString();
            String constituinte3        = jComboBoxConstituintes3.getSelectedItem().toString();
            String constituinte4        = jComboBoxConstituintes4.getSelectedItem().toString();
            String constituinte5        = jComboBoxConstituintes5.getSelectedItem().toString();
            String constituinte6        = jComboBoxConstituintes6.getSelectedItem().toString();
            String constituinte7        = jComboBoxConstituintes7.getSelectedItem().toString();
            String constituinte8        = jComboBoxConstituintes8.getSelectedItem().toString();
            String constituinte9        = jComboBoxConstituintes9.getSelectedItem().toString();
            if (jRadioButtonReceitaSimIns.isSelected()) receita  = "1";
            if (jRadioButtonReceitaNaoIns.isSelected()) receita  = "0";
            if (jRadioButtonGenericoSim.isSelected())   generico = "1";
            if (jRadioButtonGenericoNao.isSelected())   generico = "0";
            // Para devolver os ID
            faixa_etaria        = Negocio.procurarFaixaEtariaPorNome(faixa_etaria);
            area_terapeutica    = Negocio.procuraAreaTerapeuticaPorNOME(area_terapeutica);
            temperatura         = Negocio.procurarTemperaturaPorNome(temperatura);
            administracao       = Negocio.procuraAdministracaoPorNOME(administracao);
            formato             = Negocio.procurarFormatoPorNome(formato);
            constituinte1       = Negocio.procurarConstituintesPorNome(constituinte1);
            constituinte2       = Negocio.procurarConstituintesPorNome(constituinte2);
            constituinte3       = Negocio.procurarConstituintesPorNome(constituinte3);
            constituinte4       = Negocio.procurarConstituintesPorNome(constituinte4);
            constituinte5       = Negocio.procurarConstituintesPorNome(constituinte5);
            constituinte6       = Negocio.procurarConstituintesPorNome(constituinte6);
            constituinte7       = Negocio.procurarConstituintesPorNome(constituinte7);
            constituinte8       = Negocio.procurarConstituintesPorNome(constituinte8);
            constituinte9       = Negocio.procurarConstituintesPorNome(constituinte9);
            String msgERRO = "";
            if (produto.equalsIgnoreCase(""))                       msgERRO = msgERRO + "Falta inserir produto!\n";
            if (nome_generico.equalsIgnoreCase(""))                 msgERRO = msgERRO + "Falta inserir o nome generico!\n";
            if (nome_medicamento.equalsIgnoreCase(""))              msgERRO = msgERRO + "Falta inserir o nome do medicamento!\n";
            if (reg_infarmed.equalsIgnoreCase(""))                  msgERRO = msgERRO + "Falta inserir o registo infarmed!\n";
            if (dosagem.equalsIgnoreCase(""))                       msgERRO = msgERRO + "Falta inserir a dosagem do produto!\n";
            if (isNumber(produto) == false)                         msgERRO = msgERRO + "O codigo do produto apenas pode ter algarismos!\n";
            if (isNumber(reg_infarmed) == false)                    msgERRO = msgERRO + "O registo do infarmed apenas pode ter algarismos!\n";
            if (Negocio.verificarProdutoExiste(produto))            msgERRO = msgERRO + "O produo já existe!\n";
            if (Negocio.verificarRegInfarmedExiste(reg_infarmed))   msgERRO = msgERRO + "O registo infarmed inserido já existe!\n";
            System.out.println(msgERRO);
            if (msgERRO.equalsIgnoreCase("") == false) {
            JOptionPane.showMessageDialog(null, msgERRO, "Erro ao inserir produto", 1);
            } else {
            //Negocio.insertProduto(produto, nome_generico, nome_medicamento, "" + quantidade + "", faixa_etaria, reg_infarmed, area_terapeutica, lote, dosagem, temperatura, preco, administracao, receita, generico, formato, folheto_url);
            if(constituinte1.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte1);
            if(constituinte2.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte2);
            if(constituinte3.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte3);
            if(constituinte4.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte4);
            if(constituinte5.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte5);
            if(constituinte6.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte6);
            if(constituinte7.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte7);
            if(constituinte8.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte8);
            if(constituinte9.equalsIgnoreCase("1")==false)  Negocio.insertConstituinte(produto, constituinte9);
            JDialogAlterProduto.this.dispose();
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!", "Produto inserido", 1);
            }
            } catch (Exception ex) {
            Logger.getLogger(JDialogInsertProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
             *
             */
        

}//GEN-LAST:event_jButtonAdicionarProdutoActionPerformed

    private void jButtonCancelarInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarInsActionPerformed
        JDialogAlterProduto.this.dispose();
}//GEN-LAST:event_jButtonCancelarInsActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JDialogAlterProduto dialog = new JDialogAlterProduto(new java.awt.Frame(), "", true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JDialogAlterProduto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(JDialogAlterProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarProduto;
    private javax.swing.JButton jButtonCancelarIns;
    private javax.swing.JButton jButtonLimparCamposInsertproduto;
    private javax.swing.JComboBox jComboBoxAdministracaoIns;
    private javax.swing.JComboBox jComboBoxAreaTerapeuticaIns;
    private javax.swing.JComboBox jComboBoxConstituintes1;
    private javax.swing.JComboBox jComboBoxConstituintes2;
    private javax.swing.JComboBox jComboBoxConstituintes3;
    private javax.swing.JComboBox jComboBoxConstituintes4;
    private javax.swing.JComboBox jComboBoxConstituintes5;
    private javax.swing.JComboBox jComboBoxConstituintes6;
    private javax.swing.JComboBox jComboBoxConstituintes7;
    private javax.swing.JComboBox jComboBoxConstituintes8;
    private javax.swing.JComboBox jComboBoxConstituintes9;
    private javax.swing.JComboBox jComboBoxFaixaEtaria;
    private javax.swing.JComboBox jComboBoxFormatoIns;
    private javax.swing.JComboBox jComboBoxTemperaturaIns;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabelAdministracao;
    private javax.swing.JLabel jLabelAreaTerapeuticaIns;
    private javax.swing.JLabel jLabelCodProdutoIns;
    private javax.swing.JLabel jLabelDosagemIns;
    private javax.swing.JLabel jLabelFaixaEtariaIns;
    private javax.swing.JLabel jLabelLoteIns;
    private javax.swing.JLabel jLabelNomeGenIns;
    private javax.swing.JLabel jLabelNomeMedicamentoIns;
    private javax.swing.JLabel jLabelPrecoIns;
    private javax.swing.JLabel jLabelQuantidadeIns;
    private javax.swing.JLabel jLabelRegistoInfarmedIns;
    private javax.swing.JLabel jLabelTemperaturaIns;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelLote;
    private javax.swing.JPanel jPanelinserirProduto;
    private javax.swing.JRadioButton jRadioButtonGenericoNao;
    private javax.swing.JRadioButton jRadioButtonGenericoSim;
    private javax.swing.JRadioButton jRadioButtonReceitaNaoIns;
    private javax.swing.JRadioButton jRadioButtonReceitaSimIns;
    private javax.swing.JSpinner jSpinnerQuantidadeIns;
    private javax.swing.JTextField jTextFieldCodProdutoIns;
    private javax.swing.JTextField jTextFieldDosagemIns;
    private javax.swing.JTextField jTextFieldFolhetoURLIns;
    private javax.swing.JTextField jTextFieldLoteIns;
    private javax.swing.JTextField jTextFieldNomeDoMedicamentoIns;
    private javax.swing.JTextField jTextFieldNomeGenIns;
    private javax.swing.JTextField jTextFieldPrecoIns;
    private javax.swing.JTextField jTextFieldRegistoInfarmedIns;
    // End of variables declaration//GEN-END:variables


    public boolean isNumber (String input){
        try {
			Integer.parseInt(input);
			return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private String vazio(String str) {
        if (str == null) {
            return "<vazio>";
        }
        return str;
    }

    private String sim_nao(String str) {
        if (str.equalsIgnoreCase("1")) {
            return "Sim";
        } else {
            return "Não";
        }
    }

    public static void centerOnScreen(final Component target) {
       if (target != null) {
           Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
           Dimension dialogSize = target.getSize();

           if (dialogSize.height > screenSize.height) {
               dialogSize.height = screenSize.height;
           }
           if (dialogSize.width > screenSize.width) {
               dialogSize.width = screenSize.width;
           }

           target.setLocation((screenSize.width - dialogSize.width) / 2,
                   (screenSize.height - dialogSize.height) / 2);
       }
   }

}
