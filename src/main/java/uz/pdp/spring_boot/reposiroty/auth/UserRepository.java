package uz.pdp.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.spring_boot.entity.auth.AuthRole;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

public interface UserRepository extends JpaRepository<AuthUser,Long>, AbstractRepository {

    @Query(value = "from  AuthRole r where r.code=:roleName")
    AuthRole findRoleByName(String roleName);
}
