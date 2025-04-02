package xmlutil.xmlupdate.constants;

public enum CoverageAttribute {
    COVERAGE_REFERENCE_ID("coverageReferenceId"),
    POLICY_NUMBER("policyNumber"),
    COVERAGE_PERCENTAGE("coveragePercentage");

    private final String attributeName;

    CoverageAttribute(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttribute(){
        return attributeName;
    }
}
