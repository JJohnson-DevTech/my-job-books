package com.techelevator.controller;

import com.techelevator.dao.JobsDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Job;
import com.techelevator.model.NewJobDto;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class JobController {
    @Autowired
    private JobsDao jobsDao;
    @Autowired
    private UserDao userDao;

    @PostMapping(path = "/create-job")
    public Job createJob(@RequestBody NewJobDto newJobDto){
        return jobsDao.createJob(newJobDto);
    }
    @GetMapping(path = "/get-jobs")
    public List<Job> getJobsByUserId(Principal principal) {
        try {
            User user = userDao.getUserByUsername(principal.getName());
            return jobsDao.getJobsByUserId(user.getId());
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving data", e);
        }
    }




}
