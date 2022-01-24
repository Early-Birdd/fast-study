package com.example.faststudy.repository;

import com.example.faststudy.FastStudyApplication;
import com.example.faststudy.model.entity.Item;
import com.example.faststudy.model.entity.User;
import com.example.faststudy.model.enumclass.UserStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

//        User user = new User();
//        user.setAccount("TestUser03");
//        user.setEmail("TestUser03@gmail.com");
//        user.setPhoneNumber("010-1111-3333");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setCreatedBy("TestUser03");
//
//        User newUser = userRepository.save(user);
//        System.out.println("newUser : " + newUser);

        String account = "Test03";
        String password = "Test03";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();

        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        //빌더 패턴
        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){
//        //select * from user where id = ?
//        Optional<User> user = userRepository.findByAccount("TestUser03");
//
//        user.ifPresent(selectUser -> {
//
//            selectUser.getOrderDetailList().stream().forEach(detail ->{
//                Item item = detail.getItem();
//                System.out.println(detail.getItem());
//            });
//        });

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        //체인패턴
//        user.setEmail("")
//                .setPhoneNumber("")
//                .setStatus("");
//
//        User u = new User()
//                .setAccount("")
//                .setEmail("")
//                .setPassword("");

        if(user != null) {

            user.getOrderGroupList().stream().forEach(orderGroup -> {

                System.out.println("------------------주문묶음-----------------");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("------------------주문상세-----------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리" + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.printf("주문 상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착 예정 일자 : " + orderDetail.getArrivalDate());

                });
            });
        }
        Assertions.assertNotNull(user);
    }

    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional
    public  void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser.get());
        }
        else {
            System.out.println("데이터 없음");
        }

        Assertions.assertFalse(deleteUser.isPresent());
    }
}
