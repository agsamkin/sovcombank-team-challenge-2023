package hackathon.ru.data.model.vacancy;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hackathon.ru.data.model.City;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.data.model.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
Класс завершен
 */

@Entity
@Table(name = "vacancy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "vacancy name should not be Empty")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "unit name should not be Empty")
    @Column(name = "unit_name")
    private String unitName;

    @NotNull(message = "Min Salary should not be Empty")
    @Column(name = "min_salary")
    private Integer minSalary;

    @NotNull(message = "Max Salary should not be Empty")
    @Column(name = "max_salary")
    private Integer maxSalary;

    @NotNull(message = "Public Salary should not be Empty")
    @Column(name = "public_salary")
    private Integer publicSalary;

    @Lob
    @NotBlank(message = "Description should not be Empty")
    @Column(name = "description")
    private String description;

    @Lob
    @NotBlank(message = "Requirement should not be Empty")
    @Column(name = "requirements")
    private String requirements;

    @Lob
    @NotBlank(message = "Responsibility should not be Empty")
    @Column(name = "responsibilities")
    private String responsibilities;

    @Lob
    @NotBlank(message = "Benefit should not be Empty")
    @Column(name = "benefits")
    private String benefits;

    @NotBlank(message = "Skills should not be Empty")
    @Column(name = "skills")
    private String skills;

    @NotNull(message = "City should not be Empty")
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @NotNull(message = "Hr should not be Empty")
    @ManyToOne
    @JoinColumn(name = "hr_id", referencedColumnName = "id")
    private User hr;

//    @NotNull(message = "Owner should not be Empty")
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

//    @NotNull(message = "Vacancy Status should not be Empty")
    @ManyToOne()
    @JoinColumn(name = "vacancy_status_id", referencedColumnName = "id")
    private VacancyStatus vacancyStatus;

//    @NotNull(message = "Work Format should not be Empty")
    @ManyToOne()
    @JoinColumn(name = "work_format_id", referencedColumnName = "id")
    private WorkFormat workFormat;

//    @NotNull(message = "Required Experience should not be Empty")
    @ManyToOne()
    @JoinColumn(name = "required_experience_id", referencedColumnName = "id")
    private RequiredExperience requiredExperience;

//    связи
    @JsonIgnore
    @OneToMany(mappedBy = "vacancy")
    private List<Application> applications;
}
