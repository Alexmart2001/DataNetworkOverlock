package co.edu.usbbog.datanetworkoverlock.controller.config;

public enum HostInfo {

    USER("mikle"),
    PASSWORD("Mikle"),
    HOST("192.168.1.200"),
    PORT("22");

    private String value;

    HostInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
