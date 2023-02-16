package interfaces;

import controle.ControladorCadastroContrato;
import entidade.Contrato;
import entidade.Contrato.ModeloContrato;
import entidade.Faculdade;
import entidade.Professor;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaCadastroContrato extends javax.swing.JFrame {

    ControladorCadastroContrato controlador;
    DefaultListModel modelo_lista_contrato;
    Faculdade[] faculdades_cadastradas;
    Professor[] professores_cadastrados;

    public JanelaCadastroContrato(ControladorCadastroContrato controlador) {
        this.controlador = controlador;
        faculdades_cadastradas = Faculdade.getVisões();
        professores_cadastrados = Professor.getVisões();
        initComponents();
        inicializaListaContrato();
        limparCampos();
    }

    private void inicializaListaContrato() {
        modelo_lista_contrato = (DefaultListModel) contratos_cadastradosList.getModel();
        Contrato[] visoes = Contrato.getVisoes();
        for (Contrato visao : visoes) {
            modelo_lista_contrato.addElement(visao);
        }
    }

    private Contrato obtemContratoInformada() {
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) {
            sequencial = Integer.parseInt(sequencial_str);
        }
        Faculdade visao_faculdade = (Faculdade) faculdades_cadastradasComboBox.getSelectedItem();
        if (visao_faculdade == null) {
            return null;
        }
        Professor visao_professor = (Professor) professores_cadastradosComboBox.getSelectedItem();
        if (visao_professor == null) {
            return null;
        }
        Contrato.ModeloContrato modelo_contrato = null;
        if (modelo_contratoComboBox.getSelectedItem() != null) {
            modelo_contrato = (Contrato.ModeloContrato) modelo_contratoComboBox.getSelectedItem();
        } else {
            return null;
        }
        Contrato.Modalidade modalidade = null;
        if (modalidadeButtonGroup.getSelection() != null) {
            modalidade = Contrato.Modalidade.values()[modalidadeButtonGroup.getSelection().getMnemonic()];
        }
        Timestamp data_hora = new Timestamp(Calendar.getInstance().getTimeInMillis());
        return new Contrato(sequencial, visao_faculdade, visao_professor, modelo_contrato,
                modalidade, data_hora);
    }

    private void selecioneModalidadeRadioButton(int indice_modalidade) {
        switch (indice_modalidade) {
            case 0:
                pjRadioButton.setSelected(true);
                break;
            case 1:
                cltRadioButton.setSelected(true);

        }
    }

    private Professor getVisaoProfessorSelecionado(Contrato contrato) {
        String chave_professor = contrato.getProfessor().getCpf();
        for (Professor visao_professor : professores_cadastrados) {
            if (visao_professor.getCpf().equals(chave_professor)) {
                return visao_professor;
            }
        }
        return null;
    }

    private Faculdade getVisaoFaculdadeSelecionada(Contrato contrato) {
        String chave_faculdade = contrato.getFaculdade().getTitulo();
        for (Faculdade visao_faculdade : faculdades_cadastradas) {
            if (visao_faculdade.getTitulo().equals(chave_faculdade)) {
                return visao_faculdade;
            }
        }
        return null;
    }

    private void limparCampos(){
        sequencialTextField.setText("");
        faculdades_cadastradasComboBox.setSelectedIndex(-1);
        professores_cadastradosComboBox.setSelectedIndex(-1);
        modelo_contratoComboBox.setSelectedIndex(-1);
        modalidadeButtonGroup.clearSelection();
        data_horaTextField.setText("");
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        modalidadeButtonGroup = new javax.swing.ButtonGroup();
        contratos_cadastradosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contratos_cadastradosList = new javax.swing.JList();
        sequencialTextField = new javax.swing.JTextField();
        ordem_contratoLabel = new javax.swing.JLabel();
        faculdades_cadastradasComboBox = new javax.swing.JComboBox();
        faculdades_cadastradasLabel = new javax.swing.JLabel();
        professores_cadastradosLabel = new javax.swing.JLabel();
        professores_cadastradosComboBox = new javax.swing.JComboBox();
        modelo_contratoLabel = new javax.swing.JLabel();
        modelo_contratoComboBox = new javax.swing.JComboBox<>();
        pjRadioButton = new javax.swing.JRadioButton();
        cltRadioButton = new javax.swing.JRadioButton();
        modalidadeLabel = new javax.swing.JLabel();
        data_horaLabel = new javax.swing.JLabel();
        data_horaTextField = new javax.swing.JTextField();
        contratojPanel = new javax.swing.JPanel();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        inserirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Contrato");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        contratos_cadastradosLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contratos_cadastradosLabel.setText("Contratos Cadastrados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 35;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 66;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 14, 0, 0);
        getContentPane().add(contratos_cadastradosLabel, gridBagConstraints);
        contratos_cadastradosLabel.getAccessibleContext().setAccessibleName("");

        contratos_cadastradosList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contratos_cadastradosList.setModel(new DefaultListModel()
        );
        jScrollPane1.setViewportView(contratos_cadastradosList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 104;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 647;
        gridBagConstraints.ipady = 127;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(24, 10, 0, 10);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        sequencialTextField.setEditable(false);
        sequencialTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 2, 0, 0);
        getContentPane().add(sequencialTextField, gridBagConstraints);

        ordem_contratoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ordem_contratoLabel.setText("Ordem de Contrato");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        getContentPane().add(ordem_contratoLabel, gridBagConstraints);

        faculdades_cadastradasComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faculdades_cadastradasComboBox.setModel(new DefaultComboBoxModel(faculdades_cadastradas));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 89;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 291;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        getContentPane().add(faculdades_cadastradasComboBox, gridBagConstraints);

        faculdades_cadastradasLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faculdades_cadastradasLabel.setText("Faculdades Cadastradas");
        faculdades_cadastradasLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        getContentPane().add(faculdades_cadastradasLabel, gridBagConstraints);

        professores_cadastradosLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        professores_cadastradosLabel.setText("Professores Cadastrados");
        professores_cadastradosLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        getContentPane().add(professores_cadastradosLabel, gridBagConstraints);
        professores_cadastradosLabel.getAccessibleContext().setAccessibleName("");

        professores_cadastradosComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        professores_cadastradosComboBox.setModel(new DefaultComboBoxModel(professores_cadastrados));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 89;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 293;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 0);
        getContentPane().add(professores_cadastradosComboBox, gridBagConstraints);

        modelo_contratoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modelo_contratoLabel.setText("Modelo Contrato");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        getContentPane().add(modelo_contratoLabel, gridBagConstraints);

        modelo_contratoComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modelo_contratoComboBox.setModel(new DefaultComboBoxModel (ModeloContrato.values()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 65;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 119;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 0);
        getContentPane().add(modelo_contratoComboBox, gridBagConstraints);

        modalidadeButtonGroup.add(pjRadioButton);
        pjRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pjRadioButton.setText("PJ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        getContentPane().add(pjRadioButton, gridBagConstraints);

        modalidadeButtonGroup.add(cltRadioButton);
        cltRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cltRadioButton.setMnemonic('\u0001');
        cltRadioButton.setText("CLT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 23;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 0);
        getContentPane().add(cltRadioButton, gridBagConstraints);

        modalidadeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modalidadeLabel.setText("Modalidade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 10, 0, 0);
        getContentPane().add(modalidadeLabel, gridBagConstraints);

        data_horaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        data_horaLabel.setText("Data e Hora");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 10, 0, 0);
        getContentPane().add(data_horaLabel, gridBagConstraints);

        data_horaTextField.setEditable(false);
        data_horaTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 34;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 161;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 10, 0, 0);
        getContentPane().add(data_horaTextField, gridBagConstraints);

        consultarButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarContrato(evt);
            }
        });

        alterarButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarContrato(evt);
            }
        });

        removerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerContrato(evt);
            }
        });

        limparButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparContrato(evt);
            }
        });

        inserirButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirContrato(evt);
            }
        });

        javax.swing.GroupLayout contratojPanelLayout = new javax.swing.GroupLayout(contratojPanel);
        contratojPanel.setLayout(contratojPanelLayout);
        contratojPanelLayout.setHorizontalGroup(
            contratojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contratojPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inserirButton)
                .addGap(18, 18, 18)
                .addComponent(consultarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limparButton))
        );
        contratojPanelLayout.setVerticalGroup(
            contratojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contratojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(consultarButton)
                .addComponent(alterarButton)
                .addComponent(removerButton)
                .addComponent(limparButton)
                .addComponent(inserirButton))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 15, 0, 0);
        getContentPane().add(contratojPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarContrato(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarContrato
        Contrato visao_contrato = (Contrato) contratos_cadastradosList.getSelectedValue();
        Contrato contrato = null;
        String mensagem_erro = null;
        if (visao_contrato != null) {
            contrato = Contrato.buscarContrato(visao_contrato.getSequencial());
            if (contrato == null) {
                mensagem_erro = "Contrato Não Cadastrado";
            }
        } else {
            mensagem_erro = "Nenhum contrato selecionada";
        }
        if (mensagem_erro == null) {
            sequencialTextField.setText(contrato.getSequencial() + "");
            faculdades_cadastradasComboBox.setSelectedItem(getVisaoFaculdadeSelecionada(contrato));
            professores_cadastradosComboBox.setSelectedItem(getVisaoProfessorSelecionado(contrato));
            modelo_contratoComboBox.setSelectedItem(contrato.getModeloContrato());
            selecioneModalidadeRadioButton(contrato.getModalidade().ordinal());
            data_horaTextField.setText(Contrato.formatarDataHora(contrato.getDataHora().toString()));
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarContrato

    private void alterarContrato(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarContrato
        Contrato contrato = obtemContratoInformada();
        String mensagem_erro = null;
        if (contrato != null) {
            mensagem_erro = controlador.alterarContrato(contrato);
        } else {
            mensagem_erro = "Algum atributo de Contrato Não informado";
        }
        if (mensagem_erro != null) {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_alterarContrato

    private void removerContrato(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerContrato
        Contrato visão = (Contrato) contratos_cadastradosList.getSelectedValue();
        String mensagem_erro = null;
        if (visão != null) {
            mensagem_erro = controlador.removerContrato(visão.getSequencial());
        } else {
            mensagem_erro = "Nenhum Contrato selecionado";
        }
        if (mensagem_erro == null) {
            modelo_lista_contrato.removeElement(visão);
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_removerContrato


    private void limparContrato(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparContrato
         limparCampos();
    }//GEN-LAST:event_limparContrato

    private void inserirContrato(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirContrato
        Contrato contrato = obtemContratoInformada();
        String mensagem_erro = null;
        if (contrato != null) {
            mensagem_erro = controlador.inserirContrato(contrato);
        } else {
            mensagem_erro = "Algum atributo do contrato não foi informado";
        }
        if (mensagem_erro == null) {
            int sequencial = Contrato.ultimoSequencial();
            contrato.setSequencial(sequencial);
            modelo_lista_contrato.addElement(contrato.getVisao());
            contratos_cadastradosList.setSelectedIndex(modelo_lista_contrato.size() - 1);
            sequencialTextField.setText("" + sequencial);
            data_horaTextField.setText(Contrato.formatarDataHora(contrato.getDataHora().toString()));
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_inserirContrato

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JRadioButton cltRadioButton;
    private javax.swing.JButton consultarButton;
    private javax.swing.JPanel contratojPanel;
    private javax.swing.JLabel contratos_cadastradosLabel;
    private javax.swing.JList contratos_cadastradosList;
    private javax.swing.JLabel data_horaLabel;
    private javax.swing.JTextField data_horaTextField;
    private javax.swing.JComboBox faculdades_cadastradasComboBox;
    private javax.swing.JLabel faculdades_cadastradasLabel;
    private javax.swing.JButton inserirButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparButton;
    private javax.swing.ButtonGroup modalidadeButtonGroup;
    private javax.swing.JLabel modalidadeLabel;
    private javax.swing.JComboBox<String> modelo_contratoComboBox;
    private javax.swing.JLabel modelo_contratoLabel;
    private javax.swing.JLabel ordem_contratoLabel;
    private javax.swing.JRadioButton pjRadioButton;
    private javax.swing.JComboBox professores_cadastradosComboBox;
    private javax.swing.JLabel professores_cadastradosLabel;
    private javax.swing.JButton removerButton;
    private javax.swing.JTextField sequencialTextField;
    // End of variables declaration//GEN-END:variables
}
