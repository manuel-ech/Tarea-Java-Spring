# Tarea-Java-Spring

Para la ejecución de los servicios y la aplicación principal es necesario ejecutar los siguientes
comandos en una shell unix desde la raiz de cada proyecto:

1)	java -Dserver.port=8080 -jar build/libs/loginForm-0.1.0.jar
2)	java -Dserver.port=8081 -jar build/libs/loginService-0.1.0.jar
3)  java -Dserver.port=8082 -jar build/libs/verifyUserService-0.1.0.jar

Si requiere cambiar los puertos estos deben ser cambiados también en los archivos propeties dentro
de los siguientes archivos .jar:

1)	En el archivo loginForm.properties dentro de loginForm-0.1.0.jar está el puerto del loginService
2)	En el archivo loginService.properties dentro de verifyUserService-0.1.0.jar está el puerto del verifyUserService

Para compilar cada proyecto ejecutar el siguiente comando desde el directorio raiz de cada proyecto

  ./gradlew build