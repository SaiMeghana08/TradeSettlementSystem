import { Trade } from "./Trade";

 export interface Settlement {
    status: string;
    settlementId: number;
    trade: Trade;
  }