package hello.micronaut.services;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;

import java.util.Map;
import java.util.Set;


@ConfigurationProperties("credentials")
public class UsersStore {
    @MapFormat
    Map<String, String> users;
    @MapFormat
    Map<String, Set<String>> roles;
    public String getUserPassword(String username) {
        return users.get(username);
    }
    public Set<String> getUserRole(String username) {
        return roles.get(username);
    }
}