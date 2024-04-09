package bank.controller;

import bank.dto.BankAccountCurrencyDto;
import bank.service.BankAccountCurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class BankAccountCurrencyController {

    private final BankAccountCurrencyService bankAccountCurrencyService;

    BankAccountCurrencyController(BankAccountCurrencyService bankAccountCurrencyService)
    {
        this.bankAccountCurrencyService = bankAccountCurrencyService;
    }

    @GetMapping("/accountcurrency")
    @ResponseStatus(value = HttpStatus.OK)
    public List<BankAccountCurrencyDto> findAllAccountCurrency() {
        return this.bankAccountCurrencyService.getList();
    }

    @PostMapping("/accountcurrency")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createAccountCurrency(@RequestBody BankAccountCurrencyDto bankAccountCurrencyDto) {
        bankAccountCurrencyService.create(bankAccountCurrencyDto);
    }

    @PutMapping("/accountcurrency")
    public void updateAccountCurrency(@RequestBody BankAccountCurrencyDto bankAccountCurrencyDto) {
        bankAccountCurrencyService.update(bankAccountCurrencyDto);
    }

    @GetMapping("/accountcurrency/{idAccount}/{idCurrency}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public BankAccountCurrencyDto getAccountCurrency(@PathVariable Integer idAccount, @PathVariable Integer idCurrency) {
        return bankAccountCurrencyService.getById(idAccount,idCurrency);
    }

    @DeleteMapping("/accountcurrency/{accountId}/{currencyId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAccountCurrency(@PathVariable Integer accountId, @PathVariable Integer currencyId) {
        bankAccountCurrencyService.deleteById(accountId,currencyId);
    }
}
