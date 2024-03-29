package hello.micronaut.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;

@Controller("/example")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class ExampleController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/admin")
    @Secured({"ADMIN"})
    public String withroles() {
        return "You have ADMIN roles";
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/anonymous")
    @Secured(SecurityRule.IS_ANONYMOUS)
    public String anonymous() {
        return "You are anonymous";
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/authenticated") 
    public String authenticated(Authentication authentication) {
        return authentication.getName() + " is authenticated";
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/view")
    @Secured({"VIEW"})
    public String view(Authentication authentication) {
        return authentication.getName() + " is view role";
    }

}