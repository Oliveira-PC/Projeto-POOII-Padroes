package classes;
import java.util.ArrayList;

public class ExportData {

    // Método que converte os dados em Array para XML
    public String ArrayToXMLFormat(ArrayList<String[]> data, int multipler, String tag) {
    String xml = "";
    xml += "<?xml version=\"1.0\"?>";
    xml += "<data>";

    for (int i = 0; i < data.size(); i++) {
        if (i % multipler == 0) { // Abrir tag <student> no começo de cada bloco
            xml += "<" + tag + ">";
        }

        // Adiciona os dados
        xml += "   <" + data.get(i)[0] + "> " + data.get(i)[1] + " </" + data.get(i)[0] + ">";

        // Fechar tag <student> após cada bloco de dados
        if ((i + 1) % multipler == 0) {
            xml += "</" + tag + ">";
        }
    }

    xml += "</data>";
    return xml;
}
    
    // Método para exportar os dados de estudantes
    public static String exportarDadosEstudante() {
        DataBase db = DataBase.getInstance();
        ArrayList<String[]> data = new ArrayList<String[]>();

        ExportData exp = new ExportData();
        ArrayList<Aluno> alunos = db.getAlunos();
        for (int i = 0; i < alunos.size(); i++) {
        Aluno aluno = alunos.get(i);

        // Aqui você tem que passar o valor real da matrícula
        String matricula = aluno.getMatricula();  // Pegando a matrícula corretamente

        // Adicionando o valor real da matrícula ao XML
            String[] sm = {"matricula", matricula};  // O valor da matrícula real é passado aqui
            String[] sn = {"nome", aluno.getNome()};
            String[] sc = {"cpf", aluno.getCpf()};
            String[] st = {"telefone", aluno.getTelefone()};
            String[] se = {"endereco", aluno.getEndereco()};
            
            System.out.println("Matrícula do aluno " + aluno.getNome() + ": " + matricula);
            
            data.add(sm);
            data.add(sn);
            data.add(sc);
            data.add(st);
            data.add(se);
        }

        return exp.ArrayToXMLFormat(data, 5, "student");
    }
}
