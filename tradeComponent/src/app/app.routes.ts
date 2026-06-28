import { Routes } from '@angular/router';
import { TradeList } from './trade-list/trade-list';
import { TradeCreate } from './trade-create/trade-create';
import { AccountView } from './account-view/account-view';
import { AccountDetails } from './account-details/account-details';

export const routes: Routes = [
    {
    path: 'trade',
    component: TradeList
  },
  {
    path: 'tradecreate',
    component: TradeCreate
  },
  {
    path:'account',
    component: AccountView
  },
   {
    path: 'accountDetails',
    component: AccountDetails
  },
  {
    path: '',
    redirectTo: 'trade',
    pathMatch: 'full'
  },
  {
    path: '**',
    redirectTo: 'trade'
  }
];
