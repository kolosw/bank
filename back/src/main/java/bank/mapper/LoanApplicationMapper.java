package bank.mapper;

import bank.dto.LoanApplicationDto;
import bank.entities.LoanApplication;

public class LoanApplicationMapper {

    public static LoanApplicationDto toDto(LoanApplication loanApplication) {
        LoanApplicationDto dto = new LoanApplicationDto();
        dto.setId(loanApplication.getId());
        dto.setAmount(loanApplication.getAmount());
        dto.setInterest(loanApplication.getInterest());
        dto.setPeriod(loanApplication.getPeriod());
        dto.setBankAccountId(loanApplication.getBankAccountId());
        return dto;
    }

    public static LoanApplication toEntity(LoanApplicationDto dto) {
        LoanApplication loanApplication = new LoanApplication();
        if(dto.getId()!=null)
            loanApplication.setId(dto.getId());
        loanApplication.setAmount(dto.getAmount());
        loanApplication.setInterest(dto.getInterest());
        loanApplication.setPeriod(dto.getPeriod());
        loanApplication.setBankAccountId(dto.getBankAccountId());
        return loanApplication;
    }
}
