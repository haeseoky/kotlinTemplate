# Kotlin Spring Boot 템플릿 프로젝트

이 프로젝트는 Kotlin과 Spring Boot를 사용하여 빠르게 어플리케이션을 개발할 수 있는 기본 템플릿입니다. Spring Boot 2.7.2 버전과 Kotlin 1.6.21 버전을 기반으로 합니다.

## 기술 스택

- Kotlin 1.6.21
- Spring Boot 2.7.2
- Spring Data JPA
- Spring Cloud Stream Kafka
- MySQL / H2 Database
- Gradle (Kotlin DSL)
- Java 17

## 프로젝트 구조

```
src/main/
├── kotlin/me/ocean/kotlintemplate/
│   ├── KotlinTemplateApplication.kt  - 메인 애플리케이션 클래스
│   ├── applicationeventpublish/      - Spring 애플리케이션 이벤트 관련 기능
│   ├── entitylistener/               - JPA 엔티티 리스너 관련 기능
│   ├── jpa/                          - JPA 관련 설정 및 엔티티
│   ├── logspy/                       - SQL 로깅 관련 기능 (p6spy)
│   └── validation/                   - 데이터 검증 관련 기능
└── resources/
    └── application.yml               - 애플리케이션 설정 파일
```

## 주요 기능

- **Spring Boot 기반 환경**: Spring Boot의 자동 설정 및 의존성 관리를 활용한 개발 환경
- **Kotlin 언어 지원**: Kotlin의 간결한 문법과 널 안전성을 활용한 개발
- **JPA 통합**: Spring Data JPA를 사용한 데이터 접근 계층
- **Kafka 메시징**: Spring Cloud Stream을 통한 Kafka 메시징 지원
- **다중 환경 설정**: local, test, dev, staging, prod 등 다양한 환경별 설정 지원
- **SQL 로깅**: p6spy를 통한 SQL 쿼리 로깅 지원
- **테스트 환경**: JUnit 기반 테스트 환경 구성

## 시작하기

### 필수 조건

- JDK 17 이상
- Gradle
- MySQL (로컬 개발 시)

### 설치 및 실행

1. 레포지토리 클론:
   ```bash
   git clone https://github.com/haeseoky/kotlinTemplate.git
   cd kotlinTemplate
   ```

2. Gradle로 빌드:
   ```bash
   ./gradlew build
   ```

3. 애플리케이션 실행:
   ```bash
   ./gradlew bootRun
   ```
   또는 특정 프로필로 실행:
   ```bash
   ./gradlew bootRun --args='--spring.profiles.active=dev'
   ```

## 환경 설정

프로젝트는 다음과 같은 프로필을 지원합니다:

- **local**: 로컬 개발 환경
- **test**: 테스트 환경 (H2 인메모리 데이터베이스 사용)
- **dev**: 개발 서버 환경
- **staging**: 스테이징 환경
- **prod**: 프로덕션 환경
- **test-kafka**: Kafka 테스트 환경

각 환경별 설정은 `application.yml` 파일에서 관리됩니다.

## 데이터베이스 설정

기본적으로 MySQL 데이터베이스를 사용하도록 설정되어 있으며, 테스트 환경에서는 H2 인메모리 데이터베이스를 사용합니다.

```yaml
# MySQL 설정 (기본)
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=true
    username: root
    password:
    driver-class-name: com.mysql.cj.jdbc.Driver

# H2 설정 (테스트 환경)
spring:
  datasource:
    url: jdbc:h2:mem:Demo;MODE=MySQL;DB_CLOSE_DELAY=-1;IGNORECASE=TRUE;DB_CLOSE_ON_EXIT=FALSE
    username: sa
    password:
    driver-class-name: org.h2.Driver
```

## Kafka 설정

Spring Cloud Stream 및 Kafka와 관련된 설정은 다음과 같습니다:

```yaml
spring:
  cloud:
    function:
      definition: producer-invoice-confirmed;consumer-invoice-confirmed
    stream:
      default-binder: kafka
      kafka:
        binder:
          brokers: kafka-event-dev-0.internal.smartfoodnet.io:9092,kafka-event-dev-1.internal.smartfoodnet.io:9092
```

## 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다.
