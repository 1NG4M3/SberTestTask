package org.mediawiki.gusev.dto.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {

    @JsonProperty("tokens")
    private Tokens tokens;

    public Tokens getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return
                "Query{" +
                        "tokens = '" + tokens + '\'' +
                        "}";
    }
}
