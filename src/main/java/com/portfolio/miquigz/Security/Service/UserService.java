package com.portfolio.miquigz.Security.Service;

import com.portfolio.miquigz.Security.Entity.User;
import com.portfolio.miquigz.Security.Repository.InterfaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    InterfaceUserRepository iUserRepository;

    public Optional<User> getByUserName(String userName){
        return iUserRepository.findByUserName(userName);
    }
    public boolean existsByUserName(String userName){
        return iUserRepository.existsByUserName(userName);
    }
    public boolean existsByEmail(String email){
        return iUserRepository.existsByEmail(email);
    }

    public void save(User user){
        iUserRepository.save(user);
    }


}
