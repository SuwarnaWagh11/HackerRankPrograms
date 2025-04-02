package xmlutil.samples;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

public class XMLGenerator {

    public static String generateXML() {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Step 2: Create the root element with namespace
            Element rootElement = document.createElementNS("http://www.automation.com/qa/marketingupdate/2013/05", "automationUpdateSets");
            document.appendChild(rootElement);

            // Step 3: Create <automationUpdatePackage>
            Element packageElement = document.createElement("automationUpdatePackage");
            rootElement.appendChild(packageElement);

            // Step 4: Create <automationUpdate> with attributes
            Element updateElement = document.createElement("automationUpdate");
            updateElement.setAttribute("senderID", "LUXMED");
            updateElement.setAttribute("updateDateTime", "2025-01-23T19:10:07.168Z");
            updateElement.setAttribute("automationUpdateID", "123456");
            updateElement.setAttribute("automationUpdateIDType", "LUXMED");
            updateElement.setAttribute("transactionID", "61784c40");
            packageElement.appendChild(updateElement);

            // Step 5: Create <updates> section
            Element updatesElement = document.createElement("updates");
            updateElement.appendChild(updatesElement);

            Element updateChild = document.createElement("update");
            updateChild.setAttribute("customerID", "11232");
            updatesElement.appendChild(updateChild);

            Element changeEvents = document.createElement("changeEvents");
            updateChild.appendChild(changeEvents);

            Element changeEvent = document.createElement("changeEvent");
            changeEvent.setAttribute("coverageRefID", "33222");
            changeEvent.setAttribute("changeEventType", "111");
            changeEvents.appendChild(changeEvent);

            // Step 6: Create <customers> section
            Element customersElement = document.createElement("customers");
            updateElement.appendChild(customersElement);

            Element customer = document.createElement("customer");
            customer.setAttribute("customerReferenceID", "6000");
            customersElement.appendChild(customer);

            Element nameElement = document.createElement("name");
            customer.appendChild(nameElement);

            Element givenName = document.createElement("givenName");
            givenName.appendChild(document.createTextNode("Javier"));
            nameElement.appendChild(givenName);

            Element surName = document.createElement("surName");
            surName.appendChild(document.createTextNode("Tes"));
            nameElement.appendChild(surName);

            Element customerInfo = document.createElement("customerInformation");
            customer.appendChild(customerInfo);

            Element relationshipCode = document.createElement("relationshipCode");
            relationshipCode.appendChild(document.createTextNode("Primary"));
            customerInfo.appendChild(relationshipCode);

            // Step 7: Write the content into an XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            // Create the XML file
            File outputFile = new File("C:\\MMS\\output.xml");
            StreamResult result = new StreamResult(outputFile);

            // Transform the DOM object to an XML file
            transformer.transform(source, result);
            //StringWriter stringWriter = new StringWriter();
            //transformer.transform(new DOMSource(doc), new StreamResult(stringWriter));

            System.out.println("XML file created successfully: " + outputFile.getAbsolutePath());
            return outputFile.getAbsolutePath();

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
