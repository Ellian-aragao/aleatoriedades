import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './services/guard/auth-guard.service';

const routes: Routes = [
  {
    path: 'interpolacaoBinding',
    loadChildren: 'src/app/interpolation-binding/interpolation-binding.module#InterpolationBindingModule',
    canActivate: [AuthGuardService],
    canLoad: [AuthGuardService]
  },
  {
    path: 'diretivas',
    loadChildren: 'src/app/diretivas/page-diretivas.module#DiretivasPageModule',
    canActivate: [AuthGuardService],
    canLoad: [AuthGuardService]
  },
  {
    path: 'forms',
    loadChildren: 'src/app/forms/forms-methods.module#FormsMethodsModule',
    // canActivate: [AuthGuardService],
    // canLoad: [AuthGuardService]
  },
  { path: 'login', loadChildren: 'src/app/login/login.module#LoginModule' },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login', pathMatch: 'full' }
];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(routes);
