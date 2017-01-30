package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.enums.Department;
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

    private KlassService service;

    @Autowired
    public void setService(KlassService service) {
        this.service = service;
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateKlasses() throws Exception {

        Klass classes = new Klass();

        classes.setName("Primary");
        classes.setSemester(new Date() );
        classes.setDepartment(Department.SCIENCE);
        classes.setFee(100.00d);

        Klass expected = this.service.create(classes);

        assertNotNull(expected);
        assertEquals(2,expected.getId());
        assertEquals("Primary", expected.getName());
    }

    @Test
    public void shouldGetClassesByName() throws Exception {

        Klass expected = this.service.findByName("asdf");

        assertNotNull(expected);
        assertEquals(1,expected.getId());
        assertEquals("asdf", expected.getName());
    }

    @Test
    public void shouldGetClassesById() throws Exception {

        Klass expected = this.service.findById(1);

        assertNotNull(expected);
        assertEquals(1,expected.getId());
        assertEquals("asdf", expected.getName());
    }
}