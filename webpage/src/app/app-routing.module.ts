import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AccountsComponent } from './customer/accounts/accounts.component';
import { CustomerComponent } from './customer/customer.component';
import { StatementComponent } from './customer/statement/statement.component';
import { TransferComponent } from './customer/transfer/transfer.component';
import { CreateAccComponent } from './employee/create-acc/create-acc.component';
import { CreateCustComponent } from './employee/create-cust/create-cust.component';
import { EmployeeComponent } from './employee/employee.component';
import { ViewAccountsComponent } from './employee/view-accounts/view-accounts.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [

  {path: '', component:WelcomeComponent},
  {path:"employee", component:EmployeeComponent,
    children: [
      {
        path: 'createAcc',
        component: CreateAccComponent
      },
      {
        path: 'createCust',
        component: CreateCustComponent
      },
      {
        path: 'viewAccounts',
        component: ViewAccountsComponent
      }
    ]
  },
  {path:"customer", component:CustomerComponent,
    children: [
      {
        path: 'transfer',
        component: TransferComponent
      },
      {
        path: 'statement',
        component: StatementComponent
      },
      {
        path: 'accounts',
        component: AccountsComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
