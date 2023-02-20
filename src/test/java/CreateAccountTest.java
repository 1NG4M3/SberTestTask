import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import org.mediawiki.gusev.api.CreateAccountApi;
import org.mediawiki.gusev.dto.create_account.CreateAccountErrorResponse;
import org.mediawiki.gusev.utils.PropertyManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mediawiki.gusev.api.TokenApi.getTokens;
import static org.mediawiki.gusev.constants.PropertyConstants.CONFIG;

@Epic("Regression")
@Feature("API")
@Story("Create account tests")
public class CreateAccountTest {
    private static final String username = "MySuperUserName";
    private static final String password = "MySuperPassword";
    private static final String createReturnUrl = PropertyManager.propHandler(CONFIG, "TEST_HOST");
    private static final String errorCsrfToken = "Invalid CSRF token.";
    private static final String errorDetails = "See https://test.wikipedia.org/w/api.php for API usage. " +
            "Subscribe to the mediawiki-api-announce mailing list at &lt;" +
            "https://lists.wikimedia.org/postorius/lists/mediawiki-api-announce.lists.wikimedia.org/&gt; " +
            "for notice of API deprecations and breaking changes.";

    @Test()
    public void createAccountGetErrorInvalidCsrfToken() {
        String createAccountToken = getTokens().getQuery().getTokens().getCreateAccountToken();

        CreateAccountErrorResponse createAccountErrorResponse =
                CreateAccountApi.createAccountAndGetBadTokenError(username, password, createReturnUrl, createAccountToken);

        assertThat(createAccountErrorResponse.getError().getInfo())
                .as("CSRF token was valid")
                .isEqualTo(errorCsrfToken);
    }

    @Test()
    public void createAccountGetErrorDetails() {
        String createAccountToken = getTokens().getQuery().getTokens().getCreateAccountToken();

        CreateAccountErrorResponse createAccountErrorResponse =
                CreateAccountApi.createAccountAndGetBadTokenError(username, password, createReturnUrl, createAccountToken);

        assertThat(createAccountErrorResponse.getError().getDetails())
                .as("Details were not received")
                .isEqualTo(errorDetails);
    }
}
