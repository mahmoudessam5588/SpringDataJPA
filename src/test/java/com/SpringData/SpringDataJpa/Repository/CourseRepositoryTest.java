package com.SpringData.SpringDataJpa.Repository;

import com.SpringData.SpringDataJpa.Entity.Course;
import com.SpringData.SpringDataJpa.Entity.Student;
import com.SpringData.SpringDataJpa.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("Courses List" +courseList);
    }
    @Test
    public void saveCourseTeacher(){
        Teacher teacher = Teacher.builder().firstName("essam").lastName("el-Masry").build();
        Course course = Course.builder().title("Kafka").credit(6).teacher(teacher).build();
        Course save = courseRepository.save(course);
        System.out.println("Course Credentials = "+ save);
    }
    @Test
    public void findAllPagination(){
        Pageable pageRequestThreeRecords = PageRequest.of(0, 3);
        Pageable pageRequestTwoRecords = PageRequest.of(0, 2);
        List<Course> courseList = courseRepository.findAll(pageRequestThreeRecords).getContent();
        System.out.println("courses= "+ courseList);
        long totalElements = courseRepository.findAll(pageRequestTwoRecords).getTotalElements();
        System.out.println("total Elements Courses= "+ totalElements );
        int totalPages = courseRepository.findAll(pageRequestTwoRecords).getTotalPages();
        System.out.println("total Pages = "+ totalPages);
    }
    @Test
    public void findAllSorting(){
        Pageable titleSorted = PageRequest.of(0, 2, Sort.by("title"));
        System.out.println("Course Sorted Title "+ titleSorted.getSort());
        Pageable creditSorted = PageRequest.of(0, 2, Sort.by("credit").descending());
        System.out.println("Credit Sorted In Descending Order "+ creditSorted.getSort());
    }

    @Test
    public void sortByTitleAndCreditDesc(){
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> courseList = courseRepository.findAll(pageRequest).getContent();
        System.out.println("Course List ="+ courseList);
    }
    @Test
    public void findByTitleContainingTest(){
        PageRequest pageRequest = PageRequest.of(0, 10);
        List<Course> courseList = courseRepository.findByTitleContaining("K", pageRequest).getContent();
        System.out.println("page list find element 'K' =" + courseList);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder().firstName("Mohammed").lastName("Ismail").build();
        Course course = Course.builder().title("AI").credit(6).teacher(teacher).build();
        Student student =Student.builder().firstName("yara").lastName("Ragab").emailId("yaraRagab@gamil").build();
        course.addStudent(student);
        courseRepository.save(course);
    }

}