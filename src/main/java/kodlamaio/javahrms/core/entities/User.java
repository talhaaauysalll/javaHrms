package kodlamaio.javahrms.core.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name="users")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_user",strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="email")
    @NotBlank(message = "Bu alan boş bırakılamaz")
    @Email(message = "Geçerli bir mail adresi giriniz")
    private String email;

    @Column(name="password")
    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String password;
}
