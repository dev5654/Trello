package uz.pdp.spring_boot.entity.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Nodirbek Abdukarimov Tue. 5:14 PM. 2/22/2022
 */
@Getter
@Setter
@Entity
@Table(name = "auth_permission", schema = "auth")
public class AuthPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;
}
