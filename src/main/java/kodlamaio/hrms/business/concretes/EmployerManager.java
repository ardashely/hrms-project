package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adaptor.EmailAdaptor;
import kodlamaio.hrms.core.utilites.results.*;
import kodlamaio.hrms.dataAcces.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmailAdaptor emailAdaptor;

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailAdaptor emailAdaptor) {
        this.employerDao = employerDao;
        this.emailAdaptor = emailAdaptor;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccesDataResult<List<Employer>>
                (this.employerDao.findAll(), "İş verenler listelendi");
    }

    private boolean isMailExists(String eMail) {
        return this.employerDao.findByEmail(eMail).isPresent();
    }

    @Override
    public Result add(Employer employer) {
        if (isMailExists(employer.getEmail())) {
            return new ErrorResult("Bu mail daha önce kullanılmış");
        } else if (!emailAdaptor.sendEmail(employer.getEmail())) {
            return new ErrorResult("E mail doğrulanmadı");
        }
        employerDao.save(employer);
        return new SuccesResult("İş veren eklendi");
    }
}