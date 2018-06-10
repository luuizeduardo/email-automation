package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.mailbox.MailboxPage;

public class PasswordPage extends BasePage {

    public PasswordPage(WebDriver browser) {
        super(browser);
    }

    public MailboxPage typePassword(String password){
        System.out.println("Type password and ENTER to sign in");
        browser.findElement(By.name("password")).sendKeys(password + Keys.ENTER);
        return new MailboxPage(browser);
    }
}
