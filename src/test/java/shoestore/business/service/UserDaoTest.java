package shoestore.business.service;

import jakarta.persistence.RollbackException;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.junit.jupiter.api.*;
import shoestore.business.service.IUserDao;
import shoestore.business.service.UserDao;
import shoestore.data.entity.User;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    private static IUserDao iUserDao = null;

    @BeforeAll
    public static void setUp() {
        System.out.println("@BeforeAll - setUp()");

        iUserDao = new UserDao();
    }

    @BeforeEach
    public void queryData() {
        System.out.println("@BeforeEach - queryData()");

    }

    @AfterEach
    public void resetQuery() {
        System.out.println("@AfterEach - resetQuery()");

    }

    @AfterAll
    public static void tearDown() {
        System.out.println("@AfterAll - tearDown()");

    }

    @Test
    public void testGetUserById() {
        System.out.println("---------- ---------- ---------- ---------- ----------");
        System.out.println("@Test - testGetUserById()");

        // given
        User expected = new User();
        expected.setId(1);
        expected.setEmail("wasin.sanguansuk@gmail.com");

        // when
        User actual = iUserDao.findUserById(1);

        // then
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getEmail(), actual.getEmail());
    }

    // bad test; shouldn't modify the database
    @Test
    public void testNoDuplicateEmail() {
        System.out.println("---------- ---------- ---------- ---------- ----------");
        System.out.println("@Test - testDuplicateEmail()");

        // given
        User newUser = new User();
        newUser.setFirstName("Wasin");
        newUser.setLastName("Sanguansuk");
        newUser.setEmail("wasin.sanguansuk@gmail.com");
        newUser.setPassword("123456");
        newUser.setPhone("(773) 999-8888");
        newUser.setAddress("1280 N Milwaukee Ave Apt 1101");
        newUser.setCity("Chicago");
        newUser.setState("IL");
        newUser.setZipCode("60642");

        try {
            iUserDao.addUser(newUser);
            Assertions.fail("Fail - Was able to insert record into the database with a duplicate email");

        } catch (Exception e) {
            if (e instanceof java.sql.SQLIntegrityConstraintViolationException) {
                System.out.println("Pass - Unable to insert due to duplicate email");
                Assertions.assertTrue(true);
            }
        }

        System.out.println("----------");

        //assertThrows(SQLIntegrityConstraintViolationException.class, () -> {      // fail
        //assertThrows(DatabaseException.class, () -> {                             // fail
        assertThrows(RollbackException.class, () -> {                               // pass
            iUserDao.addUser(newUser);
        });
    }

    // bad test; shouldn't modify the database
    @Test
    public void testNoNullEmail() {
        System.out.println("---------- ---------- ---------- ---------- ----------");
        System.out.println("@Test - testNoNullEmail()");

        // given
        User newUser = new User();
        newUser.setFirstName("Wasin");
        newUser.setLastName("Sanguansuk");
        newUser.setPassword("123456");
        newUser.setPhone("(773) 999-8888");
        newUser.setAddress("1280 N Milwaukee Ave Apt 1101");
        newUser.setCity("Chicago");
        newUser.setState("IL");
        newUser.setZipCode("60642");

        try {
            iUserDao.addUser(newUser);
            Assertions.fail("Fail - Was able to insert record into the database with a null email");

        } catch (Exception e) {
            if (e instanceof java.sql.SQLIntegrityConstraintViolationException) {
                System.out.println("Pass - Unable to insert due to null email");
                Assertions.assertTrue(true);
            }

            if (e.getMessage().contains(("Column 'email' cannot be null"))) {
                System.out.println("Pass - (check .getMessage()) Unable to insert due to null email");
                Assertions.assertTrue(true);
            }
        }

        System.out.println("----------");

        //assertThrows(SQLIntegrityConstraintViolationException.class, () -> {      // fail
        // assertThrows(DatabaseException.class, () -> {                            // fail
        assertThrows(RollbackException.class, () -> {                               // pass
            iUserDao.addUser(newUser);
        });
    }

    // testing
    @Test
    public void testIfTwoObjectsAreEqual() {
        System.out.println("---------- ---------- ---------- ---------- ----------");
        System.out.println("@Test - testIfTwoObjectsAreEqual()");

        User userOne = new User();
        userOne.setPhone("(773) 888-1234");
        User userTwo = new User();
        userTwo.setPhone("(773) 888-1234");

        if (userOne.equals(userTwo)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }

        assertEquals(userOne, userTwo);
    }

    // testing
    @Test
    public void testContainsUser() {
        System.out.println("---------- ---------- ---------- ---------- ----------");
        System.out.println("@Test - testContainsUser()");

    }

    // testing
    @Test
    public void testComparingArrays() {
        System.out.println("---------- ---------- ---------- ---------- ----------");
        System.out.println("@Test - testComparingArrays()");

        int[] arr1 = { 1, 2, 3 };
        //int[] arr2 = { 1, 3, 2 };
        int[] arr2 = { 1, 2, 3 };

        assertArrayEquals(arr1, arr2);
    }

    // testing
    @Test
    public void testComparingLists() {
        System.out.println("---------- ---------- ---------- ---------- ----------");
        System.out.println("@Test - testComparingLists()");

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));

        assertArrayEquals(list1.toArray(), list2.toArray());

        assertTrue(list1.equals(list2));
    }

    // testing
    @Test
    public void testNumberFormatException() {
        System.out.println("---------- ---------- ---------- ---------- ----------");
        System.out.println("@Test - testNumberFormatException()");

        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("Five"); // This line will throw NumberFormatException
        });
    }


}
