package data;

public enum TopMenuList {
    PRODUCT("Product"),
    SOLUTIONS("Solutions"),
    RESOURCES("Resources"),
    OPENSOURCE("Open Source"),
    ENTERPRISE("Enterprise");

    public final String description;

    TopMenuList(String description) {
        this.description = description;
    }

}
