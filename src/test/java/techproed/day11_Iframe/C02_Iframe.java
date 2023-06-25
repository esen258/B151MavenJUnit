package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Iframe extends TestBase {


    //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
    //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
    //==>  textBox içindeki yazıyı siliniz.
    //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
    //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.

    @Test
    public void iframe() {

        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");



        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        String kalinYazi = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();

        Assert.assertTrue(kalinYazi.contains("Editor"));







        //==>  textBox içindeki yazıyı siliniz.

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);


/*
        Iframe'e gecmenin 2.yolu index ile;
        driver.switchTo().frame(0);

        Eger 2 tane Iframe olsaydı ve 2. Iframe'e gecmek isteseydim index'i 1 almam gerekecekti
*/

/*
    Iframe'e gecmenin 3. yolu id veya name value ile;
    iframe HTML kod blogunda id veya name attribute'u varsa

   driver.switchTo().frame("mce_0_ifr");

    bu sekilde de gecis yapabiliriz
*/

        bekle(3);

        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));

        textBox.clear();




        //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.

        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        bekle(2);


        //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.

        driver.switchTo().defaultContent();

        bekle(2);

        WebElement elementalSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSelenium.isDisplayed());

        //Birden fazla iframe oldugu zaman onlarin kac tane oldugu nasil anlariz
        //ve kac adet oldugu ile ilgil sonuc yazdirabilir miyiz?
        //herhanbgi bir dongu icine mi almamiz gerekir?

        //web sayfasina gideriz, sag click incele deriz, html kodlari gelir, alttaki cubuga //iframe yazariz
        // sagdaki kisimda 1 of 1 oldugunda 1 tane iframe oldugunu görürüz.
        // iframe yazarsak bu sayfada bulunan iframe taglarini getirir
        //kodlarda anlöamak icin bu yöntemi kullaniriz. iframe olup olmadigini bu sekilde anlariz


    }
}