package in.theqwerty.travel.user.services;

import in.theqwerty.travel.core.services.GenericDaoImpl;
import in.theqwerty.travel.user.api.UserDao;
import in.theqwerty.travel.user.domain.User;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<String, User> implements UserDao  {

}
