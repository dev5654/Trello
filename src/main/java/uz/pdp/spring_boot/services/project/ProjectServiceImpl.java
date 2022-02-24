package uz.pdp.spring_boot.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectDto;
import uz.pdp.spring_boot.dto.project.ProjectUpdateDto;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.mapper.ProjectMapper;
import uz.pdp.spring_boot.reposiroty.project.ProjectRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.utils.BaseUtils;
import uz.pdp.spring_boot.utils.validators.project.ProjectValidator;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator>
        implements ProjectService {


    @Autowired
    protected ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    @Override
    public Long create(ProjectCreateDto createDto) {
        Project project = mapper.fromCreateDto(createDto);
        project.setCreateby(1L);
        repository.save(project);
        return 1L;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto updateDto) {
        repository.update(updateDto.getName(), updateDto.getTzPath(), updateDto.getId());
        return null;
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ProjectDto get(Long id) {
        Project project = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        ProjectDto dto=mapper.toDto(project);
        return dto;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
