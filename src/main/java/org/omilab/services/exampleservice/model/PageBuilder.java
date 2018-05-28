package org.omilab.services.exampleservice.model;

public class PageBuilder {


    public String buildMainSite(){

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <title>Bootstrap Example</title>\n" +
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
                "  <h1>My First Bootstrap Page</h1>\n" +
                "  <p>Resize this responsive page to see the effect!</p> \n" +
                "</div>\n" +
                "  \n" +
                "<div class=\"container\">\n" +
                "  <div class=\"row\">\n" +
                "    <div class=\"col-sm-4\">\n" +
                "      <h3>Column 1</h3>\n" +
                "      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>\n" +
                "      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>\n" +
                "    </div>\n" +
                "    <div class=\"col-sm-4\">\n" +
                "      <h3>Column 2</h3>\n" +
                "      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>\n" +
                "      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>\n" +
                "    </div>\n" +
                "    <div class=\"col-sm-4\">\n" +
                "      <h3>Column 3</h3>        \n" +
                "      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>\n" +
                "      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";

    }

}
