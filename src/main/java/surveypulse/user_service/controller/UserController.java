package surveypulse.user_service.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import surveypulse.user_service.dto.controller.JoinControllerDTO;
import surveypulse.user_service.dto.controller.UpdateUserControllerDTO;
import surveypulse.user_service.dto.response.RespondentUserDto;
import surveypulse.user_service.dto.response.UserResponseDTO;
import surveypulse.user_service.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<Void> joinUser(@Valid @RequestBody JoinControllerDTO joinControllerDTO) {
        userService.joinUser(joinControllerDTO.toServiceDTO());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<UserResponseDTO> getMyUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserResponseDTO userResponseDTO = userService.getUserByUsername(username);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<RespondentUserDto> getUser(@PathVariable Long userId) {
        RespondentUserDto respondentUserDto = userService.getUser(userId);
        return ResponseEntity.ok(respondentUserDto);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateUser(@Valid @RequestBody UpdateUserControllerDTO updateUserControllerDTO) {
        String username  = SecurityContextHolder.getContext().getAuthentication().getName();
        userService.updateUser(updateUserControllerDTO.toServiceDTO(), username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        userService.deleteUser(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
