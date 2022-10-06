package cn.cg.batch.quick.start;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cg1
 * @date: 2022-10-06 01:54
 **/
@RestController
public class JobLauncherController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping("/handle")
    public void handle() throws Exception {
        jobLauncher.run(job, new JobParameters());
    }
}
