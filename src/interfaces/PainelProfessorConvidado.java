
package interfaces;

import entidade.ProfessorConvidado.Atividade;
import javax.swing.DefaultComboBoxModel;

public class PainelProfessorConvidado extends javax.swing.JPanel {

   
    public PainelProfessorConvidado() {
        initComponents();
        limparCampos();
    }

     public boolean isBolsista() {
        return bolsistaCheckBox.isSelected();
    }

    public void setBolsista(boolean bolsista) {
        bolsistaCheckBox.setSelected(bolsista);
    }
    
      public String getNomeProjeto() {
        String nome_projeto = nome_projetoTextField.getText();
        if (nome_projeto.isEmpty()) {
            return null;
        } else {
            return nome_projeto;
        }
    }
        public void setNomeProjeto(String nome_projeto) {
        nome_projetoTextField.setText(nome_projeto + "");
    }
    
    public Atividade getSelectedAtividade() {
        Object atividade = atividadeComboBox.getSelectedItem();
        if (atividade != null) {
            return (Atividade) atividade;
        } else {
            return null;
        }
    }

    public void setSelectedAtividade(Atividade atividade) {
        atividadeComboBox.setSelectedItem(atividade);
    }
        
    
    public void limparCampos() {
        bolsistaCheckBox.setSelected(false);
        nome_projetoTextField.setText("");
        atividadeComboBox.setSelectedIndex(-1);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bolsistaCheckBox = new javax.swing.JCheckBox();
        nome_projetoLabel = new javax.swing.JLabel();
        nome_projetoTextField = new javax.swing.JTextField();
        atividadeLabel = new javax.swing.JLabel();
        atividadeComboBox = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(400, 300));

        bolsistaCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bolsistaCheckBox.setText("Bolsista");

        nome_projetoLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nome_projetoLabel.setText("Nome Projeto");

        nome_projetoTextField.setColumns(30);
        nome_projetoTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        atividadeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        atividadeLabel.setText("Atividade");

        atividadeComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        atividadeComboBox.setModel(new DefaultComboBoxModel(Atividade.values()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(bolsistaCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nome_projetoLabel)
                    .addComponent(atividadeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atividadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome_projetoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(bolsistaCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome_projetoLabel)
                    .addComponent(nome_projetoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atividadeLabel)
                    .addComponent(atividadeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> atividadeComboBox;
    private javax.swing.JLabel atividadeLabel;
    private javax.swing.JCheckBox bolsistaCheckBox;
    private javax.swing.JLabel nome_projetoLabel;
    private javax.swing.JTextField nome_projetoTextField;
    // End of variables declaration//GEN-END:variables
}
