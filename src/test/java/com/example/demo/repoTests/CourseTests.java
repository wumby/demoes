package com.example.demo.repoTests;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
public class CourseTests {

    @Autowired
    CourseRepo courseRepo;

    @Test
    public void findByIdTest(){
        Course course = courseRepo.findById(10002L);
        Assertions.assertEquals("sd",course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteByIdTest(){
        courseRepo.deleteById(10002L);
        Course course = courseRepo.findById(10002L);
        Assertions.assertNull(course);
    }

    @Test
    @DirtiesContext
    public void saveTest(){
        Course course = courseRepo.findById(10002L);
        course.setName("updated course");
        courseRepo.save(course);
        Assertions.assertEquals("updated course",course.getName());
    }

    @Test
    @DirtiesContext
    public void entityManagerTest(){
        courseRepo.playWithEM();
    }

}
