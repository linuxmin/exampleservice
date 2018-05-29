package org.omilab.services.exampleservice.model;

public class PageBuilder {

    public String showRegistration(){
       return "<form method=\"post\" action=\"\">\n" +
               "  <div class=\"form-group\">\n" +
               "    <label for=\"usernameid\">Username:</label>\n" +
               "    <input type=\"text\" class=\"form-control\" id=\"usernameid\" name=\"username\">\n" +
               "  </div>\n" +
               "  <div class=\"form-group\">\n" +
               "    <label for=\"emailid\">Email address:</label>\n" +
               "    <input type=\"email\" class=\"form-control\" id=\"emailid\" name=\"email\">\n" +
               "  </div>\n" +
               "  <div class=\"form-group\">\n" +
               "    <label for=\"pwdid\">Password:</label>\n" +
               "    <input type=\"password\" class=\"form-control\" id=\"pwdid\" name=\"pwd\">\n" +
               "  </div>\n" +
               "  <div class=\"form-group\">\n" +
               "    <label for=\"rpwdid\">Repeat Password:</label>\n" +
               "    <input type=\"password\" class=\"form-control\" id=\"rpwid\" name=\"rpwd\">\n" +
               "  </div>\n" +
               "  <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
               "</form>";
    }


    public String showForum(ForumThread forumThread) {

            return "  <a href=\"javascript:submitform('thread" + forumThread.getThreadId() + "');\" class=\"list-group-item list-group-item-action flex-column align-items-start\">\n" +
                    "    <div class=\"d-flex w-100 justify-content-between\">\n" +
                    "      <h5 class=\"mb-1\">" + forumThread.getForumUser().getUserName() + "</h5>\n" +
                    "      <small>3 days ago</small>\n" +
                    "    </div>\n" +
                    "    <p class=\"mb-1\">"+ forumThread.getThreadTitle() + "</p>\n" +
                    "    <small>"+ forumThread.getCreationDate() + "</small>\n" +
                    "  </a>";


    }

    public String showThread(ForumThread forumThread, Integer i){
       return "<div class=\"media border p-3\">\n" +
               "  <img src=\"https://www.w3schools.com/bootstrap4/img_avatar3.png\" alt=\"John Doe\" class=\"mr-3 mt-3 rounded-circle\" style=\"width:60px;\">\n" +
               "  <div class=\"media-body\">\n" +
               "    <h4>John Doe <small><i>Posted on February 19, 2016</i></small></h4>\n" +
               "    <p>"+ forumThread.getForumPostings().get(i).getPostingContent() + "</p>\n" +
               "  </div>\n" +
               "</div>";
    }

    public String createThread(ForumUser forumUser){
        return "  <h2>Create new Thread</h2>\n" +
                "  <form method=\"post\" action=\"\">\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"title\">Title:</label>\n" +
                "      <input type=\"text\" class=\"form-control\" id=\"threadtitleid\" placeholder=\"Enter title\" name=\"threadtitle\">\n" +
                "    </div>\n" +
                "    <div class=\"form-group\">\n" +
                "      <label for=\"comment\">Comment:</label>" +
                "      <textarea class=\"form-control\" rows=\"5\" id=\"threadpostingid\" name=\"threadposting\"></textarea>" +
                "    </div>\n" +
                "   <input type=\"hidden\" name=\"login\" value=\"" + forumUser.getUserId() + "\" />" +
                "   <input type=\"hidden\" name=\"user\" value=\""+ forumUser.getUserName() + "\" />" +
                "<input type=\"hidden\" id=\"navform2\" name=\"navinput\" value=\"true\" />" +
                "    <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
                "  </form>";
    }

    public String forumSite(){
        return "";
    }

