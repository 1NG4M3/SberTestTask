package org.mediawiki.gusev.api;

import lombok.extern.slf4j.Slf4j;
import org.mediawiki.gusev.constants.PathConstants;
import org.mediawiki.gusev.dto.create_account.CreateAccountErrorResponse;
import org.mediawiki.gusev.utils.PropertyManager;

import static io.restassured.RestAssured.given;
import static org.mediawiki.gusev.constants.PropertyConstants.CONFIG;

@Slf4j
public class CreateAccountApi {

    public static CreateAccountErrorResponse createAccountAndGetBadTokenError(
            String username, String password, String createReturnUrl, String createToken) {
        log.info("Create account with username: " + username + " password: " + password +
                " createreturnurl: " + createReturnUrl + " createtoken: " + createToken);
        return given()
                .baseUri(PropertyManager.propHandler(CONFIG, "TEST_HOST"))
                .basePath(PathConstants.WIKI_API.getApiMethod())
                .queryParam("action", "createaccount")
                .queryParam("format", "json")
                .param("username", username)
                .param("password", password)
                .param("retype", password)
                .param("createreturnurl", createReturnUrl)
                .param("createtoken", createToken)
                .when().post()
                .then().extract()
                .as(CreateAccountErrorResponse.class);
    }
}
