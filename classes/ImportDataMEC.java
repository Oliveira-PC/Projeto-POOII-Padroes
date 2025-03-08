package classes;

public class ImportDataMEC {

    public void importData(String jsonData) {
        // Aqui, você pode processar os dados do JSON
        // Exemplo simples de saída dos dados
        System.out.println("Dados recebidos para importação ao MEC: ");
        System.out.println(jsonData);
    }

    public static void importDadosEstudanteMEC() {
        // Passo 1: Exportar os dados no formato XML
        String xmlData = ExportData.exportarDadosEstudante();

        // Passo 2: Converter o XML para JSON utilizando o Adapter
        String jsonData = XMLToJSONAdapter.convertXMLToJSON(xmlData);

        // Passo 3: Importar os dados no formato JSON para o MEC
        ImportDataMEC imec = new ImportDataMEC();
        imec.importData(jsonData);
    }
}
