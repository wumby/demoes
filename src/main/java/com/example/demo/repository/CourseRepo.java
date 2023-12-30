package com.example.demo.repository;

import com.example.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepo {
    
    @Autowired
    EntityManager em;

    public Course save(Course course){
        if(course.getId()==null){
            em.persist(course);
        }
        else{
            em.merge(course);
        }
        return course;
    }
    
    public Course findById(Long id){
        return em.find(Course.class,id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEM(){
        Course course = new Course("playing");
        em.persist(course);
        course.setName("playing updated");
    }
}
