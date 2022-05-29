# cs590-spring-boot-batch
A Restful service allowing an admin to trigger a batch job.  The batch job , reads a CSV file and writes its contents into Mysql DB after performing some conversion.

Please follow the below instructions

run: docker compose up

Spring security implemented with Keycloak

User roles: ADMIN and USER

Admin user: myadmin
password: password

user: myuser
password: password

run the api http://localhost:3000/students/load using the admin user credentials to process the batch from CSV to mysql db
run the api http://localhost:3000/students using the regular user to get a list of all students from the db

to generate a token on postman, use the below info:
Authentication Type: OAuth 2.0
Token Type: Bearer
Grant Type: Password Credentials
Access Token URL: http://localhost:8080/realms/batch-auth/protocol/openid-connect/token
Client ID: springboot-keycloak
Scope: openid

