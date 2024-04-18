package bank.controller;

import bank.dto.BankAccountCurrencyDto;
import bank.service.BankAccountCurrencyService;
import bank.service.BankAccountService;
import bank.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class BankAccountCurrencyController {

    private final BankAccountCurrencyService bankAccountCurrencyService;
    private final CurrencyService currencyService;
    private final BankAccountService bankAccountService;

    BankAccountCurrencyController(BankAccountCurrencyService bankAccountCurrencyService,
                                  CurrencyService currencyService,
                                  BankAccountService bankAccountService)
    {
        this.bankAccountCurrencyService = bankAccountCurrencyService;
        this.currencyService = currencyService;
        this.bankAccountService = bankAccountService;
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
    @PutMapping("/accountcurrency/{idAccount}/{idCurrency}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateAccountCurrencyWithId(@PathVariable Integer idAccount, @PathVariable Integer idCurrency,
                                                              @RequestBody BankAccountCurrencyDto bankAccountCurrencyDto) {
        bankAccountCurrencyDto.setCurrency(currencyService.getById(idCurrency));
        bankAccountCurrencyDto.setCurrency(currencyService.getById(idCurrency));
        bankAccountCurrencyService.update(bankAccountCurrencyDto);
    }
    @GetMapping("/accountcurrency/{idAccount}/{idCurrency}")
    @ResponseStatus(value = HttpStatus.OK)
    public BankAccountCurrencyDto getAccountCurrency(@PathVariable Integer idAccount, @PathVariable Integer idCurrency) {
        return bankAccountCurrencyService.getById(idAccount,idCurrency);
    }

    @DeleteMapping("/accountcurrency/{accountId}/{currencyId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAccountCurrency(@PathVariable Integer accountId, @PathVariable Integer currencyId) {
        bankAccountCurrencyService.deleteById(accountId,currencyId);
    }
}
