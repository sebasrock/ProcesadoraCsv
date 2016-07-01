#ProcesadoraCsv

API for transformation the CSV files to java objects, validations of structure and formatting data

## Synopsis

It's solution for transform, validation and formatting data,that from CSV file , it's way more easy  with annotations @.

ProcasadoraCsv can read  many structures in only file

## Code Example

Call to power
```java
 ConversorArchivos<TestBugIndex> csv = new ConversorArchivos<TestBugIndex>();
ResultadoCargue<TestBugIndex> resultadoCargue = csv.ejecutar(TestBugIndex.class, archivo, TiposArchivo.CSV);
```
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

Read file embeds an object in another

```
1|EPS005|2000-03-27|2015-03-31|1
1|EPS005|2000-03-27|2015-03-31|1
```

```java
@DatosArchivo(separador = "|", cantidadColumnas = 5)
public class TestDtoOneToOne implements Serializable {

    @DatosCampo(posicion = 0)
    private int consecutivo;

    @OneToOne
    private TestHijoOneToOne testHijoOneToOne;

    ......    
}
```
```java
public class TestHijoOneToOne implements Serializable {

    @DatosCampo(posicion = 1, trim = true)
    private String codigoEPS;
    @DatosCampo(posicion = 2, trim = true)
    @ValidarCampo( formatoFecha = "yyyy-MM-dd")
    private Date fechaInicialPeriodoReportado;
    @DatosCampo(posicion = 3, trim = true)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaFinalPeriodoReportado;
    @DatosCampo(posicion = 4, trim = true)
    private int numeroRegistroArchivo;

    ......    
}
```

Read many structures

```
1|EPS005|1890-02-27|2015-03-20|3
2|1|1969-05-08|6
2||1969-05-08|6
2|45|1969-05-08|6
1|EPS006|1890-02-27|2015-03-20|2
2|1|1969-05-08|6
2||1969-05-08|6
```

```java
@DatosArchivo(separador = "|", cantidadColumnas = 5 , multiEstructura = true)
public class TestDtoOneToMany implements Serializable {

    @DatosCampo(posicion = 1, trim = true)
    private String codigoEPS;
    @DatosCampo(posicion = 2, trim = true)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaInicialPeriodoReportado;
    @DatosCampo(posicion = 3, trim = true)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaFinalPeriodoReportado;
    @DatosCampo(posicion = 4, trim = true)
    private int numeroRegistroArchivo;

    @OneToMany(palabraResevada = "2")
    private List<TestHijoOneToMany> testHijoOneToManies;
```
```java
@DatosArchivo(separador = "|", cantidadColumnas = 4)
public class TestHijoOneToMany implements Serializable {

    @DatosCampo(posicion = 1)
    private String codigo;
    @DatosCampo(posicion = 2)
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fecha;
    @DatosCampo(posicion = 3)
    private Long numeroLong;
```

Write file csv from java object

```java
List<TestDtoBasicoEscritura> archivo = ....
ConversorObjetos<TestDtoBasicoEscritura> csv = new ConversorObjetos<TestDtoBasicoEscritura>();
ByteArrayOutputStream resultadoCargue = csv.ejecutar(archivo, TiposArchivo.CSV);
```
```java
@DatosArchivo(cantidadColumnas = 4, separador = "|",nombre = "TESTs")
public class TestDtoBasicoEscritura {
    @DatosCampo(posicion = 0, nombre = "COODIGO")
    private String codigoEPS;
    @DatosCampo(posicion = 1, nombre = "FECHA INICIAL")
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaInicialPeriodoReportado;
    @DatosCampo(posicion = 2, nombre = "FECHA FINAL")
    @ValidarCampo(formatoFecha = "yyyy-MM-dd")
    private Date fechaFinalPeriodoReportado;
    @DatosCampo(posicion = 3, nombre = "NUMERO")
    private int numeroRegistroArchivo;
```

***for more examples see the unit test***

## Motivation

The main reason is make easy our work

## Installation

1. Download proyect and run **maven install** 
2. Put Jar in your repository
3. Add dependency to proyect
4. To work

## API Reference


* **@DatosArchivo** 
 *String nombre() default "";  ----> the name of output file
 *String separador() default ","; ----> the token in file to read
 *int cantidadColumnas(); ----> the number of columns in row that represents to Object
 *boolean saltarPrimeraLinea() default false; ----> if you want skip first line
 *boolean multiEstructura() default false;  ----> Flag for multi-structure for api

* **@DatosCampo** 
  *  boolean trim() default false; ----> Delete spaces in begin and end to word
  *  String nombre() default ""; ----> Name column to output file
  *  int posicion() default 0; ----> Number column in row, that represents  property in class
  *  Class<? extends ConversionPersonal> convercionClass() default ConversionPersonal.class; ----> Custom conversion data

* **@OneToOne**

* **@OneToMany**
 * String palabraResevada(); ----> The chart represents new structure,

* **@ValidarCampo**
* String expresion() default ""; ----> Validate Regex 
* int longitudMaxima() default 0;----> Number max length
* int longitudMinima() default 0;----> Number min length
* boolean requirido() default false;----> Obligatory data
* String[] listaLimitante() default {};----> List of possible values to take
* String formatoFecha() default "yyyy-MM-dd";----> Format date
* String fechaMinima() default "";---->  minimum date 
* String fechaMaxima() default ""; ----> maximum date

## Tests

[See unite test ] (https://github.com/sebasrock/ProcesadoraCsv/tree/develop/src/test/java/co/bassan/test)

## License

A short snippet describing the license (MIT, Apache, etc.)
