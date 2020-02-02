package net.homecredit.testautomation.us.Steps;


import lombok.extern.slf4j.Slf4j;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehavesupport.core.TestContext;
import org.jbehavesupport.core.expression.ExpressionEvaluatingParameter;
import org.jbehavesupport.core.web.WebElementLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class eshopCustomSteps {

    @Autowired
    private TestContext testContext;

    @Autowired
    private WebElementLocator webElementLocator;

    @Autowired
    private WebDriver driver;

    private final int waitTimeLimit = 25;

    private static final long ONE_SECOND = 1000;

    @Given("following text is logged: $text")
    public void print(ExpressionEvaluatingParameter<String> text) {
        log.info(text.getValue());
    }

    @Given("save a value [$value] into a context [$context]")
    public void saveVal(String value,String context){
        testContext.put(context,value);
    }

    @When("write out the context [$context]")
    public void writeOut(String context){
        System.out.println(testContext.get(context).toString());
    }

    @Given("open a web page with URL [$url]")
    public void openWebPage(String url){
        String urlContext = testContext.get(url);
        if(urlContext!=null){
            driver.get(urlContext);
        }

    }
    @Then("wait on the page [$page] for an element [$element] until is clickable")
        public void waitForElement(String page, String element) {
        WebDriverWait wait = new WebDriverWait(driver, waitTimeLimit);
        WebElement webElement = webElementLocator.findElement(page, element);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    @Then("on the page [$page] hover element [$element]")
    public void hovering(String page, String element){
        Actions action = new Actions(driver);
        WebElement webElement = webElementLocator.findElement(page,element);
        action.moveToElement(webElement).perform();

    }

    @When("on the page [$page] click on the element [$element]")
    public void clickOnElement(String page, String element){
        Actions action = new Actions(driver);
        WebElement webElement = webElementLocator.findElement(page,element);
        action.click(webElement).perform();

    }

    @Then("check on the page [$page] the element [$element] has value [$contextValue]")
    public void checkContent(String page,String element, String contextValue){
        String valContext = testContext.get(contextValue);
        if(!valContext.isEmpty()){
            WebElement webElement = webElementLocator.findElement(page,element);
            String elemText = webElement.getText();
            if(!valContext.equals(elemText)) throw new IllegalArgumentException("value "+ valContext + " is not equal to "+ elemText);
        }
        else {
            throw new IllegalArgumentException("value of an element must be specified");
        }
    }

    @Then("on the page [$page] save value of element [$element] in to context [$contextName]")
    public void saveContent(String page, String element, String contextName){
        WebElement webElement = webElementLocator.findElement(page,element);
        String elemText = webElement.getText();
        if(!elemText.isEmpty() && !contextName.isEmpty()){
            testContext.put(contextName,elemText);
        }else {
            throw new IllegalArgumentException("empty String(s) ! "+elemText+ " "+contextName);
        }

    }

    @Then("execution waits for $waitTime seconds")
    public void waitForSeconds(int waitTime) {
        try {
            Thread.sleep(waitTime * ONE_SECOND);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    @Then("on the page [$page] focus on element [$element]")
    public void focusElement(String page,String element){
        WebElement webElement = webElementLocator.findElement(page,element);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
    }

}
