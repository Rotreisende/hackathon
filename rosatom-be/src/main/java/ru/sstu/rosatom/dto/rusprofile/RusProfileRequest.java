package ru.sstu.rosatom.dto.rusprofile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RusProfileRequest {

    @JsonProperty("state-1")
    private Boolean state_1 = true;
    private Boolean okved_strict = true;
    private List<String> okved;
    @JsonProperty("state-2")
    private Boolean state_2 = true;
}
