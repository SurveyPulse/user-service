````markdown
# MSA 기반 SurveyPulse 사용자 서비스

SurveyPulse 플랫폼의 사용자 관리를 담당하는 마이크로서비스입니다. 사용자 등록, 조회, 수정, 삭제 기능을 제공합니다.

## 주요 기능

- **회원 가입** (`POST /api/users/join`)
  - 사용자명, 이메일 유효성 검증
  - BCrypt를 이용한 비밀번호 암호화

- **여러 사용자 조회** (`GET /api/users?userIds=`)
  - 외부 서비스의 페인클라이언트를 위한 사용자 ID 목록으로 기본 정보 조회

- **단일 사용자 조회** (`GET /api/users/{userId}`)

- **사용자 정보 수정** (`POST /api/users/update`)

- **회원 탈퇴** (`POST /api/users/delete`)

## 기술 스택

- **언어 & 프레임워크**: Java, Spring Boot
- **데이터베이스**: Spring Data JPA, MYSQL(AWS RDS)
- **보안**: Spring Security, JWT
- **로깅 & 모니터링**: Elasticsearch, Logstash, Kibana (ELK), Prometheus, Grafana
- **CI/CD**: GitHub Actions
- **컨테이너 & 오케스트레이션**: Docker, Kubernetes, Helm, AWS EKS
- **아키텍처**: 마이크로서비스 아키텍처(MSA)
- **로드밸런싱**: AWS Load Balancer Controller (ALB Ingress)
