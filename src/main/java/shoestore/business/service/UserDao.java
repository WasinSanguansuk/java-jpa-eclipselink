package shoestore.business.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import shoestore.data.entity.User;

import java.util.List;

public class UserDao implements IUserDao {

    private EntityManager entitymanager = null;

    public UserDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entitymanager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "SELECT u FROM User u";

        TypedQuery<User> query = entitymanager.createQuery(sql, User.class);
        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public List<User> findUserById(Integer idIn) {
        String sql = "SELECT u FROM User u WHERE u.id = :idValue";

        TypedQuery<User> query = entitymanager.createQuery(sql, User.class);
        query.setParameter("idValue", idIn);
        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public List<User> findUserByLastName(String lastNameIn) {
        String sql = "SELECT u FROM User u WHERE u.lastName = :lastNameValue";

        TypedQuery<User> query = entitymanager.createQuery(sql, User.class);
        query.setParameter("lastNameValue", lastNameIn);
        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User addUser(User userIn) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(userIn);
        entitymanager.getTransaction().commit();

        return userIn;
    }

    @Override
    public User removeUser(User userIn) {
        entitymanager.getTransaction().begin();
        entitymanager.remove(userIn);
        entitymanager.getTransaction().commit();

        return userIn;
    }

    @Override
    public User updateUserAddressById(Integer idIn, String addressIn, String cityIn, String stateIn, String zipCodeIn) {
        return null;
    }
}
