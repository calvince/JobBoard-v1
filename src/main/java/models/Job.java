package models;

import java.util.ArrayList;
import java.util.Collection;

public class Job {

    private String title;
    private String description;
    private int  tel;
    private int id;
    private static ArrayList<Job> jobs = new ArrayList<>();



    public Job( String title, String description, int tel){

        this.title=title;
        this.description=description;
        this.tel=tel;
        this.jobs.add(this);
        this.id = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;

        Job job = (Job) o;

        if (getTel() != job.getTel()) return false;
        if (getId() != job.getId()) return false;
        if (!getTitle().equals(job.getTitle())) return false;
        return getDescription().equals(job.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getTel();
        result = 31 * result + getId();
        return result;
    }

    public static ArrayList<Job> getAll() {
        return jobs;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getTel() {
        return tel;
    }
    public  int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
