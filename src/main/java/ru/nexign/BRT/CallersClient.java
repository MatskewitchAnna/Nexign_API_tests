package ru.nexign.BRT;

import io.restassured.response.Response;
import ru.nexign.Service;

import static io.restassured.RestAssured.given;

public class CallersClient extends Service {
    private static final String CALLER_CREATE_PATH = "/api.brt/v1/callers/create";
    private static final String CALLER_INFO_PATH = "/api.brt/v1/callers";
    private static final String ALL_CALLERS_INFO_PATH = "/api.brt/v1/callers/info";
    private static final String CALLER_UPDATE_TARIFF_PATH = "/api.brt/v1/callers/updateTariff";
    private static final String CALLER_REPLENISHMENT_PATH = "/api.brt/v1/callers/replenishment";

    public Response createCaller (Callers callers){
        return given()
                .spec(getBaseSpecificationBRT())
                .and()
                .body(callers)
                .log().all()
                .post(CALLER_CREATE_PATH);
    }

    public Response getCallerInfo (String callerUuid){
        return given()
                .spec(getBaseSpecificationBRT())
                .get(CALLER_INFO_PATH + callerUuid);
    }

    public Response getAllCallersInfo (){
        return given()
                .spec(getBaseSpecificationBRT())
                .get(ALL_CALLERS_INFO_PATH);
    }

    public Response updateCallerTariff (String callerUuid, String tariffUuid){
        String tariffData = "{ \"callersUuid\": " + callerUuid + "," +
                "\n{ \"tariffUuid\": " + tariffUuid +"}";
        return given()
                .spec(getBaseSpecificationBRT())
                .and()
                .body(tariffData)
                .log().all()
                .post(CALLER_UPDATE_TARIFF_PATH);
    }

    public Response balanceReplenishment (String callerUuid, int amount){
        String balanceData = "{ \"callersUuid\": " + callerUuid + "," +
                "\n{ \"amount\": " + amount +"}";
        return given()
                .spec(getBaseSpecificationBRT())
                .and()
                .body(balanceData)
                .log().all()
                .post(CALLER_REPLENISHMENT_PATH);
    }
}
