import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { EmployeeComponent } from './employee/employee.component';
import { CustomerComponent } from './customer/customer.component';
import { HeaderEmpComponent } from './employee/header-emp/header-emp.component';
import { HeaderCustComponent } from './customer/header-cust/header-cust.component';
import { CreateAccComponent } from './employee/create-acc/create-acc.component';
import { CreateCustComponent } from './employee/create-cust/create-cust.component';
import { ViewAccountsComponent } from './employee/view-accounts/view-accounts.component';
import { AccountsComponent } from './customer/accounts/accounts.component';
import { StatementComponent } from './customer/statement/statement.component';
import { TransferComponent } from './customer/transfer/transfer.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    HeaderComponent,
    FooterComponent,
    EmployeeComponent,
    CustomerComponent,
    HeaderEmpComponent,
    HeaderCustComponent,
    CreateAccComponent,
    CreateCustComponent,
    ViewAccountsComponent,
    AccountsComponent,
    StatementComponent,
    TransferComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
