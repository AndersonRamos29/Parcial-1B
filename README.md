# Parcial-1B

## Cómo ejecutar las pruebas

### Local
Ejecuta en consola:

### GitHub Actions
Cada vez que hacemos `push` a la rama `main`, se ejecutan las pruebas automáticamente.

# GESTION-PRODUCTOS-REACTIVO

Proyecto de backend desarrollado con **Spring Boot WebFlux**, que expone un API REST para gestionar productos. Incluye pruebas automatizadas y pipeline CI/CD usando **GitHub Actions**.

---

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring WebFlux
- Maven
- JUnit 5
- Mockito
- WebTestClient
- GitHub Actions
- Visual Studio Code

---

##  Estructura del Proyecto

src/ / principal/ │ └── java/ │ └── com/ejemplo/demo/ │ ├── DemoApplication.java │ ├── controlador/ │ ├── servicio/ │ └── modelo/ ├── prueba/ │ └── java/ │ └── com/ejemplo/demo/ │ └── pruebas/

##  Configuración del entorno

### Pre-requisitos

- JDK 17
- Maven
- Git
- Visual Studio Code con extensiones:
  - Extension Pack for Java
  - Spring Boot Extension Pack

### Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/gestion-productos-reactivo.git
cd gestion-productos-reactivo
