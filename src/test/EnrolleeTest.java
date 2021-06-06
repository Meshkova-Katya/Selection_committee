package test;

import org.junit.Before;
import org.junit.Test;
import sample.Enrollee;

import static org.junit.Assert.*;

public class EnrolleeTest {

    private Enrollee enrolle;

    @Before
    public void init() {
        enrolle = new Enrollee("4.2", "123456", "1234", "Пенза", "Информационные системы и программирование",
                "Мешкова Екатерина Александровна", "Женский");
    }

    @Test
    public void getAdmission_score() {
        assertEquals(enrolle.getAdmission_score(), "4.2");
    }

    @Test
    public void setAdmission_score() {
        enrolle.setAdmission_score("3");
        assertEquals(enrolle.getAdmission_score(), "3");
    }

    @Test
    public void getPassport_ID() {
        assertEquals(enrolle.getPassport_ID(), "123456");
    }

    @Test
    public void setPassport_ID() {
        enrolle.setPassport_ID("678901");
        assertEquals(enrolle.getPassport_ID(), "678901");
    }

    @Test
    public void getPassport_series() {
        assertEquals(enrolle.getPassport_series(), "1234");
    }

    @Test
    public void setPassport_series() {
        enrolle.setPassport_series("5678");
        assertEquals(enrolle.getPassport_series(), "5678");
    }

    @Test
    public void getRegistration() {
        assertEquals(enrolle.getRegistration(), "Пенза");
    }

    @Test
    public void setRegistration() {
        enrolle.setRegistration("Москва");
        assertEquals(enrolle.getRegistration(), "Москва");
    }

    @Test
    public void getName_specialty() {
        assertEquals(enrolle.getName_specialty(), "Информационные системы и программирование");
    }

    @Test
    public void setName_specialty() {
        enrolle.setName_specialty("Мехатроника и мобильная робототехника");
        assertEquals(enrolle.getName_specialty(), "Мехатроника и мобильная робототехника");
    }

    @Test
    public void getName_enrollee() {
        assertEquals(enrolle.getName_enrollee(), "Мешкова Екатерина Александровна");
    }

    @Test
    public void setName_enrollee() {
        enrolle.setName_enrollee("Пупкин Владислав Николаевич");
        assertEquals(enrolle.getName_enrollee(), "Пупкин Владислав Николаевич");
    }

    @Test
    public void getGender() {
        assertEquals(enrolle.getGender(), "Женский");
    }

    @Test
    public void setGender() {
        enrolle.setGender("Мужской");
        assertEquals(enrolle.getGender(), "Мужской");
    }
}