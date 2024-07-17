## 전자정부 프레임워크(Spring) 실무 교육

- 시기 : 한국재정정보원 2024 하반기 체험형 인턴
- 기간 : 2024/07/15 ~ 2024/07/18 (4일간)
- 학습 키워드 : Spring Framework, MyBatis, PostgreSQL, Logging, AOP, Test

### MyBatis vs Spring Data JPA
#### 1) MyBatis
    - sqlMapper를 사용하며, 데이터 소스파일을 직접 설정해야 함.
    - 관련 파일 : DatasourceConfiguration.java, MybatisConfiguration.java, PostRepository.xml
#### 2) Spring Data JPA
    - 데이터 소스파일과 Mapper가 필요없음.
    - Repository가 CrudRepository를 상속하여 사용(기본 CRUD구현 필요없음)
    - 객체를 매핑하는 ORM방식으로 제공