package org.mediawiki.gusev.api;

import lombok.extern.slf4j.Slf4j;
import org.mediawiki.gusev.constants.PathConstants;
import org.mediawiki.gusev.dto.login.LoginErrorResponse;
import org.mediawiki.gusev.utils.PropertyManager;

import static io.restassured.RestAssured.given;
import static org.mediawiki.gusev.constants.PropertyConstants.CONFIG;

@Slf4j
public class LoginApi {

    public static LoginErrorResponse loginWithBadTokenError(
            String username, String password, String loginReturnUrl, String loginToken) {
        log.info("Login with username: " + username + " password: " + password + " loginReturnUrl: " +
                loginReturnUrl + " token: " + loginToken);
        return given()
                .baseUri(PropertyManager.propHandler(CONFIG, "TEST_HOST"))
                .basePath(PathConstants.WIKI_API.getApiMethod())
                .queryParam("action", "clientlogin")
                .queryParam("format", "json")
                .param("username", username)
                .param("password", password)
                .param("loginreturnurl", loginReturnUrl)
                .param("logintoken", "loginToken")
                .when().post()
                .then().extract().as(LoginErrorResponse.class);
    }
}
