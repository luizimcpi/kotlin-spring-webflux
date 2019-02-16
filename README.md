# kotlin-spring-webflux
A kotlin api using Spring Webflux

# Run in Terminal
** IMPORTANT: You should install Docker and docker-compose on your pc
** Run all the commands bellow inside the root directory of this project


First Time Configuration:

Build
```
./gradlew build
```

Generate Docker Application Image:
```
docker build -t kotlin-spring-webflux .
```
Get mongodb image:
```
docker pull bitnami/mongodb:latest
```

Now start all enviroment:
```
docker-compose up