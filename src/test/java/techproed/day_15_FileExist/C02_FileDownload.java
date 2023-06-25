package techproed.day_15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void test() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
//"b10 all test cases" dosyasını indirin
        driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']")).click();

        bekle(2);
// Dosyanın başarıyla indirilip indirilmediğini test edin.
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\lenovo2\\Downloads\\b10 all test cases, code.docx")));

        String farkliKisim = System.getProperty("user.home");
        String ayniKisim="\\Downloads\\b10 all test cases, code.docx";
        String dosyAdresi= farkliKisim+ayniKisim;
        System.out.println(dosyAdresi);


        File silinecekDosya=new File("C:\\Users\\lenovo2\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();

      // Eger localinizden otomasyon ile bir dosya silmek icin File class'ından obje olusturup dosya yolunuzu
      // içine yerlestiririz. Ve olusturdugumuz obje ile delete() methodunu kullanarak o dosyayı silebiliriz.

      // Bunu yapma sebebimiz test class'ımızı çalıstırdıgımızda, her calıstırmada yeni bir dosya indirecegi icin
      // ordaki dosya kalabalıgını önlemiş oluruz. aynı zamanda dogrulama yaparken işimizi garantiye almış oluruz.

      // Aynı isimde birden fazla dosya indirmis olsak da her indirilenin yanına index verecegi icin ve bizim ilk indirdigimiz
      // o klasörün icinde bulamayacagı icin her zaman ilk dosyanın varlıgı test etmis oluruz.


        //driver.get("chrome://downloads/");
        //driver.get("C:\\Users\\lenovo2\\Desktop\\esen\\5-6-7 Yazılılar");









    }
}
