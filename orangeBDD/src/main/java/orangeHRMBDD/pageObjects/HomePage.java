package orangeHRMBDD.pageObjects;

import orangeHRMBDD.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    @FindBy(id = "welcome")
    static WebElement welcomeAdmin;

    @FindBy(linkText = "Admin")
    WebElement adminLink;

    @FindBy(linkText = "PIM")
    static WebElement pimLink;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public static String verifyAdminLogin(){
        return welcomeAdmin.getText();
    }

    public AdminPage goToAdminPage(){
        adminLink.click();
        return new AdminPage();
    }

    public static PimPage goToPimPage(){
        pimLink.click();
        return new PimPage();
    }
}
