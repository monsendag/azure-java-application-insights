# azure-java-application-insights
Java in azure with application insights

Applikasjonen er veldig enkel. Det er en Todoliste. Den har et RESTful API, er laget med [Spring Boot] [spring-boot-url] og benytter en in-memory database.

###Det som trengs
- [Java 7] [java-url] eller nyere.
- [Maven] [maven-url], følg installasjonsbeskrivelsen på nedlastingssiden.

###Installer Microsoft JDBC Driver for SQL Server
`mvn install:install-file -Dfile=3rd-party-jars/sqljdbc4-4.0.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.0 -Dpackaging=jar`

###Kjør applikasjonen:
- fra kommandolinja med kommandoen: `mvn spring-boot:run`
- fra IDE ved å kjøre TodoApplication.java som inneholder main metoden.

###Hva applikasjonen kan gjøre
Da det ikke er noe GUI så benytt gjerne en REST-klient. Det gjør lagring av data enklere.

####List alle Todos
URL: localhost:8080/todo (GET)

####Legg til en Todo
URL: localhost:8080/todo (POST)

Forventet input:

    {
      "title": "eksempeltittel",
      "content": "beskrivelse for todo"
    }
    
####Endre en Todo
URL: localhost:8080/todo (PUT)

Forventet input:

    {
      "id": 1,
      "title": title,
      "content": content,
      "completed": true
    }

####Slette en Todo
URL: localhost:8080/todo/{id_for_todo} (DELETE)

###Fremprovosere exception
Denne brukes for enkelt å få en stack trace og se hvordan det logges i Azure.

URL: localhost:8080/api/throwexception (GET)

[java-url]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[maven-url]: http://maven.apache.org/
[spring-boot-url]: http://projects.spring.io/spring-boot/