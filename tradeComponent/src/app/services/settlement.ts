import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Settlement {
  private URL='http://localhost:8080';
  constructor(private http:HttpClient) { }
 settleTrade(id: number) {
  return this.http.post(
    `http://localhost:8080/settleTrade/${id}`,
    {},
    { responseType: 'text' }
  );
}
  public getAllSettlements():any{
    return this.http.get(`{this.URL}/getAllSettlements`);
  }
}
