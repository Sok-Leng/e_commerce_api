package com.example.e_commerce_api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageResponse <T>{
    private boolean isSuccess;
    private String errorCode;
    private String Message;
    private T data;

    public MessageResponse(String errorCode, String Message, T data, boolean isSuccess) {
        this.data = data;
        this.Message = Message;
        this.isSuccess = isSuccess;
        this.errorCode = errorCode;
    }


}
