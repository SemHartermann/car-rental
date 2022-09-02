

import db.FieldsTest;

import db.RoleTest;
import db.StatusTest;
import db.entity.*;
import exception.AppExceptionTest;
import exception.DBExceptionTest;
import exception.MessagesTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import util.DateUtilTest;
import web.ControllerTest;


@RunWith(Suite.class)
@SuiteClasses({ CarTest.class, OrderTest.class, UserInfoTest.class,
		UserTest.class, UserInfoBeanTest.class, UserOrderBeanTest.class,
		FieldsTest.class, RoleTest.class, StatusTest.class,
		DBExceptionTest.class, AppExceptionTest.class, MessagesTest.class,
		DateUtilTest.class, ControllerTest.class, PathTest.class})
public class AllTests {

}
