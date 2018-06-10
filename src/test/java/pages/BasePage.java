package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver browser;

    public BasePage(WebDriver browser){
        this.browser = browser;
    }

    public String toastMessage(){
        System.out.println("Validate toast message");
        return browser.findElement(By.xpath("//div/span/span[text()=\"Mensagem enviada.\"]")).getText();
    }
}
