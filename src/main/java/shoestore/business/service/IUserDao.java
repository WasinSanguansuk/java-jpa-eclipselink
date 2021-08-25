package shoestore.business.service;

import shoestore.data.entity.User;

import java.util.List;

public interface IUserDao {

    void createEntityManager();
    void closeEntityManager();

    List<User> findAllUsers();
    User findUserById(Integer idIn);
    List<User> findUserByLastName(String lastNameIn);

    User updateUserAddress(User userIn, String addressIn, String cityIn, String stateIn, String zipCodeIn);
    User updateUserPhone(User userIn, String phoneIn);
    User updateUserPhoneById(Integer idIn, String phoneIn);

    User addUser(User userIn);
    User removeUser(User userIn);
    User removeUserById(Integer idIn);

}
