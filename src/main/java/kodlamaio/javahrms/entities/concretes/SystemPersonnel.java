package kodlamaio.javahrms.entities.concretes;

import kodlamaio.javahrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name="system_personnel")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonnel extends User {
    @Column(name="first_name")
    @NotBlank(message = "Bu alan boş geçilemez")
    private String firstName;

    @Column(name="last_name")
    @NotBlank(message = "Bu alan boş geçilemez")
    private String lastName;

    @Column(name = "department")
    @NotBlank(message = "Bu alan boş geçilemez")
    private String department;
}
