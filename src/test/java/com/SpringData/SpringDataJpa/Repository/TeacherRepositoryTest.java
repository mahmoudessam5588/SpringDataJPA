package com.SpringData.SpringDataJpa.Repository;

import com.SpringData.SpringDataJpa.Entity.Course;
import com.SpringData.SpringDataJpa.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course dba = Course.builder().title("DBA").credit(5).build();
        Teacher teacherBuilder = Teacher.builder().firstName("essam").lastName("el-Masry").build();
                //courses(List.of(dba))

        teacherRepository.save(teacherBuilder);
    }
}