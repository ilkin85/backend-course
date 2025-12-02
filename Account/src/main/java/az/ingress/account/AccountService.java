package az.ingress.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;

    public Account addAccount(AccountDto dto) {
        Account account = Account.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
        return repository.save(account);
    }

    public Account getById(Long id) {
        return repository.findById(id)
                .filter(a -> !a.isDeleted())
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Account> getAll() {
        return repository.findByDeletedFalse();
    }


    public Account updateAccount(Long id, AccountDto dto) {
        Account account = getById(id);
        account.setFullName(dto.getFullName());
        account.setEmail(dto.getEmail());
        account.setPhone(dto.getPhone());
        account.setUsername(dto.getUsername());
        account.setPassword(dto.getPassword());
        account.setRole(dto.getRole());
        return repository.save(account);
    }

    public void softDelete(Long id) {
        Account account = getById(id);
        account.setDeleted(true);
        repository.save(account);
    }
}
