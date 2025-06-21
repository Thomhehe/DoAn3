package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimkiemPage {

    WebDriver driver;
    WebDriverWait wait;

    private By timkiem = By.cssSelector("span.header-icon.icon-action__search.icon-action__search--desktop.toggle_form_search");
    private By keywords = By.cssSelector(".input-group-field.auto-search.form-control");
    private By xemkq = By.cssSelector(".ega-sm-bottom.tw-py-2.tw-text-center.tw-cursor-pointer.tw-text-sm.tw-border-t.tw-border-solid.tw-border-slate-200.tw-border-x-0.tw-border-b-0");
    private By ketquatimkiem = By.cssSelector(".col-lg-12.col-md-12.col-sm-12.col-xs-12.margin-bottom-15.mt-3");
    private By khongcoketqua = By.cssSelector("div[class='col-lg-12 col-md-12 col-sm-12 col-xs-12']");

    public TimkiemPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clicktimkiem() {
        wait.until(ExpectedConditions.elementToBeClickable(timkiem)).click();
    }

    public void enterkeywords(String Keywords) {
        WebElement keywordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(keywords));
        keywordBox.clear();
        keywordBox.sendKeys(Keywords);
    }

    public void clickxemkq() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(xemkq));
            button.click();
        } catch (TimeoutException e) {
            WebElement keywordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(keywords));
            keywordBox.sendKeys(Keys.ENTER);
        }

    }

    public String kiemtratrong() {
        WebElement keywordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(keywords));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", keywordBox);
    }


    public String kiemtrakqtk() {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(ketquatimkiem));
            return result.getText();
        } catch (TimeoutException e) {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(khongcoketqua));
            return message.getText();
        }
    }

}
