import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { TradeService } from '../services/trade';
import { Trade } from '../Model/Trade';

@Component({
  selector: 'app-trade-create',
  imports: [ReactiveFormsModule],
  templateUrl: './trade-create.html',
  styleUrl: './trade-create.css',
})
export class TradeCreate implements OnInit {
  tradeForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private tradeService: TradeService,
  ) {}

  ngOnInit(): void {
    this.tradeForm = this.fb.group({
      buyerId: ['', Validators.required],
      sellerId: ['', Validators.required],
      amount: ['', [Validators.required, Validators.min(1)]],
      shares: ['', [Validators.required, Validators.min(1)]],
    });
  }
  tradeValues: Trade= {
    buyerId: 0,
    sellerId: 0,
    amount: 0,
    shares: 0,
    settled: false,
  };
  onSubmit() {
    if (this.tradeForm.valid) {
      this.tradeService
        .createTrade(this.tradeForm.value)
        .subscribe((res: any) => {
          console.log('Trade Created', res);
          this.tradeValues=res;
          this.tradeForm.reset();
        });
    }
  }
}
