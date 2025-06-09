package automation.uipractice.year2025.june;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class June0506 {

    @Test
    public void testBrokenLinks() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://pkup.epam.com/main");
        System.out.println("I m here");
        Thread.sleep(3000);
        driver.close();
    }
}
