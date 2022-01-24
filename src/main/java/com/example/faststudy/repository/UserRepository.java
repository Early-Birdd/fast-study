package com.example.faststudy.repository;

import com.example.faststudy.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  //crud 사용
public interface UserRepository extends JpaRepository<User, Long> {

//    //select * from user where account = ?
//    Optional<User> findByAccount(String account);
//
//    Optional<User> findByEmail(String email);
//
//    Optional<User> findByAccountAndEmail(String account, String email);

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
}
