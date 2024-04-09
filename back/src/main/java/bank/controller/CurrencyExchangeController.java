package bank.controller;

import bank.dto.CurrencyExchangeDto;
import bank.service.CurrencyExchangeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class CurrencyExchangeController {
    private final CurrencyExchangeService currencyExchangeService;
    CurrencyExchangeController(CurrencyExchangeService currencyExchangeService)
    {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/currencyexchange")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CurrencyExchangeDto> findAllUser() {
        return this.currencyExchangeService.getList();
    }

    @PostMapping("/currencyexchange")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody CurrencyExchangeDto currencyExchangeDto) {
        currencyExchangeService.create(currencyExchangeDto);
    }

    @GetMapping("/currencyexchange/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public CurrencyExchangeDto getById(@PathVariable int id) {
        return currencyExchangeService.getById(id);
    }

    @PutMapping("/currencyexchange/{id}")
    public void update(@PathVariable int id, @RequestBody CurrencyExchangeDto currencyExchangeDto) {
        currencyExchangeService.update(currencyExchangeDto, id);
    }

    @DeleteMapping("/currencyexchange/{id}")
    public void delete(@PathVariable int id) {
        currencyExchangeService.delete(id);
    }
}
