package uz.pdp.spring_boot.entity.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author Nodirbek Abdukarimov Tue. 4:36 PM. 2/22/2022
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "auth_user", schema = "auth")
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String language;

    private String phone;

    private String email;

    private String fullName;

    private String profile_image;

    private Instant birth_date;

    private Timestamp created_at;

    @Column(name = "is_super_admin")
    private boolean is_super_admin;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Column(name = "is_blocked", nullable = false)
    private boolean blocked;

    @OneToOne
    private AuthRole role;
}
