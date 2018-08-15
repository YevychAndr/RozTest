package model;

public enum SubMenu {
    KATUSHKY("Катушки"),
    LASTY("Ласты"),
    TACHKY("Тачки"),
    RADIONYANYA("Радионяни");

    private String elementText;

    SubMenu(String elementText){
        this.elementText = elementText;
    }

    public String getElementText() {
        return elementText;
    }
}
