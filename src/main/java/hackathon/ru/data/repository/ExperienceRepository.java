package hackathon.ru.data.repository;

import hackathon.ru.data.model.candidate.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    //List<Long> getAllByCandidateId(Long id);
    List<Experience> getAllByCandidateId(Long id);
}
