import { Component, OnInit } from '@angular/core';
import { Accounts } from '../accounts/accounts';
import { TransferService } from './transfer.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
  sourceAccountId: number = 0;
  targetAccountId: number = 0;
  amount: number = 0;
  accounts: Accounts[] = [];

  constructor(private transferService: TransferService) {}

  ngOnInit() {
    this.transferService.getAccounts(1) // for example, customer ID is 1
      .subscribe(accounts => {
        this.accounts = accounts;
      });
  }

  transfer() {
    this.transferService
      .transfer(this.sourceAccountId, this.targetAccountId, this.amount)
      .subscribe(response => {
        console.log(response);
      });
  }
}

