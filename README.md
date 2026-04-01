# DESARROLLO FULLSTACK 1 - API DE PRODUCTOS v 1.0

Este microservicio esta desarrollado siguiendo el modelo de capas MVC utilizando Spring Boot

## Versión de Java

- Java 21 o superior.

## Tecnologia y Depedencias instaladas

- **Java 21** o superior.
- **Spring Boot 4.x** (Spring Web).
- **Lombok**: Para la reducción de código boilerplate (Getters/Setters).
- **Jakarta Validation**: Para asegurar la integridad de los datos de entrada.
- **Maven**: Gestor de dependencias.
- **JPA**: Para crear el CRUD.

## 🧪 Pruebas en Postman (Reglas de Negocio)

Para validar la lógica v1, asegúrese de probar los siguientes escenarios:

1. **Creación Duplicada**: Intentar un `POST`. Debe retornar `400 Bad Request`.
2. **Arriendo Doble**: Intentar un `PUT`. Debe retornar `400 Bad Request`.
3. **ID Inexistente**: Intentar un `DELETE` o `PUT` con un ID que no esté en la lista. Debe retornar `404 Not Found`.

---

## 👤 Autor

- **Álvaro Morales - Fullstack Programmer**
- **Versión:** 1.0 (Marzo 2026)
