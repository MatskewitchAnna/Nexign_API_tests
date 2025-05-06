package ru.nexign.HRS;

import io.restassured.response.Response;
import ru.nexign.Service;

import static io.restassured.RestAssured.given;

public class TariffsClient extends Service {
    private static final String TARIFF_CALCULATION_PATH = "/api.hrs/v1/tariffs/calculation";
    private static final String TARIFF_INFO_PATH = "/api.hrs/v1/tariffs";
    private static final String ALL_TARIFFS_INFO_PATH = "/api.hrs/v1/tariffs/info";
    private static final String TARIFFS_SUBSCRIPTION_PATH = "/api.hrs/v1/tariffs/subscription";

    public Response calculationTariff (String outcomingCallerId, String tariffUuid, String operatorName,
                                       String startCallTime, String finishCallTime, int balance, int minutes){
        String calculationData = "{ \"outcomingCallerId\": " + outcomingCallerId + "," +
                "\n{ \"tariffUuid\": " + tariffUuid +"," +
                "\n{ \"operatorName\": " + operatorName +"," +
                "\n{ \"startCallTime\": " + startCallTime +"," +
                "\n{ \"finishCallTime\": " + finishCallTime +"," +
                "\n{ \"balance\": " + balance +"," +
                "\n{ \"minutes\": " + minutes +"}";
        return given()
                .spec(getBaseSpecificationHRS())
                .and()
                .body(calculationData)
                .log().all()
                .post(TARIFF_CALCULATION_PATH);
    }

    public Response getTariffInfo (String tariffUuid){
        return given()
                .spec(getBaseSpecificationHRS())
                .get(TARIFF_INFO_PATH + tariffUuid);
    }

    public Response getAllTariffsInfo (){
        return given()
                .spec(getBaseSpecificationHRS())
                .get(ALL_TARIFFS_INFO_PATH );
    }

    public Response getTariffSubscription (String tariffUuid){
        return given()
                .spec(getBaseSpecificationHRS())
                .get(TARIFFS_SUBSCRIPTION_PATH + tariffUuid);
    }
}
