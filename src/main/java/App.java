import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
  }
  get("/", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
       model.put("heroes", request.session().attribute("heroes"));
       model.put("template", "templates/index.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("heroes/new", (request, response) -> {
   Map<String, Object> model = new HashMap<String, Object>();
   model.put("template", "templates/hero-form.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 get("/heroes", (request, response) -> {
   Map<String, Object> model = new HashMap<String, Object>();
   model.put("heroes", Hero.all());
   model.put("template", "templates/heroes.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 get("/heroes/:id", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
   model.put("hero", hero);
   model.put("template", "templates/hero.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 get("/teams/new", (request, response) -> {
Map<String, Object> model = new HashMap<String, Object>();
model.put("template", "templates/team-form.vtl");
return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

get("/teams", (request, response) -> {
Map<String, Object> model = new HashMap<String, Object>();
model.put("teams", Team.all());
model.put("template", "templates/teams.vtl");
return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());


get("/teams/:id", (request, response) -> {
Map<String, Object> model = new HashMap<String, Object>();
Team team = Team.find(Integer.parseInt(request.params(":id")));
model.put("team", team);
model.put("template", "templates/team.vtl");
return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());


get("teams/:id/heroes/new", (request, response) -> {
Map<String, Object> model = new HashMap<String, Object>();
Team team = Team.find(Integer.parseInt(request.params(":id")));
model.put("team", team);
model.put("template", "templates/team-heroes-form.vtl");
return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

post("/teams", (request, response) -> {
Map<String, Object> model = new HashMap<String, Object>();
String name = request.queryParams("name");
Team newTeam = new Team(name);
model.put("template", "templates/team-success.vtl");
return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());


     post("/heroes", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();

     ArrayList<Hero> heroes = request.session().attribute("heroes");
     if (heroes == null) {
     heroes = new ArrayList<Hero>();
     request.session().attribute("heroes", heroes);
     }

     String name = request.queryParams("name");
  int age = Integer.parseInt(request.queryParams("age"));
  String strength = request.queryParams("strength");
  String weakness = request.queryParams("weakness");
  Hero newHero = new Hero(name, age, strength, weakness);
  heroes.add(newHero);

          model.put("template", "templates/success.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


   }
}
