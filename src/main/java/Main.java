import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-notifications");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        WebElement webElementCookies = driver.findElement(By.xpath("//button[@title='Zezwól na korzystanie z niezbędnych i opcjonalnych plików cookie']"));
        webElementCookies.click();
        WebElement login = driver.findElement(By.xpath("//input[@placeholder='Adres e-mail lub numer telefonu']"));
        login.sendKeys("jerry4urban@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Hasło']"));
        password.sendKeys("gHtbS7hT*sdOp");
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();
        Thread.sleep(3000);
        driver.get("https://www.facebook.com/groups/BoiskoMSAGH?sorting_setting=CHRONOLOGICAL");

        List<WebElement> allDivs = driver.findElements(By.tagName("div"));

        allDivs.forEach(div -> {
            if (div.getText().equals("Napisz komentarz publiczny…")) {
                System.out.println("hererere");
            }
            System.out.println("text: " + div.getText());
        });

        int w = 4;

        Thread.sleep(500_000);
        driver.close();
    }

}
