import clients.AuthClient;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static utils.DataGenerator.getRandomEmail;
import static org.hamcrest.Matchers.equalTo;

public class UserUpdateTest extends BaseTest {

    private String email = getRandomEmail();
    private String accessToken;
    private AuthClient authClient;

    @Before
    @DisplayName("Устанавливаем базовый URI для всех запросов и Регистрируем и логинимся для получения accessToken")
    public void setup() {
        super.setup();
        authClient = new AuthClient();
        accessToken = authClient.registerUser(email, "password123", "Update User")
                .then()
                .extract()
                .path("accessToken");
    }

    @Test
    @DisplayName("Обновление данных пользователя с авторизацией")
    public void updateUserWithAuth() {
        authClient.updateUser(accessToken, "Updated Name")
                .then()
                .statusCode(200) // Проверяем, что код ответа 200
                .body("success", equalTo(true)); // Проверяем, что поле success равно true
    }

    @Test
    @DisplayName("Обновление данных пользователя без авторизации")
    public void updateUserWithoutAuth() {
        authClient.updateUserWithoutAuth("Updated Name")
                .then()
                .statusCode(401) // Проверяем, что код ответа 401 (Unauthorized)
                .body("success", equalTo(false)) // Проверяем, что поле success равно false
                .body("message", equalTo("You should be authorised")); // Проверяем сообщение об ошибке
    }

    @After
    @Step("Удаление созданного пользователя")
    public void deleteUser() {
        if (accessToken != null) {
            authClient.deleteUser(accessToken);
        }
    }
}
