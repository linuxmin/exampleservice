# Deployment

`$ git clone https://gitlab.dke.univie.ac.at/omilab-tutorials/ExampleService.git`


`$ cd ExampleService`


`$ vim src/main/resources/config/application-distribution.properties`


`$ mvn clean -Pdistribution package`


`$ java -jar target/exampleservice-0.1.0-SNAPSHOT.jar`

To keep the jar running in the background, a tool like "screen" can be used.