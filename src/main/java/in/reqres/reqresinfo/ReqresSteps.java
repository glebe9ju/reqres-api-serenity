package in.reqres.reqresinfo;

import in.reqres.constants.EndPoints;
import in.reqres.model.ReqresPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ReqresSteps {
    @Step("Getting users")
    public ValidatableResponse getUserList() {
        return SerenityRest.given()
                .when()
                .get()
                .then();
    }

    @Step("Getting users")
    public ValidatableResponse singleUser(int userId) {
        return SerenityRest.given()
                .pathParam("userID", userId)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then();
    }

    @Step("Creating users with emil : {0},name: {1},lastname: {2},job: {3}")
    public ValidatableResponse createUser(String email, String name, String lastname, String job) {
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setEmail(email);
        reqresPojo.setLastname(lastname);
        reqresPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(reqresPojo)
                .when()
                .post()
                .then();
    }

    @Step("Updateing user information with userId: {0}, email: {1}, name {2}, lastname{3}, job{4}")
    public ValidatableResponse updateUserInformation(int userId, String email, String name, String lastname, String job) {
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setEmail(email);
        reqresPojo.setName(name);
        reqresPojo.setLastname(lastname);
        reqresPojo.setJob(job);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("userID", userId)
                .body(reqresPojo)
                .when()
                .put(EndPoints.UPDATE_SINGLE_USER_BY_ID)
                .then();
    }
    @Step("Deleting user information")
    public ValidatableResponse deleteUserId(int userId){
        return SerenityRest.given().log().all()
                .pathParam("userID", userId)
                .when()
                .delete(EndPoints.DELETE_SINGLE_USER_BY_ID)
                .then();

    }

}
