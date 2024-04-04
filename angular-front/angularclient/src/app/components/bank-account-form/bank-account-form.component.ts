import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BankAccountService } from '../../service/bank-account-service/bank-account.service';
import { BankAccount } from '../../model/bank-account';

@Component({
  selector: 'app-bank-account-form',
  templateUrl: './bank-account-form.component.html',
  styleUrls: ['./bank-account-form.component.css']
})
export class BankAccountFormComponent {

  account: BankAccount;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private bankAccountService: BankAccountService) {
    this.account = new BankAccount();
  }

  onSubmit() {
    console.log('Account:', this.account);
    this.bankAccountService.save(this.account).subscribe(result => this.goToBankAccountList());
  }

  goToBankAccountList() {
    this.router.navigate(['/account']);
  }
}
