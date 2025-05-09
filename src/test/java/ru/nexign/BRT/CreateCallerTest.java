package ru.nexign.BRT;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.nexign.Service;

import static java.net.HttpURLConnection.HTTP_CREATED;

// Тесты создания нового абонента
public class CreateCallerTest {
    private final CallersSteps step = new CallersSteps();
    private Callers callerRandom;

    @Before
    public void setUp() {
        RestAssured.baseURI = Service.BASE_URL;
        callerRandom = CallerRandomData.randomCaller();
    }

    @Test
    @DisplayName("Создание нового абонента")
    @Description("Абонент создан, если все данные введены корректно")
    public void createNewCallerTest() {
        Response response = step.callerCreate(callerRandom);
        step.statusCodeCorrect(response, HTTP_CREATED);
    }

    //На будущее: прописать негативные тесты?
}
