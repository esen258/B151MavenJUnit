package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;


public class C01_JSExecuter_Scroll extends TestBase {

    //Scroll: Kaydirmak demek


    JavascriptExecutor js;//objesin buraya atmistik

    @Test
    public void name() {

        //1 asagi sonra en alta sonra 4 yukari sonra en alta sonra en üste sonra en alta

        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");

        bekle(4);

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklam

        bekle(7);

        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement weOffer = driver.findElement(By.xpath("(//span[@class='elementor-icon-list-text'])[1]"));

        // js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView(true);", weOffer);

        //METHOD ILE
        scroll(weOffer);


        bekle(3);

        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        WebElement enrollFree = driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);


        //scroll(enrollFree);

        bekle(3);


        // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUs = driver.findElement(By.xpath("//h3[text()='WHY US?']"));

        //scroll(whyUs);

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", whyUs);


        bekle(3);


        // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        //webelementini yukarida olusturduk
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);

        //scroll(enrollFree);

        bekle(3);

        // Sayfayi en üste scroll et (sayfayı kaydır)

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

        scrollHome();



        bekle(3);


        // Sayfayı en alta scroll et (sayfayı kaydır)

        //js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        //- yi sildik cünkü en alta kaydiriyoruz kuzey yönü negatif sectik

        scrollEnd();

//bi değişiklik

        //Process finished with exit code 0

    }
}