    public String homeSite(){
        return "<div class=\"container\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-sm-6\">\n" +
                "            <h1 id=\"cats\">Was gibt es hier zu sehen?</h1>\n" +
                "    <h3>Katzen</h3>\n" +
                "    <p><img class=\"catswithbats\" src=\"pictures/catsbats.jpg\" alt=\"Cats with Bats\" width=480\">\"Die ersten Vorfahren der Kleinkatze der Alten Welt, zu denen auch die Wildkatze (Felis silvestris) gehört, erschienen vor etwa neun Millionen Jahren.[16] Die Wildkatze ist asiatischen Ursprungs und trat erstmals im unteren Pleistozän mit der Spezies Felis lunensis in Erscheinung.\n" +
                "    Anschließend breiteten sich verschiedene Unterarten in der gesamten Alten Welt aus. Wegen der morphologischen Ähnlichkeit und der nahen genetischen Verwandtschaft war der Ursprung der Hauskatze (Felis catus) bis vor kurzem nicht gänzlich geklärt.\n" +
                "    Eine Abstammung von der Manul (Otocolobus manul) oder der Rohrkatze (Felis chaus) wurde von der Wissenschaft verneint.\n" +
                "    Auch die Meinung, die Hauskatze sei eine Kreuzung aus Rohr- und Wildkatze, ist heute obsolet, wenn es auch vereinzelt zu Paarungen der beiden Arten gekommen sein mag, zumal diese in der F1-Generation fruchtbar sind.\n" +
                "    Die Domestikationsforschung ging davon aus, dass die Hauskatze lediglich von einer Wildart abstammt, nämlich der Wildkatze (Felis silvestris), deren Lebensraum sich von Schottland über Afrika bis nach Asien erstreckt.\n" +
                "    Es galt als wahrscheinlich, dass Vertreter von drei Hauptgruppen der Art (Waldkatze, Falbkatze, Steppenkatze) am Domestikationsprozess beteiligt waren. Hierbei hat die Waldkatze (Felis silvestris silvestris) ihren natürlichen Lebensraum in Europa, Kleinasien und im Iran.\n" +
                "    Sie ist relativ kräftig, hat kurze Ohren und einen buschigen, dicken Schwanz. Die Falbkatze (Felis silvestris lybica) lebt in den Buschlandschaften und Steppen Afrikas und Arabiens. Sie hat große Ohren, ist schlank und hochbeinig.\n" +
                "    Die Steppenkatze (Felis silvestris ornata) kommt in Vorder- und Mittelasien vor. Sie ist kräftiger gebaut und untersetzter als die Falbkatze.\n" +
                "    Die genetischen Merkmale der Wildkatzen sind gegenüber denen der Hauskatze dominant. Als Hauptstammform betrachtete man die Falbkatze, der zweitstärkste Einfluss wurde der Steppenkatze zugesprochen. Die Waldkatze ist ein ausgesprochener Kulturflüchter und kam als Vorfahre am wenigsten in Frage.\n" +
                "    Tatsächlich ist unter den verschiedenen Unterarten von Felis silvestris der Urahn der domestizierten Hauskatze die auch als Falbkatze bezeichnete afrikanische Wildkatze Felis silvestris lybica.[35]\n" +
                "    Diese Unterart ist die am wenigsten aggressive und damit am besten für das Zusammenleben mit den Menschen geeignet, so dass sie im Alten Ägypten als Heimtier gehalten wurde.\n" +
                "    Ein Team der Universität Oxford um den Genetiker Carlos Driscoll, das die Gene von fast 1000 Hauskatzen von fünf Kontinenten untersuchte, wies nach,\n" +
                "    dass alle fünf aufgefundenen genetischen Hauptlinien allein von der Felis silvestris lybica abstammen und dass die\n" +
                "        Domestikation wahrscheinlich fünffach unabhängig voneinander im sogenannten Fruchtbaren Halbmond erfolgte.\"[36] (Quelle: <a href=\"https://de.wikipedia.org/wiki/Hauskatze\" target=\"_blank\">Wikipedia</a>)\n" +
                "    </p>\n" +
                "        </div>\n" +
                "        <div class=\"col-sm-6\">\n" +
                "            <h3 id=\"databases\">Datenbanken in Verwendung mit MySQL und PHP</h3>\n" +
                "            <h4>MySQL</h4>\n" +
                "            <p>\n" +
                "\n" +
                "            </p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-sm-6\">\n" +
                "    <h3 id=\"programming\">Programmiersprachen</h3>\n" +
                "    <h4>C++</h4>\n" +
                "    <section>\n" +
                "        <svg class=\"cpplogo\" viewbox=\"0 0 50 50\" width=\"50\" height=\"50\">\n" +
                "            <defs>\n" +
                "                <mask id=\"mask\" x=\"0\" y=\"0\" width=\"100\" height=\"49\">\n" +
                "                    <rect x=\"0.5\" y=\"0.5\" width=\"49\" height=\"49\" fill=\"#fff\"/>\n" +
                "                    <text class=\"cpptext\" x=\"20\" text-anchor=\"middle\" y=\"50\" dy=\"0\">C</text>\n" +
                "                    <text class=\"cpptext\" x=\"27\" id=\"ltrV\" text-anchor=\"middle\" y=\"50\" dy=\"0\">+</text>\n" +
                "                    <text class=\"cpptext\" x=\"34\" text-anchor=\"middle\" y=\"50\" dy=\"0\">+</text>\n" +
                "                </mask>\n" +
                "            </defs>\n" +
                "            <rect x=\"0.5\" y=\"0.5\" width=\"49\" height=\"49\" mask=\"url(#mask)\" fill-opacity=\"1\" fill=\"#E3DFD2\"/>\n" +
                "        </svg>\n" +
                "        C++ wird sowohl in der Systemprogrammierung als auch in der Anwendungsprogrammierung eingesetzt und gehört in beiden Bereichen zu den verbreitetsten Programmiersprachen.[2]\n" +
                "        Typische Anwendungsfelder in der Systemprogrammierung sind Betriebssysteme, eingebettete Systeme, virtuelle Maschinen, Treiber und Signalprozessoren. C++ nimmt hier oft den Platz ein, der früher ausschließlich Assemblersprachen und der Programmiersprache C vorbehalten war.\n" +
                "        Bei der Anwendungsprogrammierung kommt C++ vor allem dort zum Einsatz, wo hohe Forderungen an die Effizienz gestellt werden, um durch technische Rahmenbedingungen vorgegebene Leistungsgrenzen möglichst gut auszunutzen. Ab dem Jahr 2000 wurde C++ aus der Domäne der Anwendungsprogrammierung von den Sprachen Java und C# zurückgedrängt.\n" +
                "        (Quelle: <a href=\"https://de.wikipedia.org/wiki/C%2B%2B\"target=\"_blank\">Wikipedia</a>)</section><br>\n" +
                "        </section>\n" +
                "        </div>\n" +
                "        <div class=\"col-sm-6\">\n" +
                "    <h4>Java</h4>\n" +
                "    <section><img class=\"javalogo\" src=\"pictures/Java-Logo.svg\" alt=\"Java\" width=\"50\">Java ist eine objektorientierte Programmiersprache und eine eingetragene Marke des Unternehmens Sun Microsystems, welches 2010 von Oracle aufgekauft wurde. Die Programmiersprache ist ein Bestandteil der Java-Technologie – diese besteht grundsätzlich aus dem Java-Entwicklungswerkzeug (JDK) zum Erstellen von Java-Programmen und der Java-Laufzeitumgebung (JRE) zu deren Ausführung.\n" +
                "        Die Laufzeitumgebung selbst umfasst die virtuelle Maschine (JVM) und die mitgelieferten Bibliotheken. Java als Programmiersprache darf nicht mit der Java-Technologie gleichgesetzt werden, Java-Laufzeitumgebungen führen Bytecode aus, der neben der Java-Programmiersprache auch aus anderen Programmiersprachen wie Nice und Groovy kompiliert werden kann.\n" +
                "        Im Prinzip könnte jede Programmiersprache als Grundlage für Java Bytecode genutzt werden, meistens existieren aber keine entsprechenden Bytecode-Compiler.\n" +
                "        Die Programmiersprache Java dient innerhalb der Java-Technologie vor allem dem Formulieren von Programmen.\n" +
                "        Diese liegen zunächst als reiner, menschenverständlicher Text vor, als sogenannter Quellcode. Dieser Quellcode ist nicht direkt ausführbar; erst der Java-Compiler,\n" +
                "        der Teil des Entwicklungswerkzeugs ist, übersetzt ihn in einen maschinenverständlichen Code, den sogenannten Java-Bytecode. Die Maschine, die diesen Bytecode ausführt,\n" +
                "        ist jedoch typischerweise virtuell – das heißt, der Code wird meist nicht direkt durch Hardware (etwa einen Mikroprozessor) ausgeführt, sondern durch entsprechende Software auf der Zielplattform.\n" +
                "        Zweck dieser Virtualisierung ist Plattformunabhängigkeit: Das Programm soll ohne weitere Änderung auf jeder Rechnerarchitektur laufen können, wenn dort eine passende Laufzeitumgebung installiert ist.\n" +
                "        Oracle selbst bietet Laufzeitumgebungen für die Betriebssysteme Linux, macOS, Solaris und Windows an. Andere Hersteller lassen eigene Java-Laufzeitumgebungen für ihre Plattform zertifizieren.\n" +
                "        Auch in Autos, HiFi-Anlagen und anderen elektronischen Geräten wird Java verwendet. (Quelle: <a href=\"https://de.wikipedia.org/wiki/Java_(Programmiersprache)\"target=\"_blank\">Wikipedia</a>)</section><br></section>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>";

    }

