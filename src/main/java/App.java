import models.Job;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        get("/", (req,res) -> {
            Map<String, String> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new/job", (req,res) -> {
            Map<String, Object> model = new HashMap<>();
            String desc = req.queryParams("description");
            String title = req.queryParams("title");
            int tel = Integer.parseInt(req.queryParams("tel"));
            Job job = new Job(title,desc,tel);
            model.put("jobs", Job.getAll());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
