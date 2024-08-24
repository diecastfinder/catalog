# Catalog
Catalog service to report about found models and keep them in DB

## Project tech stack
Java 17, 
Spring boot

Spring JPA
H2 in memory DB,
or MariaDB

ActiveMQ

## Used patterns and approaches.
* Microservices
* Repositories (JPA/Hibernate) for working with DB
* Mapstruct to convert POJOs between domain (DB) model and API model.  
* Message queue: ActiveMQ

## Configuration in IntelliJ
1. Add "local-discovery" to Active profiles

## How to run application
### On localhost standalone
1. Run Docker (Docker Decktop for Win OS)
2. Run artemis container: docker run --detach --name mycontainer -p 61616:61616 -p 8161:8161 --rm apache/activemq-artemis:latest-alpine
3. Run project eurekareganddiscovery, check http://localhost:8761
4. Run [CatalogApplication.java](src%2Fmain%2Fjava%2Forg%2Fdiecastfinder%2Fcatalog%2FCatalogApplication.java) .main(). 

### Standalone in Docker
TBD

### As a part of application in Docker Compose
TBD

## Settings 
### set port
open [application.properties](src%2Fmain%2Fresources%2Fapplication.properties) and update server.port parameter.

### set DB
This is a responsibility of property files. 
* [application.properties](src%2Fmain%2Fresources%2Fapplication.properties) default profile that starts H2 in memory DB.
* [application-mariadb.properties](src%2Fmain%2Fresources%2Fapplication-mariadb.properties) MariaDB profile, add 'mariadb' to Active Profiles in Run/Debug Configurations.

## How to pre-populate DB
In order to start on non-empty DB, open [BootStrapData.java](src%2Fmain%2Fjava%2Forg%2Fdiecastfinder%2Fcatalog%2Frepositories%2Fbootstrap%2FBootStrapData.java)
and initialize and save domain object [CatalogModel.java](src%2Fmain%2Fjava%2Forg%2Fdiecastfinder%2Fcatalog%2Frepositories%2Fdomain%2FCatalogModel.java)

## How to load DB web UI
* If you use H2:
After application start open browser and type address http://localhost:8086/h2-console/ in order to open H2 console. 8086 is an application port from [application.properties](src%2Fmain%2Fresources%2Fapplication.properties). 

## How to change log level
TBD

## Deployment: artifacts preparation
* Docker - to make a container out of service from DevOps point of view.<br>
  To build docker image use command:
  `C:\Projects\DiecastFinder2\catalog> docker build -f .\src\main\docker\Dockerfile -t diecastfinder-catalog .`
  <br>To run build use command:
  `C:\Projects\DiecastFinder2\catalog> docker run -p 8081:8081 diecastfinder-catalog`


* Spring Boot docker Layers - to optimize consuming of space by sharing common parts of software between services and versions.
  https://springframework.guru/why-you-should-be-using-spring-boot-docker-layers/
    * `mvn clean package` -> fat jar

  Manual creation of layers. Just to test the command.
    * `java -Djarmode=tools -jar target/catalog-0.0.1-SNAPSHOT.jar list-layers` -> printed list
    * `java -Djarmode=tools -jar target/catalog-0.0.1-SNAPSHOT.jar extract --layers --launcher` -> folder with layers

  Run docker file and let docker do all job.
    * `--no-cache` - cache is turned off,<br>
      `-D --progress=plain` - print stdout to console<br>
      `C:\Projects\DiecastFinder2\catalog> docker -D build -f .\src\main\docker\Dockerfile -t diecastfinder-catalog --progress=plain --no-cache .`


* Run Docker from Maven and use properties - in order not to update dockerfile every time as you change version, same docker file for every project.<br>

Plugin docker-maven-plugin from Fabric8 add docker jobs to mvn.<br>
To build docker image from mvn: `mvn docker:build`

