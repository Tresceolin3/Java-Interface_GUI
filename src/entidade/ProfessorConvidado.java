package entidade;

public class ProfessorConvidado extends Professor {

    public enum Atividade{
        pesquisa, extensão, orientação;
    }

    private Atividade atividade;
    private String nome_projeto;
    private boolean bolsista;

     public ProfessorConvidado(int sequencial, String cpf, String nome, String email, AreaConcurso area_concurso,Atividade atividade,String nome_projeto, boolean bolsista) {
        super(sequencial, cpf, nome, email, area_concurso);
        this.atividade = atividade;
        this.nome_projeto = nome_projeto;
        this.bolsista = bolsista ; 
    }
    
    
    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public String getNomeProjeto() {
        return nome_projeto;
    }

    public void setNomeProjeto(String nome_projeto) {
        this.nome_projeto = nome_projeto;
    }

    public boolean isBolsista() {
        return bolsista;
    }

    public void setBolsista(boolean bolsista) {
        this.bolsista = bolsista;
    }

}
