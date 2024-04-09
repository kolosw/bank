package bank.controller;

import bank.dto.BankAccountDto;
import bank.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class BankAccountController {
    private final BankAccountService accountService;
    BankAccountController(BankAccountService accountService) {this.accountService = accountService;}

    @GetMapping("/account")
    @ResponseStatus(value = HttpStatus.OK)
    public List<BankAccountDto> findAllAccount() {return this.accountService.getList();}

    @PostMapping("/account")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createAccount(@RequestBody BankAccountDto bankAccountDto) {
        System.out.println(bankAccountDto);
        accountService.create(bankAccountDto);
    }

    @GetMapping("/account/{id}")
    public BankAccountDto getAccount(@PathVariable Integer id) {
        return accountService.getById(id);
    }

    @PutMapping("/account/{id}")
    public void updateAccount(@PathVariable Integer id, @RequestBody BankAccountDto bankAccount) {
        accountService.update(id, bankAccount);
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        accountService.deleteById(id);
    }
}
