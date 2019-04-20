# mvn-spring-orm-demos
Maven spring ORM demos

# To clean install
mvn clean install -DskipTests

# To run
mvn spring-boot:run

# To debug
mvnDebug spring-boot:run

# To run the project(There are 2 approaches):
   ** Approach first **
   1. cd project-folder-name
   2. mvn clean install -DskipTests   || mvn package	(It will create the jar/war file of project)
   3. java -jar target/jar-or-war-name-with-extension
    	
   ** Approach second **
   1. cd project-folder-name
   2. mvn clean install -DskipTests
   3. mvn sprint-boot:run
   
# To run in debug mode:
   1. cd project-folder-name
   2. mvnDebug spring-boot:run
   3. goto eclipse > debug > debug configurations > remote java application > create new configuration
   
# Branch: sboot-crud
	* Adding External configuration (.properties file configuration)
	* Adding Logging functionality slf4j
	* Adding management services (health, audit, beans and more)
	* Adding Data JPA with Hibernate as implementation
	* Adding MySQL as database
	* Adding modelMapper to map DTO to Entity and vice-versa
	* Adding JodaTime
	* Adding Exception handling for Validations fail
	* Adding indexes to optimize the search from database
	* Adding Criteria for dynamic query generation
	* Adding Specification for dynamic query generation
	* Adding QueryDSL for dynamic query generation. (Still didn't implement)
	* Adding Projection to fetch specific numbers of columns
	* Adding Caching @Service and @Repository levels

# Branch: sboot-crud-junit
	* Adding JUnit with Mockito and PowerMockito

# Spring boot URLs
	* https://spring.io/guides/gs/spring-boot/

# JodaTime URLs
	* https://stackoverflow.com/questions/18504174/daylight-saving-time-in-java/23147782#23147782
	* https://stackoverflow.com/questions/41743455/how-to-store-joda-datetime-in-sql-server-database-with-hibernate
	* https://stackoverflow.com/questions/17271039/does-system-currenttimemillis-return-utc-time
	* https://en.wikipedia.org/wiki/List_of_tz_database_time_zones

# DataJPA URLs
	* https://codingexplained.com/coding/java/spring-framework/fetch-query-not-working-spring-data-jpa-pageable

# Exception Handling URLs
	* https://www.toptal.com/java/spring-boot-rest-api-error-handling
	* https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/ExceptionHandler.html

# MySQL indexing URLs
	* https://dev.mysql.com/doc/refman/5.7/en/mysql-indexes.html
	* https://stackoverflow.com/questions/2955459/what-is-an-index-in-sql
	* https://www.w3schools.com/sql/sql_create_index.asp

# Data JPA Criteria URLs
	* http://www.baeldung.com/rest-api-search-language-spring-data-specifications
	* http://www.baeldung.com/rest-search-language-spring-jpa-criteria
	* https://github.com/pkainulainen/spring-data-jpa-examples/tree/master/criteria-api

# Data JPA Specifications & QueryDSL URLs
	* https://spring.io/blog/2011/04/26/advanced-spring-data-jpa-specifications-and-querydsl/
	* https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-five-querydsl/

# Data JPA metamodel(Used in criteria, specification, queryDsl) automatic generator URLs
	* https://docs.jboss.org/hibernate/orm/5.0/topical/html/metamodelgen/MetamodelGenerator.html
	* https://www.thoughts-on-java.org/static-metamodel/
	* https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-four-jpa-criteria-queries/

# Swagger URLs
	* https://huongdanjava.com/documenting-your-rest-api-with-swagger-in-spring-boot.html
	* https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger

# ThreadLocal Variables URLs
	* https://stackoverflow.com/questions/817856/when-and-how-should-i-use-a-threadlocal-variable

# Cache URLs
	* https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-cache				// Scheduler + profiling
	* https://memorynotfound.com/spring-boot-ehcache-2-caching-example-configuration/

# Connection Pooling URLs
	* https://www.wix.engineering/single-post/how-does-hikaricp-compare-to-other-connection-pools
	* https://github.com/hendisantika/HikariCP/blob/master/pom.xml
	* https://www.mkyong.com/spring-boot/spring-boot-how-to-know-which-connection-pool-is-used/
	* http://www.mkyong.com/spring-boot/spring-boot-jdbc-mysql-hikaricp-example/
	* https://github.com/brettwooldridge/HikariCP/wiki/MBean-(JMX)-Monitoring-and-Management

# Google Compute Engine Vs Google App Engine (Standard) vs Google App Engine (Flexible) Urls
	* https://stackoverflow.com/questions/22697049/what-is-the-difference-between-google-app-engine-and-google-compute-engine

# SAAS vs PAAS vs IAAS
	* https://www.computenext.com/blog/when-to-use-saas-paas-and-iaas/

# Google Cloud
	* https://cloud.google.com/compute/docs/quickstarts
	* https://cloud.google.com/compute/docs/tutorials/basic-webserver-apache