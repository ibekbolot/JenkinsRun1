package kg.rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import kg.utils.file.AppConfig;
import kg.utils.file.ConfigurationManager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static io.restassured.RestAssured.given;

@Slf4j
@Data
public class HttpRequest {

    private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);
    //private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);
    protected String url;
    protected RequestSpecification requestSpecification;
    protected Response response;
    protected

    static final String SLASH = "/";

    public HttpRequest(String url) {
        this.url = url;
        this.requestSpecification = given().baseUri(url).header("Authorization", "Bearer " +
                ConfigurationManager.getBaseConfig().bearerToken()).contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    public Response get(String endPoint){
        log.info("Performed Get {} ", endPoint);
        this.response = given().spec(requestSpecification).get(endPoint);
        logResponse();
        return this.response;
    }

    public Response post(String endPoint, String body){
        log.info("Performed POST {}", endPoint);
        log.info("Body is {}", body);
        this.response = given().spec(requestSpecification).body(body).post(endPoint);
        logResponse();
        return this.response;
    }

    private void logResponse(){
        log.warn("Response is: ");
        log.warn(getResponse().getBody().asPrettyString());
        log.warn("Status code is: {}", getResponse().getStatusCode());
    }

    public String getEndPoint(String... endPoints){
        StringBuilder endPoint = new StringBuilder();

        for (String arg : endPoints) {
            endPoint.append(arg).append(SLASH);
        }

        return endPoint.substring(0, endPoint.length()-1);
    }
}
