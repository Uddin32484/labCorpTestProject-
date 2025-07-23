package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CareerPage {
    WebDriver driver;
    WebDriverWait wait;

    public CareerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickCareers() {
        driver.findElement(By.linkText("Careers")).click();
    }

    public void searchJob(String jobTitle) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("typehead")));
        searchBox.sendKeys(jobTitle);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void selectJobFromResults() {
        // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".search-results a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-ph-id='ph-page-element-page11-Zk12Zp' and contains(text(),'Test Master Analyst')]"))).click();
    }

    public String getJobTitle() {
      String jobName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='job-title' and  contains(text(), 'Test Master Analyst')]"))).getText();
      Assert.assertEquals(jobName, "Test Master Analyst");
        return jobName;
    }

    public String getJobLocation() {
        WebElement clickonSee = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/section/div/div/div/div[1]/section/div/div[1]/span[2]/span/button"));
        clickonSee.click();
       String jobLocation = driver.findElement(By.xpath("//li[@class='each-location']")).getText();
        System.out.println(jobLocation);
        Assert.assertEquals(jobLocation, "Burlington, North Carolina, United States of America");
        driver.findElement(By.xpath("//button[@class='close ph-a11y-close-multi-location au-target']//i")).click();

        return jobLocation;
    }

    public String getJobId() {
        String jobIDSearch = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/section/div/div/div/div[1]/section/div/div[1]/span[3]")).getText();
        Assert.assertEquals(jobIDSearch, "Job ID : 2524704");

        return jobIDSearch;
    }

    public String getThirdParagraphText() {
        WebElement thirdParagraph = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[1]/section[1]/div/div"))).get(2); // 0-based index
        String actualThirdPara = thirdParagraph.getText().trim();
        String expectedThirdPara = "The right candidate for this role will participate in the test automation technology development and best practice models.";
        if (!actualThirdPara.equals(expectedThirdPara)) {
            throw new AssertionError(" Mismatch in 3rd paragraph:Expected: " + expectedThirdPara + "Actual: " + actualThirdPara);
        }
      return thirdParagraph.getText();

    }

    public void getSecondBulletManagement() {
        String  actualSecondBullet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='jd-info au-target']//p)[1]"))).getText();
        actualSecondBullet =  actualSecondBullet.trim();
        String expectedSecondBullet = "project planning, execution";
      boolean status =   verifyText( actualSecondBullet,  expectedSecondBullet);
       Assert.assertTrue(status);
        System.out.println(actualSecondBullet+ " checking text");
    }

    public void getThirdRequirement() {
        String  thirdRequirement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='jd-info au-target']//p)[14]"))).getText();
        String actualThirdReq = thirdRequirement.trim();
        System.out.println(actualThirdReq);
        String expectedThirdReq = "2-5 years of relevant experience in test data";
        boolean status =   verifyText(actualThirdReq, expectedThirdReq);
        Assert.assertTrue(status);


    }

    public void getSuggestedTools() {
        String  toolsList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='jd-info au-target']//p)[24]"))).getText();
        String actualTool = toolsList.trim();
        String expectedTool = "Familiarity with programming languages such as SAS and SQL.";
        boolean status =   verifyText(actualTool, expectedTool);
        Assert.assertTrue(status);


    }

    public void clickApplyNow() {
        WebElement    applyButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@ph-tevent='apply_click'])[2]")));
         //= wait.until(ExpectedConditions.presenceOfElementLocated(app));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyButton);
        Assert.assertTrue(applyButton.isDisplayed());
        applyButton.click();

    }

    public String getJobTitleOnApply() {
        return driver.findElement(By.cssSelector(".apply-page .job-title")).getText();
    }

    public String getJobLocationOnApply() {
        return driver.findElement(By.cssSelector(".apply-page .job-location")).getText();
    }

    public String getJobIdOnApply() {
        return driver.findElement(By.cssSelector(".apply-page .job-id")).getText();
    }

    public void returnToSearchPage() throws InterruptedException {
        //WebElement    applyButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/header/div[2]/div[3]/div/nav/button")));
        Thread.sleep(8000);
       // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div/div[2]/div[3]/div/button")).click();
        driver.navigate().to("https://careers.labcorp.com/global/en");
       // driver.navigate().back();
       String strUrl = driver.getCurrentUrl();
       Assert.assertEquals(strUrl, "https://careers.labcorp.com/global/en");
    }







    public static boolean verifyText(String actualText, String expectedText) {
        if (actualText == null || expectedText == null) {
            System.out.println("Either actual or expected text is null.");
            return false;
        }

        if (actualText.contains(expectedText)) {
            System.out.println(" Text matched: " + expectedText + " found in the actual text.");
            return true;
        } else {
            System.out.println("Text did NOT match" + actualText + " Not found in the expected text.");
            return false;
        }
    }


}