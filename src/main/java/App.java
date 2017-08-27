import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    ProcessBuilder process = new ProcessBuilder();
   Integer port;
   if (process.environment().get("PORT") != null) {
       port = Integer.parseInt(process.environment().get("PORT"));
   } else {
       port = 4567;
   }

 setPort(port);

    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("clients", request.session().attribute("clients")); //We are retrieving the squad from the session
    	model.put("template", "templates/index.vtl");
    	return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("stylists/:id/clients/new", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();
       Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
       model.put("stylist", stylist);
       model.put("template", "templates/stylist-clients-form.vtl");
       return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("clients", Client.all()); // We are placing the ArrayList of all heros into the model making it available to the template
    	model.put("template", "templates/clients.vtl");
    	return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients/:id", (request, response) -> { //This route will be executed when someone clicks a link to see a hero's detail page
        Map<String, Object> model = new HashMap<String, Object>();
        Client client = Client.find(Integer.parseInt(request.params(":id"))); // Retrieves the value currently represented by :id, since the value is a string, we converted it into an int
        model.put("client", client);
        model.put("template", "templates/client.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        ArrayList<Client> clients = request.session().attribute("clients");
        if (clients == null) { // We are retrieving an ArrayList from the session saved under the key "heros"
            clients = new ArrayList<Client>(); // If that ArrayList does not exist yet, we create a new one 
            request.session().attribute("clientss", clients); // And add it to the session
        }

        String name = request.queryParams("name"); // Saving user inputted hero name into a String
        String description = request.queryParams("description");
        Client newClient = new Client(name, description); // Squad constructorcreating new squad with the user's provided name
        request.session().attribute("client", "newClient"); // We then save the squad object into the user's session
        clients.add(newClient); // we create our Squad object and add it into the heros ArrayList


        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // Category creation

    get("/stylists/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/stylist-form.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    // Posting categories into the app

    post("/stylists", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         String name = request.queryParams("name");
          String description = request.queryParams("description");
         Stylist newStylist = new Stylist(name, description);
         model.put("template", "templates/stylist-success.vtl");
         return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    // Listing all categories

    get("/stylists", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("stylists", Stylist.all());
        model.put("template", "templates/stylists.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // Category details page

    get("/stylists/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
        model.put("stylist", stylist);
        model.put("template", "templates/stylist.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();

       Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));

       String name = request.queryParams("name"); // Saving user inputted hero name into a String
        String description = request.queryParams("description");
        Stylist newClient = new Stylist(name, description); // Squad constructorcreating new squad with the user's provided name
        request.session().attribute("client", "newClient"); // We then save the squad object into the user's session

       stylist.addClient(newClient);

       model.put("stylist", stylist);
       model.put("template", "templates/stylist-clients-success.vtl");
       return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
    
  }
}