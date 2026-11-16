package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrangLienHe {
    private WebDriver driver;
    private By byTen = By.id("name");
    private By byEmail = By.name("email");
    private By byNumber = By.name("number");
    private By byNoiDung = By.name("message");

    public TrangLienHe(WebDriver driver) {
        this.driver = driver;
    }

    public void NhapThongTin(String inTen, String inEmail, String inNumber, String inNoidung) {
        driver.findElement(byTen).sendKeys(inTen);
        driver.findElement(byEmail).sendKeys(inEmail);
        driver.findElement(byNumber).sendKeys(inNumber);
        driver.findElement(byNoiDung).sendKeys(inNoidung);
    }

    public void XoaThongTin() {
        driver.findElement(byTen).clear();
        driver.findElement(byEmail).clear();
        driver.findElement(byNumber).clear();
        driver.findElement(byNoiDung).clear();
    }
}
