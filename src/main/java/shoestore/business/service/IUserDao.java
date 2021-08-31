package shoestore.business.service;

import shoestore.data.entity.User;

import java.util.List;

public interface IUserDao {

    //void createEntityManager();
    //void closeEntityManager();

    List<User> findAllUsers();
    User findUserById(Integer idIn);
    List<User> findUserByLastName(String lastNameIn);

    User updateUserAddressById(Integer idIn, String addressIn, String cityIn, String stateIn, String zipCodeIn);
    User updateUserPhoneById(Integer idIn, String phoneIn);

    User addUser(User userIn);
    User removeUserById(Integer idIn);

}
