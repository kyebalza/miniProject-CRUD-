# miniProject-CRUD-
CRUD구현 미니 프로젝트입니다.

## Why: 과제 제출시에는 아래 질문을 고민해보고 답변을 함께 제출해주세요.

1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
 - 수정 : id 값을 파라메터로 넘겨주고 body로 JSON 입력받아 객체로 반환했습니다.
 - 삭제 : id 값을 파라메터로 넘겨주어 삭제처리를 했습니다.

2. 어떤 상황에 어떤 방식의 request를 써야하나요?
 - 작성 : @PostMapping
 - 전체 조회, 특정게시글 조회, 비밀번호 확인 : @GetMapping
 - 삭제 : @DeleteMapping
 - 수정 : @PutMapping

3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
 - URL에 행위에 대한 내용을 포함하지 않고 명사로 명시해 주었다.
 
4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
 - Controller : 사용자에게서 특정한 요청을 받았을 때 올바른 요청을 맵핑해주는 기능을 넣었다.
 - Service : Controller와 Repository 사이의 로직 역할을 넣었다.
 - Repository : DB 작업을 해주는 기능을 넣었다.

5. 작성한 코드에서 빈(Bean)을 모두 찾아보세요!
 - @RestController
 - @Service

6. API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요!
