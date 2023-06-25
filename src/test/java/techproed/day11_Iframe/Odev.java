package techproed.day11_Iframe;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class Odev extends TestBase {

     /*
    Yeni bir class olusturun: WindowHandle
    Amazon anasayfa adresine gidin.
    Sayfa’nin window handle degerini String bir degiskene atayin
    Sayfa title’nin “Amazon” icerdigini test edin
    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    Sayfa title’nin “Walmart” icerdigini test edin
    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */

    @Test
    public void test01() throws InterruptedException {
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");
        String amazonWindowHandle = driver.getWindowHandle();
        bekle(2);
        //Sayfa title’nin “Amazon” icerdigini test edin
        String amazonTitle = driver.getTitle();
        String expectedAmazonTitle = "Amazon";
        Assert.assertTrue(amazonTitle.contains(expectedAmazonTitle));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        bekle(2);

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin.
        String techproTitle = driver.getTitle();
        String expectedTechproTitle = "TECHPROEDUCATION";
        Assert.assertFalse(techproTitle.contains(expectedTechproTitle));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com/");
        bekle(2);

        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        String expectedURL = "https://www.amazon.com/";
        bekle(2);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }


}

