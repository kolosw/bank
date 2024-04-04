import { Component, OnInit } from '@angular/core';
import { BankAccount } from '../../model/bank-account';
import { BankAccountService } from '../../service/bank-account-service/bank-account.service';

@Component({
  selector: 'app-bank-account-list',
  templateUrl: './bank-account-list.component.html',
  styleUrls: ['./bank-account-list.component.css']
})
export class BankAccountListComponent implements OnInit {

  accounts: BankAccount[] = [];

  constructor(private bankAccountService: BankAccountService) {
  }

  ngOnInit() {
    this.bankAccountService.findAll().subscribe(data => {
      this.accounts = data;
    });
  }
  loadBankAccounts() {
      this.bankAccountService.findAll().subscribe(data => {
        this.accounts = data;
      });
    }

    delete(bankAccountId: number) {
      this.bankAccountService.delete(bankAccountId).subscribe(() => {
        this.loadBankAccounts(); // Refresh the user list after deletion
      });
    }
}
