package xmlutil.xmlupdate.xmlnodes;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DemographicInformation {
    private List<Address> addresses;
}
