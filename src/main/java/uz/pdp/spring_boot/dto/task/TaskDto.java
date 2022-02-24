package uz.pdp.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.project.ProjectColumn;
import uz.pdp.spring_boot.enums.Level;

import java.time.Instant;

@Getter
@Setter
public class TaskDto extends GenericDto {
    private String tittle;
    private String description;
    private ProjectColumn projectColumn;
    private Instant deadline;
    private Integer orders;
    private Level level;


    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, String tittle, String description, ProjectColumn projectColumn, Instant deadline, Integer orders, Level level) {
        super(id);
        this.tittle = tittle;
        this.description = description;
        this.projectColumn = projectColumn;
        this.deadline = deadline;
        this.orders = orders;
        this.level = level;
    }
}

