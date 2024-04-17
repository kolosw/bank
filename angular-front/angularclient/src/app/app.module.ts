import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CrudService } from './service/crud-service/crud.service';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserService } from './service/user-service/user.service';
import { UserUpdateComponent } from './components/user-update/user-update.component';
import { BankAccountListComponent } from './components/bank-account-list/bank-account-list.component';
import { BankAccountFormComponent } from './components/bank-account-form/bank-account-form.component';
import { BankAccountUpdateComponent } from './components/bank-account-update/bank-account-update.component';
import { BankAccountService } from './service/bank-account-service/bank-account.service';
import { CurrencyListComponent } from './components/currency-list/currency-list.component';
import { CurrencyFormComponent } from './components/currency-form/currency-form.component';
import { CurrencyUpdateComponent } from './components/currency-update/currency-update.component';
import { CurrencyService } from './service/currency-service/currency.service';
import { BankAccountCurrencyListComponent } from './components/bank-account-currency-list/bank-account-currency-list.component';
import { BankAccountCurrencyFormComponent } from './components/bank-account-currency-form/bank-account-currency-form.component';
import { BankAccountCurrencyService } from './service/bank-account-currency-service/bank-account-currency.service';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserFormComponent,
    UserUpdateComponent,
    BankAccountListComponent,
    BankAccountFormComponent,
    BankAccountUpdateComponent,
    CurrencyListComponent,
    CurrencyFormComponent,
    CurrencyUpdateComponent,
    BankAccountCurrencyListComponent,
    BankAccountCurrencyFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService, BankAccountService, CurrencyService, BankAccountCurrencyService, CrudService],
  bootstrap: [AppComponent]
})
export class AppModule { }
