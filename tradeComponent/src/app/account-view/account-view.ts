import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { Account } from '../services/account';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account-view',
  imports: [MatFormFieldModule, MatInputModule, MatSelectModule,FormsModule],
  templateUrl: './account-view.html',
  styleUrl: './account-view.css',
})
export class AccountView {
   accountId:any;
   account:any;
   constructor(private accountService: Account,private router:Router) {}

  onSubmit() {
    return this.accountService.getAccount(this.accountId).subscribe(
      (response: any) => {
        console.log('Account details:', response);
        this.accountService.setAccount(response);
        this.router.navigate(['/accountDetails']);
      },
      (error: any) => {
        console.error('Error fetching account details:', error);
      }
    );
  }
}
