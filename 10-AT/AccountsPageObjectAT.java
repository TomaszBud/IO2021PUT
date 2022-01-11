package put.selenium.pageobjects;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.pageobjects.repository.*;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AccountsPageObjectAT {

    private WebDriver driver;

    private ResetDatabase resetDatabse;
    private MainMenu mainMenu;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private LoggedInUserInformation loggedInUserInfo;

    private String hostURL;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {

        Properties properties = new Properties();
        InputStream in = getClass().getResourceAsStream("selenium.properties");
        properties.load(in);
        in.close();
        WebElement header;
        this.hostURL=properties.getProperty("host.url");

        System.setProperty("webdriver.chrome.driver", "chromedriver-96.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);

        resetDatabse = new ResetDatabase(driver, this.hostURL);
        mainMenu = new MainMenu(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver, this.hostURL);
        loggedInUserInfo = new LoggedInUserInformation(driver);

        resetDatabse.resetDatabase();
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        driver.manage().window().setSize(new Dimension(974, 1040));
        driver.findElement(By.linkText("Home")).click();
        assertEquals(true, mainPage.isOnPageNotLoggedIn());
        driver.findElement(By.linkText("Register")).click();
        assertEquals(true, registrationPage.isOnPage());
        registrationPage.registerUser("user", "password", "password", "Jan Kowalski", "ul. Nowa 10");
        assertEquals(true, mainPage.isOnPageNotLoggedIn());
        loginPage.loginUser("user", "password");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("user");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("Login")).click();
        assertEquals(true, mainPage.isOnPageNotLoggedIn());

    }


}
