package CareerStepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CareerPage;
import utilities.DriverFactory;

import static org.testng.AssertJUnit.*;

public class CareerStepDefination {


WebDriver driver = DriverFactory.getDriver();
CareerPage careerPage = new CareerPage(driver);

String  jobTitle;
String  jobLocation ;
String jobId;





    @Given("I launch the Lab corp website")
    public void iLaunchTheLabCorpWebsite() {
        driver.get("https://www.labcorp.com");
    }

    @When("I click on the Careers link")
    public void iClickOnTheCareersLink() {
        careerPage.clickCareers();

    }

    @And("I search for {string}")
    public void search_for_job(String jobTitleSearch) {
        System.out.println(jobTitleSearch);
        careerPage.searchJob(jobTitleSearch);
    }

    @And("I select the job from the search results")
    public void select_job_from_results() {
        careerPage.selectJobFromResults();
        jobTitle = careerPage.getJobTitle();
        jobLocation = careerPage.getJobLocation();
        jobId = careerPage.getJobId();
    }

    @Then("I validate the job title, job location, and job ID")
    public void validate_job_details() {
        assertNotNull(jobTitle);
        assertNotNull(jobLocation);
        assertNotNull(jobId);
    }



    @And("I validate the second bullet point under Management Support")
    public void validate_management_support() {
        careerPage.getSecondBulletManagement();
    }
    @And("I validate the third requirement as {string}")
    public void validate_third_requirement(String requirement) {
        careerPage.getThirdRequirement();
    }
    @And("I validate the first suggested automation tool contains {string}")
    public void validate_automation_tool(String tool) {
        careerPage.getSuggestedTools();
    }

    @When("I click Apply Now")
    public void click_apply_now() {
        careerPage.clickApplyNow();
    }

    @Then("I confirm job details match on the application page")
    public void confirm_job_details_on_apply_page() {
        assertEquals(jobTitle, careerPage.getJobTitleOnApply());
        assertEquals(jobLocation, careerPage.getJobLocationOnApply());
        assertEquals(jobId, careerPage.getJobIdOnApply());
    }

    @And("I return to the Job Search page")
    public void return_to_job_search() throws InterruptedException {
        careerPage.returnToSearchPage();
    }



    @And("I validate the first sentence of the third paragraph under Description Introduction")
    public void validate_description_intro() {
       // assertTrue(careerPage.getThirdParagraphText().contains("The right candidate for this role will participate in the test automation technology development and best practice models."));
    }
}
