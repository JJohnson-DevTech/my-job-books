package com.techelevator.dao;

import com.techelevator.model.Job;
import com.techelevator.model.NewJobDto;

import java.util.List;

public interface JobsDao {
    Job getJobByJobId(int jobId);

    List<Job> getJobsByUserId(int userId);

    Job createJob(NewJobDto job);
}
