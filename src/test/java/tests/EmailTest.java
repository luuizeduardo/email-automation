package tests;

import lib.Generator;
import lib.JUnitTestReporter;
import lib.Screenshot;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Display;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.login.LoginPage;
import factory.Web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "EmailTest.csv")

public class EmailTest extends JUnitTestReporter {
    private WebDriver browser;

    @Before
    public void setUpEnvironment(){
        browser = Web.createChrome();
    }

    @Test
    public void testSendEmail(
        @Param(name="email")String email,
        @Param(name="password")String password,
        @Param(name="to")String to,
        @Param(name="subject")String subject,
        @Param(name="content")String content,
        @Param(name="message")String message
    ){
        String mensagemToast =
                new LoginPage(browser)
                .typeEmail(email)
                .typePassword(password)
                .sendEmail(to, subject, content)
                .toastMessage();

        assertEquals(message, mensagemToast);

        Screenshot.takeScreenshot(
                browser,
                System.getProperty("user.dir")
                    + "\\screenshots\\" +
                        Generator.dateToScreenshot() +
                        ".png"
        );
    }

    @Test
    public void testValidateEmailReceived(
        @Param(name="email")String email,
        @Param(name="password")String password,
        @Param(name="subject")String subject,
        @Param(name="content")String content
    ){
        new LoginPage(browser)
            .typeEmail(email)
            .typePassword(password)
            .verifyEmailReceived(subject, content);

        Screenshot.takeScreenshot(
                browser,
                System.getProperty("user.dir")
                        + "\\screenshots\\" +
                        Generator.dateToScreenshot() +
                        ".png"
        );
    }

    @After
    public void tearDownEnvironment(){
        browser.quit();
    }
}
