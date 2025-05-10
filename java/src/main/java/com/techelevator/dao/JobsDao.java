package com.techelevator.dao;

import com.techelevator.dto.NewJobDto;
import com.techelevator.model.Job;
import com.techelevator.dto.NewJobDto;

import java.util.List;

public interface JobsDao {
    Job getJobByJobId(int jobId);

    List<Job> getJobsByUserId(int userId);

    void updateJob(Job jobToUpdate);

    Job createJob(NewJobDto job);
}
