package shoestore.business.service;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Service Test Suite")
//@SelectPackages("shoestore.business.service")
//@SelectClasses({UserDaoTest.class})
@SelectClasses({UserDaoTest.class, UserDaoMockitoTest.class})
public class ServiceTestSuite {

    //
}
