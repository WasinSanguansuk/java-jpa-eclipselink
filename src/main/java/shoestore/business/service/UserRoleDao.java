package shoestore.business.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import shoestore.data.entity.Order;
import shoestore.data.entity.UserRole;

import java.util.List;

public class UserRoleDao implements IUserRoleDao {

    // Data
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;

    // Constructors
    public UserRoleDao() {
    }

    // Methods
    //@Override
    public void createEntityManager() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa-eclipselink");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    //@Override
    public void closeEntityManager() {
        this.entityManager.close();
        this.entityManagerFactory.close();
    }

    @Override
    public List<UserRole> findAllUserRoles() {
        createEntityManager();

        TypedQuery<UserRole> query = entityManager.createNamedQuery("findAllUserRolesQuery", UserRole.class);
        List<UserRole> userRoles = query.getResultList();

        closeEntityManager();
        return userRoles;
    }

    @Override
    public UserRole findUserRoleById(Integer idIn) {
        createEntityManager();

        UserRole userRole = this.entityManager.find(UserRole.class, idIn);

        closeEntityManager();
        return userRole;
    }
}
