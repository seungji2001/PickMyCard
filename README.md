# PickMyCard

## 아키텍처
![image](https://github.com/user-attachments/assets/e42390d5-480b-475f-aef5-c3b40b29ed55)
이 시스템은 카드 서비스, 유저 서비스, 데이터 분석 서비스로 구성되어 있으며, 클라이언트는 API Gateway를 통해 이들 서비스에 접근합니다. 모든 서비스는 Eureka 서버에 등록되어 있어, API Gateway가 Eureka 서버를 통해 각 마이크로서비스의 위치 정보를 얻을 수 있습니다. 이러한 구조는 서비스 간의 독립성을 보장하면서도 효율적인 통신과 관리를 가능하게 합니다.

## Eureka Server
![image](https://github.com/user-attachments/assets/ee336ea5-14b3-45a7-b2f8-7a04a4af6998)

## Cloud Gateway
![image](https://github.com/user-attachments/assets/9cd5cfce-795a-4e22-a15c-ab4d3cf1dbbf)
Spring Eureka 대시보드는 시스템의 전반적인 상태, 등록된 서비스들의 목록과 각 서비스의 현재 상태, 그리고 서버의 상세한 리소스 정보를 보여주어 마이크로서비스 아키텍처의 전반적인 건강 상태와 각 구성 요소의 가용성을 한눈에 파악할 수 있게 해줍니다.

## MSA 서비스에서 발생하는 오류를 파악하기 위한 아키텍처
![image](https://github.com/user-attachments/assets/992e5112-1ccd-4bec-9f9d-7897a7fd2486)
이 모니터링 아키텍처는 마이크로서비스 환경에서 서비스의 안정성과 가용성을 보장하기 위한 구조를 설명합니다. 사용자는 API Gateway를 통해 카드 서비스와 유저 서비스에 접근합니다. 카드 서비스는 의도적으로 50%의 요청에 대해 500 에러를 발생시키도록 설정되어 있으며, 유저 서비스는 정상적으로 응답합니다. 카드 서비스의 장애 상황에 대비하여 서킷 브레이커가 구현되어 있어, 서비스 실패 시 대체 응답(fallback)을 제공합니다. 프로메테우스는 API Gateway와 카드 서비스의 서킷 브레이커를 모니터링하여 전체 시스템의 상태를 실시간으로 감시합니다. 이러한 구조를 통해 서비스 장애 상황을 효과적으로 관리하고 시스템의 전반적인 안정성을 유지할 수 있습니다.

## 500 에러 상태를 나타내는 요청을 총 요청 수와 비교한 비율
![image](https://github.com/user-attachments/assets/5afe49d1-d607-4e5d-93ea-0bf520ac8688)

## 최근 1분간 발생한 HTTP 상태 코드 200(성공)의 요청 비율
![image](https://github.com/user-attachments/assets/dcd9ff7f-951e-4312-8d78-3647271704ed)
