package classes;

public class Reprovado implements Estado {
    @Override
    public void executarAcao(AlunoTurma alunoturma, Nota nota) {
        /*Emitir Mensagem de erro!*/
        System.out.println("ERRO: O Aluno está REPROVADO!");
    }
    
}
