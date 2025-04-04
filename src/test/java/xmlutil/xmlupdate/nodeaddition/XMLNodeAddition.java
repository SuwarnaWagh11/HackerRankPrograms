package xmlutil.xmlupdate.nodeaddition;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import xmlutil.xmlupdate.constants.CoverageAttribute;
import xmlutil.xmlupdate.constants.GroupInformationAttribute;
import xmlutil.xmlupdate.xmlnodes.Address;
import xmlutil.xmlupdate.xmlnodes.CoverageInformation;
import xmlutil.xmlupdate.xmlnodes.DemographicInformation;
import xmlutil.xmlupdate.xmlnodes.GroupInformation;

import java.util.Arrays;

public class XMLNodeAddition {

    public static void coverageNodeAddition(Document document, Element automationUpdate, CoverageInformation coverageInformation) {

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

    public static void groupInfoNodeAddition(Document document, Element automationUpdate, GroupInformation groupInformation) {

        // Step 4: Create new <coverageInformation> element
        Element grpInfo = document.createElement(GroupInformationAttribute.GROUP_INFORMATION.getAttribute());
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

    public static void demographicNodeAddition(Document document, Element customer, DemographicInformation demographicInfo) {


        // Step 4: Create <demographicInformation> element
            Element demoInfoElement = document.createElement("demographicInformation");

            for (Address address : demographicInfo.getAddresses()) {
                Element addressElement = document.createElement("address");
                addressElement.setAttribute("type", address.getType());

                Element addressLine1 = document.createElement("addressLine1");
                addressLine1.appendChild(document.createTextNode(address.getAddressLine1()));
                addressElement.appendChild(addressLine1);

                Element addressLine2 = document.createElement("addressLine2");
                addressLine2.appendChild(document.createTextNode(address.getAddressLine2()));
                addressElement.appendChild(addressLine2);

                Element zipcode = document.createElement("zipcode");
                zipcode.appendChild(document.createTextNode(address.getZipcode()));
                addressElement.appendChild(zipcode);

                Element stateCode = document.createElement("stateCode");
                stateCode.appendChild(document.createTextNode(address.getStateCode()));
                addressElement.appendChild(stateCode);

                // Append address inside demographicInformation
                demoInfoElement.appendChild(addressElement);
            }

            // Append <demographicInformation> inside <customer>
            customer.appendChild(demoInfoElement);
        }

}
