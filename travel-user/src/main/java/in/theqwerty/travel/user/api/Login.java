package in.theqwerty.travel.user.api;

import in.theqwerty.travel.user.domain.User;

public interface Login {
	boolean isAuthenticated(final User user);
}
