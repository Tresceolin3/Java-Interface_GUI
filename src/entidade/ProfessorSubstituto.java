package entidade;

public class ProfessorSubstituto extends Professor {

    public enum DiaSemana {
        segunda, terça, quarta, quinta, sexta, sabado;
    }

    public enum Periodo {
        Matutino, Verpertino, Noturno;
    }

    private int horas_aula;
    private DiaSemana dia_semana;
    private Periodo periodo;

    public ProfessorSubstituto(int sequencial, String cpf, String nome, String email, AreaConcurso area_concurso, DiaSemana dia_semana, Periodo periodo,int horas_aula) {
        super(sequencial, cpf, nome, email, area_concurso);
       this.dia_semana = dia_semana;
        this.periodo = periodo;
        this.horas_aula = horas_aula;
    }

    public int getHorasAula() {
        return horas_aula;
    }

    public void setHorasAula(int horas_aula) {
        this.horas_aula = horas_aula;
    }

    public DiaSemana getDiaSemana() {
        return dia_semana;
    }

    public void setDiaSemana(DiaSemana dia_semana) {
        this.dia_semana = dia_semana;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

}
