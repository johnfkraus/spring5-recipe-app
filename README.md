# Spring Boot Recipe Application


[![CircleCI](https://circleci.com/gh/johnfkraus/spring5-recipe-app.svg?style=svg)](https://circleci.com/gh/johnfkraus/spring5-recipe-app)

This repository is for an example application built in the Spring Framework 5 - Beginner to Guru

You can learn about the Spring Framework 5 Online course [here.](https://go.springframework.guru/spring-framework-5-online-course)

H2 database console:
http://localhost:8080/h2-console


Services -- services as stateless reusable objects, preferably with singleton scope, that are used to perform business logic operations on other objects passed as arguments.

@Repository -- stereotype for persistence layer;  annotation is a marker for any class that fulfills the role or stereotype (also known as Data Access Object or DAO) of a repository. Among the uses of this marker is the automatic translation of exceptions.
In addition to pointing out, that this is an Annotation based Configuration, @Repository’s job is to catch platform specific exceptions and re-throw them as one of Spring’s unified unchecked exception.

@Controller -- stereotype for presentation layer (spring-mvc)

