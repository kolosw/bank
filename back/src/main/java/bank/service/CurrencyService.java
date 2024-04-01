package bank.service;

import bank.dto.CurrencyDto;
import bank.entities.Currency;
import bank.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public void createCurrency(CurrencyDto currencyDto)
    {
        Currency currency = new Currency(currencyDto.getName(),currencyDto.getShortname(),currencyDto.getSymbol());
        currencyRepository.save(currency);
    }
    public CurrencyDto getCurrencyById(int i)
    {
        Currency currency = currencyRepository.getById(i);
        return new CurrencyDto(currency.getId(), currency.getName(), currency.getShortname(), currency.getSymbol());
    }
    public void deleteCurrencyById(int i)
    {
        currencyRepository.delete(currencyRepository.getById(i));
    }
    public void updateCurrency (CurrencyDto newCurrency)
    {
        Currency currency = new Currency(newCurrency.getId(), newCurrency.getName(), newCurrency.getShortname(), newCurrency.getSymbol());
        currencyRepository.save(currency);
    }
}
