package org.mediawiki.gusev.dto.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

    @JsonProperty("code")
    private String code;

    @JsonProperty("*")
    private String details;

    @JsonProperty("info")
    private String info;

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", details='" + details + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
