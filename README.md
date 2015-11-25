## About

Reference application using spring boot and aws java api

[Java Developer Guide](http://aws.amazon.com/sdk-for-java/)

## Dev Process
initial project setup created at https://start.spring.io/


## Spring Components 

core: cache 

- https://spring.io/guides/gs/caching/ 
- http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html

core: devtools 

- https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3

web: web

- http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html
- https://spring.io/guides/gs/serving-web-content/

web: rest repositories

- http://docs.spring.io/spring-data/rest/docs/current/reference/html/
- https://spring.io/guides/gs/rest-service/

web: rest repositories HAL Browser 

- http://docs.spring.io/spring-data/rest/docs/current/reference/html/#_the_hal_browser

web: hateoas

- https://spring.io/guides/gs/rest-hateoas/

web: rest docs 

- http://projects.spring.io/spring-restdocs/

database: mysql

data: jdbc


data: jpa

- http://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- http://projects.spring.io/spring-data-jpa/
- https://spring.io/guides/gs/accessing-data-jpa/


- https://spring.io/guides/gs/accessing-data-rest/

io: mail(javx.mail)

ops: actuator
ops: actuator docs
ops: remote shell


## App Requirements

- create a watch list
- add tickers to watchlist
- add price levels to tickers
- store images related to 
- generate alerts: email, sns, etc


## Properties Configuration

application.yml contains runtime static propeties

reference
- http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-external-config-yaml
- http://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html


## Caching

Basic caching can be applied at the service layer to reduce calls to "expensive" services. Care must be taken to evict 
caches when data is created/updated.

see docs: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cache.html


