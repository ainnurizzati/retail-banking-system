import { Component, OnInit } from '@angular/core';
import { AccountInfoDTO } from './account-info-dto';
import { Accounts } from './accounts';
import { AccountService } from './accounts.service';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})

export class AccountsComponent implements OnInit {
  accounts: AccountInfoDTO[] = [];

  constructor(private accountService: AccountService) { }

  ngOnInit() {
    this.getAccounts();
  }

  getAccounts(): void {
    const customerId = 1; // hardcoded for example purposes
    this.accountService.getAccountsByCustomerId(customerId)
      .subscribe(accounts => this.accounts = accounts);
  }
}
