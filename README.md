programa corriendo ![img.png](img.png)
primera prueba con repository ![img_1.png](img_1.png)
prueba del controlador ![img_2.png](img_2.png)

## Descripción

Productos Service es un microservicio desarrollado con Spring Boot para gestionar productos mediante una arquitectura básica por capas. El proyecto implementa una capa de dominio, una capa de persistencia con Spring Data JPA, una capa de servicio y una capa web REST. Además, incluye pruebas automatizadas para validar el funcionamiento del repositorio JPA, del controlador REST y de la lógica de servicio.

El objetivo principal del proyecto es aplicar pruebas unitarias y de integración en una aplicación Spring Boot, usando `@DataJpaTest` para la capa de persistencia, `@WebMvcTest` para la capa web, Mockito para simulación de dependencias y JaCoCo para medir cobertura de código. También se configura un pipeline de integración continua con GitHub Actions para ejecutar automáticamente las pruebas y publicar el reporte de cobertura en cada push o pull request.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- JUnit 5
- Mockito
- MockMvc
- JaCoCo
- GitHub Actions

## Estructura del proyecto

productos-service
 ├── .github
 │   └── workflows
 │       └── ci.yml
 ├── docs
 │   └── jacoco-report.png
 ├── src
 │   ├── main
 │   │   ├── java
 │   │   │   └── com
 │   │   │       └── universidad
 │   │   │           └── productosservice
 │   │   │               ├── ProductosServiceApplication.java
 │   │   │               ├── controller
 │   │   │               │   └── ProductoController.java
 │   │   │               ├── domain
 │   │   │               │   └── Producto.java
 │   │   │               ├── repository
 │   │   │               │   └── ProductoRepository.java
 │   │   │               └── service
 │   │   │                   ├── ProductoService.java
 │   │   │                   └── ProductoServiceImpl.java
 │   │   └── resources
 │   │       └── application.properties
 │   └── test
 │       ├── java
 │       │   └── com
 │       │       └── universidad
 │       │           └── productosservice
 │       │               ├── controller
 │       │               │   └── ProductoControllerTest.java
 │       │               ├── repository
 │       │               │   └── ProductoRepositoryTest.java
 │       │               └── service
 │       │                   └── ProductoServiceImplTest.java
 │       └── resources
 │           └── application-test.properties
 ├── pom.xml
 └── README.md
Funcionalidades principales

El microservicio permite gestionar productos mediante endpoints REST. Cada producto 
contiene un identificador, nombre, precio y stock. La aplicación utiliza H2 como base 
de datos en memoria, por lo que puede ejecutarse localmente sin instalar un motor externo 
de base de datos.

| Método | Endpoint              | Descripción                            |
| ------ | --------------------- | -------------------------------------- |
| GET    | `/api/productos`      | Lista todos los productos registrados  |
| GET    | `/api/productos/{id}` | Busca un producto por su identificador |
| POST   | `/api/productos`      | Crea un nuevo producto                 |

Cobertura JaCoCo

La actividad exige verificar la cobertura de la clase ProductoServiceImpl, especialmente en 
la capa de negocio. El reporte de JaCoCo permite revisar la cobertura por paquetes, clases, 
métodos y líneas ejecutadas durante las pruebas automatizadas.

Autor

María Pierina Pérez Cedeño
Ingeniería de Sistemas
