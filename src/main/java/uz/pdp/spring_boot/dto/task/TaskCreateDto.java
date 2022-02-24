package uz.pdp.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.Dto;
import uz.pdp.spring_boot.enums.Level;

import java.time.Instant;

@Getter
@Setter
@Builder
public class TaskCreateDto implements Dto {
    private String tittle;
    private String description;
    private Instant deadline;
    private Level level;

    @Builder(builderMethodName = "childBuilder")
    public TaskCreateDto(String tittle, String description, Instant deadline, Level level) {
        this.tittle = tittle;
        this.description = description;
        this.deadline = deadline;
        this.level = level;
    }
}
