package kodlamaio.hrms.dataAcces.abstracts;

import kodlamaio.hrms.entities.concretes.JobPostion;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    Optional<JobSeeker> findByEmail(String eMail);
    Optional<JobSeeker> findByNationalIdentity(String nationalIdentity);
}