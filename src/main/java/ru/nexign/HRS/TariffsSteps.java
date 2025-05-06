package ru.nexign.HRS;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.nexign.Service;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TariffsSteps {
    private final TariffsClient tariffsClient = new TariffsClient();

    @Step("Получение информации о тарифе")
    public Response tariffInfo(String tariffUuid){
        Response response = tariffsClient.getTariffInfo(tariffUuid);
        printResponseBody("Получение информации о тарифе: ", response, Service.DETAIL_LOG);
        return response;
    }

    @Step("Расчёт стоимости звонка по тарифу")
    public Response tariffCalculation(String outcomingCallerId, String tariffUuid, String operatorName,
                                       String startCallTime, String finishCallTime, int balance, int minutes){
        Response response = tariffsClient.calculationTariff(outcomingCallerId, tariffUuid, operatorName,
                startCallTime, finishCallTime, balance, minutes);
        printResponseBody("Расчёт стоимости звонка по тарифу: ", response, Service.DETAIL_LOG);
        return response;
    }

    @Step("Получение информации о всех тарифах")
    public Response allTariffsInfo(){
        Response response = tariffsClient.getAllTariffsInfo();
        printResponseBody("Получение информации о всех тарифах: ", response, Service.DETAIL_LOG);
        return response;
    }

    @Step("Получение информации о стоимости подписки на тариф")
    public Response tariffSubscription(String tariffUuid){
        Response response = tariffsClient.getTariffSubscription(tariffUuid);
        printResponseBody("Получение информации о стоимости подписки на тариф: ", response, Service.DETAIL_LOG);
        return response;
    }

    @Step("Проверка, что результат = true")
    public void compareResultToTrue(Response response, int statusCode){
        response
                .then()
                .assertThat()
                .log().all()
                .statusCode(statusCode)
                .body("ok", is(true));
    }

//    @Step("Сравнение результата с текстовым сообщением")
//    public void compareResultMessageToText(Response response, int statusCode, String text){
//        response
//                .then()
//                .log().all()
//                .statusCode(statusCode)
//                .and()
//                .assertThat()
//                .body("message", is(text));
//    }

    @Step("Вывод текста ответа")
    public void printResponseBody(String headerText, Response response, boolean detailedLog){
        if (detailedLog)
            System.out.println(headerText + response.body().asString());
    }

//    @Step("Проверка, что tariffUuid не null")
//    public void compareUuidNotNull(Response response){
//        response
//                .then()
//                .assertThat()
//                .log().all()
//                .statusCode(HTTP_OK)
//                .body("tariffUuid", notNullValue());
//    }
}
