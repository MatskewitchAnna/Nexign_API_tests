package ru.nexign.HRS;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import ru.nexign.Service;

import static java.net.HttpURLConnection.HTTP_OK;

public class TariffCalculationTest {

    private final TariffsSteps step = new TariffsSteps();

    @Before
    public void setUp() {
        RestAssured.baseURI = Service.BASE_URL;
    }

    @Test
    @DisplayName("Расчёт стоимости звонка по тарифу")
    @Description("Расчёт завершён, если все данные введены корректно")
    public void createNewCallerTest() {
        Response response = step.tariffCalculation("1", "11", "Ромашка",
                "2025-05-06T11:30:00.537Z", "2025-05-06T11:40:00.537Z", 100, 100);
        step.statusCodeCorrect(response, HTTP_OK);
    }

    // Дописать негативные тесты? + Проверка правильности расчёта (подумать, как сделать)
}
