package specyfication;

import com.jsystems.qa2.api.configuration.ApiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specyfication {
    private static final String v2 = "v2";

    public static RequestSpecification requestSpecification()
    {
        return new RequestSpecBuilder()
                //.addHeader("Authorize", "ApiKey, " + auth)
                .setContentType(ContentType.JSON)
                .setBaseUri(ApiConfig.BASE_URL)
                .setBasePath(v2)
                .build();
    }

    public static RequestSpecification requestSpecificationWithAuth(String auth)
    {
        return new RequestSpecBuilder()
                .addHeader("Authorize", "ApiKey, " + auth)
                .setContentType(ContentType.JSON)
                .setBaseUri(ApiConfig.BASE_URL)
                .setBasePath(v2)
                .build();
    }

}
