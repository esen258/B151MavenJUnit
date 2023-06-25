package day03_practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev {


    static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public  void test01() {
        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String taytil= driver.getTitle();
        Assert.assertTrue(taytil.contains("Google"));

        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("nutella"+ Keys.ENTER);

        // bulunan sonuc sayısını yazdırın
        WebElement sonuclar=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonuclar.getText());
       // String[] sonucSayisi =sonuclar.getText().split(" ");
        //System.out.println("sonucSayisi[1] = " + sonucSayisi[1]);
        String snc[]=sonuclar.getText().split(" ");
        String netice = snc[1];
        System.out.println(netice);

        // sonuc sayısının 100000000  fazla oldugunu test edin
      // Assert.assertTrue(sonucSayisi[1].valueOf() > 100000000);
        String sonucSayisi2 = netice.replaceAll("//ab","");
        if(Integer.parseInt(netice)> 100000000){
            System.out.println("Bu is tamam");
        }else{
            System.out.println("Bi daha dene");
        }



        // if(sonucSayisi[1]>100000000){
        //     System.out.println("TEST PASSED");
        // }else{
        //   System.out.println("TEST FAILED");



    }
}