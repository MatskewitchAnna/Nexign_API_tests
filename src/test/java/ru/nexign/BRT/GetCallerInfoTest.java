package ru.nexign.BRT;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.nexign.Service;

import static java.net.HttpURLConnection.HTTP_OK;

// Тесты получения информации об абоненте
public class GetCallerInfoTest {
    private final CallersSteps step = new CallersSteps();

    @Before
    public void setUp() {
        RestAssured.baseURI = Service.BASE_URL_BRT;
    }

    @Test
    @DisplayName("Получение информации об абоненте")
    @Description("Информация получена, если все данные введены корректно")
    public void getCallerInfoTest() {
        Response response = step.callerInfo("1");
        step.compareResultToTrue(response, HTTP_OK);
    }

    //На будущее: прописать негативные тесты?
}
