package com.example.student_management.controller;

import com.example.student_management.model.Student;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    //Lista de recursos
    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(0001, "Jareth", "magandajareth@gmail.com", 28, "Ciencias"),
            new Student(0002, "Yamileth", "magandayamileth@gmail.com", 24, "Matematicas"),
            new Student(0003, "Leslie", "magandaleslie@gmail.com", 10, "Fisica"),
            new Student(0004, "Evelyn", "magandaevelyn@gmail.com", 6, "Quimica")

    ));

    //Mostrar todos los Alumnos
   @GetMapping
   public List<Student> getCustomers(){
       return students;
   }

   @PostMapping("/nombre")
   public Student getAlumnos(@RequestBody Student student){
       for (Student a : students){
           if(a.getNombre().equalsIgnoreCase(student.getNombre())){
            return a;
           }
       }
       return null;
   }

   @PostMapping("/id")
    public Student getAlumnoId(@RequestBody Student student){
       for(Student a : students){
           if(a.getId() == student.getId()){
               return a;
           }
       }
       return null;
   }

    @GetMapping("/{id}")
    public Student getAlumnosid(@PathVariable int id){
        for(Student a : students){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    //Consultar un alumno por su email
    @GetMapping("buscar/{email}")
    public Student getStudentemail(@PathVariable String email){
       for (Student a : students){
           if (a.getCorreo().equalsIgnoreCase(email)){
               return a;
           }
       }
       return null;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student){
       boolean existe = false;
       for(Student a : students){
           if (a.getId() == student.getId()){
               existe = true;
               System.out.println("El Id se repite");
               break;

           }else if (a.getNombre().equalsIgnoreCase(student.getNombre())){
               System.out.println("El nombre se repite");
               break;

           }else{
               students.add(student);
               return student;
           }

       }
       return null;

    }

    @PutMapping
    public Student putStudent(@RequestBody Student student){
       for (Student a : students){
           if(a.getId() == student.getId()){
               a.setNombre(student.getNombre());
               a.setCorreo(student.getCorreo());
               a.setEdad(student.getEdad());
               a.setCurso(student.getCurso());

               return a;
           }
       }
    return null;
    }

    @PatchMapping
    public Student patchStudent(@RequestBody Student student){
       for (Student a : students){
           if(a.getId() == student.getId()){
               if(student.getNombre() != null){
                   a.setNombre(student.getNombre());
               }
               if(student.getEdad() != 0){
                   a.setEdad(student.getEdad());
               }
               if(student.getCorreo() != null){
                   a.setCorreo(student.getCorreo());
               }
               if(student.getCurso() != null){
                   a.setCurso(student.getCurso());
               }
           }
           return a;
       }
       return null;
    }

    @DeleteMapping
    public Student deleteAlumnos(@RequestBody Student student){
       for (Student a : students){
           if(a.getId() == student.getId()){
               students.remove(a);
               return a;
           }
       }
       return null;
    }

}
