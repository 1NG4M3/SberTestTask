package org.mediawiki.gusev.dto.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse {

    @JsonProperty("batchcomplete")
    private String batchComplete;

    @JsonProperty("query")
    private Query query;

    public String getBatchComplete() {
        return batchComplete;
    }

    public Query getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return
                "TokenResponse{" +
                        "batchcomplete = '" + batchComplete + '\'' +
                        ",query = '" + query + '\'' +
                        "}";
    }
}
