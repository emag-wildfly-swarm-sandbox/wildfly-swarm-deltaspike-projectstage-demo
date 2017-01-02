# wildfly-swarm-deltaspike-projectstage-demo

WildFly Swarm DeltaSpike ProjectStage Demo

## Usage

### Run App

``` sh
$ ./mvnw clean package &&\
  java -jar target/wildfly-swarm-deltaspike-projectstage-demo-swarm.jar
```

``` sh
$ curl localhost:8080
{"message": "Hello"} 
```

### Run the test

``` sh
  $ ./mvnw clean verify \
    -Dswarm.project.stage.file=file://`pwd`/src/main/resources/project-stages.yml \
    -Dswarm.project.stage=it
```
