import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PulseDoctorSignUpTest {

    public static void main(String[] args) {

        // 1️⃣ Setup Chrome Driver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // 2️⃣ Launch Browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3️⃣ Open Pulse Doctor Registration Page
        driver.get("https://bookwithpulse.vercel.app/admin/auth/register");

        // 4️⃣ Locate Input Fields
        WebElement fullName = driver.findElement(By.name("name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement phone = driver.findElement(By.name("phone"));
        WebElement fieldOfPractice = driver.findElement(By.name("specialization"));
        WebElement password = driver.findElement(By.name("password"));

        // 5️⃣ Enter Doctor Information
        fullName.sendKeys("Jobayer Hossain");
        email.sendKeys("admin@gmail.com");
        phone.sendKeys("0172883929");
        fieldOfPractice.sendKeys("Cardiology");
        password.sendKeys("Test@1234");

        // 6️⃣ Locate Sign Up Button using FULL XPATH
        WebElement signUpButton = driver.findElement(
                By.xpath("/html/body/div[1]/section/div/form/button")
        );

        // 7️⃣ Click Sign Up Button
        signUpButton.click();

        // 8️⃣ Validation (Basic Assertion)
        if (driver.getPageSource().contains("Dashboard")
                || driver.getCurrentUrl().contains("dashboard")) {

            System.out.println("✅ Doctor Registration Successful – Test Passed");
        } else {
            System.out.println("❌ Doctor Registration Failed – Test Failed");
        }

        // 9️⃣ Close Browser
        driver.quit();
    }
}
