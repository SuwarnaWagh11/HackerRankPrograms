package xmlutil.xmlupdate;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xmlutil.xmlupdate.constants.CoverageAttribute;
import xmlutil.xmlupdate.constants.GroupInformationAttribute;
import xmlutil.xmlupdate.xmlnodes.CoverageInformation;
import xmlutil.xmlupdate.xmlnodes.GroupInformation;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLModifier {

    @Test
    public void xmlModification1() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Step 1: Load the existing XML file
        Document document = loadXML();
        // Step 2: Locate the <automationUpdate> element
        NodeList updateNode = document.getElementsByTagName("automationUpdate");
        if(updateNode.getLength() > 0){
            Element automationUpdate = (Element) updateNode.item(0); // Assuming only one automationUpdate node

            // Step 3: Create new <coverageInformation> element
            Element coverageInfo = document.createElement("coverageInformation");
            coverageInfo.setAttribute("coverageReferenceId","cvg88729");

            Element policyNum = document.createElement("policyNumber");
            policyNum.appendChild(document.createTextNode("HM234666"));
            coverageInfo.appendChild(policyNum);

            Element coverageSplit = document.createElement("coveragePercentage");
            coverageSplit.appendChild(document.createTextNode("50%"));
            coverageInfo.appendChild(coverageSplit);
            // Step 4: Append the new element inside <automationUpdate>
            automationUpdate.appendChild(coverageInfo);

            // Step 5: Save the updated XML back to the file
            writeUpdateTag(document, "C:\\MMS\\UpdatedOutput2.xml");
            System.out.println("XML file updated successfully with new tag!");
        }
    }

    @Test
    public void xmlModificationWithDataModel() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Step 1: Load the existing XML file
        Document document = loadXML();
        // Step 2: Locate the <automationUpdate> element
        NodeList updateNode = document.getElementsByTagName("automationUpdate");
        if(updateNode.getLength() > 0){
            Element automationUpdate = (Element) updateNode.item(0); // Assuming only one automationUpdate node
            // Step 3: Create new coverageInformation object using Lombok
            CoverageInformation coverageInfo = new CoverageInformation(
                    "acvg88729","HM234666","75%");
            coverageNodeAddition(document, automationUpdate, coverageInfo);
            // Step 6: Save the updated XML back to the file
            writeUpdateTag(document, "C:\\MMS\\UpdatedOutput4.xml");
            System.out.println("XML file updated successfully with new tag!");
        }
    }

    @Test
    public void xmlModificationForGrpInfoWithDataModel() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Step 1: Load the existing XML file
        Document document = loadXML();
        // Step 2: Locate the <automationUpdate> element
        NodeList updateNode = document.getElementsByTagName("automationUpdate");
        if(updateNode.getLength() > 0){
            Element automationUpdate = (Element) updateNode.item(0); // Assuming only one automationUpdate node
            // Step 3: Create new coverageInformation object using Lombok
            GroupInformation groupInformation = new GroupInformation("980000","GENERALHealth");
            groupInfoNodeAddition(document, automationUpdate, groupInformation);
            // Step 6: Save the updated XML back to the file
            writeUpdateTag(document, "C:\\MMS\\UpdatedOutput5.xml");
            System.out.println("XML file updated successfully with new tag!");
        }
    }

    private static void coverageNodeAddition(Document document, Element automationUpdate, CoverageInformation coverageInformation) {

        // Step 4: Create new <coverageInformation> element
        Element coverageInfo = document.createElement("coverageInformation");
        coverageInfo.setAttribute(CoverageAttribute.COVERAGE_REFERENCE_ID.getAttribute(), coverageInformation.getCoverageReferenceId());

        Element policyNum = document.createElement(CoverageAttribute.POLICY_NUMBER.getAttribute());
        policyNum.appendChild(document.createTextNode(coverageInformation.getPolicyNumber()));
        coverageInfo.appendChild(policyNum);

        Element coverageSplit = document.createElement(CoverageAttribute.COVERAGE_PERCENTAGE.getAttribute());
        coverageSplit.appendChild(document.createTextNode(coverageInformation.getCoveragePercentage()));
        coverageInfo.appendChild(coverageSplit);
        // Step 5: Append the new element inside <automationUpdate>
        automationUpdate.appendChild(coverageInfo);
    }

    private static void groupInfoNodeAddition(Document document, Element automationUpdate, GroupInformation groupInformation) {

        // Step 4: Create new <coverageInformation> element
        Element grpInfo = document.createElement("groupInformation");
        //coverageInfo.setAttribute(GroupInformationAttribute.GROUP_ID.getAttribute(), groupInformation.getGroupId());

        Element grpName = document.createElement(GroupInformationAttribute.GROUP_NAME.getAttribute());
        grpName.appendChild(document.createTextNode(groupInformation.getGroupName()));
        grpInfo.appendChild(grpName);

        Element grpId = document.createElement(GroupInformationAttribute.GROUP_ID.getAttribute());
        grpId.appendChild(document.createTextNode(groupInformation.getGroupId()));
        grpInfo.appendChild(grpId);
        // Step 5: Append the new element inside <automationUpdate>
        automationUpdate.appendChild(grpInfo);
    }

    private static Document loadXML() throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File("C:\\MMS\\output1.xml");
        DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        return document;
    }

    private static void writeUpdateTag(Document document, String outputFilename) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(outputFilename));
        transformer.transform(source, result);
    }
}
