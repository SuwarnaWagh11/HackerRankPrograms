package apitest;

import com.google.common.base.Function;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PractiveUITest {
    //@org.junit.jupiter.api.Test
    public void test11() throws IOException {
        Capabilities k = new DesiredCapabilities();
        RemoteWebDriver rb = new RemoteWebDriver(k);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
        driver.get("https://intellipaat.com/blog/interview-question/selenium-interview-questions/?US");
        driver.findElement(By.id("")).sendKeys("C:\\Documents\\myFile.txt");
        WebElement ele = driver.findElement(By.xpath(""));
        String sss = ele.getText();
        Point p = ele.getLocation();p.getX();p.getY();
        Dimension d = ele.getSize();d.getWidth();d.getHeight();
        boolean b1 = ele.isDisplayed();
        boolean b2 = ele.isEnabled();
        boolean b3 = ele.isSelected();
        String s1 = ele.getAttribute("href");
        ele.submit();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        alert.accept();
        alert.getText();
        alert.sendKeys("");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
        webDriverWait.until(ExpectedConditions.titleIs("Beautiful"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(""))).submit();
        webDriverWait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(ele, ""));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)).switchTo().frame(0);

        FluentWait wait = new FluentWait(driver);
        wait.pollingEvery(Duration.ofSeconds(300));
        wait.withTimeout(Duration.ofSeconds(300));
        wait.ignoring(NoSuchElementException.class);
        WebElement foo;
        foo = (WebElement) wait.until((Function<WebDriver, WebElement>) driver1 -> driver1.findElement(By.id("foo")));

        Actions actions = new Actions(driver);
        actions.moveToElement(ele).scrollToElement(ele).build().perform();
        actions.scrollToElement(ele).clickAndHold(ele).release(ele).build().perform();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");

        File tke = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tke, new File("C:\\document\\myFiles.png"));


        String currentHandlr = driver.getWindowHandle();
        Set<String> totWindow =  driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(totWindow);
        for(String s: tabs){
            if(!s.equals(currentHandlr)){
                driver.switchTo().window(s);
            }
        }

        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        for(WebElement e: imgList){
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(e.getAttribute("src"));
            HttpResponse resp = client.execute(request);
            if(resp.getStatusLine().getStatusCode()!=200){
                System.out.println("Broken image found");
            }

        }
    }

    //@Test(expectedExceptions= NoSuchElementException.class)
    public void foo(){

    }
}
