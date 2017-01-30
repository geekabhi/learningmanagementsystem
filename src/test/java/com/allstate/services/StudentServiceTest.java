package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.repositories.IStudentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {

    private StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTheStudentGivenAnEmailId() throws Exception {
        Student expected = this.service.create("asdf@yahoo.com");

        assertNotNull(expected);
        assertEquals(2, expected.getId());
        assertEquals("asdf@yahoo.com", expected.getEmail());

    }

    @Test
    public void shouldCreateTheStudent() throws Exception {

        Student student = new Student();

        student.setEmail("asdf@gmail.com");

        Student expected = this.service.create(student);

        assertNotNull(expected);
        assertEquals(2, expected.getId());
        assertEquals("asdf@gmail.com", expected.getEmail());

    }

    @Test
    public void shouldFindStudentByEmail() throws Exception {

        Student expected = this.service.findByEmail("asdf@asdf.asdf");

        assertNotNull(expected);
        assertEquals("asdf@asdf.asdf",expected.getEmail());

    }
}