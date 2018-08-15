package model;

public enum MainMenu {
    SPORT("9017"),
    DACHA("8261"),
    DYTYACHITOVARY("13224"),
    KANCTOVARY("14127");


    private String elementId;

    MainMenu (String elementId){
        this.elementId = elementId;
    }

    public String getElementId() {
        return elementId;
    }

}
