package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class odev extends TestBase {

    @Test
    public void Test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over  Me First" kutusunun ustune gelin
        WebElement hover = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(hover).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //4- Popup mesajini yazdirin
        System.out.println("mesaj : " + driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement basiliTutma  = driver.findElement(By.xpath("//div[@id='click-box']"));
        action.clickAndHold(basiliTutma).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("sonuc yazisi : " + driver.findElement(By.xpath("//div[text()='Well done! keep holding that click now.....']")).getText());

        // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin

        WebElement doublec = driver.findElement(By.cssSelector("[id='double-click']"));
        String doublecText = doublec.getAttribute("class");
        bekle(5);


        action.doubleClick(doublec).perform();
        WebElement doublec2 = driver.findElement(By.cssSelector("[id='double-click']"));
        String doublec2Text = doublec2.getAttribute("class");

        System.out.println(doublecText);
        System.out.println(doublec2Text);

        Assert.assertNotEquals(doublecText,doublec2Text);

        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        action.dragAndDrop(drag,drop).perform();

    }
}