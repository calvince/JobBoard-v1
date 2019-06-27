package interfaces;

import models.Job;
import org.sql2o.*;
import org.sql2o.Sql2oException;


import java.util.List;


public class SqlJobInterface implements  JobInterface{
    private final Sql2o sql2o;

    public SqlJobInterface(Sql2o sql2o){
        this.sql2o = sql2o;

    }

    @Override
    public void add(Job job) {
        String sql = "INSERT INTO  jobs(title,description,tel) VALUES (:title,:description,:tel)";
        try (Connection con = sql2o.open()){
           int id =(int) con.createQuery(sql,true).bind(job).executeUpdate().getKey();
           job.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Job> getAll() {
        return null;
    }

    @Override
    public Job findById(int id) {
        String sql = "SELECT * FROM  jobs WHERE id=:id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(Job.class);
        }
    }

    @Override
    public void update(Job job, int id) {
        String sql = "UPDATE jobs SET (title,description,tel)=(:title,:description,:tel) WHERE id=:id";
        try (Connection con= sql2o.open()){
            con.createQuery(sql).addParameter("title",job.getTitle())
                    .addParameter("description",job.getDescription())
                    .addParameter("tel",job.getTel())
                     .addParameter("id",id).executeUpdate();
        }

    }

    @Override
    public void delete() {

    }
}
