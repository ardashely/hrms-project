package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilites.results.*;
import kodlamaio.hrms.dataAcces.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobPostion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        super();
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobPostion>> getAll() {
        return new SuccesDataResult<List<JobPostion>>
                (this.jobTitleDao.findAll(), "İş pozisyonları listelendi");
    }

    @Override
    public Result add(JobPostion jobPostion) {
        if (!isTitleExists(jobPostion.getTitle())) {
            this.jobTitleDao.save(jobPostion);
            return new SuccesResult("İş pozisyonu eklendi" + jobPostion.getId());
        }
        return new ErrorResult("Aynı isme sahip pozisyonu var");
    }

    private boolean isTitleExists(String title){
        return jobTitleDao.findByTitle(title).isPresent();
    }
}