    public String loggedInNav(ForumUser forumUser){
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
                "<script type=\"text/javascript\">\n" +
                "function submitform(p)\n" +
                "{\n" +
                " document.getElementById(\"navform\").value = p; " +
                "  document.loginform.submit();\n" +
                "}\n" +
                "</script>\n" +
                "<style>\n" +
                ".list-group, .postings{ max-height: 300px;\n" +
                "    margin-bottom: 10px;\n" +
                "    overflow:scroll;\n" +
                "    -webkit-overflow-scrolling: touch;}" +
                "h1 {color:red;}\n" +
                "p {color:blue;}\n" +
                "</style>" +
                "</head>\n" +
                "<body data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"50\">" +
                "\n" +
                "<div class=\"jumbotron text-center\">\n" +
                "  <h1>Enterprise IS Forum</h1>\n" +
                "  <p>Welcome " + forumUser.getUserName() + "</p> \n" +
                "</div>" +
                "<nav class=\"navbar navbar-expand-sm bg-primary navbar-dark\">\n" +
                "  <ul class=\"navbar-nav\">\n" +
                "    <li class=\"nav-item active\">\n" +
                "      <a class=\"nav-link\" <a class=\"nav-link\" href=\"javascript:submitform('home');\">Home</a>\n" +
                "    </li>\n" +
                "    <li class=\"nav-item\">\n" +
                "      <a class=\"nav-link\" href=\"javascript:submitform('forum');\">Forum</a>\n" +
                "    </li>\n" +
                "    <li class=\"nav-item\">\n" +
                "      <a class=\"nav-link\" href=\"javascript:submitform('profile');\">My Profile</a>\n" +
                "    </li>\n" +
                "    <li class=\"nav-item\">\n" +
                "      <a class=\"nav-link\" href=\"javascript:submitform('logout');\">Logout</a>\n" +
                "    </li>\n" +
                "  </ul>\n" +
                "  <form class=\"navbar-form navbar-left\" action=\"/action_page.php\">\n" +
                "      <div class=\"input-group\">\n" +
                "        <input type=\"text\" class=\"form-control\" placeholder=\"Search\" name=\"search\">\n" +
                "        <div class=\"input-group-btn\">\n" +
                "          <button class=\"btn btn-default\" type=\"submit\">\n" +
                "            <i class=\"glyphicon glyphicon-search\"></i>\n" +
                "          </button>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </form>"+
                "<ul class=\"navbar-nav\">\n" +
                "                  <li class=\"nav-item \">" +
                "                      <a class=\"nav-link\"href=\"javascript:submitform('newtopic');\">Create new Thread</a>\n " +
                "                    </li>" +
                "                  </ul>" +
                "</nav>" + "<form class=\"form-inline\" name=\"loginform\" method=\"post\" action=\"\">\n" +
                "<input type=\"hidden\" name=\"login\" value=\"" + forumUser.getUserId() + "\" />" +
                "<input type=\"hidden\" id=\"navform\" name=\"navinput\" value=\"true\" /></form>";


    }

    public String notLoggedInNav(){

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
                "<body data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"50\">" +
                "\n" +
                "<div class=\"jumbotron text-center\">\n" +
                "  <h1>Enterprise IS Forum</h1>\n" +
                "  <p>Discuss the important things of Life!</p> \n" +
                "</div>" +
                "<nav class=\"navbar navbar-expand-sm bg-primary navbar-dark\">\n" +
                "  <ul class=\"navbar-nav\">\n" +
                "    <li class=\"nav-item active\">\n" +
                "      <a class=\"nav-link\" href=\"#\">Home</a>\n" +
                "    <li class=\"nav-item\">\n" +
                "      <a class=\"nav-link\" href=\"javascript:submitform('register');\">Register</a>\n" +
                "    </li>\n" +
                "  </ul>\n" +
                " <form class=\"form-inline\" action=\"\" method=\"post\">\n" +
                "    <input class=\"form-control mr-sm-2\" type=\"text\" name=\"user\" placeholder=\"Username\">\n" +
                "    <input class=\"form-control mr-sm-2\" type=\"password\" name=\"password\" placeholder=\"Password\">\n" +
                "    <button class=\"btn btn-success\" type=\"submit\">Login</button>\n" +
                "  </form>" +
                "</nav>";

    }

}
