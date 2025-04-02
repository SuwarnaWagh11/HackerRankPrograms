package xmlutil.xmlupdate.xmlnodes;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CoverageInformation {
    private String coverageReferenceId;
    private String policyNumber;
    private String coveragePercentage;
}
