import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.TrangLienHe;

public class TestCases {
    public static void main(String[] args) throws InterruptedException {
        if (new File("c:\\chromedriver.exe").exists()) {
            System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        }
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        try {
            driver.manage().window().maximize();
            driver.navigate().to("https://xaydungphanmem.com");
            
            // Click liên kết Liên Hệ (hỗ trợ cả Liên Hệ và Liên hệ)
            try {
                driver.findElement(By.linkText("Liên Hệ")).click();
            } catch (Exception e) {
                try {
                    driver.findElement(By.partialLinkText("Liên")).click();
                } catch (Exception e2) {
                    driver.navigate().to("https://xaydungphanmem.com/lien-he/");
                }
            }

            TrangLienHe lienhe = new TrangLienHe(driver);

            // Nhập thông tin form liên hệ
            System.out.println("Dang nhap thong tin lien he...");
            lienhe.NhapThongTin("Lớp trưởng Long Ca", "longca@gmail.com", "12345667", "Chào các bạn sinh viên VLU siêng năng, không chơi game");
            Thread.sleep(2000);
            
            // Xóa thông tin đã nhập
            System.out.println("Dang xoa thong tin...");
            lienhe.XoaThongTin();
            System.out.println("Hoan thanh TestCases main()!");
        } finally {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
