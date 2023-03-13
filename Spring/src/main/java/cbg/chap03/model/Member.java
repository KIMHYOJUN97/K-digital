package cbg.chap03.model;

import cbg.chap03.exception.WrongIdPasswordException;

import java.time.LocalDateTime;

public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime registerDateTime;

    public Member() {
    }

    public Member(String email, String password, String name, LocalDateTime registerDateTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDateTime = registerDateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    /**
     * 바꿀부분이 있으면 entity에 method 작성=>변경에 초점
     * Duplication과 같은 경우에는 따로 exception class를 파놓는다.
     */
    public void changePassword(String oldPassword, String newPassword) {
        if (!newPassword.equals(oldPassword)) {
            throw new WrongIdPasswordException();
        }
        this.password = newPassword;
    }
}
