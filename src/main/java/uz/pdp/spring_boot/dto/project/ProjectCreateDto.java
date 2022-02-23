package uz.pdp.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.dto.Dto;
import uz.pdp.spring_boot.entity.organization.Organization;

import java.time.Instant;

@Getter
@Setter
@Builder
public class ProjectCreateDto implements Dto {
    private String name;
    private String tzPath;

    @Builder(builderMethodName = "childBuilder")
    public ProjectCreateDto(String name, String tzPath) {
        this.name = name;
        this.tzPath = tzPath;
    }
}
