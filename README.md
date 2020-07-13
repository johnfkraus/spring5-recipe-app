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

## Okta notes

https://dev-336446-admin.okta.com/admin/app/oidc_client/instance/0oa3y4407akF9gOWB4x6/#tab-general

Client ID
0oa3y4407akF9gOWB4x6

Client Secret
Nl_YK28UIb7xkAkYCw7_xeVNtVZ6Ym5uI-tlQzAO

Org URL
Self-dev-336446
https://dev-336446-admin.okta.com
https://dev-336446.okta.com
Note: https://{yourOktaDomain} is different from your admin URL. Don’t include -admin in the value.
When copying your Okta domain from the developer console, you can find the correct value in upper right corner of the dashboard.

