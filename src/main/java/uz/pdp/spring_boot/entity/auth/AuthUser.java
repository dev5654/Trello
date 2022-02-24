package uz.pdp.spring_boot.entity.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.pdp.spring_boot.entity.BaseEntity;
import uz.pdp.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Nodirbek Abdukarimov Tue. 4:36 PM. 2/22/2022
 */
@ToString
@Getter
@Setter
@Entity
@Table(name = "auth_user", schema = "auth")
public class AuthUser implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    private String phone;

    private String email;

    private String fullName;

    private String profileImage;

    private Timestamp created_at;


    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Column(name = "is_blocked", nullable = false)
    private boolean blocked;

    @OneToOne
    private AuthRole role;

}
