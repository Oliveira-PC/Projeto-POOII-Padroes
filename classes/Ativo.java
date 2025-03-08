package classes;

public class Ativo implements Estado {
    @Override
    public void executarAcao(AlunoTurma alunoturma, Nota nota) {
        /*Adicionar Nota*/
        System.out.println("O Aluno está APROVADO!");
        alunoturma.setNota(nota);
    }
    
}
