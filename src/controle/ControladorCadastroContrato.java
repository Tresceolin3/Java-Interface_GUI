package controle;

import entidade.Contrato;
import interfaces.JanelaCadastroContrato;

public class ControladorCadastroContrato {

    public ControladorCadastroContrato() {
        new JanelaCadastroContrato(this).setVisible(true);
    }

    public String inserirContrato(Contrato contrato) {
        if (!Contrato.existeContratoInserir(contrato.getFaculdade().getSigla(), contrato.getProfessor().getSequencial())) {
            return Contrato.inserirContrato(contrato);
        } else {
            return "Contrato ja cadastrado";
        }
    }

    public String alterarContrato(Contrato contrato_info) {
        Contrato contrato_cadastrados = Contrato.buscarContrato(contrato_info.getSequencial());
        if ((contrato_info.getFaculdade().getSigla().equals(contrato_cadastrados.getFaculdade().getSigla()))
                && (contrato_info.getProfessor().getSequencial() == contrato_cadastrados.getProfessor().getSequencial()))  {
            return Contrato.alterarContrato(contrato_info);
        } else {
            return "Alteração não permitida : chave  faculdade/professor foram alteradas";
        }
    }


     public String removerContrato(int sequencial) {
        if (Contrato.existeContrato(sequencial)) {
            return Contrato.removerContrato(sequencial);
        } else {
            return "Sequencial não corresponde a nenhum contrato";
        }
    }



}
