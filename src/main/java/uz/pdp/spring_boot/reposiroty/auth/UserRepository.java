package uz.pdp.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

public interface UserRepository extends JpaRepository<AuthUser,Long>, AbstractRepository {

}
