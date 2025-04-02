package xmlutil.xmlfactory;

import org.junit.jupiter.api.Test;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class XMLCreator {

    @Test
    public void xmltest11(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElementNS("http://www.automation.com/qa/marketingupdate/2013/05", "automationUpdateSets");
            document.appendChild(rootElement);

            Element packageElement = document.createElement("automationUpdatePackage");
            rootElement.appendChild(packageElement);

            PolicyInformation policy = new PolicyInformation("1123", "SW23322", "MH1216", "200", "2025-01-23T19:10:07.168Z");
            AutomationUpdate automationUpdate = new AutomationUpdate(
                    "LUXMED", "2025-01-23T19:10:07.168Z", "123456", "LUXMED", "61784c40", policy)
                    .addUpdate(new Update("11232").addChangeEvent(new ChangeEvent("33222", "111")))
                    .addCustomer(new Customer("6000", "Javier", "Tes", "Primary", "EPAM Systems"));

            Element updateElement = XMLFactory.createUpdateElement(document, automationUpdate, policy);
            packageElement.appendChild(updateElement);

            Element updatesElement = document.createElement("updates");
            updateElement.appendChild(updatesElement);

            for (Update update : automationUpdate.updates) {
                Element updateChild = document.createElement("update");
                updateChild.setAttribute("customerID", update.customerID);
                updatesElement.appendChild(updateChild);

                Element changeEvents = document.createElement("changeEvents");
                updateChild.appendChild(changeEvents);

                for (ChangeEvent event : update.changeEvents) {
                    Element changeEvent = document.createElement("changeEvent");
                    changeEvent.setAttribute("coverageRefID", event.coverageRefID);
                    changeEvent.setAttribute("changeEventType", event.changeEventType);
                    changeEvents.appendChild(changeEvent);
                }
            }

            Element customersElement = document.createElement("customers");
            updateElement.appendChild(customersElement);

            for (Customer customer : automationUpdate.customers) {
                customersElement.appendChild(XMLFactory.createCustomerElement(document, customer));
            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("C:\\MMS\\output1.xml"));
            transformer.transform(source, result);


            System.out.println("XML file created successfully.");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
