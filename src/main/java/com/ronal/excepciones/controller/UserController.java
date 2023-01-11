package com.ronal.excepciones.controller;

import com.ronal.excepciones.dao.UserDAO;
import com.ronal.excepciones.exception.BusinessException;
import com.ronal.excepciones.exception.RequestException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserDAO userDAO){
        if (StringUtils.isEmpty(userDAO.getName())){
            throw new RequestException("P-500","Name is required");
        }
        if (StringUtils.isEmpty(userDAO.getSurname())){
            throw new RequestException("P-456","Surname is required");
        }
        if (userDAO.getName().equals("ronal")){
            throw new BusinessException("P-500", HttpStatus.INTERNAL_SERVER_ERROR,"The name is exist");
        }
        return null;
    }
}
