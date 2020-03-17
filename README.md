# piano-test

## Requirements

1. Java - 13.x

2. Gradle - 5.x.x

3. Mysql - 8.x.x

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/iesoveev/piano-test.git
```

**2. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

Database will be create automaticly and table **users** will be filled


**4. Build and run app**

```bash
gradle bootJar
gradle bootRun
```

The app will start running at <http://localhost:8080>.

## Explore Rest API
Example:

    GET /check?roomId=1&entrance=true&keyId=1
