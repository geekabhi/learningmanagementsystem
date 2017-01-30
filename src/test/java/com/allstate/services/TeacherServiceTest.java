package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {


    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

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

        Teacher teacher = new Teacher();

        teacher.setName("Chyld");
        teacher.setAge(45);
        teacher.setGender(Gender.Male);

        Teacher expected = this.teacherService.create(teacher);

        assertNotNull(expected);
        assertEquals(3, expected.getId());
        assertEquals("Chyld", expected.getName());
    }

    @Test
    public void getTeacherById() throws Exception {

        Teacher expected = this.teacherService.findById(1);

        assertNotNull(expected);
        assertEquals("Andreas",expected.getName());

    }

    @Test
    public void getTeachersByGender() throws Exception {

        ArrayList<Teacher> expected = (ArrayList) this.teacherService.findByGender(Gender.Male);

        assertNotNull(expected);
        assertEquals(2,expected.size());
    }

    @Test
    public void getTeachersOlderthanACertainAge() throws Exception {

        ArrayList<Teacher> expected = (ArrayList) this.teacherService.findByAgeGreaterThan(30);

        assertNotNull(expected);
        assertEquals(2,expected.size());
    }

    @Test
    @Transactional
    @Ignore(value = "Ignored because Functionality can't be written in TEST CASES")
    public void shouldFindAllTheKlassesTaughtByTeacher() throws Exception {
        List<Klass> listKlass = this.teacherService.findById(2).getKlasses();

        assertEquals(1, listKlass.size());
    }

    @Test
    @Transactional
    public void shouldFindAllTheKlassesTaughtByTeacherByName() throws Exception {
        List<Klass> excpected = this.teacherService.findAllClassesByTeacherName("Chyld");

        assertEquals("qwerty", excpected.get(0).getName());

    }
}