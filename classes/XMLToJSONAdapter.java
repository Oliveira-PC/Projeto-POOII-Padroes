package classes;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.InputSource;

public class XMLToJSONAdapter {

    // Método para converter XML para JSON
    public static String convertXMLToJSON(String xmlData) {
        StringBuilder jsonBuilder = new StringBuilder();
        try {
            // Criar um documento XML a partir da string XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlData));
            Document doc = builder.parse(is);

            // Iniciar a estrutura JSON
            jsonBuilder.append("{\n  \"students\": [\n");

            NodeList nodeList = doc.getElementsByTagName("student"); // Ajuste para o tag apropriado
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    jsonBuilder.append("    {\n");
                    jsonBuilder.append("      \"matricula\": \"").append(getTagValue("matricula", element)).append("\",\n");
                    jsonBuilder.append("      \"nome\": \"").append(getTagValue("nome", element)).append("\",\n");
                    jsonBuilder.append("      \"cpf\": \"").append(getTagValue("cpf", element)).append("\",\n");
                    jsonBuilder.append("      \"telefone\": \"").append(getTagValue("telefone", element)).append("\",\n");
                    jsonBuilder.append("      \"endereco\": \"").append(getTagValue("endereco", element)).append("\"\n");
                    jsonBuilder.append("    }");
                    if (i < nodeList.getLength() - 1) {
                        jsonBuilder.append(",");
                    }
                    jsonBuilder.append("\n");
                }
            }

            jsonBuilder.append("  ]\n}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonBuilder.toString();
    }

    // Método auxiliar para pegar o valor de uma tag
    private static String getTagValue(String tag, Element element) {
        NodeList nl = element.getElementsByTagName(tag);
        if (nl.getLength() > 0) {
            return nl.item(0).getTextContent();
        }
        return "";
    }
}
