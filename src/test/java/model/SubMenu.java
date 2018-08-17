package model;

public enum SubMenu {
    COIL("Катушки"),
    FLUTTER("Ласты"),
    WHEELBARROW("Тачки"),
    BABYRADIO("Радионяни");

    private String elementText;

    SubMenu(String elementText){
        this.elementText = elementText;
    }

    public String getElementText() {
        return elementText;
    }
}
