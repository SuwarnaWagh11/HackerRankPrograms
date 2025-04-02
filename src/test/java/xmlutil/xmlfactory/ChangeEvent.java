package xmlutil.xmlfactory;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class ChangeEvent {
    String coverageRefID;
    String changeEventType;

    public ChangeEvent(String coverageRefID, String changeEventType) {
        this.coverageRefID = coverageRefID;
        this.changeEventType = changeEventType;
    }
}

class Update {
    String customerID;
    List<ChangeEvent> changeEvents = new ArrayList<>();

    public Update(String customerID) {
        this.customerID = customerID;
    }

    public Update addChangeEvent(ChangeEvent event) {
        this.changeEvents.add(event);
        return this;
    }
}

class Customer {
    String customerReferenceID;
    String givenName;
    String surName;
    String relationshipCode;
    String companyInformation;
    public Customer(String customerReferenceID, String givenName, String surName, String relationshipCode, String companyInformation) {
        this.customerReferenceID = customerReferenceID;
        this.givenName = givenName;
        this.surName = surName;
        this.relationshipCode = relationshipCode;
        this.companyInformation = companyInformation;
    }
}

class AutomationUpdate {
    String senderID;
    String updateDateTime;
    String automationUpdateID;
    String automationUpdateIDType;
    String transactionID;
    List<Update> updates = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    PolicyInformation policyInformation;;

    public AutomationUpdate(String senderID, String updateDateTime, String automationUpdateID, String automationUpdateIDType, String transactionID, PolicyInformation policyInformation) {
        this.senderID = senderID;
        this.updateDateTime = updateDateTime;
        this.automationUpdateID = automationUpdateID;
        this.automationUpdateIDType = automationUpdateIDType;
        this.transactionID = transactionID;
        this.policyInformation = policyInformation;
    }

    public AutomationUpdate addUpdate(Update update) {
        this.updates.add(update);
        return this;
    }

    public AutomationUpdate addCustomer(Customer customer) {
        this.customers.add(customer);
        return this;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class PolicyInformation {
    private String policyReferenceID;
    private String policyNumber;
    private String planName;
    private String premiumAmount;
    private String dueDate;
}

