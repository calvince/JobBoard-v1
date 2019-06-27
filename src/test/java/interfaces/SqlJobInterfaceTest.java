package interfaces;

import models.Job;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.*;




import static org.junit.Assert.*;


public class SqlJobInterfaceTest {
    private Connection conn;
    private SqlJobInterface sqlJobInterface;

    @Before
    public void setUp() throws Exception{
        String establishConn = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(establishConn,"","");
        sqlJobInterface = new SqlJobInterface(sql2o);
        conn = sql2o.open();
    }
    @After
    public void tearDown() throws Exception{
        conn.close();
    }

    @Test
    public void addJobAndSetsId() throws Exception {
        Job job = setupJobs();
        int firstId = job.getId();
        sqlJobInterface.add(job);
        assertNotEquals(firstId,job.getId());
    }
    @Test
    public void getJobById() throws Exception{
        Job exiStingJob = new Job("Backend","Python",89556);
        sqlJobInterface.add(exiStingJob);
        Job fetchJob =  sqlJobInterface.findById(exiStingJob.getId());
        assertEquals(exiStingJob, fetchJob);

    }
    @Test
    public void upDate()throws Exception{
        Job job = setupJobs();
        sqlJobInterface.add(job);
        Job jobUpdate = new Job("Comp_support","computing",45524);
        sqlJobInterface.update(jobUpdate,job.getId());
        Job fetchJob = sqlJobInterface.findById(job.getId());
        assertEquals(jobUpdate,fetchJob);
    }
    public Job setupJobs(){
        return new Job("frontend","Android",97865746);
    }
}
