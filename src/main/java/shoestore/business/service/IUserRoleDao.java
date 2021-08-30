package shoestore.business.service;

import shoestore.data.entity.Order;
import shoestore.data.entity.UserRole;

import java.util.List;

public interface IUserRoleDao {

    void createEntityManager();
    void closeEntityManager();

    List<UserRole> findAllUserRoles();
    UserRole findUserRoleById(Integer idIn);


}
