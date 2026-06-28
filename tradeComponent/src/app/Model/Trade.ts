export interface Trade{
  buyerId: number;
  sellerId: number;
  amount: number;
  shares:number;
  settled: boolean;
}
