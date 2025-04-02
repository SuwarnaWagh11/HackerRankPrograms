package xmlutil.xmlfactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class XMLFactory {

    public static Element createUpdateElement(Document document, AutomationUpdate automationUpdate, PolicyInformation policyInformation) {
        Element updateElement = document.createElement("automationUpdate");
        updateElement.setAttribute("senderID", automationUpdate.senderID);
        updateElement.setAttribute("updateDateTime", automationUpdate.updateDateTime);
        updateElement.setAttribute("automationUpdateID", automationUpdate.automationUpdateID);
        updateElement.setAttribute("automationUpdateIDType", automationUpdate.automationUpdateIDType);
        updateElement.setAttribute("transactionID", automationUpdate.transactionID);

        Element policyInfoElement = document.createElement("policyInformation");
        policyInfoElement.setAttribute("policyReferenceID", policyInformation.getPolicyReferenceID());
//        Element policyReferenceID = document.createElement("policyReferenceID");
//        policyReferenceID.appendChild(document.createTextNode(policyInformation.getPolicyReferenceID()));
//        policyInfoElement.appendChild(policyReferenceID);

        Element policyNum = document.createElement("policyNumber");
        policyNum.appendChild(document.createTextNode(policyInformation.getPolicyNumber()));
        policyInfoElement.appendChild(policyNum);
        Element planName = document.createElement("planName");
        planName.appendChild(document.createTextNode(policyInformation.getPlanName()));
        policyInfoElement.appendChild(planName);
        Element premiumAmount = document.createElement("premiumAmount");
        premiumAmount.appendChild(document.createTextNode(policyInformation.getPremiumAmount()));
        policyInfoElement.appendChild(premiumAmount);
        Element dueDate = document.createElement("dueDate");
        dueDate.appendChild(document.createTextNode(policyInformation.getDueDate()));
        policyInfoElement.appendChild(dueDate);

        updateElement.appendChild(policyInfoElement);
        return updateElement;
    }

    public static Element createCustomerElement(Document document, Customer customer) {
        Element customerElement = document.createElement("customer");
        customerElement.setAttribute("customerReferenceID", customer.customerReferenceID);

        Element nameElement = document.createElement("name");
        customerElement.appendChild(nameElement);
        Element givenName = document.createElement("givenName");
        givenName.appendChild(document.createTextNode(customer.givenName));
        nameElement.appendChild(givenName);
        Element surName = document.createElement("surName");
        surName.appendChild(document.createTextNode(customer.surName));
        nameElement.appendChild(surName);

        Element customerInfo = document.createElement("customerInformation");
        customerElement.appendChild(customerInfo);
        Element relationshipCode = document.createElement("relationshipCode");
        relationshipCode.appendChild(document.createTextNode(customer.relationshipCode));
        customerInfo.appendChild(relationshipCode);
        Element companyInfo = document.createElement("companyInformation");
        companyInfo.appendChild(document.createTextNode(customer.companyInformation));
        customerElement.appendChild(companyInfo);
        return customerElement;
    }
}
