# Java-Assignment

###### Required : JDK 8, Open the project in terminal and from root path of project, execute below commands
 - For Building App: ```mvnw.cmd clean install -Dmaven.test.skip=true```
 - For running App: ```mvnw.cmd spring-boot:run``` 
 - Swagger URL(need to update the port as per project) : ```http://localhost:${portNo}/swagger-ui.html#/```
 - Log File : ```${Workspace}>${Project}>${Logs}>${AppName.log}```
 - Zipkin server(attached jar file inside task2 folder)
    - start the server  : ```java -jar zipkin-server-2.12.9-exec.jar```
    - zipikin UI : ```http://localhost:9411/zipkin/```



## Task-1 description 
-  I Assume given data is like of cartoon characters and named the resource as cartoon
-  Inserted the data into AWS Relational database and use the same as datasource in project.

#### anime-rest-api service- [exposed RESTAPI endpoints - getById && getting the list]

```bash
URL(pass the id in path variable) : http://localhost:8080/v1/cartoon/{id}
HTTP Method : GET
```
Json Response :
```json
 {
    "Name": "Rogue",
    "Sub Classes": [
      {
        "Name": "Thief",
        "Sub Classes": [
          {
            "Name": "Assassin"
          }
        ]
      },
      {
        "Name": "Bard"
      }
 }
```

```bash
URL(/list) : http://localhost:8080/v1/cartoon/list
HTTP Method : GET
```
Json Response :
```json
 [
  {
    "name": "Warrior",
    "subclasses": [
      {
        "name": "Fighter"
      },
      {
        "name": "Paladin"
      },
      {
        "name": "Ranger"
      }
    ]
  },
  {
    "name": "Wizard",
    "subclasses": [
      {
        "name": "Mage"
      },
      {
        "name": "Specialist wizard"
      }
    ]
  },
  {
    "name": "Priest",
    "subclasses": [
      {
        "name": "Cleric"
      },
      {
        "name": "Druid"
      },
      {
        "name": "Priest of specific mythos"
      }
    ]
  },
  {
    "name": "Rogue",
    "subclasses": [
      {
        "name": "Thief",
        "subclasses": [
          {
            "name": "Assassin"
          }
        ]
      },
      {
        "name": "Bard"
      }
    ]
  }
]
```


## Task-2 description 
- demo-rest-api (microservice1) communicates to service-b(microservice2) and service-c(microservice3)
- start all three services
- Below provided the project>exposed end points && there request, response json OR view from Swagger UI after running the project.


#### service-c [PortNo:8083 , RESTAPI endpoints - post]
```bash
URL : http://localhost:8083/service-c/hello
HTTP Method : GET
```
Json Request :
```json
{
  "message": "Hello"
}
```
</br>





#### service-b [PortNo:8082 , RESTAPI endpoints - post]
```bash
URL : http://localhost:8082/service-c/concat
HTTP Method : POST
```
Json Request :
```json
{
    "name":"John",
    "surname": "Doe"
}
```
Json Response :
```json
{
  "John Doe"
}
```
</br>


#### demo-rest-api [Default PortNo:8080 , endpoints - get,post]
```bash
URL : http://localhost:8080/service-a/concat
HTTP Method : POST
```
Json Request :
```json
{
    "name":"John",
    "surname": "Doe"
}

```
Json Response :
```json
{
  "Hello John Doe"
}

```
```bash
URL : http://localhost:8080/service-a/service-status
HTTP Method : GET
```
Json Response :
```json
{
  "service-status":"Up"
}
```

