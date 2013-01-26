package fi.springsecuritylogin.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.security.Principal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ExtendedModelMap;

import static org.mockito.Matchers.any;
import fi.springsecuritylogin.domain.User;
import fi.springsecuritylogin.service.UserService;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SecurityContextHolder.class})
public class MainControllerTest {

    @InjectMocks
    private MainController mainController = new MainController();
    
    @Mock 
    private SecurityContext mockSecurityContext;
    
    @Mock
    private UserService userService;
    
    @Test
    public void testGetUsers() throws Exception {
      when(userService.get(any(String.class))).thenReturn(new User());
      when(mockSecurityContext.getAuthentication()).thenReturn(getAuthentication());
      PowerMockito.mockStatic(SecurityContextHolder.class);
      Mockito.when(SecurityContextHolder.getContext()).thenReturn(mockSecurityContext);
      
      assertEquals(mainController.getMainPage(new ExtendedModelMap().addAttribute("test", new User())), "index");
    }
    
    public Authentication getAuthentication() {
      Principal principal = new Principal() {
        @Override
        public String getName() {
          return "test";
        }
      };
      return new UsernamePasswordAuthenticationToken(principal, "test");
    }
}
