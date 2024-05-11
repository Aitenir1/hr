package kg.alatoo.hr.service;

import kg.alatoo.hr.entity.User;

public interface UserService {
    User getById(Long id);
    User getByUsername(String username);

    User update(User user);

    User create(User user);
}
