# Proyecto Base :nerd_face:

En el siguiente proyecto solo se busca implementar el arquetipo para ejecutar el navegador (google) y ahorrar tiempo en la configuracion.

Recordar el archivo chromedriver.exe instalarlo en la carpeta features y descargar la version que tengas en el navegador.

- Instalación
- Estructura

## Instalación

Para usar serenity bdd con screenplay se deben seguir los siguientes pasos:

Instala Intellij IDEA:

- Descargarlo desde:

 ```bash
 https://www.jetbrains.com/es-es/idea/download/download-thanks.html?platform=windows&code=IIC
```
- Descarga e instala Java JDK 17 :
```bash
 https://download.oracle.com/java/17/archive/jdk-17.0.11_windows-x64_bin.exe (sha256 )
```
- Descargar e instalar Gradle 7.6.4:
 ```bash
 https://gradle.org/next-steps/?version=7.6.4&format=bin
```

## Estructura
```bash
Project/
│
src/
└── test/
    ├── java/
    │   └── co/com/screenplay/project/
    │       ├── runners/               <-- 2. Runners/Ejecución
    │       ├── stepdefinitions/       <-- 3. Steps (Traducción Gherkin)
    │       ├── questions/             <-- 4. Preguntas (Questions)
    │       ├── tasks/                 <-- 5. Tareas (Tasks)
    │       └── userinterfaces/        <-- 6. Interfaces de Usuario (UI)
    └── resources/
        ├── features/                <-- A. Archivos Gherkin (.feature)
        ├── serenity.conf            <-- B. Configuración de Serenity


```
Explicación

Este proyecto sigue el patrón Screenplay utilizando Serenity BDD y Cucumber.

- Los tests se dividen en Tasks (acciones que los actores realizan) y Questions (verificaciones).
- Los locators y otros elementos relacionados con las páginas están en la carpeta ui.
- Los step definitions de Cucumber vinculan los archivos .feature con las Tasks y Questions de Screenplay.

## Cambiar link de la pagina
Ubicarse en el archivo de serenity.conf y en la linea 31 ubicar las enviroments, remplazar el link por el deseado
```bash
Project/
│
├── src/
│   └── test/
│       └── java/
│           └── project/
│               ├── resources/
│               │   ├── features/
│               │   │   ├── ExampleFeature.feature
│               │   └── serenity.conf
│
///////////////////////////////
environments {
  default {
    webdriver.base.url = "https://www.example.com//"
  }
   default {
        webdriver.map.url = "https://www.example.com/"
      }
}
```

