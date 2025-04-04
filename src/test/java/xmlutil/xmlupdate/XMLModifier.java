package xmlutil.xmlupdate;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xmlutil.xmlupdate.xmlnodes.Address;
import xmlutil.xmlupdate.xmlnodes.CoverageInformation;
import xmlutil.xmlupdate.xmlnodes.DemographicInformation;
import xmlutil.xmlupdate.xmlnodes.GroupInformation;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.transform.TransformerException;

import static xmlutil.xmlupdate.XMLCommonSteps.loadXML;
import static xmlutil.xmlupdate.XMLCommonSteps.writeUpdateTag;
import static xmlutil.xmlupdate.nodeaddition.XMLNodeAddition.*;

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
            writeUpdateTag(document, "C:\\MMS\\UpdatedOutput6.xml");
            System.out.println("XML file updated successfully with new tag!");
        }
    }

    @Test
    public void xmlModificationForDemographic() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Step 1: Load the existing XML file
        Document document = loadXML();
        // Step 2: Locate the <automationUpdate> element
        NodeList customerNodes = document.getElementsByTagName("customer");
        if (customerNodes.getLength() > 0) {
            Element customerElement = (Element) customerNodes.item(0); // Assuming one customer node

            // Step 3: Create Demographic Information object
            DemographicInformation demographicInfo = new DemographicInformation(Arrays.asList(
                    new Address("Residence", "123 Main St", "Apt 101", "12345", "CA"),
                    new Address("Mailing", "456 Elm St", "Suite 200", "67890", "NY")
            ));
            demographicNodeAddition(document, customerElement, demographicInfo);
            writeUpdateTag(document, "C:\\MMS\\UpdatedOutput4.xml");
            System.out.println("XML file updated successfully with new tag!");
        }
    }
}
