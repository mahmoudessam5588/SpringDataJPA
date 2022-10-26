package com.SpringData.SpringDataJpa.Repository;

import com.SpringData.SpringDataJpa.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
