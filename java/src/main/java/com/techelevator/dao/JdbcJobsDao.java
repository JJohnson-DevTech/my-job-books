package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Job;
import com.techelevator.dto.NewJobDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcJobsDao implements JobsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcJobsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Job getJobByJobId(int jobId) {
        Job job = null;
        String sql = "SELECT * FROM jobs WHERE job_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, jobId);
            if (results.next()) {
                job = mapRowToJob(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return job;
    }
    @Override
    public List<Job> getJobsByUserId(int userId) {

        List<Job> jobsByUserid = new ArrayList<>();
        String sql = "SELECT job_id, title, customer_name, customer_email, customer_number, location, job_date, material_cost, price, user_id " +
                "FROM jobs WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while (results.next()) {
            jobsByUserid.add(mapRowToJob(results));
        }
        try {

        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation while accessing course", e);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to datasource", e);
        } catch (Exception e) {
            throw new DaoException("Error while viewing course(s)", e);
        }
        return jobsByUserid;
    }
    @Override
    public void updateJob(Job jobToUpdate) {
        String updateJobSql = "UPDATE jobs SET " +
                "title = ?, " +
                "customer_name = ?, " +
                "customer_email = ?, " +
                "customer_number = ?, " +
                "location = ?, " +
                "job_date = ?, " +
                "material_cost = ?, " +
                "price = ?, " +
                "user_id = ? " +
                "WHERE job_id = ?;";

        try {
            jdbcTemplate.update(updateJobSql,
                    jobToUpdate.getTitle(),
                    jobToUpdate.getName(),
                    jobToUpdate.getEmail(),
                    jobToUpdate.getNumber(),
                    jobToUpdate.getLocation(),
                    jobToUpdate.getJobDate(),
                    jobToUpdate.getMaterialCost(),
                    jobToUpdate.getPrice(),
                    jobToUpdate.getUserId(),
                    jobToUpdate.getJobId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation while updating job", e);
        }
    }


    @Override
    public Job createJob(NewJobDto job) {
        Job newJob = null;
        String Sql = "INSERT INTO jobs (title,customer_name, customer_email, customer_number, location, job_date, material_cost, price, user_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING job_id";
        try {
            int newJobId = jdbcTemplate.queryForObject(Sql, int.class, job.getTitle(), job.getName(),job.getEmail(),job.getNumber(), job.getLocation(), job.getJobDate(),job.getMaterialCost(),job.getPrice(), job.getUserId());
            newJob = getJobByJobId(newJobId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newJob;
    }

    private Job mapRowToJob(SqlRowSet rs) {
        Job job = new Job();
        job.setJobId(rs.getInt("job_id"));
        job.setTitle(rs.getString("title"));
        job.setName(rs.getString("customer_name"));
        job.setEmail(rs.getString("customer_email"));
        job.setNumber(rs.getString("customer_number"));
        job.setLocation(rs.getString("location"));
        job.setJobDate(rs.getTimestamp("job_date").toLocalDateTime());
        job.setMaterialCost(rs.getBigDecimal("material_cost"));
        job.setPrice(rs.getBigDecimal("price"));
        job.setUserId(rs.getInt("user_id"));
        return job;
    }
}
