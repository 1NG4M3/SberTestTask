package org.mediawiki.gusev.dto.create_account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountErrorResponse {

    @JsonProperty("error")
    private Error error;

    @JsonProperty("servedby")
    private String servedBy;

    @Override
    public String toString() {
        return
                "TokenErrorResponse{" +
                        "error = '" + error + '\'' +
                        ",servedby = '" + servedBy + '\'' +
                        "}";
    }
}
