package uz.pdp.spring_boot.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.project.ProjectColumn;
import uz.pdp.spring_boot.entity.task.Task;
import uz.pdp.spring_boot.enums.Level;
import uz.pdp.spring_boot.reposiroty.AbstractRepository;

import javax.transaction.Transactional;
import java.time.Instant;

public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query("update Task t set t.tittle=:tittle,t.description=:description,t.deadline=:deadline,t.level=:level where t.id=:id")
    void update(@Param("tittle") String tittle,
                @Param("description") String description,
                @Param("deadline") Instant deadline,
                @Param("level") Level level,
                @Param("id") Long id);
}
