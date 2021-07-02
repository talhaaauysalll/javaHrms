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
public class JobAdvertisementDto {

    private int id;

    private String jobTitleName;

    private String companyName;

    private String cityName;

    private String workTimesName;

    private String workTypeName;

    private double minSalary;

    private double maxSalary;

    private int numberOfOpenPositions;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applicationDate;
}
