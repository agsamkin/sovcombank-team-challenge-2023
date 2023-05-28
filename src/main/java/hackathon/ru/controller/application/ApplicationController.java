package hackathon.ru.controller.application;

import hackathon.ru.data.dto.application.ApplicationDto;
import hackathon.ru.data.dto.application.ApplicationForCardDto;
import hackathon.ru.data.dto.application.customDto.ApplicationForListDto;
import hackathon.ru.data.dto.application.customDto.ApplicationResponseDto;
import hackathon.ru.data.dto.applicationVacancyCandidateDto.ApplicationVacancyCandidateDto;
import hackathon.ru.data.model.application.Application;
import hackathon.ru.service.application.iService.ApplicationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Tag(name = "Application controller")
@AllArgsConstructor
@RestController
@RequestMapping("${base-url}" + ApplicationController.APPLICATION_CONTROLLER_PATH)
public class ApplicationController {

    public static final String APPLICATION_CONTROLLER_PATH = "/applications";

    public static final String ID = "/{id}";
    public static final String HR = "/hr";
    public static final String APPLICATION = "/application";
    private final ApplicationService applicationService;


    // GET /api/applications/{id} - получение кандидата по идентификатору
    // GET /api/applications/{id} - получение по идентификатору
    @GetMapping(ID)
    public Application getApplicationById(@PathVariable("id") final Long id) {
        return applicationService.getApplicationById(id);
    }


    @PostMapping()
    @ResponseStatus(CREATED)
    public ApplicationResponseDto createApplication(
            @RequestBody @Valid ApplicationVacancyCandidateDto applicationVacancyCandidateDto) {
        return applicationService.createApplication(applicationVacancyCandidateDto);
    }


    @GetMapping()
    public List<ApplicationForListDto> getAllApplications() {
        return applicationService.getAllApplications();
    }


    @PutMapping(ID)
    public Application updateApplication(@PathVariable("id") final Long id,
                                         @RequestBody @Valid final ApplicationDto applicationDto) {
        return applicationService.updateApplication(id, applicationDto);
    }


    @DeleteMapping(ID)
    public void deleteApplication(@PathVariable("id") final Long id) {
        applicationService.deleteApplicationById(id);
    }


    //----------------------HR----------------------//
    // GET /api/applications/hr/application/{id} получение всех заявок кондидата
    @GetMapping(HR + ID)
    public List<ApplicationForListDto> getAllApplicationsList(@PathVariable("id") final Long id) {
        return applicationService.getListOfCandidateApplication(id);
    }


    // GET /api/applications/hr/application/{id} - получение кандидата по id заявке
    @GetMapping(HR + APPLICATION + ID)
    public ApplicationForCardDto getApplicationCardById(@PathVariable("id") final Long id) {
        return applicationService.getApplicationForCardDto(id);
    }

}