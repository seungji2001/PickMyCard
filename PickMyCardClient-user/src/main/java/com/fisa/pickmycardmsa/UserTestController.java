package com.fisa.pickmycardmsa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserTestController {
    @GetMapping("/test")
    public Map<String, String> test(){
        Map<String, String> map = new HashMap<>();
        map.put("user", "백승지");
        return map;
    }
}
