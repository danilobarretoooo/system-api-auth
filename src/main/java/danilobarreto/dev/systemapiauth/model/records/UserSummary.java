package danilobarreto.dev.systemapiauth.model.records;

public record UserSummary(
        Long id,
        String username,
        String name,
        String email
) {
}
