package uz.pdp.spring_boot.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.dto.Dto;

/**
 * @author : Oyatjon  -> @data :2/24/2022 10:57
 */


@Getter
@Setter
@Builder
public class UserCreateDto implements Dto {
    private String username;
    private String password;
    private String language;
    private String phone;
    private String email;
    private String fullName;
    private MultipartFile profileImage;
    private String  role;

    public UserCreateDto(String username, String password, String language, String phone, String email, String fullName, MultipartFile profileImage, String  role) {
        this.username = username;
        this.password = password;
        this.language = language;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.profileImage = profileImage;
        this.role = role;
    }
}
