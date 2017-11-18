package com.cat.zsy.mvc.service;

import com.cat.zsy.mvc.domain.User;
import com.cat.zsy.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    public Page<User> findByNameContains(String name, Pageable pageable) {
        return userRepository.findByNameContains(name, pageable);
    }
}
