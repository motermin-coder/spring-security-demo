package com.example.springsecuritydemo.event;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * @Auth tom
 * @Date 2023-03-29 20:52:52
 */
@Component
public class LoginStatusEvent {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
        System.out.println("success = " + success);
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failures) {
        System.out.println("failures = " + failures);
    }
}
