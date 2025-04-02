package surveypulse.user_service.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import surveypulse.user_service.dto.response.RespondentUserDto;
import surveypulse.user_service.dto.response.UserResponseDTO;
import surveypulse.user_service.dto.service.JoinServiceDTO;
import surveypulse.user_service.dto.service.UpdateUserServiceDTO;
import surveypulse.user_service.entity.User;
import surveypulse.user_service.exception.UserExceptionType;
import surveypulse.user_service.global.exception.type.BadRequestException;
import surveypulse.user_service.global.exception.type.NotFoundException;
import surveypulse.user_service.repository.UserRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void joinUser(JoinServiceDTO joinServiceDTO) {

        checkUsernameValid(joinServiceDTO.getUsername());


        User user = User.builder()
                        .username(joinServiceDTO.getUsername())
                        .password((bCryptPasswordEncoder.encode(joinServiceDTO.getPassword())))
                        .role("USER")
                        .email(joinServiceDTO.getEmail())
                        .build();

        userRepository.save(user);
    }

    private void checkUsernameValid(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new BadRequestException(UserExceptionType.INVALID_NICKNAME);
        }

        if (userRepository.existsByUsername(userName)) {
            throw new BadRequestException(UserExceptionType.DUPLICATED_NICKNAME);
        }
    }

    public UserResponseDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(UserExceptionType.NOT_FOUND_USER));

        UserResponseDTO userResponseDTO = UserResponseDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .birthDay((user.getBirthDay()))
                .build();

        return userResponseDTO;
    }

    @Transactional
    public void updateUser(UpdateUserServiceDTO updateUserServiceDTO, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->new NotFoundException(UserExceptionType.NOT_FOUND_USER));

        user.setEmail(updateUserServiceDTO.getBio());

        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(UserExceptionType.NOT_FOUND_USER));

        userRepository.delete(user);
    }

    public RespondentUserDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                                  .orElseThrow(() -> new NotFoundException(UserExceptionType.NOT_FOUND_USER));

        return new RespondentUserDto(userId, user.getUsername());
    }

    public User getUserBySecurityUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException(UserExceptionType.NOT_FOUND_USER));

        return user;
    }

}
