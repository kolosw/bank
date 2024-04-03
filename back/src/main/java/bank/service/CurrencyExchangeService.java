package bank.service;

import bank.dto.CurrencyDto;
import bank.dto.CurrencyExchangeDto;
import bank.entities.Currency;
import bank.entities.CurrencyExchange;
import bank.repository.CurrencyExchangeRepository;
import bank.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {
    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    public void create(CurrencyExchangeDto currencyExchangeDto)
    {
        CurrencyExchange currency = new CurrencyExchange(currencyExchangeDto.getId(),currencyExchangeDto.getFrom(),
                currencyExchangeDto.getTo(), currencyExchangeDto.getAmount());
        currencyExchangeRepository.save(currency);
    }
    public CurrencyExchangeDto getById(int i)
    {
        CurrencyExchange currency = currencyExchangeRepository.getReferenceById(i);
        return new CurrencyExchangeDto(currency.getId(),currency.getFrom(),
                currency.getTo(), currency.getAmount());
    }
    public void delete(int i)
    {
        currencyExchangeRepository.delete(currencyExchangeRepository.getReferenceById(i));
    }
    public void update (Integer id, CurrencyExchangeDto currencyExchangeDto)
    {
        CurrencyExchange currency = currencyExchangeRepository.getReferenceById(id);
        if(currencyExchangeDto.getTo() != null)
            currency.setTo(currencyExchangeDto.getTo());
        if(currencyExchangeDto.getFrom() != null)
            currency.setFrom(currencyExchangeDto.getFrom());
        if(currencyExchangeDto.getAmount() != null)
            currency.setAmount(currencyExchangeDto.getAmount());
        currencyExchangeRepository.save(currency);
    }
}
