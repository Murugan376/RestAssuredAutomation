package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jdk.jfr.Name;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SpecBuilder {

    public static RequestSpecification req = null;

    @Name("RequestBuilder")
    public static RequestSpecification requestBuilder() throws IOException {

            if (req == null) {
                PrintStream logfile = new PrintStream(new FileOutputStream("loggingfile.txt"));
                req = new RequestSpecBuilder().setBaseUri(String.valueOf(Util.getConfigProperties("baseurl")))
                        .setRelaxedHTTPSValidation()
                        .addQueryParam("key", "qaclick123")
                        .addFilter(RequestLoggingFilter.logRequestTo(logfile)) //log file is the logging file creation using prontStream
                        .addFilter(ResponseLoggingFilter.logResponseTo(logfile)) //same like above
                        .setContentType(ContentType.JSON).build();
                return req;
            }
        return req;

    }

    @Name("ResponseBuilder")
    public static ResponseSpecification responseBuilder() {

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        return res;
    }
}
