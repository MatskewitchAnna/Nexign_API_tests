package ru.nexign;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Service {
    public static final String BASE_URL_BRT = "https://api.brt/v1";
    public static final String BASE_URL_HRS = "https://api.hrs/v1";
    public final static boolean DETAIL_LOG = true;

    protected RequestSpecification getBaseSpecificationBRT() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL_BRT)
                .setContentType(ContentType.JSON)
                .build();
    }

    protected RequestSpecification getBaseSpecificationHRS() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL_HRS)
                .setContentType(ContentType.JSON)
                .build();
    }

}
