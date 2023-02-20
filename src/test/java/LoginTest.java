import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import org.mediawiki.gusev.api.LoginApi;
import org.mediawiki.gusev.dto.login.LoginErrorResponse;
import org.mediawiki.gusev.utils.PropertyManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mediawiki.gusev.api.TokenApi.getTokens;
import static org.mediawiki.gusev.constants.PropertyConstants.CONFIG;

@Epic("Regression")
@Feature("API")
@Story("Login tests")
public class LoginTest {
    private static final String username = "MySuperUserName";
    private static final String password = "MySuperPassword";
    private static final String loginReturnUrl = PropertyManager.propHandler(CONFIG, "TEST_HOST");
    private static final String errorCsrfToken = "Invalid CSRF token.";
    private static final String errorDetails = "See https://test.wikipedia.org/w/api.php for API usage. " +
            "Subscribe to the mediawiki-api-announce mailing list at &lt;" +
            "https://lists.wikimedia.org/postorius/lists/mediawiki-api-announce.lists.wikimedia.org/&gt; " +
            "for notice of API deprecations and breaking changes.";

    @Test
    public void loginAndGetErrorInvalidCsrfToken() {
        String loginToken = getTokens().getQuery().getTokens().getLoginToken();

        LoginErrorResponse loginErrorResponse =
                LoginApi.loginWithBadTokenError(username, password, loginReturnUrl, loginToken);

        assertThat(loginErrorResponse.getError().getInfo())
                .as("CSRF token was valid")
                .isEqualTo(errorCsrfToken);
    }

    @Test
    public void loginAndGetErrorDetails() {
        String loginToken = getTokens().getQuery().getTokens().getLoginToken();

        LoginErrorResponse loginErrorResponse =
                LoginApi.loginWithBadTokenError(username, password, loginReturnUrl, loginToken);

        assertThat(loginErrorResponse.getError().getDetails())
                .as("Details were not received")
                .isEqualTo(errorDetails);
    }
}
