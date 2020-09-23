import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './services/guard/auth-guard.service';

const routes: Routes = [
  {
    path: 'interpolacaoBiding',
    loadChildren: 'src/app/initial-page/initial-page.module#InitialPageModule',
    canActivate: [AuthGuardService]
  },
  {
    path: 'diretivas',
    loadChildren: 'src/app/diretivas/page-diretivas.module#DiretivasPageModule',
    canActivate: [AuthGuardService]
  },
  {
    path: 'login',
    loadChildren: 'src/app/login/login.module#LoginModule'
  },
  {
    path: '', redirectTo: 'login' , pathMatch: 'full',
    canActivate: [AuthGuardService]
  }
];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(routes);
