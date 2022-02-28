package uz.pdp.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.project.ProjectColumn;
import uz.pdp.spring_boot.enums.Level;

import java.time.Instant;

/**
 * @author : Oyatjon  -> @data :2/28/2022 05:19
 */

@Getter
@Setter
public class TaskUpdateDto extends GenericDto {

    private String tittle;
    private String description;
    private ProjectColumn projectColumn;
    private Instant deadline;
    private Integer orders;
    private Level level;

    private Instant createdat;
    private Long createby;
    private Instant updatedat;
    private Long updateby;

    @Builder(builderMethodName = "childBuilder")
    public TaskUpdateDto(Long id, String tittle, String description, ProjectColumn projectColumn, Instant deadline, Integer orders, Level level, Instant createdat, Long createby, Instant updatedat, Long updateby) {
        super(id);
        this.tittle = tittle;
        this.description = description;
        this.projectColumn = projectColumn;
        this.deadline = deadline;
        this.orders = orders;
        this.level = level;
        this.createdat = createdat;
        this.createby = createby;
        this.updatedat = updatedat;
        this.updateby = updateby;
    }
}
