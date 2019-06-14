package com.jsystems.qa2.api;

import com.jsystems.qa2.api.database.UserDao;
import com.jsystems.qa2.api.model.error.ErrorResponse;
import com.jsystems.qa2.api.model.user.MyUser;
import com.jsystems.qa2.api.model.user.User;
import com.jsystems.qa2.api.model.user.UserDb;
import com.jsystems.qa2.api.service.ApiService;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@DisplayName("Api tests")
public class ApiTest {
    @Test
    public void firstApiTest()
    {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("Piotr"))
                .body("surname", Matchers.equalTo("Kowalski"));

    }

    @Test
    public void secondApiTest()
    {
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", Matchers.equalTo("Piotr"))
                .body("[0].imie", Matchers.notNullValue())
                .body("[0].nazwisko", Matchers.equalTo("Kowalski"))
                .body("[0].nazwisko", Matchers.notNullValue())
                //.body("[0].device[0].device.model.produce", Matchers.equalTo("Kowalski"))
                // nie przejdzie bo nazwa pola zawiera kropke
        ;
    }

    @Test
    @DisplayName("First test with mapping to jsonPath")
    public void jsonPathTest()
    {
        List<User> users = new ApiService().getUsers();

        assertThat(users.get(0).imie.equals("Piotr"));
        assertThat(users.get(0).nazwisko.equals("Kowalski"));
        assertThat(users.get(0).device.get(0).type).isEqualTo("computer");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize).isEqualTo(17);
    }

    @Test
    @DisplayName("Test with mapped MyUser")
    public void myUserJsonPathTest()
    {
        MyUser user = ApiService.getUser();

        assertThat(user.name).isEqualTo("Piotr");
        assertThat(user.surname).isEqualTo("Kowalski");
    }

    @Test
    @DisplayName("Post test")
    public void postTest()
    {
        String[] strings = ApiService.postMyUser(new MyUser("Piotr", "Kowalski"));

        assertThat(strings).isEmpty();
    }

    @Test
    @DisplayName("Error response test")
    public void errorResponseTest()
    {
        ErrorResponse errorResponse = ApiService.getErrorResponse();

        assertThat(errorResponse.error.errorCode).isEqualTo(400);
        assertThat(errorResponse.error.validationError).isEqualTo(400);
        assertThat(errorResponse.error.message).isEqualTo(400);
    }

    @Test
    public void dbTest ()
    {
        UserDb userDb = UserDao.getOneById(1L);

        assertThat(userDb.getName()).isEqualTo("Piotr");
    }
}
