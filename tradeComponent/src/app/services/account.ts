import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Account {
  constructor(private http: HttpClient) { }
  private URL = 'http://localhost:8080';
  public getAccount(accountId: number): any {
    return this.http.get(`${this.URL}/getAccount/${accountId}`);
  }
   private account: any;

  setAccount(account: any) {
    this.account = account;
  }

  getAccountDetails() {
    return this.account;
  }
}
