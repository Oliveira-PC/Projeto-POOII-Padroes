package classes;

public class Recuperacao implements Estado {
    
    @Override
    public void executarAcao(AlunoTurma alunoturma, Nota nota) {
        /*Adicionar Nota em Recuperacao*/
        double media;
        media = nota.calcularMedia();
        System.out.println("O Aluno está em RECUPERAÇÃO!");
        alunoturma.getNota().setNotaRecuperacao(media);
    }
    
}
