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
import java.util.List;

public class Odev {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        // -Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        //4.Tüm dropdown değerleri(value) yazdırın
        WebElement degerler = driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select = new Select(degerler);
        select.getOptions().forEach(w -> System.out.println(w.getText()));

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığına yazdıralım
        select.selectByIndex(1);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        select.selectByIndex(2);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        select.selectByIndex(3);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        select.selectByIndex(4);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        select.selectByIndex(5);
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        //Not: Select Class'ı kullanalım

    }

    }





