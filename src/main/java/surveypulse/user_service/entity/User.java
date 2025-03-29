package surveypulse.user_service.entity;

import jakarta.persistence.*;
import lombok.*;
import surveypulse.user_service.global.common.BaseEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    private String email;

    private String password;

    @Column(nullable = false)
    private String role;

    private String birthDay;

    @Builder
    public User(String username, String email, String password, String role, String birthDay) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.birthDay = birthDay;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
