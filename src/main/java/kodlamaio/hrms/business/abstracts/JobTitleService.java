package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostion;
import java.util.List;

public interface JobTitleService {
    DataResult<List<JobPostion>> getAll();
    Result add(JobPostion jobPostion);
}
