package com.softtek.acceleo.demo.security.repository;

import com.softtek.acceleo.demo.domain.User;

public interface UserRepository  {
    User findByUsername(String username);
}


