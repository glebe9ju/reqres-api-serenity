package in.reqres.reqresinfo;

import in.reqres.reqresinfo.testbase.TestBase;
import in.reqres.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ReqresCRUDtestWithSteps extends TestBase {

    static String email = TestUtils.getRandomValue() + "xyz123@gmail.com";
    static String name = "Elisa" + TestUtils.getRandomValue();
    static String lastname = "Patric" + TestUtils.getRandomValue();
    static String job = "Quality Tester";
    static int iD;


    @Steps
    ReqresSteps reqresSteps;

    @Title("Get all user List ")
    @Test
    public void test001() {
        reqresSteps.getUserList().log().all().statusCode(200);
    }

    @Title("Get single user  ")
    @Test
    public void test002() {
        reqresSteps.singleUser(6).log().all().statusCode(200);
    }

    @Title("This will create new user")
    @Test
    public void test003() {
        ValidatableResponse response = reqresSteps.createUser(email, name, lastname, job);
        response.log().all().statusCode(201);

    }

    @Title("Update user information and verify the updated information")
    @Test
    public void test004() {
        reqresSteps.updateUserInformation(iD, email, name, lastname, job)
                .log()
                .all()
                .statusCode(200);

    }

    @Title("Delete the user id")
    @Test
    public void test005() {
        reqresSteps.deleteUserId(6).statusCode(204);
    }

}
