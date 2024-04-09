package bank.controller;

import bank.dto.LoanApplicationDto;
import bank.service.LoanApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class LoanApplicationController {
    private final LoanApplicationService loanApplicationService;
    LoanApplicationController(LoanApplicationService loanApplicationService)
    {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/loanapplication")
    @ResponseStatus(value = HttpStatus.OK)
    public List<LoanApplicationDto> findAllUser() {
        return this.loanApplicationService.getList();
    }

    @PostMapping("/loanapplication")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody LoanApplicationDto loanApplicationDto) {
        loanApplicationService.create(loanApplicationDto);
    }

    @GetMapping("/loanapplication/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public LoanApplicationDto getById(@PathVariable int id) {
        return loanApplicationService.getById(id);
    }

    @PutMapping("/loanapplication/{id}")
    public void update(@PathVariable int id, @RequestBody LoanApplicationDto loanApplicationDto) {
        loanApplicationService.update(loanApplicationDto, id);
    }

    @DeleteMapping("/loanapplication/{id}")
    public void delete(@PathVariable int id) {
        loanApplicationService.deleteById(id);
    }
}
