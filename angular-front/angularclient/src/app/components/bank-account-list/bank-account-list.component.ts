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
  sortedAccounts: BankAccount[] = []; // New property for sorted accounts
  sortColumn: string = ''; // New property to track the currently sorted column
  sortReverse: boolean = false; // New property to track the sorting order

  constructor(private bankAccountService: BankAccountService) {}

  ngOnInit() {
    this.loadBankAccounts();
  }

  loadBankAccounts() {
    this.bankAccountService.findAll().subscribe((data) => {
      this.accounts = data;
      this.sortData(); // Sort the data initially
    });
  }

  // Method to sort the accounts based on the selected column and sorting order
  sortData() {
    if (this.sortColumn) {
      this.sortedAccounts = this.accounts.slice().sort((a, b) => {
        const aValue = a[this.sortColumn as keyof BankAccount]; // Use keyof to specify the key type
        const bValue = b[this.sortColumn as keyof BankAccount]; // Use keyof to specify the key type
        if (aValue < bValue) {
          return this.sortReverse ? 1 : -1;
        } else if (aValue > bValue) {
          return this.sortReverse ? -1 : 1;
        } else {
          return 0;
        }
      });
    } else {
      this.sortedAccounts = this.accounts.slice(); // No sorting applied, use original order
    }
  }

  // Method to handle column sorting
  sort(column: string) {
    if (column === this.sortColumn) {
      this.sortReverse = !this.sortReverse; // Reverse sorting order if the same column is clicked again
    } else {
      this.sortColumn = column;
      this.sortReverse = false; // Reset sorting order when a new column is clicked
    }
    this.sortData(); // Sort the data based on the updated sorting configuration
  }

  delete(bankAccountId: number) {
    this.bankAccountService.delete(bankAccountId).subscribe(() => {
      this.loadBankAccounts(); // Refresh the account list after deletion
    });
  }
}
