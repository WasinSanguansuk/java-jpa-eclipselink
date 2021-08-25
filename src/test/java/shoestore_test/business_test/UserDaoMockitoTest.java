package shoestore_test.business_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import shoestore.business.service.UserDao;
import shoestore.data.entity.User;

@ExtendWith(MockitoExtension.class)
public class UserDaoMockitoTest {

    @Mock
    UserDao userDaoMock;

    @Test
    public void testGetUserByIdMock() {
        // given
        User user = new User();
        user.setId(1);
        user.setEmail("wasin.sanguansuk@gmail.com");
        user.setPassword("123456789");

        Mockito.when(userDaoMock.findUserById(1)).thenReturn(user);

        // when
        User mocked = userDaoMock.findUserById(1);

        // then
        System.out.println(mocked);
    }

}
