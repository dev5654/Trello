package uz.pdp.spring_boot.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.organization.OrganizationCreateDto;
import uz.pdp.spring_boot.dto.organization.OrganizationDto;
import uz.pdp.spring_boot.dto.organization.OrganizationDto.OrganizationDtoBuilder;
import uz.pdp.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.pdp.spring_boot.entity.organization.Organization;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-23T17:15:01+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationDto toDto(Organization e) {
        if ( e == null ) {
            return null;
        }

        OrganizationDtoBuilder organizationDto = OrganizationDto.childBuilder();

        organizationDto.id( e.getId() );
        organizationDto.name( e.getName() );
        organizationDto.logo( e.getLogo() );
        organizationDto.code( e.getCode() );
        organizationDto.location( e.getLocation() );
        organizationDto.email( e.getEmail() );
        organizationDto.owner( e.getOwner() );

        return organizationDto.build();
    }

    @Override
    public List<OrganizationDto> toDto(List<Organization> e) {
        if ( e == null ) {
            return null;
        }

        List<OrganizationDto> list = new ArrayList<OrganizationDto>( e.size() );
        for ( Organization organization : e ) {
            list.add( toDto( organization ) );
        }

        return list;
    }

    @Override
    public Organization fromCreateDto(OrganizationCreateDto organizationCreateDto) {
        if ( organizationCreateDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setName( organizationCreateDto.getName() );
        organization.setCode( organizationCreateDto.getCode() );
        organization.setEmail( organizationCreateDto.getEmail() );

        return organization;
    }

    @Override
    public Organization fromUpdateDto(OrganizationUpdateDto organizationUpdateDto) {
        if ( organizationUpdateDto == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setName( organizationUpdateDto.getName() );
        organization.setCode( organizationUpdateDto.getCode() );
        organization.setEmail( organizationUpdateDto.getEmail() );

        return organization;
    }
}
