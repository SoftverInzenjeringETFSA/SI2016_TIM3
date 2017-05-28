# SI2016_TIM3
## Dogovor za izlazak

## Prije pokretanje potrebno je:

### 1. Instalirati IntelliJ Idea Ultimate

### 2. Instalirati Apache Tomcat 9.0.0.M21

### 3. Instalirati MySQL

### 4. Instalirati npm

### 5. Instalirati node.js


## Pokretanje projekta:

### 1.Otvoriti terminal i ukucati: git clone https://github.com/SoftverInzenjeringETFSA/SI2016_TIM3.git da skinemo ovaj repozitorij

### 2. Podesavanje MySQL baze

#### 2.1 Otvoriti terminal i pristupiti MySQL shell-u komandom: mysql -u root -p 

NAPOMENA: Ako prethodna komanda ne radi nije instalirana MySQL baza podataka
          Za instalaciju ukucati: sudo apt-get install mysql-server i opet probati komandu iz 3.1
            
#### 2.2 Kreirati bazu podataka komandom: CREATE DATABASE tim3; 
#### 2.3 Kreirati usera komandom: CREATE USER 'EtfSI2016' IDENTIFIED BY '2016SIEtf';
#### 2.4 Dodijeli privilegije useru komandom: GRANT ALL PRIVILEGES ON tim3.* TO 'EtfSI2016'@'%' WITH GRANT OPTION;
     
     
### 3. Pokrenuti IntellJ Idea


#### 3.1 Odabrati opciju Import Project 
#### 3.2 Odabrati folder na sljedecoj lokaciji unutar git repozitorija ../SI2016_TIM3/sitim3-up/eventstsx      
#### 3.3 Odabrati da se projekat importuje kao Maven projetak i kliknuti next i opet next
#### 3.4 Čekirati Maven projekat com.eventstsx:eventtstsx:0.0.1-SNAPSHOT
#### 3.5 Odabrati SDK projekta, tj. folder gdje je instaliran Java SE Development Kit i kliknuti next, a zatim pricekati da se ucita
#### 3.6 Odabrati trenutni folder kao root folder da se spoji sa gitom
#### 3.7 Buildat i runat projekat
#### 3.8 Otvoriti browser i ukucati adresu: http://localhost:8080/
#### 3.9 Ako je ok, trebalo bi da na toj stranici piše sljedece:

Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sun May 28 16:54:31 CEST 2017
There was an unexpected error (type=Not Found, status=404).
No message available

#### 3.10 Ostaviti IntellJ Idea da radi 


### 4. Pokretanje aplikacije 
#### 4.1 Otvoriti terminal unutar foldera frontv2 na lokaciji ...SI2016_TIM3/sitim3-up/forntv2
#### 4.2 Ukucati komandu: sudo npm start 

Napomena: Ukoliko ima errora potrebno je ukucati komandu: sudo npm install . 
          Ako i dalje ne bude radilo potrebno je ukucati komandu: sudo apt-get install nodejs-legacy
          
          
#### 4.3 Konacno pristupiti aplikaciji na http://localhost:8000/


## Linkovi dokumentacije:

### SRS https://docs.google.com/document/d/16P1VL2MDnE-8A_uua3OTc8qs2lBSbJ3U-trUoivNlNQ/edit?usp=sharing
### Dizajn sistema https://docs.google.com/document/d/1ItsIt_7n5fCupuKGVG-D1CV9A6_5vMbpu1z8VvvSPm0/edit?usp=sharing
