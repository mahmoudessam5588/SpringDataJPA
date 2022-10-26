package com.SpringData.SpringDataJpa.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence",sequenceName = "course_material_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_material_sequence")
    private Long courseMaterial;
    private String url;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    Course course;
}