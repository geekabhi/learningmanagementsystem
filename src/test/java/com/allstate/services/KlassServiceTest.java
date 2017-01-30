package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Department;
import com.allstate.enums.Gender;
import com.allstate.services.KlassService;
import com.allstate.services.TeacherService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {

    @Autowired
    private KlassService klassService;

    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateKlasses() throws Exception {

        Teacher teacher = new Teacher();

        teacher.setName("Chyld");
        teacher.setAge(45);
        teacher.setGender(Gender.Male);

        Teacher newTeacher = this.teacherService.create(teacher);


        Klass klass = new Klass();

        klass.setName("Primary");
        klass.setSemester(new Date() );
        klass.setDepartment(Department.SCIENCE);
        klass.setFee(100.00d);
        klass.setTeacher(teacher);

        Klass expected = this.klassService.create(klass);

        assertNotNull(expected);
        assertEquals(3,expected.getId());
        assertEquals("Primary", expected.getName());
    }

    @Test
    public void shouldGetClassesByName() throws Exception {

        Klass expected = this.klassService.findByName("asdf");

        assertNotNull(expected);
        assertEquals(1,expected.getId());
        assertEquals("asdf", expected.getName());
    }

    @Test
    public void shouldGetClassesById() throws Exception {

        Klass expected = this.klassService.findById(1);

        assertNotNull(expected);
        assertEquals(1,expected.getId());
        assertEquals("asdf", expected.getName());
    }
}