# XML i veb servisi (2020/2021)

## Studenti (Tim 1)
- Marija Curcic, SW24/2017
- Ivana Marosevic, SW74/2017
- Aleksandar Vujinovic, SW46/2017
- Veljko Plecas , SW68/2017

# Uputstvo za pokretanje aplikacije

#### Za ispravan rad potrebno je redom pokrenuti: tomcat server, spring aplikacije i na kraju angular aplikacije.

## Potrebno

### tomcat server:
- 2 fuseki aplikacije koje rade na portu 8080. Fuseki za poverenika mora biti dostupan na putanji: http://localhost:8080/fuseki_poverenik. Fuseki za sluzbenika mora biti dostupan na putanji: http://localhost:8080/fuseki_sluzbenik. Fuseki poverenik mora imati dataset Poverenik. Fuseki sluzbenik mora imati dataset Sluzbenik.
- 2 exist aplikacije koje rade na portu 8080. Exist za poverenika mora biti dostupan na http://localhost:8080/exist_poverenik. Exist za sluzbenika mora biti dostupan na http://localhost:8080/exist_sluzbenik.

### spring aplikacije:
- portal poverenika je potrebno pokrenuti i on radi na portu 8090 
- portal sluzbenika je potrebno pokrenuti i on radi na portu 8091
- email aplikaciju je potrebno pokrenuti i ona radi na portu 8092

Prethodno napravljena podesavanja nalaze se u application.properties fajlovima.

### angular aplikacije:
- angular aplikacije potrebno je pokrenuti sa npm start (prethodno se pozicionirati u folder frontend-poverenik i frontend-sluzbenik)
- angular aplikacija poverenika radi na portu 4200
- angular aplikacija sluzbenika radi na portu 4201
