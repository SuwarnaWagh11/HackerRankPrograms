package xmlutil.xmlupdate.xmlnodes;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private String type; // "Residence" or "Mailing"
    private String addressLine1;
    private String addressLine2;
    private String zipcode;
    private String stateCode;
}
