package az.ingress.account;

import lombok.Data;

@Data
public class AccountDto {
    private String fullName;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String role;
}
