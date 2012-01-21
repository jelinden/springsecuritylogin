package fi.springsecuritylogin.repository;

import fi.springsecuritylogin.domain.User;

public interface UserRepository {
  public void add(User user);
  public User get(String username);
  public User addUser(User user);
  public User updateUser(User user);
  public User getUser(String id);
  public void saveUser(User user);
  public User save(User user);
}