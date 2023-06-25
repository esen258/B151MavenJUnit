package techproed.day09_DropDown;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class C01_DropDown {
    /*

    DropDown: Alt baslıkların oldugu acılır menu listesidir.

    DropDown 3 adımda handle edilir

    1-) DropDown locate edilmelidir

    2-) Select objesi olusturulmalıdır
    Select select = new Select(ddm)

   3-) Opsiyonlardan bir tanesi secilir
   -selectByVisibleText() ==> option'a görünür metin ile ulasmak icin kullanılır
   -selectByIndex() ==> option'a ındex ile ulasmak icin kullanılır. (index 0 baslar)
   -selectByValue() ==> option'a value ile ulasmak icin kullanılır

     */

    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void name() throws InterruptedException {


        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Yıl Drodown'undan "2020" seciniz
        WebElement ddmYil = driver.findElement(By.xpath("//select[@id='year']"));

        Select select = new Select(ddmYil);


        //DropDown 3 adımda handle edilir

        // 1) select.selectByVisibleText("2020");
        //en cok bu tercih edilir cünkü dropdownda görünen sekilde paranteze eklenebiliyor

        // 2) select.selectByIndex(3);
        //kacinci indexte oldugunu yazarak sectiririz. burda index 0 ve yukardan baslar.
        //bunun az tercih edilmesinin sebebi herhangi bir gerekceyle
        //yeni opsiyon eklendiginde index kayar ve index yanlis sonuc verir

        select.selectByValue("2020");

        Thread.sleep(3000);

        // Ay Dropdown'undan "August" seciniz
        WebElement ddmAy = driver.findElement(By.xpath("//select[@id='month']"));//id ile locate aldik

        Select select2 = new Select(ddmAy);//obje olusturduk

        //select2.selectByVisibleText("August");//görünen sekilde yapistirdik/yazdik. karakter hatasi olmamali.

        //select2.selectByIndex(7);//index 0 ve en yukaridan baslar. august 8. sirada ve 7. indextedir.

        select2.selectByValue("7");
        //ay dropdown una sag click incele dedik, select html kodunun yaninda bulunan ok isaretine tikladik,
        // aylarin value degeri görünür, ayin yanindaki value degerini sayisal olarak paranteze ekledik

        Thread.sleep(3000);

        // Gün Dropdown'undan "5" seciniz
        WebElement ddmGun = driver.findElement(By.xpath("//select[@id='day']"));//id ile locate alinir

        Select select3 = new Select(ddmGun);//select objesi olusturulur

        select3.selectByVisibleText("5");

        //select2.selectByIndex(4);

        //select2.selectByValue("5");
        /*
                value degerini html kodlariyla bulma:
         gün dropdownuna gitmek 2 kez sag click incele denir, karsimiz cikan html kodunun select inin yaninda
         bulunan ok isaretine tiklanir, günlerin value degeri görünür,
         günün  yanindaki value degeri sayisal olarak paranteze eklenir




        */
        Thread.sleep(3000);

    }
}