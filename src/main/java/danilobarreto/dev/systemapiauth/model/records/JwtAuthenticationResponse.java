package danilobarreto.dev.systemapiauth.model.records;

public record JwtAuthenticationResponse(
        String accessToken,
        String tokenType
) {
}
