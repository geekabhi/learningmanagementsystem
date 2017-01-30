package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Department;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private KlassService klassService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTeacher() throws Exception {

        Klass classes = new Klass();

        classes.setName("Primary");
        classes.setSemester(new Date() );
        classes.setDepartment(Department.SCIENCE);
        classes.setFee(100.00d);

        this.klassService.create(classes);

        Teacher teacher = new Teacher();

        teacher.setName("Chyld");
        teacher.setAge(45);
        teacher.setGender(Gender.Male);
        teacher.setKlass_id(classes);

        Teacher expected = this.teacherService.create(teacher);

        assertNotNull(expected);
        assertEquals(2, expected.getId());
        assertEquals("Chyld", expected.getName());
    }

    @Test
    public void getTeacherById() throws Exception {

        Teacher expected = this.teacherService.getById(1);

        assertNotNull(expected);
        assertEquals("Andreas",expected.getName());

    }

    @Test
    public void getTeachersByGender() throws Exception {

        ArrayList<Teacher> expected = (ArrayList) this.teacherService.getByGender(Gender.Male);

        assertNotNull(expected);
        assertEquals(2,expected.size());
    }

    @Test
    public void getTeachersOlderthanACertainAge() throws Exception {

        ArrayList<Teacher> expected = (ArrayList) this.teacherService.getTeachersOlderThan(30);

        assertNotNull(expected);
        assertEquals(2,expected.size());
    }

    @Test
    public void getTeachersTeachingACertainClass() throws Exception {



    }
}