import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserUpdateComponent } from './user-update/user-update.component';
import { BankAccountListComponent } from './bank-account-list/bank-account-list.component';
import { BankAccountFormComponent } from './bank-account-form/bank-account-form.component';
import { CurrencyListComponent } from './currency-list/currency-list.component';
import { CurrencyFormComponent } from './currency-form/currency-form.component';
import { CurrencyUpdateComponent } from './currency-update/currency-update.component';


const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'updateuser', component: UserUpdateComponent },
  { path: 'account', component: BankAccountListComponent },
  { path: 'addaccount', component: BankAccountFormComponent },
  { path: 'updateaccount', component: BankAccountFormComponent },
  { path: 'currency', component: CurrencyListComponent },
  { path: 'addcurrency', component: CurrencyFormComponent },
  { path: 'updatecurrency', component: CurrencyUpdateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
