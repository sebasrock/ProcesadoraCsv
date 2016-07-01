#ProcesadoraCsv

API for transformation the CSV files to java objects, validations of structure and formatting data

## Synopsis

It's solution for transform, validation and formatting data,that from CSV file , it's way more easy  with annotations @.

ProcasadoraCsv can read  many structures in only file

## Code Example

Read Basic structure 

```
EPS005|2000-03-27|2015-03-31|1
EPS005|2000-03-27|2015-03-31|1
```

```java

@DatosArchivo(cantidadColumnas = 4, separador = "|")
public class TestDtoBasico {
    @DatosCampo(posicion = 0, trim = true)
    private String codigoEPS;
    @DatosCampo(posicion = 1, trim = true)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaInicialPeriodoReportado;
    @DatosCampo(posicion = 2, trim = true)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaFinalPeriodoReportado;
    @DatosCampo(posicion = 3, trim = true)
    private int numeroRegistroArchivo;
    .......
    
}
```

## Motivation

A short description of the motivation behind the creation and maintenance of the project. This should explain **why** the project exists.

## Installation

Provide code examples and explanations of how to get the project.

## API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests

Describe and show how to run the tests with code examples.

## Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

## License

A short snippet describing the license (MIT, Apache, etc.)
