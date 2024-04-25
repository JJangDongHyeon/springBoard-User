package com.green.boardver2.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data//해당 클래스에 대한 Getter, Setter, toString(), equals(), hashCode() 등의 메소드를 자동으로 생성합니다.
@Builder // 빌더 패턴을 사용하여 객체를 생성하는 빌더 메소드를 생성합니다. 이를 통해 코드를 간결하게 작성할 수 있습니다.
public class ResultDto<T> { //제네릭
    private HttpStatus statusCode;  //HTTP 응답 상태 코드를 나타내는 statusCode 필드를 정의합니다.
    private String resultMsg;
    private T resultData;
}
//세터는 안쓰고 유연하게 값을 넣고싶을때  빌더를 씀 예시.컨트롤러