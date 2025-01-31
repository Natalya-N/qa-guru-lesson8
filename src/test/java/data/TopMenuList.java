package data;

public enum TopMenuList {
    PRODUCT("Product"),
    SOLUTIONS("Solutions"),
    RESOURCES("Resources"),
    OPENSOURCE("Open source"),
    ENTERPRISE("Enterprise"),
    PRICING("Pricing");

    public final String description;

    TopMenuList(String description) {
        this.description = description;
    }



}
