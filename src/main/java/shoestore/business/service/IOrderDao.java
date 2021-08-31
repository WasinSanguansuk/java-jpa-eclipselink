package shoestore.business.service;

import shoestore.data.entity.Order;
import shoestore.data.entity.User;

import java.util.List;

public interface IOrderDao {

    //void createEntityManager();
    //void closeEntityManager();

    List<Order> findAllOrders();
    Order findOrderById(Integer idIn);


}
