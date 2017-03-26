Build and run

1:)
Otworzyc plik i ustawic tak jak ponizej application.properties:

spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/db_agency
spring.datasource.username=agent
spring.datasource.password=gdanskOgorek

2:)
Wykonac SQL z katalogu database  (database.sql)


3:) W projekcie wykorzystalem ponizsze elementy:
Maven
Spring Core
Spring Data (Hibernate & MySQL)
Spring MVC (Tomcat)
Thymleaf

4:)Szybkie uruchomienie
mvn spring-boot:run
kliknac http://localhost:8080/
Haslo i przykladowy uzytkownik zostal ustawiony na imie: user i haslo: password.

5:)
Projekt jest dostepny na moim koncie na github:
https://github.com/HawkPK/agency


