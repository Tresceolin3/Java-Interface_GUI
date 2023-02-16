
package interfaces;


public class PainelFiltrosProfessorEfetivo extends javax.swing.JPanel {

    
    public PainelFiltrosProfessorEfetivo() {
        initComponents();
        limparFiltros();
    }
    
    public char getAfastado(){
        char afastado = 'X';
        if(afastadoButtonGroup.getSelection() != null){
            switch(afastadoButtonGroup.getSelection().getMnemonic()){
                case 0 : afastado = 'T'; break;
                case 1 : afastado = 'F';
            }
        }
        return afastado;
    }
    
    public void limparFiltros(){
        afastadoButtonGroup.clearSelection();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        afastadoButtonGroup = new javax.swing.ButtonGroup();
        afastadoLabel = new javax.swing.JLabel();
        simRadioButton = new javax.swing.JRadioButton();
        naoRadioButton = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(400, 300));
        setLayout(new java.awt.GridBagLayout());

        afastadoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        afastadoLabel.setText("Afastado");
        add(afastadoLabel, new java.awt.GridBagConstraints());

        afastadoButtonGroup.add(simRadioButton);
        simRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        simRadioButton.setText("sim");
        add(simRadioButton, new java.awt.GridBagConstraints());

        afastadoButtonGroup.add(naoRadioButton);
        naoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        naoRadioButton.setMnemonic('\u0001');
        naoRadioButton.setText("não");
        add(naoRadioButton, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup afastadoButtonGroup;
    private javax.swing.JLabel afastadoLabel;
    private javax.swing.JRadioButton naoRadioButton;
    private javax.swing.JRadioButton simRadioButton;
    // End of variables declaration//GEN-END:variables
}
