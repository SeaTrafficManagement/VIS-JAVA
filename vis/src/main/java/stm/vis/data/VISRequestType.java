package stm.vis.data;

public enum VISRequestType {
    GET,
    POST,
    DELETE,
    PATCH;

    public String value() {
        return name();
    }

    public static VISRequestType fromValue(String v) {
        return valueOf(v);
    }

}
