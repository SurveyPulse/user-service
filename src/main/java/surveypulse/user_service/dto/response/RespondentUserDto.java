package surveypulse.user_service.dto.response;

import surveypulse.user_service.entity.User;

public record RespondentUserDto(
        Long userId,
        String username,
        String userRole
) {
    public static RespondentUserDto fromEntity(User user) {
        return new RespondentUserDto(
                user.getUserId(),
                user.getUsername(),
                user.getRole()
        );
    }
}
