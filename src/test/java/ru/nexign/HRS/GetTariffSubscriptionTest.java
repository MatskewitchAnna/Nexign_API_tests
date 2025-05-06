package ru.nexign.HRS;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.nexign.Service;

import static java.net.HttpURLConnection.HTTP_OK;

public class GetTariffSubscriptionTest {
    private final TariffsSteps step = new TariffsSteps();

    @Before
    public void setUp() {
        RestAssured.baseURI = Service.BASE_URL_HRS;
    }

    @Test
    @DisplayName("Получение информации о стоимости подписки на тариф")
    @Description("Информация получена, если все данные введены корректно")
    public void getTariffSubscriptionTest() {
        Response response = step.tariffSubscription("11");
        step.compareResultToTrue(response, HTTP_OK);
    }

    //На будущее: прописать негативные тесты?
}
