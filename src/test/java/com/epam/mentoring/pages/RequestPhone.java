package com.epam.mentoring.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestPhone extends MainMailPage{
    @FindBy(className = "request-phone") private WebElement phoneForm;
    @FindBy(className = "request-phone_back-button") private WebElement declinePhone;

    //ВОПРОС: Сомнительный кусок кода, но что успел по быстрому, подозреваю, что надо через какой-то try catch
    //Кусмарь не работает так как хотелось бы, нужен цикл который внутри проверяет наличие элемента
    public RequestPhone noPhone(){
        waitForElementVisible(phoneForm);
        if (phoneForm.isDisplayed())
            waitForElementVisible(declinePhone);
            declinePhone.click();
        return this;
    }
}
