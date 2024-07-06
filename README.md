# Catalog
Catalog service to report about found models and keep them in DB

## Project tech stack 
Java 17, 
Spring boot

Spring JPA
H2 in memory DB,

## Used patterns and approaches.
* Microservices
* Repositories for working with DB
* Message queue: ActiveMQ

## #How to run application
Run [CatalogApplication.java](src%2Fmain%2Fjava%2Forg%2Fdiecastfinder%2Fcatalog%2FCatalogApplication.java) .main(). 

### set port
open [application.properties](src%2Fmain%2Fresources%2Fapplication.properties) and update server.port parameter.

### set DB
TBD

## How to pre-populate DB
In order to start on non-empty DB, open [BootStrapData.java](src%2Fmain%2Fjava%2Forg%2Fdiecastfinder%2Fcatalog%2Frepositories%2Fbootstrap%2FBootStrapData.java)
and initialize and save domain object [CatalogModel.java](src%2Fmain%2Fjava%2Forg%2Fdiecastfinder%2Fcatalog%2Frepositories%2Fdomain%2FCatalogModel.java)

## How to load DB web UI
* If you use H2:
After application start open browser and type address http://localhost:8086/h2-console/ in order to open H2 console. 8086 is an application port from [application.properties](src%2Fmain%2Fresources%2Fapplication.properties). 

## How to change log level