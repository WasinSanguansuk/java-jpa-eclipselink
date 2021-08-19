package shoestore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import shoestore.data.entity.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("----------");
        {
            System.out.println("Find the user id 1 from user table");

            User user = entityManager.find(User.class, 1);
            System.out.println(user);
        }
        System.out.println("----------");
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
        System.out.println("----------");
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
        System.out.println("----------");
        {
            System.out.println("Remove the new user id 5");

            //User user = entityManager.find(User.class, 5);
            //System.out.println(user);
            //
            //entityManager.getTransaction().begin();
            //entityManager.remove(user);
            //entityManager.getTransaction().commit();
        }
        System.out.println("----------");
        {
            System.out.println("Testing");

            String lastNameValue = "Smith";

            List<String> users = entityManager.createQuery("SELECT u.lastName FROM User AS u WHERE u.lastName LIKE :userLastName").setParameter("userLastName", lastNameValue).getResultList();

            System.out.println(users);

            List<Integer> users2 = entityManager.createQuery("SELECT u.id FROM User AS u WHERE u.lastName LIKE :userLastName").setParameter("userLastName", lastNameValue).getResultList();

            System.out.println(users2);
        }
        System.out.println("----------");
        {

        }
        System.out.println("----------");
        {

        }
        System.out.println("----------");

    }
}
