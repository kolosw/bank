package bank.service;

import bank.dto.CurrencyExchangeDto;
import bank.entities.CurrencyExchange;
import bank.mapper.CurrencyExchangeMapper;
import bank.repository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CurrencyExchangeService {
    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

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

    public void update (CurrencyExchangeDto currencyExchangeDto, Integer id)
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

    public List<CurrencyExchangeDto> getList()
    {
        List<CurrencyExchangeDto> list = new LinkedList<>();
        for(CurrencyExchange currencyExchange : currencyExchangeRepository.findAll())
            list.add(CurrencyExchangeMapper.toDto(currencyExchange));
        return list;
    }
}
