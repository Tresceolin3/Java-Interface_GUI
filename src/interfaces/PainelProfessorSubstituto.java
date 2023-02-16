package interfaces;

import entidade.ProfessorSubstituto.DiaSemana;
import entidade.ProfessorSubstituto.Periodo;
import javax.swing.DefaultComboBoxModel;

public class PainelProfessorSubstituto extends javax.swing.JPanel {

    public PainelProfessorSubstituto() {
        initComponents();
        limparCampos();
    }

    public DiaSemana getSelectedDiaSemana() {
        Object dia_semana = dia_semanaComboBox.getSelectedItem();
        if (dia_semana != null) {
            return (DiaSemana) dia_semana;
        } else {
            return null;
        }
    }

    public void setSelectedDiaSemana(DiaSemana dia_semana) {
        dia_semanaComboBox.setSelectedItem(dia_semana);
    }

    public Periodo getSelectedPeriodo() {
        Periodo periodo = null;
        if (periodoButtonGroup.getSelection() != null) {
            periodo = Periodo.values()[periodoButtonGroup.getSelection().getMnemonic()];
        }
        return periodo;
    }

    public void setSelectedPeriodo(int indice_periodo) {
        switch (indice_periodo) {
            case 0:
                matutinoRadioButton.setSelected(true);break;
            case 1:
                vespertinoRadioButton.setSelected(true);break;
            case 2:
                noturnoRadioButton.setSelected(true);
        }
    }

    public int getHorasAula() {
        String horas_aula = horas_aulaTextField.getText();
        if (!horas_aula.isEmpty()) {
            return Integer.parseInt(horas_aula);
        } else {
            return -1;
        }
    }

    public void setHorasAula(int horas_aula) {
        horas_aulaTextField.setText(horas_aula + "");

    }

    public void limparCampos() {
        dia_semanaComboBox.setSelectedIndex(-1);
        periodoButtonGroup.clearSelection();
        horas_aulaTextField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        periodoButtonGroup = new javax.swing.ButtonGroup();
        dia_semanaLabel = new javax.swing.JLabel();
        PeriodoLabel = new javax.swing.JLabel();
        horas_aulaLabel = new javax.swing.JLabel();
        dia_semanaComboBox = new javax.swing.JComboBox<>();
        periodoPanel = new javax.swing.JPanel();
        horas_aulaTextField = new javax.swing.JTextField();
        matutinoRadioButton = new javax.swing.JRadioButton();
        vespertinoRadioButton = new javax.swing.JRadioButton();
        noturnoRadioButton = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(360, 149));

        dia_semanaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dia_semanaLabel.setText("Dia Semana");

        PeriodoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PeriodoLabel.setText("Periodo");

        horas_aulaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        horas_aulaLabel.setText("Horas Aula");

        dia_semanaComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dia_semanaComboBox.setModel(new DefaultComboBoxModel (DiaSemana.values()));

        periodoPanel.setPreferredSize(new java.awt.Dimension(113, 33));

        javax.swing.GroupLayout periodoPanelLayout = new javax.swing.GroupLayout(periodoPanel);
        periodoPanel.setLayout(periodoPanelLayout);
        periodoPanelLayout.setHorizontalGroup(
            periodoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        periodoPanelLayout.setVerticalGroup(
            periodoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        horas_aulaTextField.setColumns(30);
        horas_aulaTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        periodoButtonGroup.add(matutinoRadioButton);
        matutinoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matutinoRadioButton.setText("Matutino");
        matutinoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matutinoRadioButtonActionPerformed(evt);
            }
        });

        periodoButtonGroup.add(vespertinoRadioButton);
        vespertinoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vespertinoRadioButton.setMnemonic('\u0001');
        vespertinoRadioButton.setText("Vespertino");
        vespertinoRadioButton.setToolTipText("");

        periodoButtonGroup.add(noturnoRadioButton);
        noturnoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noturnoRadioButton.setMnemonic('\u0002');
        noturnoRadioButton.setText("Noturno");
        noturnoRadioButton.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PeriodoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(matutinoRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(vespertinoRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noturnoRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dia_semanaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(dia_semanaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(horas_aulaLabel)
                        .addGap(31, 31, 31)
                        .addComponent(horas_aulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(periodoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dia_semanaLabel)
                    .addComponent(dia_semanaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PeriodoLabel)
                    .addComponent(matutinoRadioButton)
                    .addComponent(vespertinoRadioButton)
                    .addComponent(noturnoRadioButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horas_aulaLabel)
                            .addComponent(horas_aulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(periodoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void matutinoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matutinoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matutinoRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PeriodoLabel;
    private javax.swing.JComboBox<String> dia_semanaComboBox;
    private javax.swing.JLabel dia_semanaLabel;
    private javax.swing.JLabel horas_aulaLabel;
    private javax.swing.JTextField horas_aulaTextField;
    private javax.swing.JRadioButton matutinoRadioButton;
    private javax.swing.JRadioButton noturnoRadioButton;
    private javax.swing.ButtonGroup periodoButtonGroup;
    private javax.swing.JPanel periodoPanel;
    private javax.swing.JRadioButton vespertinoRadioButton;
    // End of variables declaration//GEN-END:variables

}
