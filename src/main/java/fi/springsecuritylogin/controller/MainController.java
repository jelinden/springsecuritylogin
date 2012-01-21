package fi.springsecuritylogin.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.springsecuritylogin.domain.User;
import fi.springsecuritylogin.service.UserService;

@Controller("mainController")
public class MainController {

  @Autowired
  private UserService userService;
  
  protected final Logger log = LoggerFactory.getLogger(getClass());

  @RequestMapping(value = "", method = RequestMethod.GET)
  protected String getNews(HttpServletRequest request, Model model)
      throws Exception {

    User user = userService.get(SecurityContextHolder.getContext().getAuthentication().getName());
    model.addAttribute("user", user);
    return "index";
  }
  
  public void setUserService(UserService userService) {
    this.userService = userService;
  }
}