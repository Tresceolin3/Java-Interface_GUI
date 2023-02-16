
package interfaces;


public class PainelFiltrosProfessorConvidado extends javax.swing.JPanel {

    
    public PainelFiltrosProfessorConvidado() {
        initComponents();
        limparFiltros();
    }
    
    public char getBolsita(){
        char bolsista = 'X';
        if(bolsistaButtonGroup.getSelection() != null){
            switch(bolsistaButtonGroup.getSelection().getMnemonic()){
                case 0 : bolsista = 'T'; break;
                case 1 : bolsista = 'F';
            }
        }
        return bolsista;
    }
    
    public void limparFiltros(){
        bolsistaButtonGroup.clearSelection();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bolsistaButtonGroup = new javax.swing.ButtonGroup();
        bolsistaLabel = new javax.swing.JLabel();
        simRadioButton = new javax.swing.JRadioButton();
        naoRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        bolsistaLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bolsistaLabel.setText("Bolsista");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 72, 0, 0);
        add(bolsistaLabel, gridBagConstraints);

        bolsistaButtonGroup.add(simRadioButton);
        simRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        simRadioButton.setText("sim");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 24, 22, 0);
        add(simRadioButton, gridBagConstraints);

        bolsistaButtonGroup.add(naoRadioButton);
        naoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        naoRadioButton.setMnemonic('\u0001');
        naoRadioButton.setText("não");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 26, 22, 84);
        add(naoRadioButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bolsistaButtonGroup;
    private javax.swing.JLabel bolsistaLabel;
    private javax.swing.JRadioButton naoRadioButton;
    private javax.swing.JRadioButton simRadioButton;
    // End of variables declaration//GEN-END:variables
}
