package com.example.e_commerce_api.utils;

import com.example.e_commerce_api.dto.response.MessageResponse;

public class MessageUtils {

    public static <T> MessageResponse<T> success(String message, T data) {
        return new MessageResponse<>("200", message, data, true);
    }

    public static <T> MessageResponse<T> errorMessage(String message) {
        return new MessageResponse<>("400", message, null, false);
    }

    public static <T> MessageResponse<T> generalErrorMessage(String message) {
        return new MessageResponse<>("500", message, null, false);
    }
}
