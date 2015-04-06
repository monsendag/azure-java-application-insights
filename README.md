# azure-java-application-insights
Java i [Azure] [azure-url] med [Application Insights] [azure-ai-url]

Applikasjonen er veldig enkel. Det er en Todoliste. Den har et RESTful API, er laget med [Spring Boot] [spring-boot-url].

- Benytter H2 in-memory DB lokalt og SQL Server når deployet til Azure.

###Det som trengs
- [Java 7] [java-url] eller nyere.
- [Maven] [maven-url], følg installasjonsbeskrivelsen på nedlastingssiden.
- Microsoft JDBC Driver for SQL Server. Se neste punkt.

######Installer Microsoft JDBC Driver for SQL Server i lokalt repository
`mvn install:install-file -Dfile=lib/sqljdbc_4.1/sqljdbc41.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc41 -Dversion=4.1 -Dpackaging=jar`

###Spring profiles
Applikasjonen må kjøres med én Spring profil. Det er to profiler:

- development, benytter H2 in-memory database
- production, benytter SQL Server. Krever at noen miljøvariabler er satt. Se avsnitt om miljøvariabler under.

###Kjør applikasjonen lokalt:
- fra kommandolinja med kommandoen: `mvn spring-boot:run -Dspring.profiles.active=<SPRING_PROFILE>`
- fra IDE ved å kjøre TodoApplication.java som inneholder main metoden.
    - Legg til '--spring.profiles.active=\<SPRING_PROFILE\>' som program arguments i launcher.

Under oppstart så kjøres schema-h2.sql og data-h2.sql som populerer data for lokal utvikling.

###Hva applikasjonen kan gjøre
Hvis du ikke ønsker å benytte GUI-et for å teste API-et så benytt gjerne en REST-klient. Det gjør lagring og oppdatering av data enklere.

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

####Fremprovosere exception
Denne brukes for enkelt å få en stack trace og se hvordan det logges i Azure.

URL: localhost:8080/api/throwexception (GET)

###Miljøvariabler som må være på plass i Tomcat i Azure
Miljøvariabler kan settes to steder:

- [Azure portalen (preview)] [azure-portal-url] under "Web Apps" -> \<APPLIKASJON\> -> "All settings" -> "Application settings" -> "App settings".
- [Azure manage (stabil)] [azure-manage-url] under "Web apps" -> \<APPLIKASJON\> -> "CONFIGURE" -> "app settings".

Miljøvariablene:

- SPRING_PROFILES_ACTIVE=production
- DATASOURCE_URL=\<full connection string\>, på formen: jdbc:sqlserver://\<HOST\>:\<PORT\>;database=\<DATABASE\>;loginTimeout=30;
- DB_USER=\<brukernavn\>
- DB_PASSWORD=\<passord\>

###Deploy til Microsoft Azure‎ med Maven
`mvn clean package -P deployazure -Dftp_host=<HOST> -Dftp_user=<FTPUSER> -Dftp_password=<PW>`

Merk fnuttene (") rundt brukernavn og passord. De er nødvendig for å slippe escaping.

[azure-url]: http://azure.microsoft.com/en-us/
[azure-portal-url]: https://portal.azure.com/
[azure-manage-url]: https://manage.windowsazure.com/
[azure-ai-url]: http://azure.microsoft.com/en-us/services/application-insights/
[java-url]: http://www.oracle.com/technetwork/java/javase/downloads/index.html
[maven-url]: http://maven.apache.org/
[spring-boot-url]: http://projects.spring.io/spring-boot/