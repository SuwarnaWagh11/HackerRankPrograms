package xmlutil.samples;

import org.junit.jupiter.api.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class xmltest {


    @Test
    public void xmlTest3() throws IOException, ParserConfigurationException, TransformerException {
        String xmlsFile = XMLGenerator.generateXML();
        String myFile = XMLUtils.readXMLFile(xmlsFile);
        System.out.println(myFile);
    }

    @Test
    public void xmlTest2() throws IOException {
        String myFile = XMLUtils.readXMLFile("C:\\MMS\\input.xml");
        System.out.println(myFile);
    }

    //@Test
    public void smallxmlTest1() {
        String xmlPayload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<request>\n" +
                "    <user>\n" +
                "        <id>123</id>\n" +
                "        <name>John Doe</name>\n" +
                "    </user>\n" +
                "</request>";
        given()
                .header("Content-Type", "application/xml")
                .body(xmlPayload)
                .when()
                .post("/your-api-endpoint")
                .then()
                .statusCode(200);
    }
}
