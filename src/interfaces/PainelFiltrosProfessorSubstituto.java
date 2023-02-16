
package interfaces;

import entidade.ProfessorSubstituto;



public class PainelFiltrosProfessorSubstituto extends javax.swing.JPanel {

    
    public PainelFiltrosProfessorSubstituto() {
        initComponents();
    }

    public ProfessorSubstituto.Periodo getSelectedPeriodo() {
        ProfessorSubstituto.Periodo periodo = null;
        if (periodoButtonGroup.getSelection() != null) {
            periodo = ProfessorSubstituto.Periodo.values()[periodoButtonGroup.getSelection().getMnemonic()];
        }
        return periodo;
    }

    public void limparFiltros() {
        periodoButtonGroup.clearSelection();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        periodoButtonGroup = new javax.swing.ButtonGroup();
        periodoLabel = new javax.swing.JLabel();
        matutinoRadioButton = new javax.swing.JRadioButton();
        vespertinoRadioButton = new javax.swing.JRadioButton();
        noturnoRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        periodoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        periodoLabel.setText("Periodo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 37, 0, 0);
        add(periodoLabel, gridBagConstraints);

        periodoButtonGroup.add(matutinoRadioButton);
        matutinoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matutinoRadioButton.setText("matutino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 6, 7, 0);
        add(matutinoRadioButton, gridBagConstraints);

        periodoButtonGroup.add(vespertinoRadioButton);
        vespertinoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vespertinoRadioButton.setMnemonic('\u0001');
        vespertinoRadioButton.setText("vespertino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        add(vespertinoRadioButton, gridBagConstraints);

        periodoButtonGroup.add(noturnoRadioButton);
        noturnoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noturnoRadioButton.setMnemonic('\u0002');
        noturnoRadioButton.setText("noturno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 2, 7, 53);
        add(noturnoRadioButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton matutinoRadioButton;
    private javax.swing.JRadioButton noturnoRadioButton;
    private javax.swing.ButtonGroup periodoButtonGroup;
    private javax.swing.JLabel periodoLabel;
    private javax.swing.JRadioButton vespertinoRadioButton;
    // End of variables declaration//GEN-END:variables
}
