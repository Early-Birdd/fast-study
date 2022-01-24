package com.example.faststudy.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    //api 통신시간
    //front와 통신할 때는 Localdatetime보단 String
//    @JsonProperty("transaction_time") 직접 바꾸기
    private LocalDateTime transactionTime;

    //api 응답 코드
    private String resultCode;

    //api 부가설명
    private String description;

    private T data;

    //OK
    public static <T>Header<T> OK(){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //Data OK
    public static <T>Header<T> OK(T data){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .data(data)
                .build();
    }

    //ERROR
    public static <T>Header<T> ERROR(String description){
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}
