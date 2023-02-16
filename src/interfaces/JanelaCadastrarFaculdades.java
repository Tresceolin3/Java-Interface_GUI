package interfaces;

import controle.ControladorCadastroFaculdade;
import entidade.Faculdade;
import entidade.Faculdade.Tipo;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class JanelaCadastrarFaculdades extends javax.swing.JFrame {

    ControladorCadastroFaculdade controlador;
    Faculdade[] faculdades_cadastradas;

    public JanelaCadastrarFaculdades(ControladorCadastroFaculdade controlador) {
        this.controlador = controlador;
        faculdades_cadastradas = Faculdade.getVisões();
        initComponents();
        limparCampos();
    }

    private void limparCampos() {
        tituloTextField.setText("");
        siglaTextField.setText("");
        modalidadeButtonGroup.clearSelection();
        tipoButtonGroup.clearSelection();
    }

    private Faculdade obterFaculdadeInformado() {
        String sigla = siglaTextField.getText();
        if (sigla.isEmpty()) {
            return null;
        }
        String titulo = tituloTextField.getText();
        if (titulo.isEmpty()) {
            return null;
        }
        char modalidade = 'X';
        if (modalidadeButtonGroup.getSelection() != null) {
            modalidade = (char) modalidadeButtonGroup.getSelection().getMnemonic();
        } else {
            return null;
        }

        Tipo tipo = null;
        if (tipoButtonGroup.getSelection() != null) {
            tipo = Tipo.values()[tipoButtonGroup.getSelection().getMnemonic()];
        } else {
            return null;
        }

        return new Faculdade(sigla, titulo, modalidade, tipo);
    }

    private void informarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    private Faculdade getVisãoAlterada(String sigla) {
        for (Faculdade visão : faculdades_cadastradas) {
            if (visão.getSigla().equals(sigla)) {
                return visão;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modalidadeButtonGroup = new javax.swing.ButtonGroup();
        tipoButtonGroup = new javax.swing.ButtonGroup();
        tituloLabel = new javax.swing.JLabel();
        tituloTextField = new javax.swing.JTextField();
        siglaLabel = new javax.swing.JLabel();
        siglaTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        faculdades_cadastradasLabel = new javax.swing.JLabel();
        faculdades_cadastradasComboBox = new javax.swing.JComboBox();
        tipoPanel = new javax.swing.JPanel();
        humanasRadioButton = new javax.swing.JRadioButton();
        exatasRadioButton = new javax.swing.JRadioButton();
        engenhariasRadioButton = new javax.swing.JRadioButton();
        medicinasRadioButton = new javax.swing.JRadioButton();
        TipoLabel = new javax.swing.JLabel();
        modalidadeLabel = new javax.swing.JLabel();
        modalidadePanel = new javax.swing.JPanel();
        presencialRadioButton = new javax.swing.JRadioButton();
        eadRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Faculdade");
        setPreferredSize(new java.awt.Dimension(480, 350));

        tituloLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tituloLabel.setText("Titulo");

        tituloTextField.setColumns(50);
        tituloTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        siglaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        siglaLabel.setText("Sigla");

        siglaTextField.setColumns(50);
        siglaTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        inserirButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirFaculdade(evt);
            }
        });

        consultarButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarFaculdade(evt);
            }
        });

        alterarButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarFaculdade(evt);
            }
        });

        removerButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerFaculdade(evt);
            }
        });

        limparButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        faculdades_cadastradasLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faculdades_cadastradasLabel.setText("Faculdades Cadastradas");
        faculdades_cadastradasLabel.setToolTipText("");

        faculdades_cadastradasComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faculdades_cadastradasComboBox.setModel(new DefaultComboBoxModel(faculdades_cadastradas));

        tipoButtonGroup.add(humanasRadioButton);
        humanasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        humanasRadioButton.setMnemonic('\u0001');
        humanasRadioButton.setText("Humanas");

        tipoButtonGroup.add(exatasRadioButton);
        exatasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exatasRadioButton.setText("Exatas");

        tipoButtonGroup.add(engenhariasRadioButton);
        engenhariasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        engenhariasRadioButton.setMnemonic('\u0002');
        engenhariasRadioButton.setText("Engenharias");

        tipoButtonGroup.add(medicinasRadioButton);
        medicinasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medicinasRadioButton.setMnemonic('\u0003');
        medicinasRadioButton.setText("Medicinas");

        TipoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TipoLabel.setText("Tipo");

        modalidadeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modalidadeLabel.setText("Modalidade");

        modalidadeButtonGroup.add(presencialRadioButton);
        presencialRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencialRadioButton.setMnemonic('P');
        presencialRadioButton.setText("Presencial");

        modalidadeButtonGroup.add(eadRadioButton);
        eadRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eadRadioButton.setMnemonic('E');
        eadRadioButton.setText("Ead");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(437, 437, 437)
                        .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modalidadeLabel)
                                .addGap(46, 46, 46)
                                .addComponent(eadRadioButton)
                                .addGap(5, 5, 5)
                                .addComponent(presencialRadioButton)
                                .addGap(105, 105, 105)
                                .addComponent(modalidadePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TipoLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(exatasRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(humanasRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(engenhariasRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(medicinasRadioButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inserirButton)
                                        .addGap(10, 10, 10)
                                        .addComponent(consultarButton)
                                        .addGap(6, 6, 6)
                                        .addComponent(alterarButton)
                                        .addGap(6, 6, 6)
                                        .addComponent(removerButton)
                                        .addGap(4, 4, 4)
                                        .addComponent(limparButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(siglaLabel)
                                .addGap(18, 18, 18)
                                .addComponent(siglaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(faculdades_cadastradasLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(faculdades_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tituloLabel)
                                .addGap(18, 18, 18)
                                .addComponent(tituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faculdades_cadastradasLabel)
                    .addComponent(faculdades_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(modalidadePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tituloLabel)
                            .addComponent(tituloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(eadRadioButton)
                                .addComponent(presencialRadioButton))
                            .addComponent(modalidadeLabel))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tipoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipoLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(humanasRadioButton)
                                .addComponent(exatasRadioButton)
                                .addComponent(engenhariasRadioButton)
                                .addComponent(medicinasRadioButton)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siglaLabel)
                            .addComponent(siglaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inserirButton)
                            .addComponent(consultarButton)
                            .addComponent(alterarButton)
                            .addComponent(removerButton)
                            .addComponent(limparButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)))
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    private void inserirFaculdade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirFaculdade
        Faculdade amigo = obterFaculdadeInformado();
        String mensagem_erro = null;
        if (amigo != null) {
            mensagem_erro = controlador.inserirFaculdade(amigo);
        } else {
            mensagem_erro = "Algum atributo da faculdade não foi informado";
        }
        if (mensagem_erro == null) {
            Faculdade visão = amigo.getVisao();
            faculdades_cadastradasComboBox.addItem(visão);
            faculdades_cadastradasComboBox.setSelectedItem(visão);
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_inserirFaculdade

    private void consultarFaculdade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarFaculdade
        Faculdade visão = (Faculdade) faculdades_cadastradasComboBox.getSelectedItem();
        Faculdade faculdade = null;
        String mensagem_erro = null;
        if (visão != null) {
            faculdade = Faculdade.buscarFaculdade(visão.getSigla());
            if (faculdade == null) {
                mensagem_erro = "Faculdade não cadastrada";
            }
        } else {
            mensagem_erro = "Nenhuma Faculdade selecionada";
        }
        if (mensagem_erro == null) {
            String titulo = faculdade.getTitulo();
            if (titulo == null) {
                titulo = "";
            }
            siglaTextField.setText(faculdade.getSigla());
            tituloTextField.setText(titulo);
            

            selecionarModalidadeRadioButton(faculdade.getModalidade());
            selecioneTipoRadioButton(faculdade.getTipo().ordinal());
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarFaculdade

    private void selecionarModalidadeRadioButton(char modalidade) {
        switch (modalidade) {
            case 'E':
                eadRadioButton.setSelected(true);
                break;
            case 'P':
                presencialRadioButton.setSelected(true);
        }
    }

    private void selecioneTipoRadioButton(int tipo) {
        switch (tipo) {
            case 0:
                exatasRadioButton.setSelected(true);
                break;
            case 1:
                humanasRadioButton.setSelected(true);
                break;
            case 2:
                engenhariasRadioButton.setSelected(true);
                break;
            case 3:
                medicinasRadioButton.setSelected(true);
        }
    }


    private void alterarFaculdade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarFaculdade
        Faculdade faculdade = obterFaculdadeInformado();
        String mensagem_erro = null;
        if (faculdade != null) {
            mensagem_erro = controlador.alterarFaculdade(faculdade);
        } else {
            mensagem_erro = "Algum atributo da Faculdade não foi informado";
        }
        if (mensagem_erro == null) {
            Faculdade visão = getVisãoAlterada(faculdade.getSigla());
            if (visão != null) {
                visão.setTitulo(faculdade.getTitulo());
                faculdades_cadastradasComboBox.updateUI();
                faculdades_cadastradasComboBox.setSelectedItem(visão);
            }
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_alterarFaculdade

    private void removerFaculdade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerFaculdade
        Faculdade visão = (Faculdade) faculdades_cadastradasComboBox.getSelectedItem();
        String mensagem_erro = null;
        if (visão != null) {
            mensagem_erro = controlador.removerFaculdade(visão.getSigla());
        } else {
            mensagem_erro = "Nenhuma Faculdade selecionada";
        }
        if (mensagem_erro == null) {
            faculdades_cadastradasComboBox.removeItem(visão);
            if (faculdades_cadastradas.length >= 1) {
                faculdades_cadastradasComboBox.setSelectedIndex(-1);
            } else {
                faculdades_cadastradasComboBox.setSelectedIndex(-1);
            }
        } else {
            informarErro(mensagem_erro);
        }

    }//GEN-LAST:event_removerFaculdade

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TipoLabel;
    private javax.swing.JButton alterarButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JRadioButton eadRadioButton;
    private javax.swing.JRadioButton engenhariasRadioButton;
    private javax.swing.JRadioButton exatasRadioButton;
    private javax.swing.JComboBox faculdades_cadastradasComboBox;
    private javax.swing.JLabel faculdades_cadastradasLabel;
    private javax.swing.JRadioButton humanasRadioButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JButton limparButton;
    private javax.swing.JRadioButton medicinasRadioButton;
    private javax.swing.ButtonGroup modalidadeButtonGroup;
    private javax.swing.JLabel modalidadeLabel;
    private javax.swing.JPanel modalidadePanel;
    private javax.swing.JRadioButton presencialRadioButton;
    private javax.swing.JButton removerButton;
    private javax.swing.JLabel siglaLabel;
    private javax.swing.JTextField siglaTextField;
    private javax.swing.ButtonGroup tipoButtonGroup;
    private javax.swing.JPanel tipoPanel;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JTextField tituloTextField;
    // End of variables declaration//GEN-END:variables

}
