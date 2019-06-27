package interfaces;

import models.Job;

import java.util.List;

public interface JobInterface {
    //create a list
    void add(Job job);

    List<Job> getAll();

    //find specific job
    Job findById(int id);

    //update
    void update(Job job, int id);

    //delete
    void delete();
}
