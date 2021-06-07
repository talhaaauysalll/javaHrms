package kodlamaio.javahrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.javahrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name="employers")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User {
    @Column(name="company_name")
    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String companyName;

    @Column(name="web_site")
    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String webSite;

    @Column(name="phone_number")
    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String phoneNumber;

    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String passwordRepeat;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}
