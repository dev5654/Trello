package uz.pdp.spring_boot.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

import javax.transaction.Transactional;


public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {

}
