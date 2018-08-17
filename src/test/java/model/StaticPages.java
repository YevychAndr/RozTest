package model;

public enum StaticPages {
    QUESTIONANSWER("Вопросы и ответы"),
    CREDIT("Кредит"),
    SHIPPINGPAYMENT("Доставка и оплата"),
    WARRANTY("Гарантия"),
    CONTACTS("Контакты");

    private String elementText;

    StaticPages(String elementText){
        this.elementText = elementText;
    }

    public String getElementText(){
        return elementText;
    }
}
