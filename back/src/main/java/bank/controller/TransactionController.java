package bank.controller;

import bank.dto.TransactionDto;
import bank.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class TransactionController {

    private final TransactionService transactionService;
    TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @GetMapping("/transaction")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TransactionDto> findAllUser() {
        return this.transactionService.getList();
    }

    @PostMapping("/transaction")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody TransactionDto transactionDto) {
        transactionService.create(transactionDto);
    }

    @GetMapping("/transaction/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public TransactionDto getById(@PathVariable int id) {
        return transactionService.getById(id);
    }

    @PutMapping("/transaction/{id}")
    public void update(@PathVariable int id, @RequestBody TransactionDto transactionDto) {
        transactionService.update(transactionDto, id);
    }

    @DeleteMapping("/transaction/{id}")
    public void delete(@PathVariable int id) {
        transactionService.deleteById(id);
    }
}
