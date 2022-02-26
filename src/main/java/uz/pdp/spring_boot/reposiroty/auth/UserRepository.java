package uz.pdp.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.spring_boot.entity.auth.AuthRole;
import uz.pdp.spring_boot.entity.auth.AuthUser;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

public interface UserRepository extends JpaRepository<AuthUser,Long>, AbstractRepository {

    @Query(value = "from  AuthRole r where r.code=:roleName")
    AuthRole findRoleByName(String roleName);

    @Query(value ="from Organization o where o.id=:idd" )
    Organization findOrganizationById (Long idd);
}
