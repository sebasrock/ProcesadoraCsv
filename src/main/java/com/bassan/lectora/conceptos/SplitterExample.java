package com.bassan.lectora.conceptos;

import com.bassan.lectora.core.ProcesadorCsv;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian Sanchez on 06/02/2015.
 */
public class SplitterExample {

    public static void main(String[] args) {
        //Input file which needs to be parsed
        String fileToParse = "C:\\Users\\985202\\Documents\\LectoraCsv\\inbox\\csv\\student.txt";
        String fileToParse2 = "C:\\Users\\985202\\Documents\\LectoraCsv\\inbox\\csv\\student3.txt";
//        String fileToParse = "D:\\Proyectos\\LectoraCsv\\inbox\\csv\\student2.txt";


        Student student = new Student();
        student.setCodigo("1");
        student.setName("dfssssssss");
        student.setSemester("dfdsfsd");
        Student student2 = new Student();
        student2.setCodigo("1werrrrrr");
        student2.setName("dfssssssswreeeeeeeeeeeeees");
        student2.setSemester("dfdsfsdwerrrrrrrrrrrrrrrr");
        List<Student> lista = new ArrayList<Student>();
        lista.add(student);
        lista.add(student2);
        ProcesadorCsv<Student> csv = new ProcesadorCsv<Student>();
        try {
            csv.transformarObjetoCsv(lista,fileToParse2);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            ResultadoCargue resultadoCargue = csv.transformarCsvObjeto(Student.class, fileToParse);
//
//
//            for (Object student : resultadoCargue.getElementosCargados()) {
//                System.out.println(student.toString());
//            }
//            System.out.println("_______________________________________________________________________");
//            for (Object errores : resultadoCargue.getErroresEcontrados()) {
//                System.out.println(errores.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        //Delimiter used in CSV file
//        final String DELIMITER = "|";
//        try
//        {
//            String line = "";
//            //Create the file reader
//            fileReader = new BufferedReader(new FileReader(fileToParse));
//            //Read the file line by line
//            while ((line = fileReader.readLine()) != null)
//            {
//                //Get all tokens available in line
////                String[] tokens = line.split(DELIMITER);
////
////                for(String token : tokens)
////                {
////                    //Print all tokens
////                    System.out.println(token);
////                }
//
//                if(line.indexOf("|")==0){
//                    line =" "+line;
//                }
//                line =line.replace("||","| |");
//                StringTokenizer stringTokenizer = new StringTokenizer(line, "|");
//                while (stringTokenizer.hasMoreElements()) {
//                    System.out.println(stringTokenizer.nextElement()+"=="
//                            +stringTokenizer.nextElement()+"=="
//                            +stringTokenizer.nextElement()+"=="
//                            +stringTokenizer.nextElement()+"=="+
//                            stringTokenizer.nextElement()+"=="+stringTokenizer.nextElement()+"=="+
//                            stringTokenizer.nextElement()+"=="+stringTokenizer.nextElement());
//
//                }
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally
//        {
//            try {
//                fileReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
