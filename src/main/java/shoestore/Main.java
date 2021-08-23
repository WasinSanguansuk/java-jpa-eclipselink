package shoestore;

import jakarta.persistence.*;
import shoestore.business.service.UserDao;
import shoestore.business.service.IUserDao;
import shoestore.data.entity.User;
import shoestore.data.entity.UserRole;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Find the user id 1 from user table");

            User user = entityManager.find(User.class, 1);
            System.out.println(user);
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Create a new user at id 5 (because now we have id 1-4)");

            //User newUser = new User();
            //newUser.setFirstName("Jane");
            //newUser.setLastName("Smith");
            //newUser.setEmail("jane.smith@gmail.com");
            //newUser.setPassword("jane123");
            //newUser.setPhone("(312) 999-1111");
            //newUser.setAddress("2400 N Ashland Ave");
            //newUser.setCity("Chicago");
            //newUser.setState("IL");
            //newUser.setZipCode("60640");
            //
            //System.out.println(newUser);
            //
            //entityManager.getTransaction().begin();
            //entityManager.persist(newUser);
            //entityManager.getTransaction().commit();
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Change the phone number of id 5 (the new user)");

            //User user = entityManager.find(User.class, 5);
            //System.out.println(user);
            //
            //user.setPhone("(312) 999-1112");
            //
            //entityManager.getTransaction().begin();
            //entityManager.persist(user);
            //entityManager.getTransaction().commit();
            //
            //System.out.println(user);
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Remove the new user id 5");

            //User user = entityManager.find(User.class, 5);
            //System.out.println(user);
            //
            //entityManager.getTransaction().begin();
            //entityManager.remove(user);
            //entityManager.getTransaction().commit();
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Testing");

            String lastNameValue = "Smith";

            // Correct way
            List<User> users = entityManager.createQuery("SELECT u FROM User AS u WHERE u.lastName LIKE :userLastName").setParameter("userLastName", lastNameValue).getResultList();

            System.out.println(users);

            // Incorrect way
            List users2 = entityManager.createQuery("SELECT u.id FROM User AS u WHERE u.lastName LIKE :userLastName").setParameter("userLastName", lastNameValue).getResultList();

            System.out.println(users2);

            //List<User> users3 = new ArrayList<>();
            //
            //for (Object u : users2) {
            //    users3.add((User)u);
            //}
            //
            //System.out.println(users3);
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Query all records from users table");
            System.out.println(".getResultList()");

            String sql = "SELECT u FROM User u";

            Query query = entityManager.createQuery(sql);
            List<User> users = query.getResultList();

            for (User user : users) {
                System.out.println(user);
            }

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Query 1 or more records from users table");
            System.out.println(".getResultList()");

            String sql = "SELECT u FROM User u WHERE u.id = 1";

            Query query = entityManager.createQuery(sql);
            List<User> users = query.getResultList();

            for (User user : users) {
                System.out.println(user);
            }
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Query only 1 record from users table");
            System.out.println(".getSingleResult()");

            String sql = "SELECT u FROM User u WHERE u.id = 1";
            //String sql = "SELECT u FROM User u WHERE u.id IN (1, 4)"; // Error
            //String sql = "SELECT u FROM User u WHERE u.id = 1 OR u.id = 4"; // Error

            Query query = entityManager.createQuery(sql);
            User user = (User)query.getSingleResult();

            System.out.println(user);

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Better way");

            int idIn = 2;
            //int idIn = 7;

            String sql = "SELECT u FROM User u WHERE u.id = :idValue";

            Query query = entityManager.createQuery(sql);
            query.setParameter("idValue", idIn);

            List<User> users = query.getResultList();

            for (User user : users) {
                System.out.println(user);
            }

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Worse way");

            int idIn = 2;
            //int idIn = 7; // Error

            String sql = "SELECT u FROM User u WHERE u.id = :idValue";

            Query query = entityManager.createQuery(sql);
            query.setParameter("idValue", idIn);

            User user = (User)query.getSingleResult();

            System.out.println(user);
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("Best way");
            System.out.println("TypedQuery");

            int idIn = 2;
            //int idIn = 7;

            String sql = "SELECT u FROM User u WHERE u.id = :idValue";

            TypedQuery<User> query = entityManager.createQuery(sql, User.class);
            query.setParameter("idValue", idIn);

            List<User> users = query.getResultList();

            for (User user : users) {
                System.out.println(user);
            }

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("IUserDao - findAllUsers()");

            IUserDao iUserDao = new UserDao();

            List<User> users = iUserDao.findAllUsers();

            for (User user : users) {
                System.out.println(user);
            }
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("IUserDao - findUserById()");

            IUserDao iUserDao = new UserDao();

            Integer idIn = 2;

            List<User> users = iUserDao.findUserById(idIn);

            for (User user : users) {
                System.out.println(user);
            }
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("IUserDao - findUserByLastName()");

            IUserDao iUserDao = new UserDao();

            String lastNameIn = "Smith";

            List<User> users = iUserDao.findUserByLastName(lastNameIn);

            for (User user : users) {
                System.out.println(user);
            }
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("IUserDao - addUser()");

            IUserDao iUserDao = new UserDao();

            User newUser = new User();
            newUser.setFirstName("testFirstName");
            newUser.setLastName("testLastName");
            newUser.setEmail("test@gmail.com");
            newUser.setPassword("test123");
            newUser.setPhone("(000) 000-0000");
            newUser.setAddress("123 Test st");
            newUser.setCity("Chicago");
            newUser.setState("IL");
            newUser.setZipCode("60642");

            User user = iUserDao.addUser(newUser);

            System.out.println(user);

            System.out.println("---");
            System.out.println("Print all users");
            List<User> allUsers = iUserDao.findAllUsers();
            for (User u : allUsers) {
                System.out.println(u);
            }
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("IUserDao - removeUser()");

            IUserDao iUserDao = new UserDao();

            String lastNameIn = "testLastName";

            List<User> users = iUserDao.findUserByLastName(lastNameIn);

            for (User user : users) {
                System.out.print("Going to remove ---> ");
                System.out.println(user);
                User removedUser = iUserDao.removeUser(user);
                System.out.print("After remove ---> ");
                System.out.println(user);
                System.out.println(removedUser);
            }

            System.out.println("---");
            System.out.println("Print all users");
            List<User> allUsers = iUserDao.findAllUsers();
            for (User u : allUsers) {
                System.out.println(u);
            }
        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {
            System.out.println("OneToMany and ManyToOne");

            UserDao userDao = new UserDao();

            List<User> users = userDao.findUserById(3);

            for (User user : users) {
                System.out.println(user);
                for ( UserRole role : user.getUserRoles()) {
                    System.out.println(role);
                }
            }

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");
        {

        }
        System.out.println("---------- ---------- ---------- ---------- ----------");

    }
}
