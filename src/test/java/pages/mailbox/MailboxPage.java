package pages.mailbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class MailboxPage extends BasePage {
    public MailboxPage(WebDriver browser) {
        super(browser);
    }

    public MailboxPage clickNewEmail(){
        System.out.println("Wait the page finish to load and click on 'Escrever'");
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.elementToBeClickable(browser.findElement(By.xpath("//div[text() = \"Escrever\"]"))));
        browser.findElement(By.xpath("//div[text() = \"Escrever\"]")).click();
        return this;
    }

    public MailboxPage typeTo(String to){
        System.out.println("Wait the form appears in the DOM and type the destination of this e-mail");
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
        browser.findElement(By.name("to")).sendKeys(to);
        return this;
    }

    public MailboxPage typeSubject(String subject){
        System.out.println("Type the subject of this e-mail");
        browser.findElement(By.name("subjectbox")).sendKeys(subject);
        return this;
    }

    public MailboxPage typeContent(String content){
        System.out.println("Type the e-mail content");
        browser.findElement(By.xpath("//div[@aria-label=\"Corpo da mensagem\"]")).sendKeys(content);
        return this;
    }

    public MailboxPage clickSend(){
        System.out.println("Click on 'Enviar' to send the e-mail");
        browser.findElement(By.xpath("//div[text() = \"Enviar\"]")).click();
        return this;
    }

    public MailboxPage findFirstEmailReceived(){
        System.out.println("Click on the first e-mail received");
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role=\"checkbox\"]/parent::td/parent::tr"))
        );
        browser.findElement(By.xpath("//div[@role=\"checkbox\"]/parent::td/parent::tr")).click();
        return this;
    }

    public MailboxPage validateInformationsReceived(String subject, String content){
        System.out.println("Validate that the e-mail has the right informations");
        browser.findElement(By.xpath("//h2[text()='" + subject + "']")).isDisplayed();
        browser.findElement(By.xpath("//div[text()='" + content + "']")).isDisplayed();
        return this;
    }

    public MailboxPage sendEmail(
            String to,
            String subject,
            String content
    ){
        clickNewEmail();
        typeTo(to);
        typeSubject(subject);
        typeContent(content);
        return clickSend();
    }

    public MailboxPage varifyEmailReceived(String subject, String content){
        findFirstEmailReceived();
        return validateInformationsReceived(subject, content);
    }
}
