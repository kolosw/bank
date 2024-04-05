import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserUpdateComponent } from './components/user-update/user-update.component';
import { BankAccountListComponent } from './components/bank-account-list/bank-account-list.component';
import { BankAccountFormComponent } from './components/bank-account-form/bank-account-form.component';
import { BankAccountUpdateComponent } from './components/bank-account-update/bank-account-update.component';
import { CurrencyListComponent } from './components/currency-list/currency-list.component';
import { CurrencyFormComponent } from './components/currency-form/currency-form.component';
import { CurrencyUpdateComponent } from './components/currency-update/currency-update.component';
import { BankAccountCurrencyListComponent } from './components/bank-account-currency-list/bank-account-currency-list.component';
import { BankAccountCurrencyFormComponent } from './components/bank-account-currency-form/bank-account-currency-form.component';


const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'updateuser', component: UserUpdateComponent },
  { path: 'account', component: BankAccountListComponent },
  { path: 'addaccount', component: BankAccountFormComponent },
  { path: 'updateaccount', component: BankAccountUpdateComponent },
  { path: 'currency', component: CurrencyListComponent },
  { path: 'addcurrency', component: CurrencyFormComponent },
  { path: 'updatecurrency', component: CurrencyUpdateComponent },
  { path: 'accountcurrency', component: BankAccountCurrencyListComponent },
  { path: 'addaccountcurrency', component: BankAccountCurrencyFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
