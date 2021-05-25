package kodlamaio.hrms.dataAcces.abstracts;

import kodlamaio.hrms.entities.concretes.JobPostion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobTitleDao extends JpaRepository<JobPostion, Integer> {
    Optional<JobPostion> findByTitle(String title);
}