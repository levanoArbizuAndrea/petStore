# Proyecto PetStore - Actualización de Mascotas

## 📌 **Objetivo**

Automatizar la actualización de los datos de mascotas en la API de Swagger PetStore, permitiendo modificar su nombre y estado a través de pruebas automatizadas con Serenity BDD, Cucumber y Screenplay. Además, capturar y analizar los errores para mejorar la robustez de las pruebas.

## 🛠️ **Tecnologías Utilizadas**

- **Java:** Lenguaje principal para la automatización.
- **Serenity BDD:** Framework para reportes y gestión de pruebas.
- **Cucumber:** Para definir los escenarios en lenguaje Gherkin.
- **Screenplay:** Patrón de diseño para escribir pruebas más legibles y mantenibles.
- **Maven:** Gestión de dependencias y ejecución de pruebas.
- **Swagger PetStore API:** API utilizada para la gestión de mascotas.

## ⚙️ **Funcionalidad Implementada**

- Actualizar los datos de una mascota mediante la API.
- Validar la respuesta del servidor (códigos 200, 400, 404, 500).
- Verificar que los cambios se reflejan correctamente.
- Escenarios parametrizados con diferentes casos de prueba.
- Reportes de ejecución con Serenity.
- **Manejo de errores:** Captura de respuestas inesperadas y validación de errores comunes.
## 🚀 **Procedimientos**

### 1. **Clonar el repositorio**

```bash
git clone https://github.com/levanoArbizuAndrea/petStore.git
cd petStoreAndrea
```

### 2. **Configurar Maven**

Asegúrate de tener Maven instalado. Si no, instálalo [aquí](https://maven.apache.org/).

### 3. **Ejecutar las pruebas**

```bash
mvn clean verify
```

### 4. **Ver los reportes**

Una vez finalizadas las pruebas, abre el reporte generado:

```bash
cd target/site/serenity
open index.html
```

### 5. **Estructura de archivos**

```
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── com.brooker.stepdefinitions (Step definitions)
│   │   │   ├── com.brooker.runners (Runner de Cucumber)
│   │   │   └── com.brooker.tasks (Tasks con Screenplay)
│   │   └── resources
│   │       └── features (Archivos .feature)
└── pom.xml (Configuración de dependencias)
```

### 6. **Agregar nuevos casos de prueba**

Modifica el archivo `.feature` para agregar nuevos ejemplos:

```gherkin
Examples:
  | ID     | NOMBRE   | ESTADO     | CODIGO |
  | 703403 | Zeus     | available  | 200    |
  | 703404 | Shoby    | available  | 200    |
  | 703405 | Luna     | pending    | 200    |
  | 703406 | Max      | sold       | 404    |
  | 703407 | Rocky    | available  | 500    |
```

¿Te gustaría ajustar algo o profundizar más en algún apartado? 🚀✨


## 🐞 **Errores Comunes y Soluciones**

- **400 Bad Request:** Datos mal formateados o campos faltantes.
  - 🛠️ **Solución:** Verificar que todos los campos requeridos estén presentes y bien estructurados.

- **404 Not Found:** ID de mascota inexistente.
  - 🛠️ **Solución:** Asegurar que los IDs utilizados existan en la base de datos de la API.

- **500 Internal Server Error:** Error del servidor.
  - 🛠️ **Solución:** Revisar si hay sobrecarga en la API o si los datos enviados son válidos.


