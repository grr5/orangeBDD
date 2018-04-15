package orangeHRMBDD.pageObjects;

import orangeHRMBDD.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddEmployee extends BaseTest {
    @FindBy(id = "firstName")
    static WebElement firstName;

    @FindBy(id = "lastName")
    static WebElement lastName;

    @FindBy(id = "btnSave")
    static WebElement saveButton;

    @FindBy(id = "btnSave")
    static WebElement editButton;

    @FindBy(id = "personal_optGender_1")
    static WebElement gender;

    @FindBy(id = "personal_cmbMarital")
    static WebElement maritalStatus;

    @FindBy(id = "btnSave")
    static WebElement editSaveButton;

    public AddEmployee(){
        PageFactory.initElements(driver, this);
    }

    public static AddEmployee newEmployee(String fName, String lName){
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        saveButton.click();
        return new AddEmployee();
    }

    public static AddEmployee editEmpDetails(){
        editButton.click();
        gender.click();
        Select maritalDropdown = new Select(maritalStatus);
        maritalDropdown.selectByVisibleText("Married");
        WebElement selectedValue1 = maritalDropdown.getFirstSelectedOption();
        System.out.println("selected value is " +selectedValue1.getText());
        Assert.assertEquals(selectedValue1.getText(), "Married");
        editSaveButton.click();
        return new AddEmployee();
    }
}
