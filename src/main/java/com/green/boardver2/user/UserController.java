package com.green.boardver2.user;

import com.green.boardver2.common.ResultDto;
import com.green.boardver2.user.model.ChangePasswordPatchReq;
import com.green.boardver2.user.model.SignInPostReq;
import com.green.boardver2.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final  UserService userService;



    @PostMapping
    public ResponseEntity<ResultDto<Integer>> postUser(@RequestBody UserPostReq p){
        int result =  userService.postUser(p);

//        ResultDto dto = ResultDto.builder().statusCode(HttpStatus.OK).build();
//        ResultDto dto2 = ResultDto.builder().resultData("ddd").build();


        return  ResponseEntity.ok(ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build());
    }

    @PostMapping("signin")
    public ResponseEntity<ResultDto<Integer>> postSignin(@RequestBody SignInPostReq p){
        int result = userService.postSignin(p);
        //1 > ㄹ그인 성공
        //2 > 아이디를 확인해주세요.
        //3 > 비밀번호를 확인해주세요.
        String msg = switch (result){
            case 1  -> "로그인 성공";
            case 2  -> "아이디를 확인해주세요";
            default -> "비밀번호를 확인해주세요";
        };


        return  ResponseEntity.ok(ResultDto.<Integer>builder() //ResultDto.<Integer>builder().~~해도 됨
                .statusCode(HttpStatus.OK)
                .resultMsg(msg)
                .resultData(result).build());

    }

    @PatchMapping("password")
    public ResultDto<Integer> patchPassword(@RequestBody ChangePasswordPatchReq p){
        int result = userService.patchPassword(p);


        String msg = switch (result){
            case 1  -> "비밀번호 변경 완료";
            case 2  -> "아이디를 확인해주세요";
            default -> "비밀번호를 확인해주세요";
        };


        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(msg)
                .resultData(result).build();
    }

}

