package org.sussanacode.authentication;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUserAuth> selectApplicationUserByUsername(String username);
}
