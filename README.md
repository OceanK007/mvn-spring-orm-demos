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

# Branch: sboot-crud-mongodb
	* Adding MongoDB CRUD operation
	
# MongoDB URLs
	* http://www.baeldung.com/queries-in-spring-data-mongodb
	* https://www.mkyong.com/spring-boot/spring-boot-spring-data-mongodb-example/
	* http://javasampleapproach.com/spring-framework/spring-data/mongodb-model-one-one-one-many-relationships-mongodb-embedded-documents-springboot