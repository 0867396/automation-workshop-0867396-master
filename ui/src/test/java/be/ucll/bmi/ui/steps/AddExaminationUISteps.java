package be.ucll.bmi.ui.steps;

import be.ucll.bmi.data.Persona;
import be.ucll.bmi.model.Examination;
import be.ucll.bmi.pages.AddExaminationPage;
import be.ucll.bmi.pages.PatientDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddExaminationUISteps extends UISteps {

    @Given("Martha is viewing the patient file of Tom")
    public void martha_is_viewing_the_patient_file_of_tom() {
        // Write code here that turns the phrase above into concrete actions
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        String ssn = Persona.getSsn("Tom");
        patientDetailsPage.open(ssn);
    }
    @When("Martha adds a new examination for Tom")
    public void martha_adds_a_new_examination_for_tom() {
        // Write code here that turns the phrase above into concrete actions
        Examination examination = new Examination(181, 76000, LocalDate.now());
        context.setExamination(examination);
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        AddExaminationPage addExaminationPage = patientDetailsPage.goToAddExamination();
        addExaminationPage.fillInLength(181);
        addExaminationPage.fillInWeight(76000);
        addExaminationPage.fillInExaminationDate(LocalDate.now());
        addExaminationPage.addExamination();


    }
    @Then("the examination should be added to Tom's examinations")
    public void the_examination_should_be_added_to_tom_s_examinations() {
        // Write code here that turns the phrase above into concrete actions
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        assertTrue(patientDetailsPage.isOpen());
        Examination examination = new Examination(181, 76000, LocalDate.now());
        context.setExamination(examination);
        System.out.println(context.getExamination().getExaminationDate());
        assertEquals(context.getExamination().getExaminationDate(),patientDetailsPage.getExaminationDate());
        assertEquals(context.getExamination().getLength(),patientDetailsPage.getLength());
        assertEquals(context.getExamination().getWeight(),patientDetailsPage.getWeight());
    }
    @Then("the BMI should be recalculated")
    public void the_bmi_should_be_recalculated() {
        // Write code here that turns the phrase above into concrete actions
        Examination examination = new Examination(181, 76000, LocalDate.now());
        context.setExamination(examination);
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        assertEquals(context.getExamination().getBmi(),patientDetailsPage.getBmi());
    }

}
