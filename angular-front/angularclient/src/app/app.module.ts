import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './service/user.service';
import { UserUpdateComponent } from './user-update/user-update.component';
import { BankAccountListComponent } from './bank-account-list/bank-account-list.component';
import { BankAccountFormComponent } from './bank-account-form/bank-account-form.component';
import { BankAccountUpdateComponent } from './bank-account-update/bank-account-update.component';
import {BankAccountService } from './service/bank-account.service';
import { CurrencyListComponent } from './currency-list/currency-list.component';
import { CurrencyFormComponent } from './currency-form/currency-form.component';
import { CurrencyUpdateComponent } from './currency-update/currency-update.component';
import {CurrencyService } from './service/currency.service';

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
    CurrencyUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService, BankAccountService, CurrencyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
