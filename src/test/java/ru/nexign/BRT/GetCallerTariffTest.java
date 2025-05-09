package ru.nexign.BRT;


import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.nexign.Service;

import static java.net.HttpURLConnection.HTTP_OK;

// Тесты получения информации о тарифе абонента
public class GetCallerTariffTest {
    private final CallersSteps step = new CallersSteps();

    @Before
    public void setUp() {
        RestAssured.baseURI = Service.BASE_URL;
    }

    @Test
    @DisplayName("Обновление тарифа абонента")
    @Description("Тариф обновлён, если все данные введены корректно")
    public void updateCallerTariffTest() {
        Response response = step.callerUpdateTariff("1", "11");
        step.statusCodeCorrect(response, HTTP_OK);
    }

    //На будущее: прописать негативные тесты?
}
