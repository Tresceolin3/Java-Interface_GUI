package interfaces;

import controle.ControladorCadastroContrato;
import controle.ControladorCadastroProfessor;
import controle.ControladorCadastroFaculdade;
import javax.swing.JOptionPane;
import persistencia.BD;

public class JanelaContrataçãoProfessores extends javax.swing.JFrame {

    public JanelaContrataçãoProfessores() {
        initComponents();
        BD.criaConexao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contratação_professoresMenuBar = new javax.swing.JMenuBar();
        professorMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem cadastrar_professorMenuItem = new javax.swing.JMenuItem();
        pesquisar_professorMenuItem = new javax.swing.JMenuItem();
        FaculdadeMenu = new javax.swing.JMenu();
        cadastrar_faculdadeMenuItem = new javax.swing.JMenuItem();
        pesquisar_faculdadeMenuItem = new javax.swing.JMenuItem();
        contratoMenu = new javax.swing.JMenu();
        cadastrar_contratoMenuItem = new javax.swing.JMenuItem();
        pesquisar_contratoMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contratação Professores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                terminarSistema(evt);
            }
        });

        professorMenu.setText("Professor");

        cadastrar_professorMenuItem.setText("Cadastrar");
        cadastrar_professorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarProfessor(evt);
            }
        });
        professorMenu.add(cadastrar_professorMenuItem);

        pesquisar_professorMenuItem.setText("Pesquisar");
        pesquisar_professorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarProfessor(evt);
            }
        });
        professorMenu.add(pesquisar_professorMenuItem);

        contratação_professoresMenuBar.add(professorMenu);

        FaculdadeMenu.setText("Faculdade");
        FaculdadeMenu.setToolTipText("");

        cadastrar_faculdadeMenuItem.setText("Cadastrar");
        cadastrar_faculdadeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFaculdade(evt);
            }
        });
        FaculdadeMenu.add(cadastrar_faculdadeMenuItem);

        pesquisar_faculdadeMenuItem.setText("Pesquisar");
        pesquisar_faculdadeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFaculdade(evt);
            }
        });
        FaculdadeMenu.add(pesquisar_faculdadeMenuItem);

        contratação_professoresMenuBar.add(FaculdadeMenu);

        contratoMenu.setText("Contrato");
        contratoMenu.setToolTipText("");

        cadastrar_contratoMenuItem.setText("Cadastrar");
        cadastrar_contratoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarContrato(evt);
            }
        });
        contratoMenu.add(cadastrar_contratoMenuItem);

        pesquisar_contratoMenuItem.setText("Pesquisar");
        pesquisar_contratoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarContrato(evt);
            }
        });
        contratoMenu.add(pesquisar_contratoMenuItem);

        contratação_professoresMenuBar.add(contratoMenu);

        setJMenuBar(contratação_professoresMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarProfessor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarProfessor
        new ControladorCadastroProfessor();
    }//GEN-LAST:event_cadastrarProfessor

    private void terminarSistema(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_terminarSistema
        BD.fechaConexao();
        System.exit(0);
    }//GEN-LAST:event_terminarSistema

    private void pesquisarFaculdade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFaculdade
        informarServiçoIndisponível();
    }//GEN-LAST:event_pesquisarFaculdade

    private void cadastrarFaculdade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFaculdade
        new ControladorCadastroFaculdade();
    }//GEN-LAST:event_cadastrarFaculdade

    private void pesquisarProfessor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarProfessor
        informarServiçoIndisponível();
    }//GEN-LAST:event_pesquisarProfessor

    private void cadastrarContrato(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarContrato
        new ControladorCadastroContrato();
    }//GEN-LAST:event_cadastrarContrato

    private void pesquisarContrato(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarContrato
         new JanelaPesquisaContrato().setVisible(true);
    }//GEN-LAST:event_pesquisarContrato
    private void informarServiçoIndisponível() {
        JOptionPane.showMessageDialog(this, "Serviço Indisponível", "Informação",
                 JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaContrataçãoProfessores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu FaculdadeMenu;
    private javax.swing.JMenuItem cadastrar_contratoMenuItem;
    private javax.swing.JMenuItem cadastrar_faculdadeMenuItem;
    private javax.swing.JMenuBar contratação_professoresMenuBar;
    private javax.swing.JMenu contratoMenu;
    private javax.swing.JMenuItem pesquisar_contratoMenuItem;
    private javax.swing.JMenuItem pesquisar_faculdadeMenuItem;
    private javax.swing.JMenuItem pesquisar_professorMenuItem;
    private javax.swing.JMenu professorMenu;
    // End of variables declaration//GEN-END:variables
}
