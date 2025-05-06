package ru.nexign.BRT;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.nexign.Service;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CallersSteps {
    private final CallersClient callersClient = new CallersClient();

    @Step("Создание абонента")
    public Response callerCreate(Callers callers){
        Response response = callersClient.createCaller(callers);
        printResponseBody("Создание абонента: ", response, Service.DETAIL_LOG);
        return response;
    }

    @Step("Получение информации об абоненте")
    public Response callerInfo(String callerUuid){
        Response response = callersClient.getCallerInfo(callerUuid);
        printResponseBody("Получение информации об абоненте: ", response, Service.DETAIL_LOG);
        return response;
    }

    @Step("Получение информации о всех абонентах")
    public Response allCallersInfo(){
        Response response = callersClient.getAllCallersInfo();
        printResponseBody("Получение информации о всех абонентах: ", response, Service.DETAIL_LOG);
        return response;
    }

    @Step("Обновление тарифа абонента")
    public Response callerUpdateTariff(String callerUuid, String tariffUuid){
        Response response = callersClient.updateCallerTariff(callerUuid, tariffUuid);
        printResponseBody("Обновление тарифа абонента: ", response, Service.DETAIL_LOG);
        return response;
    }

    @Step("Пополнение баланса абонента")
    public Response replenishmentBalance(String callerUuid, int amount){
        Response response = callersClient.balanceReplenishment(callerUuid, amount);
        printResponseBody("Пополнение баланса абонента: ", response, Service.DETAIL_LOG);
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

//    @Step("Проверка, что callerUuid не null")
//    public void compareUuidNotNull(Response response){
//        response
//                .then()
//                .assertThat()
//                .log().all()
//                .statusCode(HTTP_OK)
//                .body("callerUuid", notNullValue());
//    }
}
