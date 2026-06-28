import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { TradeService } from '../services/trade';
import { MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Settlement } from '../services/settlement';

@Component({
  selector: 'app-trade-list',
  imports: [MatTableModule, MatTableModule, MatPaginatorModule],
  templateUrl:'./trade-list.html',
  styleUrl: './trade-list.css',
})
export class TradeList implements OnInit, AfterViewInit {
  constructor(private tradeService: TradeService,private settlement: Settlement) {}
  trades: any[] = [];

  ngOnInit() {
    this.loadTrades();
  }
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  displayedColumns: string[] = [
    'tradeId',
    'buyer',
    'seller',
    'amount',
    'shares',
    'timestamp',
    'status',
    'Button',
  ];
  dataSource = new MatTableDataSource<any>([]);
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  isSettled: boolean | undefined;
  loadTrades() {
    this.tradeService.getAllTrades().subscribe((trades: any[]) => {
      this.trades = trades;
      this.dataSource.data = trades;
      this.dataSource.paginator = this.paginator;
    });
  }
 settleTrade(id: number) {

  this.settlement.settleTrade(id)
    .subscribe(() => {

      const trade = this.dataSource.data.find(
        t => t.tradeId === id
      );

      if (trade) {
        trade.status = 'SETTLED';
      }

      this.dataSource.data = [...this.dataSource.data];
    });

}
}
