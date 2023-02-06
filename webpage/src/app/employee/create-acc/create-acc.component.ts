import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Accounts } from 'src/app/customer/accounts/accounts';
import { AccountsComponent } from 'src/app/customer/accounts/accounts.component';
import { AccountService } from 'src/app/customer/accounts/accounts.service';
import { CreateAccService } from './create-acc.service';



@Component({
  selector: 'app-create-acc',
  templateUrl: './create-acc.component.html',
  styleUrls: ['./create-acc.component.css']
})
export class CreateAccComponent {
  account: Accounts = {
    type: '',
    accountId: 0,
    totalBalance: 0,
    individualBalance: 0,
    customerId: 0
  };

  constructor(private accountService: CreateAccService) { }

  ngOnInit() {
  }

  createAccount() {
    this.accountService.createAccount(this.account)
      .subscribe(
        data => {
          console.log(data);
          this.showSuccessMessage();
        },
        error => {
          console.error(error);
          this.handleError(error);
        }
      );
  }

  showSuccessMessage() {
    console.log("successful!")
    return (`Customer Created!`);
  }

  handleError(error: any) {
    throw new Error('Method not implemented.');
  }


}

