package Utilities;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class CommonMath {

    SoftAssert soft=new SoftAssert();
    public int Currencyformat(int d) {

        //numbers with comma and after decimal two digits
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return Integer.parseInt(nf.format(d));
        //  [^\d] --->extract only numbers regular expression
    }

public String ExtractOnlyNumbers(String text){
       return text.replaceAll("[^\\d]","");
}

    public void GetRandomNumber() {
        //getting integer random numbers with 5 digits
        Random rnd = new Random();
        int number;
        do {
            number = rnd.nextInt(100000);
            System.out.println(number);
        } while (String.valueOf(number).length() < 4);
    }

    @Step("Verifying Values actual {actual} with expected {expected} ")
    public void VerifyAssert(String actual,String expected){
        Assert.assertEquals(actual,expected);
    }


    @Step("Verifying Values actual {actual} with expected {expected} ")
    public void VerifyAssert(int actual,int expected){
        Assert.assertEquals(actual,expected);
    }

    @Step("Verifying Values actual {actual} with expected {expected} ")
    public void VerifySoftAssert(String actual,String expected){
        soft.assertEquals(actual,expected);
    }


    @Step("Verifying Values actual {actual} with expected {expected} ")
    public void VerifySoftAssert(int actual,int expected){
        soft.assertEquals(actual,expected);
    }

}
