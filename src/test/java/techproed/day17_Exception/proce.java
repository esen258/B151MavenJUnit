package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class proce extends TestBase {
    @Test
    public void proce1() {
        driver.get("https://youtube.com");

        bekle(2);

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='search']"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("adele" + Keys.ENTER);
        bekle(2);
        driver.findElement(By.xpath("(//yt-formatted-string[@class='style-scope ytd-video-renderer'])[1]")).click();
        String sarki = driver.getCurrentUrl();
        bekle(2);
        //google' a git
        driver.get("https://www.google.com");

        //arama butonuna tıkla
        WebElement googleAramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        googleAramaKutusu.click();
        bekle(2);
        //"youtube mp3 indir" şeklinde arama yaptır
        googleAramaKutusu.sendKeys("youtube mp3 indir" + Keys.ENTER);

        //1.bağlantıya tıkla
        driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
        bekle(3);

        //gelen sitedeki arama butonuna tıklayıp adele sarkısının url'ini yapıştır
        WebElement mp3SitesiURLbutonu = driver.findElement(By.xpath("//input[@type='text']"));
        mp3SitesiURLbutonu.click();
        mp3SitesiURLbutonu.sendKeys(sarki);

        //"Dönüştür"butonuna tıkla
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        bekle(2);
        //Açılan Sekmeyi Kapat
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        bekle(2);
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        bekle(3);
        //mp3 için indir butonuna tıkla
        driver.findElement(By.xpath("(//button[text()='İndir'])[1]")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }
}
