package uz.pdp.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_boot.entity.auth.AuthUser;

/**
 * @author Nodirbek Abdukarimov Tue. 8:33 PM. 2/22/2022
 */
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findAuthUserByUsername(String username);
}
