package TestNG;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.TrangLienHe;

public class TCs_LienHe {
    WebDriver driver;

    @Test(priority = 0, description = "Test case 01: Nhap thong tin lop truong Long Ca va xoa")
    public void TestCase01() throws InterruptedException {
        TrangLienHe lienhe = new TrangLienHe(driver);
        lienhe.NhapThongTin("Lớp trưởng Long Ca", "longca@gmail.com", "12345667", "Chào các bạn sinh viên VLU siêng năng, không chơi game");
        Thread.sleep(2000);
        lienhe.XoaThongTin();
        System.out.println("PASSED: TestCase01 (Lop truong Long Ca)");
    }

    @Test(priority = 1, description = "Test case 02: Nhap thong tin kiem thu tu dong va xoa")
    public void TestCase02() throws InterruptedException {
        TrangLienHe lienhe = new TrangLienHe(driver);
        lienhe.NhapThongTin("Kiểm thử tự động", "longloptruong@gmail.com", "12345667", "Chào các bạn sinh viên VLU không chơi game");
        Thread.sleep(2000);
        lienhe.XoaThongTin();
        System.out.println("PASSED: TestCase02 (Kiem thu tu dong)");
    }

    @BeforeTest
    public void beforeTest() {
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
        driver.navigate().to("https://xaydungphanmem.com");
        
        try {
            driver.findElement(By.linkText("Liên Hệ")).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.partialLinkText("Liên")).click();
            } catch (Exception e2) {
                driver.navigate().to("https://xaydungphanmem.com/lien-he/");
            }
        }
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
