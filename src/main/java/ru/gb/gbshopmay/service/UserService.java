package ru.gb.gbshopmay.service;


import ru.gb.gbapimay.security.UserDto;
//import ru.gb.gbshopmay.entity.ConfirmationToken;
import ru.gb.gbshopmay.entity.security.AccountUser;

import java.util.List;

public interface UserService {

    UserDto register(UserDto userDto);
    UserDto update(UserDto userDto);
    AccountUser findByUsername(String username);
    AccountUser update(AccountUser userDto);
    UserDto findById(Long id);
    List<UserDto> findAll();
    void deleteById(Long id);
//    void createConfirmationToken(UserDto user, String token);
//    ConfirmationToken getConfirmationToken(String token);
}
