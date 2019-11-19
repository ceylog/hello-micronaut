package hello.micronaut.services;

import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description AuthenticationProvider
 * @Author ceylog
 * @Date 2019/11/13
 */
@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Inject
    UsersStore store;


    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getIdentity().toString();
        String password = authenticationRequest.getSecret().toString();
        if (password.equals(store.getUserPassword(username))) {
            UserDetails details = new UserDetails(username, store.getUserRole(username));
            return Flowable.just(details);
        }
        return Flowable.just(new AuthenticationFailed());

    }
}
