# ms-library-app
Web app for library build with Spring Boot and Angular in microservices architecture.

## Architecture
- Config server
- Discovery service
- API gateway
- Postgres
- Spring boot
- Angular

## How it works
Library app is divided to three different microservices, one for books, one for library members and one for rents.  
Every one of these take its config from config server and register to discovery service. Whole setup is guarded by  
API gateway. Every microservice has its own instance of Postgres database.