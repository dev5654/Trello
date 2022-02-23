package uz.pdp.spring_boot.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.configs.security.UserDetails;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.organization.OrganizationCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectCreateDto;
import uz.pdp.spring_boot.dto.project.ProjectDto;
import uz.pdp.spring_boot.dto.project.ProjectUpdateDto;
import uz.pdp.spring_boot.entity.organization.Organization;
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
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public ProjectDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
