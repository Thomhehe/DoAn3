package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Hooks extends BaseSteps{
    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {

            if (scenario.isFailed()) {
                try {
                    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    String filename = scenario.getName().replaceAll("[^a-zA-Z0-9-_\\.]", "_") + ".png";

                    String path = System.getProperty("user.home") + "/OneDrive/Pictures/Screenshots";
                    File dest = new File(path, filename);

                    FileUtils.copyFile(src, dest);
                    System.out.println("Đã lưu ảnh: " + dest.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Không thể lưu ảnh: " + e.getMessage());
                }
            }

            driver.quit();
        }
    }
}
