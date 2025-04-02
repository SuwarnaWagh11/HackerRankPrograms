package xmlutil.xmlupdate.constants;

public enum GroupInformationAttribute {
    GROUP_ID("groupId"),
    GROUP_NAME("groupName");
    private final String attributeName;

    GroupInformationAttribute(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttribute(){
        return attributeName;
    }
}
