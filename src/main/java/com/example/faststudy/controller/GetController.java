package com.example.faststudy.controller;

import com.example.faststudy.model.SearchParam;
import com.example.faststudy.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        String password = "bbbb";
        System.out.println("id : " + id);
        System.out.println("pwd : " + pwd);

        return id + pwd;
    }

    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){
        return Header.builder().resultCode("OK").description("OK").build();
    }
}