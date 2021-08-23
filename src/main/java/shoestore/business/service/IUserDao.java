package shoestore.business.service;

import shoestore.data.entity.User;

import java.util.List;

public interface IUserDao {

    List<User> findAllUsers();
    List<User> findUserById(Integer idIn);
    List<User> findUserByLastName(String lastNameIn);

    User addUser(User userIn);
    User removeUser(User userIn);

    User updateUserAddressById(Integer idIn, String addressIn, String cityIn, String stateIn, String zipCodeIn);
}
