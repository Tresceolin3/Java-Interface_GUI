package interfaces;

import controle.ControladorCadastroProfessor;
import entidade.Professor;
import entidade.Professor.AreaConcurso;
import entidade.ProfessorConvidado;
import entidade.ProfessorConvidado.Atividade;
import entidade.ProfessorEfetivo;
import entidade.ProfessorSubstituto;
import entidade.ProfessorSubstituto.DiaSemana;
import entidade.ProfessorSubstituto.Periodo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaCadastroProfessores extends javax.swing.JFrame {

    ControladorCadastroProfessor controlador;
    DefaultListModel modelo_lista_professores;
    PainelProfessorEfetivo professor_efetivo_Painel;
    PainelProfessorSubstituto professor_substituto_Painel;
    PainelProfessorConvidado professor_convidado_Painel;

    public JanelaCadastroProfessores(ControladorCadastroProfessor controlador) {
        this.controlador = controlador;
        initComponents();
        professor_efetivo_Painel = new PainelProfessorEfetivo();
        professor_substituto_Painel = new PainelProfessorSubstituto();
        professor_convidado_Painel = new PainelProfessorConvidado();
        tipos_professoresTabbedPane.addTab("Professor Efetivo",
                professor_efetivo_Painel);
        tipos_professoresTabbedPane.addTab("Professor Substituto",
                professor_substituto_Painel);
        tipos_professoresTabbedPane.addTab("Professor Convidado",
                professor_convidado_Painel);
        inicializarListaProfessor();
        limparCampos();
    }

    private void inicializarListaProfessor() {
        modelo_lista_professores = (DefaultListModel) professores_cadastradosList.getModel();
        Professor[] visões = Professor.getVisões();
        for (Professor visão : visões) {
            modelo_lista_professores.addElement(visão);
        }
    }

    private void limparCampos() {
        sequencialTextField.setText("");
        nomeTextField.setText("");
        cpfTextField.setText("");
        emailTextField.setText("");
        area_concursoComboBox.setSelectedIndex(-1);
        professor_efetivo_Painel.limparCampos();
        professor_substituto_Painel.limparCampos();
        professor_convidado_Painel.limparCampos();
    }

    private Professor obterProfessorInformado() {
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) {
            sequencial = Integer.parseInt(sequencial_str);
        }

        String nome = nomeTextField.getText();
        if (nome.isEmpty()) {
            return null;
        }

        String cpf = cpfTextField.getText();
        if (cpf.isEmpty()) {
            return null;
        }

        String email = emailTextField.getText();
        if (email.isEmpty()) {
            return null;
        }

        AreaConcurso area_concurso = null;
        if (area_concursoComboBox.getSelectedItem() != null) {
            area_concurso = (AreaConcurso) area_concursoComboBox.getSelectedItem();
        } else {
            return null;
        }

        Professor professor = null;
        int indice_aba_selecionada = tipos_professoresTabbedPane.getSelectedIndex();
        switch (indice_aba_selecionada) {
            case 0 :
                boolean afastado = professor_efetivo_Painel.isAfastado();
                String ano_admissao = professor_efetivo_Painel.getAnoAdmissao();
                professor = new ProfessorEfetivo(sequencial, cpf, nome, email, area_concurso, afastado, ano_admissao
                );
                break;
            case 1 :
                DiaSemana dia_semana = professor_substituto_Painel.getSelectedDiaSemana();
                if (dia_semana == null) {
                    return null;
                }
                Periodo periodo = professor_substituto_Painel.getSelectedPeriodo();
                if (periodo == null) {
                    return null;
                }
                int horas_aulas = professor_substituto_Painel.getHorasAula();
                if (horas_aulas == -1) {
                    return null;
                }
                professor = new ProfessorSubstituto(sequencial, cpf, nome, email, area_concurso, dia_semana, periodo, horas_aulas);
                break;
            case 2 :
                boolean bolsita = professor_convidado_Painel.isBolsista();
                String nome_projeto = professor_convidado_Painel.getNomeProjeto();
                Atividade atividade = professor_convidado_Painel.getSelectedAtividade();
                professor = new ProfessorConvidado(sequencial, cpf, nome, email, area_concurso, atividade, nome_projeto, bolsita);           
              }
        return professor;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        professores_cadastradosScrollPane = new javax.swing.JScrollPane();
        professores_cadastradosList = new javax.swing.JList();
        professores_cadastradosLabel = new javax.swing.JLabel();
        identificador_sequencialLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        area_concursoComboBox = new javax.swing.JComboBox<>();
        area_concursoLabel = new javax.swing.JLabel();
        sequencialTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        tipos_professoresTabbedPane = new javax.swing.JTabbedPane();
        inserir_professorButton = new javax.swing.JButton();
        consultar_professorButton = new javax.swing.JButton();
        alterar_professorButton = new javax.swing.JButton();
        remover_professorButton = new javax.swing.JButton();
        limpar_camposButton = new javax.swing.JButton();
        cpfLabel = new javax.swing.JLabel();
        cpfTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Professor");

        professores_cadastradosScrollPane.setPreferredSize(new java.awt.Dimension(400, 20));

        professores_cadastradosList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        professores_cadastradosList.setModel(new DefaultListModel());
        professores_cadastradosList.setToolTipText("");
        professores_cadastradosScrollPane.setViewportView(professores_cadastradosList);

        professores_cadastradosLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        professores_cadastradosLabel.setText("Professores  Cadastrados");

        identificador_sequencialLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        identificador_sequencialLabel.setText("Identificador Sequencial");

        nomeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomeLabel.setText("Nome");

        nomeTextField.setColumns(50);
        nomeTextField.setPreferredSize(new java.awt.Dimension(400, 20));

        area_concursoComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        area_concursoComboBox.setModel(new DefaultComboBoxModel(AreaConcurso.values()));

        area_concursoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        area_concursoLabel.setText("Area Concurso");

        sequencialTextField.setEditable(false);
        sequencialTextField.setColumns(50);
        sequencialTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tipos_professoresTabbedPane.setPreferredSize(new java.awt.Dimension(600, 400));

        inserir_professorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inserir_professorButton.setText("Inserir");
        inserir_professorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirProfessor(evt);
            }
        });

        consultar_professorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        consultar_professorButton.setText("Consultar");
        consultar_professorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarProfessor(evt);
            }
        });

        alterar_professorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        alterar_professorButton.setText("Alterar");
        alterar_professorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarProfessor(evt);
            }
        });

        remover_professorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        remover_professorButton.setText("Remover");
        remover_professorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerProfessor(evt);
            }
        });

        limpar_camposButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        limpar_camposButton.setText("Limpar");
        limpar_camposButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        cpfLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cpfLabel.setText("CPF");

        cpfTextField.setColumns(50);
        cpfTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        emailTextField.setColumns(50);
        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailLabel.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(emailLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cpfLabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(280, 280, 280)
                                        .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(area_concursoLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(area_concursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tipos_professoresTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(identificador_sequencialLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(professores_cadastradosLabel)
                                        .addGap(92, 92, 92)
                                        .addComponent(professores_cadastradosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 382, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(inserir_professorButton)
                        .addGap(2, 2, 2)
                        .addComponent(consultar_professorButton)
                        .addGap(5, 5, 5)
                        .addComponent(alterar_professorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remover_professorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpar_camposButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(professores_cadastradosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(professores_cadastradosLabel)
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificador_sequencialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeLabel))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpfLabel))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(area_concursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(area_concursoLabel))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inserir_professorButton)
                            .addComponent(consultar_professorButton)
                            .addComponent(alterar_professorButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(remover_professorButton)
                                .addComponent(limpar_camposButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipos_professoresTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirProfessor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirProfessor
        Professor professor = obterProfessorInformado();
        String mensagem_erro = null;
        if (professor != null) {
            mensagem_erro = controlador.inserirProfessor(professor);
        } else {
            mensagem_erro = "Algum atributo do Professor não foi informado";
        }
        if (mensagem_erro == null) {
            int sequencial = Professor.últimoSequencial();
            professor.setSequencial(sequencial);
            modelo_lista_professores.addElement(professor.getVisao());
            professores_cadastradosList.setSelectedIndex(modelo_lista_professores.size() - 1);
            sequencialTextField.setText("" + sequencial);
        } else {
            informarErro(mensagem_erro);
        }

    }//GEN-LAST:event_inserirProfessor

    private void consultarProfessor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarProfessor
        Professor visão = (Professor) professores_cadastradosList.getSelectedValue();
        Professor professor = null;
        String mensagem_erro = null;
        if (visão != null) {
            professor = Professor.buscarProfessor(visão.getSequencial());
            if (professor == null) {
                mensagem_erro = "Professor não cadastrado";
            }
        } else {
            mensagem_erro = "Nenhum Professor selecionado";
        }
        if (mensagem_erro == null) {
            sequencialTextField.setText(professor.getSequencial() + "");
            nomeTextField.setText(professor.getNome());
            cpfTextField.setText(professor.getCpf());
            emailTextField.setText(professor.getEmail());
            area_concursoComboBox.setSelectedItem(professor.getAreaConcurso());
        } else {
            informarErro(mensagem_erro);
        }

        if (professor instanceof ProfessorEfetivo) {
            tipos_professoresTabbedPane.setSelectedIndex(0);
            ProfessorEfetivo professor_efetivo = (ProfessorEfetivo) professor;
            professor_efetivo_Painel.setAfastado(professor_efetivo.isAfastado());
            professor_efetivo_Painel.setAnoAdmissao(professor_efetivo.getAnoAdmissao());
        } else if (professor instanceof ProfessorSubstituto) {
            tipos_professoresTabbedPane.setSelectedIndex(1);
            ProfessorSubstituto professor_substituto = (ProfessorSubstituto) professor;
            professor_substituto_Painel.setSelectedDiaSemana(professor_substituto.getDiaSemana());
            professor_substituto_Painel.setSelectedPeriodo(professor_substituto.getPeriodo().ordinal());
            professor_substituto_Painel.setHorasAula(professor_substituto.getHorasAula());
        } else if (professor instanceof ProfessorConvidado) {
            tipos_professoresTabbedPane.setSelectedIndex(2);
            ProfessorConvidado professor_convidado = (ProfessorConvidado) professor;
            professor_convidado_Painel.setBolsista(professor_convidado.isBolsista());
            professor_convidado_Painel.setNomeProjeto(professor_convidado.getNomeProjeto());
            professor_convidado_Painel.setSelectedAtividade(professor_convidado.getAtividade());
        }


    }//GEN-LAST:event_consultarProfessor

    private void alterarProfessor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarProfessor
        Professor professor = obterProfessorInformado();
        String mensagem_erro = null;
        if (professor != null) {
            mensagem_erro = controlador.alterarProfessor(professor);
        } else {
            mensagem_erro = "Algum atributo do Professor não foi informado";
        }
        if (mensagem_erro == null) {
            Professor visão = (Professor) professores_cadastradosList.getSelectedValue();
            if (visão != null) {
                visão.setCpf(professor.getCpf());
                professores_cadastradosList.updateUI();
            }
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_alterarProfessor

    private void removerProfessor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerProfessor
        Professor visão = (Professor) professores_cadastradosList.getSelectedValue();
        String mensagem_erro = null;
        if (visão != null) {
            mensagem_erro = controlador.removerProfessor(visão.getSequencial());
        } else {
            mensagem_erro = "Nenhum Professor selecionado";
        }
        if (mensagem_erro == null) {
            modelo_lista_professores.removeElement(visão);
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_removerProfessor

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar_professorButton;
    private javax.swing.JComboBox<String> area_concursoComboBox;
    private javax.swing.JLabel area_concursoLabel;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultar_professorButton;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel identificador_sequencialLabel;
    private javax.swing.JButton inserir_professorButton;
    private javax.swing.JButton limpar_camposButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel professores_cadastradosLabel;
    private javax.swing.JList professores_cadastradosList;
    private javax.swing.JScrollPane professores_cadastradosScrollPane;
    private javax.swing.JButton remover_professorButton;
    private javax.swing.JTextField sequencialTextField;
    private javax.swing.JTabbedPane tipos_professoresTabbedPane;
    // End of variables declaration//GEN-END:variables
private void informarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
    }

}
