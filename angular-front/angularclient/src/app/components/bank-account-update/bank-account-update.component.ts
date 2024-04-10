import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BankAccountService } from '../../service/bank-account-service/bank-account.service';
import { BankAccount } from '../../model/bank-account';

@Component({
  selector: 'app-bank-account-update',
  templateUrl: './bank-account-update.component.html',
  styleUrls: ['./bank-account-update.component.css']
})
export class BankAccountUpdateComponent {

  account : BankAccount = new BankAccount();

  constructor(
  private router: Router,
  private bankAccountService: BankAccountService) {}

  onSubmit() {
    this.bankAccountService.update(this.account).subscribe(result => this.gotoAccountList());
  }

  gotoAccountList() {
    this.router.navigate(['/account']);
  }
}
