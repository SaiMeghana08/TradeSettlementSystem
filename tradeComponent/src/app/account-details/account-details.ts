import { Component } from '@angular/core';
import { Account } from '../services/account';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-account-details',
  imports: [FormsModule,CommonModule],
  templateUrl: './account-details.html',
  styleUrl: './account-details.css',
})
export class AccountDetails {
    account: any;

  constructor(private accountService: Account) {}

  ngOnInit() {
    this.account = this.accountService.getAccountDetails();
  }
}
