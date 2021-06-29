package ru.netology.basics.homework14.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {

    private final Contacts contacts = new Contacts();

    private final String group1 = "FAMILY";
    private final String group2 = "FRIENDS";
    private final String group34 = "WORK";

    private final Contact contact1 = new Contact("name1", "surname1", "phone1", Group.valueOf(group1));
    private final Contact contact2 = new Contact("name2", "surname2", "phone2", Group.valueOf(group2));
    private final Contact contact3 = new Contact("name3", "surname3", "phone3", Group.valueOf(group34));
    private final Contact contact4 = new Contact("name4", "surname4", "phone4", Group.valueOf(group34));

    @BeforeEach
    public void setUp() {
        contacts.clear();
        contacts.add(contact1.getName(), contact1.getSurname(), contact1.getPhone(), group1);
        contacts.add(contact2.getName(), contact2.getSurname(), contact2.getPhone(), group2);
        contacts.add(contact3.getName(), contact3.getSurname(), contact3.getPhone(), group34);
    }

    @Test
    public void add() {
        assertTrue(contacts.add(contact4.getName(), contact4.getSurname(), contact4.getPhone(), group34));
        assertEquals(4, contacts.size());
        assertEquals(contact4, contacts.find(contact4.getPhone()));
    }

    @Test
    public void delete() {
        assertTrue(contacts.delete(contact1.getName(), contact1.getSurname()));
        assertEquals(2, contacts.size());
        assertNull(contacts.find(contact1.getPhone()));
    }

    @Test
    public void deleteNotExist() {
        assertFalse(contacts.delete(contact4.getName(), contact4.getSurname()));
        assertEquals(3, contacts.size());
    }

    @Test
    public void find() {
        assertEquals(contact1, contacts.find(contact1.getPhone()));
    }

    @Test
    public void findNotExist() {
        assertNull(contacts.find(contact4.getPhone()));
    }

    @Test
    public void hasPhone() {
        assertTrue(contacts.hasPhone(contact1.getPhone()));
    }

    @Test
    public void edit() {
        assertTrue(contacts.edit("newName1", "newSurname1", contact1.getPhone(), group34));
    }

    @Test
    public void clear() {
        contacts.clear();
        assertEquals(0, contacts.size());
    }

//--------------------------------------------------HAMCREST--------------------------------------------------
    @Test
    public void givenBean_whenHasValue_thenCorrect() {
        assertThat(contact1, hasProperty("name"));
        assertThat(contact1, hasProperty("name", equalTo("name1")));
    }

    @Test
    public void givenAnObject_whenInstanceOfGivenClass_thenCorrect() {
        assertThat(contact1, instanceOf(Contact.class));
    }

    @Test
    public void givenString_whenNotNull_thenCorrect() {
        String phone = contact1.getPhone();
        assertThat(phone, notNullValue());
    }
}