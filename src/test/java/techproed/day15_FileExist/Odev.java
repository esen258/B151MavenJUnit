package techproed.day15_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class Odev extends TestBase {
    @Test
    public void test() {
       //  -http://szimek.github.io/signature_pad/ sayfasına gidiniz
       driver.get("http://szimek.github.io/signature_pad/");
       // - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement ekran = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions action = new Actions(driver);
        action.clickAndHold(ekran).moveByOffset(40, 50).moveByOffset(20,-120)
                .moveByOffset(55,85).moveByOffset(80,-75)
                .release().perform();
        bekle(3);
       // - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[@class='button clear'] ")).click();
        bekle(3);
       // - Sayfayi kapatiniz
        driver.close();
    }
}
