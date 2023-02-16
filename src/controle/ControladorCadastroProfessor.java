package controle;

import entidade.Professor;
import interfaces.JanelaCadastroProfessores;

public class ControladorCadastroProfessor {

    public ControladorCadastroProfessor() {
        new JanelaCadastroProfessores(this).setVisible(true);
    }

    public String inserirProfessor(Professor professor) {
        if (!Professor.existeProfessorMesmosAtributos(professor)) {
            return Professor.inserirProfessor(professor);
        } else {
            return "Já existe um Professor com os mesmos atributos";
        }
    }

    public String alterarProfessor(Professor professor) {
        Professor professor1 = Professor.buscarProfessor(professor.getSequencial());
        if (professor1 != null) {
            return Professor.alterarProfessor(professor);
        } else {
            return "Sequencial do Professor não cadastrado";
        }
    }

    public String removerProfessor(int sequencial) {
        Professor professor1 = Professor.buscarProfessor(sequencial);
        if (professor1 != null) {
            return Professor.removerProfessor(professor1);
        } else {
            return "Sequencial do Professor não cadastrado";
        }
    }

}
