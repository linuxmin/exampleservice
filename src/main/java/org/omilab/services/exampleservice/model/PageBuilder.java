package org.omilab.services.exampleservice.model;

public class PageBuilder {


    public String buildMainSite(){

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <title>Forum Service</title>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\">\n" +
                "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
                "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\"></script>\n" +
                "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"jumbotron text-center\">\n" +
                "  <h1>Enterprise IS Forum</h1>\n" +
                "  <p>Discuss the important things of life!</p> \n" +
                "</div>" +
                "<nav class=\"navbar navbar-expand-sm bg-primary navbar-dark\">\n" +
                "  <ul class=\"navbar-nav\">\n" +
                "    <li class=\"nav-item active\">\n" +
                "      <a class=\"nav-link\" href=\"#\">Home</a>\n" +
                "    </li>\n" +
                "    <li class=\"nav-item\">\n" +
                "      <a class=\"nav-link\" href=\"#\">Forum</a>\n" +
                "    </li>\n" +
                "    <li class=\"nav-item\">\n" +
                "      <a class=\"nav-link\" href=\"#\">Register</a>\n" +
                "    </li>\n" +
                "    <li class=\"nav-item\">\n" +
                "      <a class=\"nav-link disabled\" href=\"#\">My Profile</a>\n" +
                "    </li>\n" +
                "  </ul>\n" +
                " <form class=\"form-inline\" action=\"/action_page.php\">\n" +
                "    <input class=\"form-control mr-sm-2\" type=\"text\" id=\"user\" placeholder=\"Username\">\n" +
                "    <input class=\"form-control mr-sm-2\" type=\"password\" id=\"password\" placeholder=\"Password\">\n" +
                "    <button class=\"btn btn-success\" type=\"submit\">Login</button>\n" +
                "  </form>" +
                "</nav>";

    }

}
