package az.ingress.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;


    @PostMapping
    public Account addAccount(@RequestBody AccountDto dto) {
        return service.addAccount(dto);
    }


    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @GetMapping
    public List<Account> getAll() {
        return service.getAll();
    }


    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody AccountDto dto) {
        return service.updateAccount(id, dto);
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable Long id) {
        service.softDelete(id);
    }
}
