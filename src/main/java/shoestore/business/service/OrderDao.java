package shoestore.business.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import shoestore.data.entity.Order;
import shoestore.data.entity.User;

import java.util.List;

public class OrderDao implements IOrderDao {

    // Data
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;

    // Constructors
    public OrderDao() {
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
    public List<Order> findAllOrders() {
        createEntityManager();

        TypedQuery<Order> query = entityManager.createNamedQuery("findAllOrdersQuery", Order.class);
        List<Order> orders = query.getResultList();

        closeEntityManager();
        return orders;
    }

    @Override
    public Order findOrderById(Integer idIn) {
        createEntityManager();

        Order order = this.entityManager.find(Order.class, idIn);

        closeEntityManager();
        return order;
    }



}
