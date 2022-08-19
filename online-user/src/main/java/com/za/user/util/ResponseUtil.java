package com.za.user.util;

import com.za.user.enums.ErrorEnum;
import com.za.user.response.ResponseDTO;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/8/18 上午10:23
 */
public class ResponseUtil {
    
    public static ResponseDTO error(ErrorEnum errorEnum) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(errorEnum.getCode());
        responseDTO.setMessage(errorEnum.getMessage());
        return responseDTO;
    }

    public static ResponseDTO error(String code, String message) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(code);
        responseDTO.setMessage(message);
        return responseDTO;
    }
    
    public static ResponseDTO success(Object data) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode("200");
        responseDTO.setMessage("success");
        responseDTO.setData(data);
        return responseDTO;
    }
    
    public static ResponseDTO fail(String code, String message) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(code);
        responseDTO.setMessage(message);
        responseDTO.setData(null);
        return responseDTO;
    }
    
}
