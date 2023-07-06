package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_File_Upload extends TestBase {

    @Test
    public void test() {
        // masaustunde bir deneme dosyası olusturun
        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement yukleme =driver.findElement(By.xpath("//input[@id='file-upload']"));
        yukleme.sendKeys("C:\\Users\\lenovo2\\Desktop\\esen\\5-6-7 Yazılılar\\5.sınıf.docx");

       // String farkliKisim = System.getProperty("user.home");
       // String ortakKisim = "\\Desktop\\deneme.txt";
       // String dosyaYolu = farkliKisim + ortakKisim;
       // dosyaSec.sendKeys(dosyaYolu);


        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//input[@class='button']")).click();
        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement yazi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yazi.isDisplayed());
    }
}
