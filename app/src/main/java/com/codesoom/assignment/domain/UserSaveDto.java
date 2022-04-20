package com.codesoom.assignment.domain;

import com.codesoom.assignment.application.UserSaveRequest;

import javax.validation.constraints.NotBlank;

/**
 * 회원 생성 시 사용할 DTO 클래스 입니다.
 * 회원 정보를 받기 위해 컨트롤러에서만 사용합니다.
 */
public class UserSaveDto implements UserSaveRequest {

    @NotBlank(message = "회원 이름은 필수 입력 항목입니다.")
    private String name;

    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private String password;

    public UserSaveDto() {
    }

    public UserSaveDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

}
