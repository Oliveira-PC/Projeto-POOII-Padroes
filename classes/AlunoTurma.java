package classes;

public class AlunoTurma implements NotaObserver {
    private Aluno aluno;
    private Nota nota;
    private Semestre semestre;

    public AlunoTurma(){}
    
    public AlunoTurma(Aluno aluno, Semestre semestre){
        this.aluno = aluno;
        this.semestre = semestre;
        this.nota = new Nota();
        
        semestre.addObserver(this);
    }

    public AlunoTurma(Aluno aluno, Nota nota){
        this.aluno = aluno;
        this.nota =nota;
    }

    public Nota getNota(){
        return nota;
    }

    public void setNota(Nota nota){
        this.nota = nota;
    }

    public Aluno getAluno(){
        return aluno;
    }

    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
    
 @Override
    public void atualizarStatusNota() {
        nota.atualizarStatusNota(semestre.isStatus());
    }
}
