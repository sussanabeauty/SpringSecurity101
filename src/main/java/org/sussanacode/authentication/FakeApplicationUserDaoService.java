package org.sussanacode.authentication;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.sussanacode.security.ApplicationUserRole.*;


@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUserAuth> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUserAuth> getApplicationUsers(){
        List<ApplicationUserAuth> applicationUsers = Lists.newArrayList(
                new ApplicationUserAuth(
                        "beautyk",
                        passwordEncoder.encode("password"),
                        STUDENT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),

                new ApplicationUserAuth(
                        "Admin",
                        passwordEncoder.encode("password"),
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),

                new ApplicationUserAuth(
                        "admin2",
                        passwordEncoder.encode("password"),
                        ADMINASSISTANT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )

        );

        return applicationUsers;

    }
}
