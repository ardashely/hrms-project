package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jobtitle")
public class JobTitleController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPostion>> getAll() {
        return this.jobTitleService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPostion jobPostion) {
        return this.jobTitleService.add(jobPostion);
    }
}