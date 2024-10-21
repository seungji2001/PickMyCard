package com.fisa.pickmycardmsa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*

통신 오류 탐지 과정:
a. Circuit Breaker 패턴 구현 (API Gateway에서):
Spring Cloud Circuit Breaker를 사용하여 구현할 수 있습니다.
b. API Gateway (PickMyCardClientAPIGateway)에 다음 설정 추가:

 */
@RestController
public class FallbackController {
    @GetMapping("/cardFallback")
    public ResponseEntity<?> cardFallback() {
        return ResponseEntity.ok("Card service is currently unavailable");
    }
}