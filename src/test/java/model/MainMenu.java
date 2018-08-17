package model;

public enum MainMenu {
    SPORT("9017"),
    COTTAGE("8261"),
    BABYGOODS("13224"),
    STATIONERY("14127");


    private String elementId;

    MainMenu (String elementId){
        this.elementId = elementId;
    }

    public String getElementId() {
        return elementId;
    }

}
