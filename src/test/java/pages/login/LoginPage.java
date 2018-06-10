package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public PasswordPage typeEmail(String email){
        System.out.println("Type an email and ENTER to move to next page");
        browser.findElement(By.id("identifierId")).sendKeys(email + Keys.ENTER);
        return new PasswordPage(browser);
    }
}
