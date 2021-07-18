package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //Selectors
    private final static By username_Input_By = By.id("name");
    private final static By password_Input_By = By.id("password");
    private final static By login_Button_By = By.id("button_primary");
    private final static By error_IncorrectCredentialsLabel_By = By.cssSelector(".loginpage-message-title .error-text");
    private final static By error_LoginRequiredLabel_By = By.xpath("//form[//input[@id='name']]/div[@class='loginpage-message-image loginpage-message ']");
    private final static By error_PasswordRequiredLabel_By = By.cssSelector(".display-flex .loginpage-message-image");

    //Constructors
    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getUrl());
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getLoginButtonBy().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Getters
    public WebElement getUsernameInputBy() {
        return driver.findElement(username_Input_By);
    }

    public WebElement getPasswordInputBy() {
        return driver.findElement(password_Input_By);
    }

    public WebElement getLoginButtonBy() {
        return driver.findElement(login_Button_By);
    }

    public WebElement getErrorLabel() {
        return driver.findElement(error_IncorrectCredentialsLabel_By);
    }

    public WebElement getLoginRequiredLabel() {
        return driver.findElement(error_LoginRequiredLabel_By);
    }

    public WebElement getPasswordRequiredLabel() {
        return driver.findElement(error_PasswordRequiredLabel_By);
    }


    //Atomic methods for work with elements
    public void setUserName(String userName) {
        getUsernameInputBy().sendKeys(userName);
    }

    public void setPassword(String password) {
        getPasswordInputBy().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButtonBy().click();
    }
}
