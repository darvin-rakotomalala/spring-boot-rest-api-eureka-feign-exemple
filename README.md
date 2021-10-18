## Exemple micro-services avec Spring Boot, Spring Cloud (Eureka, gateway et open feign)
Dans ce projet nous allons voir un exemple de micro-services en utilisant Spring Boot, Spring Cloud (Eureka, gateway et open feign).
Nous verrons comment créer des API REST en Java avec Spring Boot avec une base de données 
PostgreSQL et des requêtes POST/GET/PUT/DELETE d'une entité - `Customer` pour le service **customer-service** et `Invoice` pour le service **billing-service**.

### Contrainte principales des architectures Monolithiques
---
* Une seule Technologie
* Processus Unique
* Difficile à Tester
* Mise en production prend beaucoup de temps
* Redéploiement à froid
* Performances (Scalabilité)

### Avantages des Micro-services
--- 
* Performances (Scalabilité)
* Processus Séparés
* Faciles à développer à tester et à maintenir
* Mise en production rapide des micro-services
* Redéploiement à froid
* Technologies différentes
* Equipes indépendantes
* Facile à appliquer l'agilité
* Facile à mettre en oeuvre TDD
* Chaque microservice possède sa propre base de données.
* L'API client n'a pas d'accès direct aux services. Il ne peut interagir que via la passerelle API.
* Le serveur de configuration contient toutes les configurations des microservices et nous utiliserons ce serveur pour obtenir des informations de configuration telles que le nom d'hôte, l'url, etc. pour nos microservices.

### Quel modèle de communication entre les micro-services
---
Modèle Synchrone avec Open Feign


### Prérequis
Pour ce tutoriel, vous auriez besoin des spécifications suivantes :
- Spring Boot v2.0+
- JDK v1.8+
- Maven 3+ ou Gradle 4+ - outil de construction
- Tout IDE prenant en charge Java et Spring Boot (Spring Tool Suite (STS), IntelliJ, VSC, NetBeans, etc.)
- Postman, curl ou n'importe quel client HTTP pour tester l'API REST
- SGBD PostgreSQL

### Dependances Maven
---
Dans ce tuto nous allons utiliser les dependances Maven suivants :
- Spring Web - Pour inclure Spring MVC et utilise le tomcat comme conteneur intégré par défaut.
- Spring Data JPA - API de persistance Java et Hibernate.
- Spring Boot DevTools - Dépendance pour les rechargements automatiques ou le rechargement en direct des applications.
- Pilote PostgreSQL - Pilote JDBC (peut être n'importe quelle base de données que vous souhaitez utiliser).
- MapStruct - MapStruct est un générateur de code Java open source qui crée du code pour les implémentations de mappage.
- springdoc-openapi-ui - Dépendances pour la documentation de l'API swagger 3.
- spring-cloud-starter-openfeign - Un client REST déclaratif pour les applications Spring Boot.
- spring-cloud-starter-netflix-eureka-client - Le client Eureka n'est rien d'autre qu'un microservice et nous en faisons un client Eureka en utilisant @EnableEurekaClien t ou @EnableDiscoveryClient et avec l'URL du serveur Eureka dans les propriétés, il s'enregistrera sur le serveur Eureka.
- spring-cloud-starter-netflix-eureka-server - 
- spring-cloud-starter-gateway - 

### Exigences fonctionnelles
---
Les exigences fonctionnelles permettent de satisfaire les besoins fonctionnels (metier) de l'entreprise.
L'application doit permettre de :
- customer-service :
	* Ajouter un client
	* Consulter tous les clients
	* Consulter les clients dont le nom contient un mot clé
- billing-service :
	* Ajouter un compte
	* Consulter un compte

### Exigences techniques
---
Dans ce projet nous utilisons les modules suivants :
**Qu'est-ce qu'Eureka Server et Client ?**
* **Eureka Server** est une application également connue sous le nom de découverte de services. Il contient les coordonnées de toutes l
es applications clientes Eureka qui y sont enregistrées. Le serveur Eureka connaîtra tous les détails tels que les adresses IP 
et les ports de toutes les applications clientes Eureka ( microservices ) qui y sont enregistrées. Cela facilitera la communication 
entre les applications clientes d'Eureka.

* Le **client Eureka** n'est rien d'autre qu'un microservice et nous en faisons un client Eureka en utilisant 
`@EnableEurekaClient` ou `@EnableDiscoveryClient` et avec l'URL du serveur Eureka dans les propriétés, 
il s'enregistrera sur le serveur Eureka. Le client Eureka est disponible dans le Spring Cloud.

* **Eureka** : 

* **Gateway** :

* **Open feign** : 

### Architecture globale
---
L'image suivante présente l'architecture globale du projet.


Le module au cœur du Spring Framework (Spring Core) repose fondamentalement sur un seul principe de conception objet : 
l’inversion de contrôle.
	
**L'Inversion de contrôle (Spring IOC)** permet au développeur de s'occuper uniquement du code metier (Exigences fonctionnelles) 
et c'est le Framework qui s'occupe du code technique (Exigences Techniques).

### Architecture du projet
---
L'image suivante présente l'architecture globale du projet.


### Tester les APIs REST
----
Pour tester l'application suivre les étapes suivantes :
* Lancer


### Conclusion
----
Voilà. Vous avez créé avec succès votre propre API REST Spring Boot !<br/>
Dans ce tutoriel, nous avons construit un projet Spring Boot entièrement fonctionnel qui expose une API à l'utilisateur final. En utilisant cette API, 
un utilisateur peut effectuer des opérations CRUD sur une Userentité.