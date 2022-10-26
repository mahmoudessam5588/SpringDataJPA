package com.SpringData.SpringDataJpa.Repository;

import com.SpringData.SpringDataJpa.Entity.Course;
import com.SpringData.SpringDataJpa.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Test
    public void SaveCourseMaterial(){
        Course springJpaCourse = Course.builder().title("Spring Jpa Course").credit(6).build();
        CourseMaterial courseMaterialOne = CourseMaterial.builder().url("www.google.com").course(springJpaCourse).build();
        courseMaterialRepository.save(courseMaterialOne);
    }
    @Test
    public void printAllCoursesMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("Courses Material List = "+courseMaterialList);
    }

}