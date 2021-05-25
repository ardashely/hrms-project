package kodlamaio.hrms.dataAcces.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    Optional<Employer> findByEmail(String eMail);
}
