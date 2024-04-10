package bank.service;

import bank.dto.LoanApplicationDto;
import bank.entities.LoanApplication;
import bank.mapper.LoanApplicationMapper;
import bank.repository.LoanApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LoanApplicationService{
    private final LoanApplicationRepository repository;

    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.repository = loanApplicationRepository;
    }
    public void create(LoanApplicationDto loanApplicationDto) {
        repository.save(LoanApplicationMapper.toEntity(loanApplicationDto));
    }

    public LoanApplicationDto getById(int i)
    {
        return LoanApplicationMapper.toDto(repository.getReferenceById(i));
    }

    public void deleteById(int i)
    {
        repository.delete(repository.getReferenceById(i));
    }

    public void update ( LoanApplicationDto applicationDto, Integer id)
    {
        LoanApplication application = repository.getReferenceById(id);
        if(applicationDto.getAmount() != null)
            application.setAmount(applicationDto.getAmount());
        if(applicationDto.getInterest() != null)
            application.setInterest(applicationDto.getInterest());
        if(applicationDto.getPeriod() != null)
            application.setPeriod(applicationDto.getPeriod());
        if(applicationDto.getBankAccountId() != null)
            application.setBankAccountId(applicationDto.getBankAccountId());
        repository.save(application);
    }

    public List<LoanApplicationDto> getList() {
        List<LoanApplicationDto> list = new LinkedList<>();
        for (LoanApplication loanApplication : repository.findAll())
            list.add(LoanApplicationMapper.toDto(loanApplication));
        return list;
    }
}
