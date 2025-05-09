package ru.nexign;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Service {
    public static final String BASE_URL = "http://localhost:8084";
    public final static boolean DETAIL_LOG = true;

    protected RequestSpecification getBaseSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)

                .build();
    }
}
