package org.mediawiki.gusev.api;

import lombok.extern.slf4j.Slf4j;
import org.mediawiki.gusev.constants.PathConstants;
import org.mediawiki.gusev.dto.token.TokenResponse;
import org.mediawiki.gusev.utils.PropertyManager;

import static io.restassured.RestAssured.given;
import static org.mediawiki.gusev.constants.PropertyConstants.CONFIG;

@Slf4j
public class TokenApi {

    public static TokenResponse getTokens() {
        log.info("Running getTokens() method from TokenApi.class");
        return given()
                .baseUri(PropertyManager.propHandler(CONFIG, "TEST_HOST"))
                .basePath(PathConstants.WIKI_API.getApiMethod())
                .param("action", "query")
                .param("meta", "tokens")
                .param("type", "*")
                .param("format", "json")
                .when().get()
                .then().extract().as(TokenResponse.class);
    }
}
