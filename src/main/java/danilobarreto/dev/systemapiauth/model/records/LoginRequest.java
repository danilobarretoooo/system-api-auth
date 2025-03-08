package danilobarreto.dev.systemapiauth.model.records;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank
        String usernameOrEmail,
        @NotBlank
        String password
) {
}
