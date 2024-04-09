package bank.controller;

import bank.dto.CurrencyDto;
import bank.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class CurrencyController {
    private final CurrencyService currencyService;
    CurrencyController(CurrencyService currencyService)
    {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CurrencyDto> findAllCurrency() {
        return this.currencyService.getList();
    }

    @PostMapping("/currency")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createCurrency(@RequestBody CurrencyDto currency) { currencyService.create(currency);}

    @GetMapping("/currency/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public CurrencyDto getCurrency(@PathVariable Integer id) {
        return currencyService.getById(id);
    }

    @PutMapping("/currency/{id}")
    public void updateCurrency(@PathVariable Integer id, @RequestBody CurrencyDto currency) {
        currencyService.update(currency, id);
    }

    @DeleteMapping("/currency/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void deleteCurrency(@PathVariable Integer id) {
        currencyService.deleteById(id);
    }
}
