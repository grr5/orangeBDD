package orangeHRMBDD.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import orangeHRMBDD.base.BaseTest;
import orangeHRMBDD.pageObjects.AddEmployee;
import orangeHRMBDD.pageObjects.HomePage;
import orangeHRMBDD.pageObjects.LoginPage;
import orangeHRMBDD.pageObjects.PimPage;
import org.junit.Assert;

import java.io.IOException;

public class StepDefsNewEmployee extends BaseTest {
    LoginPage loginPage;

    //Admin Login stepdefs

    @Given("^admin is on login page$")
    public void admin_is_on_login_page() {
        browserSetup();
        loginPage = new LoginPage();
    }

    @When("^admin enters username and password$")
    public void admin_enters_username_and_password() throws IOException {
        LoginPage.login(prop.getProperty("name"), prop.getProperty("password"));

    }

    @Then("^the admin should successfully login$")
    public void the_admin_should_successfully_login() {
        String message = HomePage.verifyAdminLogin();
        Assert.assertEquals(message, "Welcome Admin");

    }

    //Adding new employee stepdefs

    @Given("^admin is logged in and is on homepage$")
    public void admin_is_logged_in_and_is_on_homepage() throws Throwable {
        browserSetup();
        loginPage = new LoginPage();
        LoginPage.login(prop.getProperty("name"), prop.getProperty("password"));
    }

    @When("^admin click on pim link$")
    public void admin_click_on_pim_link() throws Throwable {
        HomePage.goToPimPage();
    }

    @Then("^admin clicked on add employee button$")
    public void admin_clicked_on_add_employee_button() throws Throwable {
        PimPage.clickOnAddEmployee();
    }

    @Then("^admin enters employee details as \"([^\"]*)\" and \"([^\"]*)\" and click on save button$")
    public void admin_enters_new_employee_with(String arg1, String arg2) throws Throwable {
        AddEmployee.newEmployee(arg1,arg2);

    }

    @Then("^admin can add more details$")
    public void admin_can_add_more_details() throws Throwable {
       AddEmployee.editEmpDetails();
    }

    //Employee list stepdefs

    @When("^admin clicked on employee list button$")
    public void admin_clicked_on_employee_list_button() throws Throwable {
        PimPage.clickOnEmployeeList();
    }

    @Then("^admin should see the list of employees$")
    public void admin_should_see_the_list_of_employees() throws Throwable {
        //Assertion
    }


}
