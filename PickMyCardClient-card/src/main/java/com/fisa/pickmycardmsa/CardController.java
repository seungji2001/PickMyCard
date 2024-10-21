package com.fisa.pickmycardmsa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/card")
public class CardController {
    @GetMapping("/cards")
    public ResponseEntity<?> getCards() {
        // 50% 확률로 오류 발생
        if (Math.random() < 0.5) {
            throw new RuntimeException("Card service error");
        }
        // 정상 응답
        return ResponseEntity.ok(Arrays.asList("Card1", "Card2"));
    }
}