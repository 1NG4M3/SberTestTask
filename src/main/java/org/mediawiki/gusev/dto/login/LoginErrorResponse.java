package org.mediawiki.gusev.dto.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginErrorResponse {

    @JsonProperty("error")
    private Error error;

    @JsonProperty("servedby")
    private String servedBy;

    @Override
    public String toString() {
        return
                "LoginErrorResponse{" +
                        "error = '" + error + '\'' +
                        ",servedby = '" + servedBy + '\'' +
                        "}";
    }
}
