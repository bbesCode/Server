package de.steffen.Server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class UserBox {
    private final String id;
    @NotBlank
    private final String name;

    public UserBox(@JsonProperty("id") String id,
                   @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
