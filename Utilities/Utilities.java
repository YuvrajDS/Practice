package Utilities;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public void Click(SelenideElement element){
        element.click();
    }

    @Step("Entering value")
    public void EnterText(SelenideElement element,String value){
        element.setValue(value);

    }

    @Step("Entering value")
    public void EnterText(SelenideElement element,int value){
        element.setValue(""+value);

    }

    @Step("Verifying text value")
    public void VerifyText(SelenideElement element,String value){
        element.shouldBe(Condition.text(value));


    }

    @Step("deleting value and Entering value")
    public void Clear_setValue(SelenideElement element,int Value){
        element.sendKeys(Keys.CONTROL+"a");
        element.sendKeys(Keys.DELETE);
        element.setValue(""+Value);
    }

    public String GetDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String datee=formatter.format(date);
       return datee;
    }

}
