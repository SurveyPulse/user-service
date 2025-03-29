package surveypulse.user_service.dto.controller;


import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import surveypulse.user_service.dto.service.UpdateUserServiceDTO;

@Getter
public class UpdateUserControllerDTO {

    @Email(message = "유효한 이메일 형식이어야 합니다.")
    private String email;

    private String bio;


    @Builder
    public UpdateUserControllerDTO(String email, String bio) {
        this.email = email;
        this.bio = bio;
    }

    public UpdateUserServiceDTO toServiceDTO() {
        return UpdateUserServiceDTO.builder()
                .email(this.email)
                .bio(this.bio)
                .build();
    }
}
