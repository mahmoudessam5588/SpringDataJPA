package com.SpringData.SpringDataJpa.Repository;

import com.SpringData.SpringDataJpa.Entity.Guardian;
import com.SpringData.SpringDataJpa.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveFunctionalityTestWithBoth() {
        Guardian guardian = Guardian.builder()
               .name("neo") .mobile("12587864445678").email("kla@gmail.com").build();
        Student student = Student.builder()
                .firstName("leo")
                .lastName("meo") .emailId("pno.com").guardian(guardian).build();
        studentRepository.save(student);
    }


    /*@Test
    public void saveFunctionalityTest() {
        Student student = Student.builder()
                .firstName("bla")
                .lastName("vla")

                //.guardiaName("noa")
                //.guardianMobile("00000000000")
                //.guardianEmail("noa@gmail.com")
                .build();
        studentRepository.save(student);
    }*/

    @Test
    public void listAllTestFunctionality() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList: =  " + studentList);
    }
    @Test
    public void printFirstName(){
        List<Student> byFirstName = studentRepository.findByFirstName("leo");
        System.out.println("Student =" + byFirstName);
    }
    @Test
    public void printFirstNameContains(){
        List<Student> byFirstName = studentRepository.findByFirstNameContaining("le");
        System.out.println("Student =" + byFirstName);
    }
    @Test
    public void printStudentBasedOnLastName(){
        List<Student> byLastNameNotNull = studentRepository.findByLastNameNotNull();
        System.out.println("Student Last Name Not Null = "+ byLastNameNotNull);
    }
    @Test
    public void printGuardianName(){
        List<Student> byGuardianName = studentRepository.findByGuardianName("neo");
        System.out.println("guardian Name = "+ byGuardianName);
    }
    @Test
    public void printStudentByEmailAddress(){
        Student byEmailAddress = studentRepository.getStudentByEmailAddress("pno.com");
        System.out.println("Student Info By Email Address = "+ byEmailAddress);
    }
    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstNameByEmailAddress = studentRepository.getStudentFirstNameByEmailAddress("pno.com");
        System.out.println("Student First Name By Email Address "+ firstNameByEmailAddress);
    }
    @Test
    public void printStudentByEmailAddressNative(){
        Student byEmailAddress = studentRepository.getStudentByEmailAddressNative("pno.com");
        System.out.println("Student Info By Email Address = "+ byEmailAddress);
    }
    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student byEmailAddressNativeNamedParam = studentRepository.getStudentByEmailAddressNativeNamedParam("pno.com");
        System.out.println("Student Info By Email Address "+ byEmailAddressNativeNamedParam);
    }
    @Test
    public void printUpdateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("yasser","pno.com");
    }

}