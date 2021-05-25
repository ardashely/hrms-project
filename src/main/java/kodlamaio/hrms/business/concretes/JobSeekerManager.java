package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.adaptor.EmailAdaptor;
import kodlamaio.hrms.core.utilites.results.*;
import kodlamaio.hrms.dataAcces.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private EmailAdaptor emailAdaptor;

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, EmailAdaptor emailAdaptor) {
        this.jobSeekerDao = jobSeekerDao;
        this.emailAdaptor = emailAdaptor;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccesDataResult<List<JobSeeker>>
                (this.jobSeekerDao.findAll(), "İş adayları listelendi");
    }

    private boolean isMailExists(String eMail) {
        return this.jobSeekerDao.findByEmail(eMail).isPresent();
    }

    private boolean isNationalityId(String nationalIdentity) {
        return this.jobSeekerDao.findByNationalIdentity(nationalIdentity).isPresent(); // isPresent() null ise true döndürüyor
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (isMailExists(jobSeeker.getEmail()) == true){
            return new ErrorResult("Mail adresi daha önce kullanılmış");
        } //bune amk İ ne düzelt onu
        else if (isNationalityId(jobSeeker.getNationalIdentity()) == true){
            return new ErrorResult("Kimlik numarası daha önce kullanılmış");
        } else if (!emailAdaptor.sendEmail(jobSeeker.getEmail())) {
            return new ErrorResult("E mail doğrulanmadı");
        }
        jobSeekerDao.save(jobSeeker);
        return new SuccesResult("İş adayı eklendi");

    }
}