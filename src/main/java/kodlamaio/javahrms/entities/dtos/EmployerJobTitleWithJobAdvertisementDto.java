package kodlamaio.javahrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerJobTitleWithJobAdvertisementDto {

    private String employerName;

    private String jobTitleName;

    private int numberOfOpenPositions;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applicationDate;
}
