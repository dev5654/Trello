package uz.pdp.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.Dto;
import uz.pdp.spring_boot.entity.project.ProjectColumn;
import uz.pdp.spring_boot.enums.Level;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author : Oyatjon  -> @data :2/28/2022 05:18
 */

@Getter
@Setter
public class TaskCreateDto implements Dto {

    private String tittle;
    private String description;
    private Instant deadline;
    private Integer orders;
    private Level level;
    private ProjectColumn projectColumn;

    private Instant createdat;
    private Long createby;
    private Instant updatedat;
    private Long updateby;

    @Builder(builderMethodName = "childBuilder")
    public TaskCreateDto(String tittle, String description, ProjectColumn projectColumn, Instant deadline, Integer orders, Level level, Instant createdat, Long createby, Instant updatedat, Long updateby) {
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
