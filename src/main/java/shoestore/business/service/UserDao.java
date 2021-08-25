package shoestore.business.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import shoestore.data.entity.User;

import java.util.List;

public class UserDao implements IUserDao {

    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;

    public UserDao() {
    }

    public void createEntityManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa-eclipselink");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    public void closeEntityManager() {
        this.entityManager.close();
        this.entityManagerFactory.close();
    }

    @Override
    public List<User> findAllUsers() {
        //createEntityManager();

        //String sql = "SELECT u FROM User u";

        //TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        //TypedQuery<User> query = entityManager.createQuery(User.findAllUsersQuery, User.class);
        TypedQuery<User> query = entityManager.createNamedQuery("findAllUsersQuery", User.class);
        List<User> users = query.getResultList();

        // Query interface methods:
        //      getResultList()
        //      int executeUpdate()
        //      int getFirstResult()
        //      Query setFirstResult(int startPosition)
        //      Query setMaxResult(int maxResult)
        //      int getMaxResults()

        //closeEntityManager();
        return users;
    }

    @Override
    public User findUserById(Integer idIn) {
        //createEntityManager();

        //String sql = "SELECT u FROM User u WHERE u.id = :idValue";
        //TypedQuery<User> query = entitymanager.createQuery(sql, User.class);
        //query.setParameter("idValue", idIn);
        //List<User> users = query.getResultList();

        User user = this.entityManager.find(User.class, idIn);

        //closeEntityManager();
        return user;
    }

    @Override
    public List<User> findUserByLastName(String lastNameIn) {
        //createEntityManager();

        //String sql = "SELECT u FROM User u WHERE u.lastName = :lastNameValue";

        //TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        //TypedQuery<User> query = entityManager.createQuery(User.findUsersByLastNameQuery, User.class);
        //TypedQuery<User> query = entityManager.createNamedQuery("findUsersByLastNameQuery", User.class);
        //query.setParameter("lastNameValue", lastNameIn);
        //List<User> users = query.getResultList();
        List<User> users = entityManager.createNamedQuery("findUsersByLastNameQuery", User.class)
                .setParameter("lastNameValue", lastNameIn)
                .getResultList();

        //closeEntityManager();
        return users;
    }

    @Override
    public User updateUserAddress(User userIn, String addressIn, String cityIn, String stateIn, String zipCodeIn) {
        //createEntityManager();

        //

        //closeEntityManager();
        return userIn;
    }

    @Override
    public User updateUserPhone(User userIn, String phoneIn) {
        //createEntityManager();

        userIn.setPhone(phoneIn);

        entityManager.getTransaction().begin();
        entityManager.persist(userIn);
        entityManager.getTransaction().commit();

        //closeEntityManager();
        return userIn;
    }

    @Override
    public User updateUserPhoneById(Integer idIn, String phoneIn) {
        //createEntityManager();

        User user = this.entityManager.find(User.class, idIn);

        user.setPhone(phoneIn);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        //closeEntityManager();
        return user;
    }

    @Override
    public User addUser(User userIn) {
        //createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(userIn);
        entityManager.getTransaction().commit();

        //closeEntityManager();
        return userIn;
    }

    @Override
    public User removeUser(User userIn) {
        //createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(userIn);
        entityManager.getTransaction().commit();

        //closeEntityManager();
        return userIn;
    }

    @Override
    public User removeUserById(Integer idIn) {
        //createEntityManager();

        User user = this.entityManager.find(User.class, idIn);

        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();

        //closeEntityManager();
        return user;
    }


}
