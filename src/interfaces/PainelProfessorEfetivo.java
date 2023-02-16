package interfaces;

public class PainelProfessorEfetivo extends javax.swing.JPanel {

    public PainelProfessorEfetivo() {
        initComponents();
        limparCampos();
    }

    public boolean isAfastado() {
        return afastadoCheckBox.isSelected();
    }

    public void setAfastado(boolean asfastado) {
        afastadoCheckBox.setSelected(asfastado);
    }

    
    public String getAnoAdmissao(){
        String ano_admissao = ano_admissaoTextField.getText();
        if (ano_admissao.isEmpty()) return null;
        else return ano_admissao;
    }
    
    public void setAnoAdmissao(String ano_admissao){
        ano_admissaoTextField.setText(ano_admissao);
    }
     
    public void limparCampos() {
        afastadoCheckBox.setSelected(false);
        ano_admissaoTextField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        afastadoCheckBox = new javax.swing.JCheckBox();
        ano_admissao_projetoLabel = new javax.swing.JLabel();
        ano_admissaoTextField = new javax.swing.JTextField();

        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(400, 300));

        afastadoCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        afastadoCheckBox.setText("Afastado");

        ano_admissao_projetoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano_admissao_projetoLabel.setText("Ano Admissão");
        ano_admissao_projetoLabel.setToolTipText("");

        ano_admissaoTextField.setColumns(30);
        ano_admissaoTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(afastadoCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(ano_admissao_projetoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ano_admissaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(afastadoCheckBox)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ano_admissao_projetoLabel)
                    .addComponent(ano_admissaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(213, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox afastadoCheckBox;
    private javax.swing.JTextField ano_admissaoTextField;
    private javax.swing.JLabel ano_admissao_projetoLabel;
    // End of variables declaration//GEN-END:variables

   
}
