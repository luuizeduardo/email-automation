package lib;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
public class JUnitTestReporter {

    static File junitReport;
    static BufferedWriter junitWriter;

    @BeforeClass
    public static void setUp() throws IOException {

        String junitReportFile = System.getProperty("user.dir")
                + "\\testReport.html";
        junitReport = new File(junitReportFile);
        junitWriter = new BufferedWriter(new FileWriter(junitReport, true));
        junitWriter.write("<html><body>");
        junitWriter.write("<h1>Test Execution Summary - " + Generator.dateToFile()
                + "</h1>");

    }

    @AfterClass
    public static void tearDown() throws IOException {
        junitWriter.write("</body></html>");
        junitWriter.close();
        Desktop.getDesktop().browse(junitReport.toURI());
    }

    @Rule
    public TestRule watchman = new TestWatcher() {

        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            try {
                junitWriter.write(description.getDisplayName() + " "
                        + "success!");
                junitWriter.write("<br/><br/>");
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }
        }

        @Override
        protected void failed(Throwable e, Description description) {
            try {
                junitWriter.write(description.getDisplayName() + " "
                        + e.getClass().getSimpleName());
                junitWriter.write("<br/><br/>");
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    };
}