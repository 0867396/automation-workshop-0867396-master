package be.ucll.bmi.model.steps;

import be.ucll.bmi.PatientApplication;
import be.ucll.bmi.data.Persona;
import be.ucll.bmi.model.Examination;
import be.ucll.bmi.model.Patient;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@CucumberContextConfiguration
@SpringBootTest(classes = PatientApplication.class)
public class ConsultPatientDetailsUnitSteps extends UnitSteps {

    @Before
    public void setUp(){
        reset();
    }


    @When("Martha requests the patient details of Tom")
    public void martha_requests_the_patient_details_of_tom() {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("Tom");
        context.setPatient(patient);
    }
    @Then("a BMI of {double} should be given")
    public void a_bmi_of_should_be_given(Double expectedBmi) {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = context.getPatient();
        Examination mostRecentExamination = patient.getMostRecentExamination();
        assertEquals(expectedBmi, mostRecentExamination.getBmi());

    }

    @Given("Tom's last examined length is {int} cm")
    public void tom_s_last_examined_length_is_cm(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("Tom");
    }
    @Given("Tom's last examined weight is {int} gr")
    public void tom_s_last_examined_weight_is_gr(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("Tom");
        context.getWeight();
    }



    @Given("patient Tom is registered")
    public void patient_tom_is_registered() {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("Tom");
        context.setPatient(patient);
    }
    @Then("Tom's details should be given")
    public void tom_s_details_should_be_given() {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("Tom");
        context.setPatient(patient);
    }
    @Then("Tom's BMI from the last examination should be given")
    public void tom_s_bmi_from_the_last_examination_should_be_given() {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("Tom");
        patient.getExaminations();
    }

    @Given("patient Sara is not registered")
    public void patient_sara_is_not_registered() {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("");


    }
    @When("Martha requests the patient details of Sara")
    public void martha_requests_the_patient_details_of_sara() {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("Sara");
        context.setPatient(patient);
    }
    @Then("Martha should be given an error message explaining that the requested patient does not exist")
    public void martha_should_be_given_an_error_message_explaining_that_the_requested_patient_does_not_exist() {
        // Write code here that turns the phrase above into concrete actions
        context.getErrors();

    }



}
