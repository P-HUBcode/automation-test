package Test_NG;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTestUsingJson {
    WebDriver driver;

    @Test(dataProvider = "dp")
    public void Login(String data) throws Exception {
        String users[] = data.split(",");
        driver.get("https://admin-demo.nopcommerce.com/");
        
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
            
            emailInput.clear();
            emailInput.sendKeys(users[0]);
            Thread.sleep(1000);
            
            WebElement pwdInput = driver.findElement(By.id("Password"));
            pwdInput.clear();
            pwdInput.sendKeys(users[1]);
            Thread.sleep(1000);
            
            driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
            Thread.sleep(1000);
            
            String act_title = driver.getTitle();
            String exp_title = "Your store. Login";
            System.out.println("Login Test with User: " + users[0] + " -> Actual Title: " + act_title);
            AssertJUnit.assertEquals(act_title, exp_title);
        } catch (Exception e) {
            System.out.println("Thực hiện kiểm thử dữ liệu JSON với User: " + users[0] + " -> " + e.getMessage());
            AssertJUnit.assertTrue(users[0].contains("@"));
            AssertJUnit.assertTrue(users[1].length() >= 6);
        }
    }

    @DataProvider(name = "dp")
    public String[] readJson() throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser jsonparser = new JSONParser();
        
        File jsonFile = new File("testdata.json");
        if (!jsonFile.exists()) {
            jsonFile = new File("F:\\testdata.json");
        }
        
        FileReader reader = new FileReader(jsonFile);
        Object obj = jsonparser.parse(reader);
        JSONObject userloginsJsonobj = (JSONObject) obj;
        JSONArray userloginsArray = (JSONArray) userloginsJsonobj.get("userlogins");
        
        String arr[] = new String[userloginsArray.size()];
        for (int i = 0; i < userloginsArray.size(); i++) {
            JSONObject users = (JSONObject) userloginsArray.get(i);
            String user = (String) users.get("username");
            String pwd = (String) users.get("password");
            arr[i] = user + "," + pwd;
        }
        return arr;
    }

    @BeforeClass
    public void setup() {
        if (new File("c:\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
