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
                "</div>" + "         <div class=\"navbar-default\">\n" +
                "                    <ul class=\"nav nav-pills\">\n" +
                "                        <li><a href=\"index.php\">Home</a></li>\n" +
                "                        <li><a  href=\"fahrzeugsuche.php\">Fahrzeugsuche</a></li>\n" +
                "                        <li><a  href=\"#\">Flotte</a></li>\n" +
                "                        <li><a  href=\"administration/admin.html\">Mitarbeiterbereich</a></li>\n" +
                "                        <form class=\"navbar-form navbar-right\" id=\"loginform\" action=\"index.php\" method=\"post\">\n" +
                "                            <div class=\"form-group\">\n" +
                "                                <label for=\"username\">Benutzername</label>\n" +
                "                                <input type=\"text\" class=\"form-control\" name=\"username\" id=\"username\">\n" +
                "                                <label for=\"password\">Password</label>\n" +
                "                                <input type=\"password\" class=\"form-control\" name=\"password\" id=\"password\">\n" +
                "                            </div>\n" +
                "                            <button type=\"submit\" formmethod=\"post\" class=\"btn btn-default\">Login</button>\n" +
                "                            <a href=\"register.html\">Registrierung</a>\n" +
                "                        </form>\n" +
                "                </div>";

    }

}
