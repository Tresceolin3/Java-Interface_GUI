package controle;

import entidade.Faculdade;
import interfaces.JanelaCadastrarFaculdades;

public class ControladorCadastroFaculdade {

    public ControladorCadastroFaculdade() {
        new JanelaCadastrarFaculdades(this).setVisible(true);
    }

    public String inserirFaculdade(Faculdade faculdade) {
        Faculdade faculdade1 = Faculdade.buscarFaculdade(faculdade.getSigla());
        if (faculdade1 == null) {
            return Faculdade.inserirFaculdade(faculdade);
        } else {
            return "Nome de Faculdade já cadastrado";
        }
    }

    public String alterarFaculdade(Faculdade faculdade) {
        Faculdade faculdade1 = Faculdade.buscarFaculdade(faculdade.getSigla());
        if (faculdade1 != null) {
            return Faculdade.alterarFaculdade(faculdade);
        } else {
            return "Nome de Faculdade não cadastrado";
        }
    }

    public String removerFaculdade(String sigla) {
        Faculdade faculdade1 = Faculdade.buscarFaculdade(sigla);
        if (faculdade1 != null) {
            return Faculdade.removerFaculdade(sigla);
        } else {
            return "Nome de Faculdade não cadastrado";
        }

    }

}
