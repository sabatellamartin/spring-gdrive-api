
# Aplicación para consultar directorios de Google Drive

Esta aplicación ofrece una API REST construida en Java Spring 5 para consultar directorios de una cuenta de google drive.

## Requisitos

Software:
- Java JRE 1.9
- Servidor de aplicaciones, ejemplo Tomcat 9

Servicio:
- Se debe proveer del token de autorización de la cuenta la cual se quiere consultar.
- Se puede obtener el token de sesion de google usando Google OAuth playground
- Al momento de consultar la API se debe pasar el header "Autorization" con valor "Bearer {token}"

## Metodos de la API

Obtener una lista de hasta 1000 directorios de la cuenta

GET http://localhost:8080/rias/drive/folders

Obtener los subdirectorios de un directorio, "parent_id" es el id del directorio padre. 

GET http://localhost:8080/rias/drive/folders/{parent_id}

Buscar directorios por nombre, "term" corresponde a la cadena de busqueda.

GET http://localhost:8080/rias/drive/folders/search/{term}

## Otros metodos de la API

Obtener archivos de forma genérica

GET http://localhost:8080/rias/drive/files

Obtener un archivo especifico por id de archivo 

GET http://localhost:8080/rias/drive/files/{id}

## Google Drive API

https://developers.google.com/drive/v3/web/about-sdk

https://search.maven.org/#artifactdetails%7Cfr.uha.ensisa.ff%7Cspring-mvc-archetype%7C1.0.4%7Cmaven-archetype

#### Google OAuth playground

Validar credenciales y obtener el token, para pasarlo por headers Authorization: Bearer + Token
  
https://developers.google.com/oauthplayground/
 
#### Google drive Mimetypes

Tipos de archivos de Drive
 
https://developers.google.com/drive/api/v3/mime-types


#### Habilitar una API

Obtener credenciales para autenticar mediante OAuth

https://console.cloud.google.com/flows/enableapi?apiid=drive&pli=1

## Spring

https://projects.spring.io/spring-framework/#quick-start

## Spring RestTemplate

https://spring.io/blog/2009/03/27/rest-in-spring-3-resttemplate/

#### Arquetipo de Spring elegido

http://repo1.maven.org/maven2/archetype-catalog.xml

Arquetipo: spring-mvc-archetype version 1.0.4


