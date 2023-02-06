export class AccountInfoDTO {
  accountId: number;
  balance: number;

  constructor(accountId: number, balance: number) {
    this.accountId = accountId;
    this.balance = balance;
  }
}
