package org.mediawiki.gusev.dto.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tokens {

    @JsonProperty("userrightstoken")
    private String userRightsToken;

    @JsonProperty("deleteglobalaccounttoken")
    private String deleteGlobalAccountToken;

    @JsonProperty("rollbacktoken")
    private String rollBackToken;

    @JsonProperty("setglobalaccountstatustoken")
    private String setGlobalAccountStatusToken;

    @JsonProperty("createaccounttoken")
    private String createAccountToken;

    @JsonProperty("logintoken")
    private String loginToken;

    @JsonProperty("watchtoken")
    private String watchToken;

    @JsonProperty("csrftoken")
    private String csrfToken;

    @JsonProperty("patroltoken")
    private String patrolToken;

    public String getUserRightsToken() {
        return userRightsToken;
    }

    public String getDeleteGlobalAccountToken() {
        return deleteGlobalAccountToken;
    }

    public String getRollBackToken() {
        return rollBackToken;
    }

    public String getSetGlobalAccountStatusToken() {
        return setGlobalAccountStatusToken;
    }

    public String getCreateAccountToken() {
        return createAccountToken;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public String getWatchToken() {
        return watchToken;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public String getPatrolToken() {
        return patrolToken;
    }

    @Override
    public String toString() {
        return
                "Tokens{" +
                        "userrightstoken = '" + userRightsToken + '\'' +
                        ",deleteglobalaccounttoken = '" + deleteGlobalAccountToken + '\'' +
                        ",rollbacktoken = '" + rollBackToken + '\'' +
                        ",setglobalaccountstatustoken = '" + setGlobalAccountStatusToken + '\'' +
                        ",createaccounttoken = '" + createAccountToken + '\'' +
                        ",logintoken = '" + loginToken + '\'' +
                        ",watchtoken = '" + watchToken + '\'' +
                        ",csrftoken = '" + csrfToken + '\'' +
                        ",patroltoken = '" + patrolToken + '\'' +
                        "}";
    }
}
