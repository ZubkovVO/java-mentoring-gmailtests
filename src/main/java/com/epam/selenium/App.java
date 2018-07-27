/*package selenium.epam.com;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("disable-infobars");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize(); //во весь экран
        driver.get("https:/gmail.com/");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.findElement(By.id("identifierId")).clear();
        driver.findElement(By.id("identifierId")).sendKeys("selenium.tester80@gmail.com");
        driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/div[1]/div/div[1]/div/div[1]/input")));
        //driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/div[1]/div/div[1]/div/div[1]/input")).sendKeys("Administratum41");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Administratum41");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Написать']")));
        driver.findElement(By.xpath("//div[text()='Написать']")).click();
        //Thread.sleep(10000);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("to")));
        driver.findElement(By.name("to")).sendKeys("omg@sohard.com");
        driver.findElement(By.name("subjectbox")).sendKeys("Lorem ipsum dolor sit amet");
        driver.findElement(By.xpath("//div[@aria-label='Тело письма']")).sendKeys("This text is for testing purposes");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@aria-label='Сохранить и закрыть']")).click();

        driver.findElement(By.xpath("//a[text()='Черновики']")).click();
        //driver.get("https://mail.google.com/mail/u/0/#drafts");
        Thread.sleep(3000);


        Boolean isPresent;
        try {
            driver.findElement(By.xpath("//span[text()='This text is for testing purposes']"));
            isPresent = true;
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        if (isPresent) {
            System.out.println("Everything is fine with Draft");
        }

        driver.findElement(By.xpath("//span[text()='This text is for testing purposes']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElements(By.xpath("//span[@email='omg@sohard.com']")).size()>0);
        Assert.assertTrue(driver.findElements(By.xpath("//div[text()='Lorem ipsum dolor sit amet']")).size()>0);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Тело письма']")).getText(),"This text is for testing purposes");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@aria-label,'Отправить')]")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        try {
            driver.findElement(By.xpath("//span[text()='This text is for testing purposes']"));
            isPresent = true;
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        if (isPresent==false) {
            System.out.println("Everything is fine, no email");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Отправленные']")).click();
        Thread.sleep(3000);
        try {
            driver.findElement(By.xpath("//span[text()='This text is for testing purposes']"));
            isPresent = true;
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        if (isPresent) {
            System.out.println("Everything is fine");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=ru&continue=https://mail.google.com/mail&service=mail']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Выйти']")).click();

    }
}*/
