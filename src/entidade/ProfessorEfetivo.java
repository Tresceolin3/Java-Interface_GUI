package entidade;

public class ProfessorEfetivo extends Professor {

    private boolean afastado;
    private String ano_admissao;

    public ProfessorEfetivo(int sequencial, String cpf, String nome, String email, AreaConcurso area_concurso, boolean afastado, String ano_admissao) {
        super(sequencial, cpf, nome, email, area_concurso);
        this.afastado = afastado;
        this.ano_admissao = ano_admissao;
    }

    public boolean isAfastado() {
        return afastado;
    }

    public void setAfastado(boolean afastado) {
        this.afastado = afastado;
    }

    public String getAnoAdmissao() {
        return ano_admissao;
    }

    public void setAnoAdmissao(String ano_admissao) {
        this.ano_admissao = ano_admissao;
    }

}
