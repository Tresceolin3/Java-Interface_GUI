
package interfaces;

import entidade.Contrato;
import entidade.Contrato.Modalidade;
import entidade.Contrato.ModeloContrato;
import entidade.Faculdade;
import entidade.Faculdade.Tipo;
import entidade.Professor;
import entidade.Professor.AreaConcurso;
import entidade.ProfessorSubstituto.Periodo;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class JanelaPesquisaContrato extends javax.swing.JFrame {
        Faculdade[] faculdades_cadastradas;
        Professor[] professores_cadastrados;
        PainelFiltrosProfessorSubstituto filtros_professor_substitutoPainel;
        PainelFiltrosProfessorEfetivo filtros_professor_efetivoPainel;
        PainelFiltrosProfessorConvidado filtros_professor_convidadoPainel;
   
    public JanelaPesquisaContrato() {
        faculdades_cadastradas = Faculdade.getVisões();
        professores_cadastrados = Professor.getVisões();
        initComponents();
        filtros_professor_efetivoPainel = new PainelFiltrosProfessorEfetivo();
        filtros_professor_substitutoPainel = new PainelFiltrosProfessorSubstituto();
        filtros_professor_convidadoPainel =  new PainelFiltrosProfessorConvidado();
        filtros_especificos_professoresTabbedPane.addTab("Filtros de professores efetivos",
                filtros_professor_efetivoPainel);
        filtros_especificos_professoresTabbedPane.addTab("Filtros de professores substitutos",
                filtros_professor_substitutoPainel);
        filtros_especificos_professoresTabbedPane.addTab("Filtros de professores convidados",
                filtros_professor_convidadoPainel);
        limparFiltros(null);
    }

     private Timestamp getDataMinima() {
        Timestamp data_minima = null;
        String data_minima_str = data_minimaTextField.getText();
        if (!data_minima_str.isEmpty()) {
            String[] data_minima_partes = data_minima_str.toString().split("/");
            String dia = data_minima_partes[0];
            String mes = data_minima_partes[1];
            String ano = data_minima_partes[2];
            if ((dia.length() == 2) && (mes.length() == 2) && (ano.length() == 4)) {
                data_minima_str = ano + "-" + mes + "-" + dia + " 00:00:00";
                data_minima = Timestamp.valueOf(data_minima_str);
            }
        }
        return data_minima;
    }
    
     private void mostrarContratosSelecionados(ArrayList<Contrato> contratos) {
         boolean contrato1 = true;
         for (Contrato contrato : contratos) {
            if (contrato1) {
                pesquisasTextArea.append(contrato.toStringFull());
                contrato1 = false;
            } else {
                pesquisasTextArea.append("\n" + contrato.toStringFull());
            }
        }
    }
     
    public static String formatarDataHora(String data_hora_bd) {
        String[] data_hora = data_hora_bd.split(" ");
        String[] ano_mes_dia = data_hora[0].split("-");
        String[] hora_minuto_resto = data_hora[1].split(":");
        String data_hora_formatada = ano_mes_dia[2] + "/" + ano_mes_dia[1] + "/" + ano_mes_dia[0] + " " + hora_minuto_resto[0] + ":" + hora_minuto_resto[1] + "hs";
        return data_hora_formatada;
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        modalidade_faculdadesButtonGroup = new javax.swing.ButtonGroup();
        tipoButtonGroup = new javax.swing.ButtonGroup();
        modalidade_contratosButtonGroup = new javax.swing.ButtonGroup();
        filtros_faculdadejPanel = new javax.swing.JPanel();
        faculdades_cadastradasLabel = new javax.swing.JLabel();
        faculdades_cadastradasComboBox = new javax.swing.JComboBox();
        modalidadeLabel = new javax.swing.JLabel();
        eadRadioButton = new javax.swing.JRadioButton();
        presencialRadioButton = new javax.swing.JRadioButton();
        TipoLabel = new javax.swing.JLabel();
        exatasRadioButton = new javax.swing.JRadioButton();
        humanasRadioButton = new javax.swing.JRadioButton();
        engenhariasRadioButton = new javax.swing.JRadioButton();
        medicinasRadioButton = new javax.swing.JRadioButton();
        filtros_professorjPanel = new javax.swing.JPanel();
        professores_cadastradosLabel = new javax.swing.JLabel();
        professores_cadastradosComboBox = new javax.swing.JComboBox();
        area_concursoLabel = new javax.swing.JLabel();
        area_concursoComboBox = new javax.swing.JComboBox<>();
        filtros_especificos_professoresTabbedPane = new javax.swing.JTabbedPane();
        filtros_contratosjPanel = new javax.swing.JPanel();
        modelo_contratoLabel = new javax.swing.JLabel();
        modelo_contratoComboBox = new javax.swing.JComboBox<>();
        modalidade_contratoLabel = new javax.swing.JLabel();
        pjRadioButton = new javax.swing.JRadioButton();
        cltRadioButton = new javax.swing.JRadioButton();
        data_minimaLabel = new javax.swing.JLabel();
        data_minimaTextField = new javax.swing.JTextField();
        contratos_selecionadosPanel = new javax.swing.JPanel();
        contratos_selecionadosjScrollPane = new javax.swing.JScrollPane();
        pesquisasTextArea = new javax.swing.JTextArea();
        botaoPanel = new javax.swing.JPanel();
        pesquisar_contratoButton = new javax.swing.JButton();
        limpar_contrato_filtrosButton = new javax.swing.JButton();
        limpar_pesquisaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Contrato");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        filtros_faculdadejPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros Faculdades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        filtros_faculdadejPanel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        faculdades_cadastradasLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faculdades_cadastradasLabel.setText("Faculdades Cadastradas");
        faculdades_cadastradasLabel.setToolTipText("");

        faculdades_cadastradasComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faculdades_cadastradasComboBox.setModel(new DefaultComboBoxModel(faculdades_cadastradas));

        modalidadeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modalidadeLabel.setText("Modalidade");

        modalidade_faculdadesButtonGroup.add(eadRadioButton);
        eadRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eadRadioButton.setMnemonic('E');
        eadRadioButton.setText("Ead");

        modalidade_faculdadesButtonGroup.add(presencialRadioButton);
        presencialRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        presencialRadioButton.setMnemonic('p');
        presencialRadioButton.setText("presencial");

        TipoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TipoLabel.setText("Tipo");

        tipoButtonGroup.add(exatasRadioButton);
        exatasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exatasRadioButton.setText("exatas");

        tipoButtonGroup.add(humanasRadioButton);
        humanasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        humanasRadioButton.setMnemonic('\u0001');
        humanasRadioButton.setText("humanas");

        tipoButtonGroup.add(engenhariasRadioButton);
        engenhariasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        engenhariasRadioButton.setMnemonic('\u0002');
        engenhariasRadioButton.setText("engenharias");

        tipoButtonGroup.add(medicinasRadioButton);
        medicinasRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        medicinasRadioButton.setMnemonic('\u0003');
        medicinasRadioButton.setText("medicinas");

        javax.swing.GroupLayout filtros_faculdadejPanelLayout = new javax.swing.GroupLayout(filtros_faculdadejPanel);
        filtros_faculdadejPanel.setLayout(filtros_faculdadejPanelLayout);
        filtros_faculdadejPanelLayout.setHorizontalGroup(
            filtros_faculdadejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_faculdadejPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(faculdades_cadastradasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(faculdades_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modalidadeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eadRadioButton)
                .addGap(5, 5, 5)
                .addComponent(presencialRadioButton)
                .addGap(30, 30, 30)
                .addComponent(TipoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exatasRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(humanasRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(engenhariasRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medicinasRadioButton))
        );
        filtros_faculdadejPanelLayout.setVerticalGroup(
            filtros_faculdadejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_faculdadejPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtros_faculdadejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(filtros_faculdadejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(filtros_faculdadejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eadRadioButton)
                            .addComponent(modalidadeLabel))
                        .addComponent(presencialRadioButton)
                        .addGroup(filtros_faculdadejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(humanasRadioButton)
                            .addComponent(exatasRadioButton)
                            .addComponent(engenhariasRadioButton)
                            .addComponent(medicinasRadioButton)
                            .addComponent(TipoLabel)))
                    .addGroup(filtros_faculdadejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(faculdades_cadastradasLabel)
                        .addComponent(faculdades_cadastradasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 37, 0, 10);
        getContentPane().add(filtros_faculdadejPanel, gridBagConstraints);

        filtros_professorjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros Professores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        filtros_professorjPanel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        professores_cadastradosLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        professores_cadastradosLabel.setText("Professores Cadastrados");
        professores_cadastradosLabel.setToolTipText("");

        professores_cadastradosComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        professores_cadastradosComboBox.setModel(new DefaultComboBoxModel(professores_cadastrados));

        area_concursoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        area_concursoLabel.setText("Area Concurso");

        area_concursoComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        area_concursoComboBox.setModel(new DefaultComboBoxModel(AreaConcurso.values()));

        filtros_especificos_professoresTabbedPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros Especificos Professores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        filtros_especificos_professoresTabbedPane.setPreferredSize(new java.awt.Dimension(600, 200));

        javax.swing.GroupLayout filtros_professorjPanelLayout = new javax.swing.GroupLayout(filtros_professorjPanel);
        filtros_professorjPanel.setLayout(filtros_professorjPanelLayout);
        filtros_professorjPanelLayout.setHorizontalGroup(
            filtros_professorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_professorjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(professores_cadastradosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(professores_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(area_concursoLabel)
                .addGap(18, 18, 18)
                .addComponent(area_concursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filtros_especificos_professoresTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addContainerGap())
        );
        filtros_professorjPanelLayout.setVerticalGroup(
            filtros_professorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_professorjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtros_professorjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(professores_cadastradosLabel)
                    .addComponent(professores_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area_concursoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area_concursoLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(filtros_especificos_professoresTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 422;
        gridBagConstraints.ipady = 157;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 37, 0, 10);
        getContentPane().add(filtros_professorjPanel, gridBagConstraints);

        filtros_contratosjPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros Contratos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        modelo_contratoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modelo_contratoLabel.setText("Modelo Contrato");

        modelo_contratoComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modelo_contratoComboBox.setModel(new DefaultComboBoxModel (ModeloContrato.values()));

        modalidade_contratoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modalidade_contratoLabel.setText("Modalidade");

        modalidade_contratosButtonGroup.add(pjRadioButton);
        pjRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pjRadioButton.setText("PJ");

        modalidade_contratosButtonGroup.add(cltRadioButton);
        cltRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cltRadioButton.setMnemonic('\u0001');
        cltRadioButton.setText("CLT");

        data_minimaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        data_minimaLabel.setText("Data Minima");

        data_minimaTextField.setColumns(50);
        data_minimaTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout filtros_contratosjPanelLayout = new javax.swing.GroupLayout(filtros_contratosjPanel);
        filtros_contratosjPanel.setLayout(filtros_contratosjPanelLayout);
        filtros_contratosjPanelLayout.setHorizontalGroup(
            filtros_contratosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_contratosjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modelo_contratoLabel)
                .addGap(18, 18, 18)
                .addComponent(modelo_contratoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(modalidade_contratoLabel)
                .addGap(18, 18, 18)
                .addComponent(pjRadioButton)
                .addGap(10, 10, 10)
                .addComponent(cltRadioButton)
                .addGap(37, 37, 37)
                .addComponent(data_minimaLabel)
                .addGap(18, 18, 18)
                .addComponent(data_minimaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        filtros_contratosjPanelLayout.setVerticalGroup(
            filtros_contratosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_contratosjPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtros_contratosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtros_contratosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modelo_contratoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modelo_contratoLabel))
                    .addGroup(filtros_contratosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cltRadioButton)
                        .addComponent(pjRadioButton)
                        .addComponent(modalidade_contratoLabel))
                    .addGroup(filtros_contratosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(data_minimaLabel)
                        .addComponent(data_minimaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 37, 0, 0);
        getContentPane().add(filtros_contratosjPanel, gridBagConstraints);

        contratos_selecionadosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contratos Selecionados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        contratos_selecionadosjScrollPane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        pesquisasTextArea.setEditable(false);
        pesquisasTextArea.setColumns(20);
        pesquisasTextArea.setRows(5);
        contratos_selecionadosjScrollPane.setViewportView(pesquisasTextArea);

        javax.swing.GroupLayout contratos_selecionadosPanelLayout = new javax.swing.GroupLayout(contratos_selecionadosPanel);
        contratos_selecionadosPanel.setLayout(contratos_selecionadosPanelLayout);
        contratos_selecionadosPanelLayout.setHorizontalGroup(
            contratos_selecionadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contratos_selecionadosjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );
        contratos_selecionadosPanelLayout.setVerticalGroup(
            contratos_selecionadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contratos_selecionadosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 749;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 37, 0, 0);
        getContentPane().add(contratos_selecionadosPanel, gridBagConstraints);

        pesquisar_contratoButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pesquisar_contratoButton.setText("Pesquisar");
        pesquisar_contratoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarContrato(evt);
            }
        });

        limpar_contrato_filtrosButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        limpar_contrato_filtrosButton.setText("Limpar Filtros");
        limpar_contrato_filtrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFiltros(evt);
            }
        });

        limpar_pesquisaButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        limpar_pesquisaButton.setText("LimparPesquisa");
        limpar_pesquisaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparPesquisaSelecionada(evt);
            }
        });

        javax.swing.GroupLayout botaoPanelLayout = new javax.swing.GroupLayout(botaoPanel);
        botaoPanel.setLayout(botaoPanelLayout);
        botaoPanelLayout.setHorizontalGroup(
            botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botaoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pesquisar_contratoButton)
                .addGap(18, 18, 18)
                .addComponent(limpar_contrato_filtrosButton)
                .addGap(18, 18, 18)
                .addComponent(limpar_pesquisaButton)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        botaoPanelLayout.setVerticalGroup(
            botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botaoPanelLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisar_contratoButton)
                    .addComponent(limpar_contrato_filtrosButton)
                    .addComponent(limpar_pesquisaButton)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(81, 226, 0, 0);
        getContentPane().add(botaoPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarContrato(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarContrato
        String chave_faculdade = null;
        if (faculdades_cadastradasComboBox.getSelectedItem() != null) {
            chave_faculdade = ((Faculdade) faculdades_cadastradasComboBox.getSelectedItem()).getSigla();
        }
        int chave_professor = -1;
        if (professores_cadastradosComboBox.getSelectedItem() != null) {
            chave_professor = ((Professor) professores_cadastradosComboBox.getSelectedItem()).getSequencial();
        }
        char modalidade_faculdade = 'X';
        if (modalidade_faculdadesButtonGroup.getSelection() != null) {
            modalidade_faculdade = (char) modalidade_faculdadesButtonGroup.getSelection().getMnemonic();
        }
        Tipo tipo_faculdade = null;
        if (tipoButtonGroup.getSelection() != null) {
            tipo_faculdade = Tipo.values()[tipoButtonGroup.getSelection().getMnemonic()];
        }
        AreaConcurso area_concurso_professor = null;
        if (area_concursoComboBox.getSelectedItem() != null) {
            area_concurso_professor = (AreaConcurso) area_concursoComboBox.getSelectedItem();
        }
        
        char afastado_professor_efetivo = 'X';
        char bolsista_professor_convidado = 'X';
        Periodo periodo_professor_substituto = null;
        int indice_aba_selecionada = filtros_especificos_professoresTabbedPane.getSelectedIndex();
        if (indice_aba_selecionada == 0) {
            afastado_professor_efetivo = filtros_professor_efetivoPainel.getAfastado();
        }else if(indice_aba_selecionada == 1){
            bolsista_professor_convidado = filtros_professor_convidadoPainel.getBolsita();
        }else if (indice_aba_selecionada == 2) {
            periodo_professor_substituto = filtros_professor_substitutoPainel.getSelectedPeriodo();
        }
        ModeloContrato modelo_contrato = (ModeloContrato) modelo_contratoComboBox.getSelectedItem();
        Modalidade modalidade = null;
        if (modalidade_contratosButtonGroup.getSelection() != null) {
            modalidade = Modalidade.values()[modalidade_contratosButtonGroup.getSelection().getMnemonic()];
        }
        Timestamp data_minima = getDataMinima();
        ArrayList<Contrato> contratos = Contrato.pesquisarContratos(chave_faculdade, chave_professor,
            modalidade_faculdade, tipo_faculdade, area_concurso_professor,afastado_professor_efetivo,bolsista_professor_convidado
                ,periodo_professor_substituto,modelo_contrato, modalidade, data_minima);
        mostrarContratosSelecionados(contratos);
    }//GEN-LAST:event_pesquisarContrato

    private void limparFiltros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFiltros
        faculdades_cadastradasComboBox.setSelectedIndex(-1);
        professores_cadastradosComboBox.setSelectedIndex(-1);
        modalidade_faculdadesButtonGroup.clearSelection();
        tipoButtonGroup.clearSelection();
        area_concursoComboBox.setSelectedIndex(-1);
        modelo_contratoComboBox.setSelectedIndex(-1);
        modalidade_contratosButtonGroup.clearSelection();
        data_minimaTextField.setText("");
        filtros_professor_efetivoPainel.limparFiltros();
        filtros_professor_convidadoPainel.limparFiltros();
        filtros_professor_substitutoPainel.limparFiltros();
    }//GEN-LAST:event_limparFiltros

    private void limparPesquisaSelecionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparPesquisaSelecionada
        pesquisasTextArea.setText("");
    }//GEN-LAST:event_limparPesquisaSelecionada

    public static void main(String args[]) {
    
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPesquisaContrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TipoLabel;
    private javax.swing.JComboBox<String> area_concursoComboBox;
    private javax.swing.JLabel area_concursoLabel;
    private javax.swing.JPanel botaoPanel;
    private javax.swing.JRadioButton cltRadioButton;
    private javax.swing.JPanel contratos_selecionadosPanel;
    private javax.swing.JScrollPane contratos_selecionadosjScrollPane;
    private javax.swing.JLabel data_minimaLabel;
    private javax.swing.JTextField data_minimaTextField;
    private javax.swing.JRadioButton eadRadioButton;
    private javax.swing.JRadioButton engenhariasRadioButton;
    private javax.swing.JRadioButton exatasRadioButton;
    private javax.swing.JComboBox faculdades_cadastradasComboBox;
    private javax.swing.JLabel faculdades_cadastradasLabel;
    private javax.swing.JPanel filtros_contratosjPanel;
    private javax.swing.JTabbedPane filtros_especificos_professoresTabbedPane;
    private javax.swing.JPanel filtros_faculdadejPanel;
    private javax.swing.JPanel filtros_professorjPanel;
    private javax.swing.JRadioButton humanasRadioButton;
    private javax.swing.JButton limpar_contrato_filtrosButton;
    private javax.swing.JButton limpar_pesquisaButton;
    private javax.swing.JRadioButton medicinasRadioButton;
    private javax.swing.JLabel modalidadeLabel;
    private javax.swing.JLabel modalidade_contratoLabel;
    private javax.swing.ButtonGroup modalidade_contratosButtonGroup;
    private javax.swing.ButtonGroup modalidade_faculdadesButtonGroup;
    private javax.swing.JComboBox<String> modelo_contratoComboBox;
    private javax.swing.JLabel modelo_contratoLabel;
    private javax.swing.JButton pesquisar_contratoButton;
    private javax.swing.JTextArea pesquisasTextArea;
    private javax.swing.JRadioButton pjRadioButton;
    private javax.swing.JRadioButton presencialRadioButton;
    private javax.swing.JComboBox professores_cadastradosComboBox;
    private javax.swing.JLabel professores_cadastradosLabel;
    private javax.swing.ButtonGroup tipoButtonGroup;
    // End of variables declaration//GEN-END:variables

   
}
