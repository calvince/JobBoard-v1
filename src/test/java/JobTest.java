import models.Job;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class JobTest {

    @Test
    public void instantiatesJobCorrectly() {

        Job job = setUpJob();
        assertTrue(job instanceof Job );

    }

    @Test
    public void getsTitleCorrectly(){
        Job job = setUpJob();
        assertEquals("HR",job.getTitle());
    }

    @Test
    public void getsDescriptionCorrectly(){
        Job job = setUpJob();
        assertEquals("we are people",job.getDescription());
    }

    @Test
    public void getsTelCorrectly(){
        Job job = setUpJob();
        assertEquals(448545,job.getTel());
    }

    @Test
    public void getsAllJobsCreated(){
        Job job = setUpJob();
        assertTrue(Job.getAll().contains(job));
    }

    public Job setUpJob(){
        return new Job("HR","we are people",448545);
    }



}