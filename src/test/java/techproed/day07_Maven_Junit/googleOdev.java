package techproed.day07_Maven_Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class googleOdev {
    public static void main(String[] args) {
        /*

cookies uyarisini  kabul ederek kapatin
Sayfa  basliginin "Google"   ifadesi    icerdigini test  edin
Arama cubuguna "Nutella" yazip aratin
Bulunan sonuc sayisini yazdirin
sonuc sayisinin 10 milyon'dan fazla oldugunu test  edin
Sayfayi kapatin
         */

        System.setProperty("chromeDriver","src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //https://www.google.com/  adresine gidin
        driver.get("https://www.google.com/");
        //cookies uyarisini  kabul ederek kapatin

        //Sayfa    basliginin "Google"   ifadesi    icerdigini test  edin

        if (driver.getTitle().contains("Google")){
            System.out.println("Contains");
        }else {
            System.out.println("Yok :( ");
        }
        //Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.cssSelector("textarea[class='gLFyf']")).sendKeys("tahin pekmez", Keys.ENTER);
        //Bulunan sonuc sayisini yazdirin
        //Yaklaşık 155.000.000 sonuç bulundu (0,34 saniye)
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        String [] sonucSayisi=sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi));
        System.out.println(sonucSayisi[1]);
        int sonuc= Integer.valueOf(sonucSayisi[1].replace(".",""));

        //sonuc sayisinin 10 milyon'dan fazla oldugunu test  edin
        if (sonuc>10000000){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        driver.close();
    }
}


