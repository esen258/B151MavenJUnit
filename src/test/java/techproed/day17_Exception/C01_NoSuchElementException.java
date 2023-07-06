package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;


public class C01_NoSuchElementException extends TestBase {
    @Test
    public void NoSuchElementException() {
        /*
        NoSuchElementException:
         Sayfada bulunmayan bir elemenente erisim saglanmaya calisildiginde
        NoSuchElementException hatasi aliriz.
         */

        //techpro sayfasına gidelim


        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz


        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //arama kutusuna java yazip aratin
        driver.findElement(By.
                        xpath("//input[@id='YANLIS elementor-search-form-9f26725']")).
                sendKeys("Java" + Keys.ENTER);


        //Hatali kod
         /*
     NoSuchElementException:
Yanlis locator
Popup, yeni pencere, iframe,…
Sayfa dolmada problemler ve yavaslamalar
Sakli olan elementle

            Solution:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada
fluent wait kullaniriz
     */


    }
}