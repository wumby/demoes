package com.example.demo.repoTests;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseTests {

    @InjectMocks
    CourseRepo courseRepo;

    @Test
    public void findByIdTest(){
        Course course = courseRepo.findById(10001L);
        Assertions.assertEquals("hibernate",course.getName());
    }

}
