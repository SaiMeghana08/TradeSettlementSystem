import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeCreate } from './trade-create';

describe('TradeCreate', () => {
  let component: TradeCreate;
  let fixture: ComponentFixture<TradeCreate>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TradeCreate]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TradeCreate);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
