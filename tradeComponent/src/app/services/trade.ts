import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Trade } from '../Model/Trade';

@Injectable({
  providedIn: 'root',
})
export class TradeService {
  constructor(private http: HttpClient) { }
  private URL = 'http://localhost:8080';
  public createTrade(tradeData: Trade): any {
    return this.http.post(`${this.URL}/createTrade`, tradeData);
  }
  public getTradeById(tradeId:number):any{
    return this.http.get(`${this.URL}/viewTrade/${tradeId}`);
  }
  public getAllTrades():any{
    return this.http.get(`${this.URL}/getAllTrades`);
  }
}
