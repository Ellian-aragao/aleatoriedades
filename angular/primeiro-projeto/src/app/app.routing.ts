import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginModule } from './login/login.module';

const routes: Routes = [
  { path: 'interpolacaoBiding', loadChildren: 'src/app/initial-page/initial-page.module#InitialPageModule' },
  { path: 'diretivas', loadChildren: 'src/app/diretivas/page-diretivas.module#DiretivasPageModule' },
  { path: 'login', loadChildren: 'src/app/login/login.module#LoginModule' },
  { path: '', redirectTo: 'login' , pathMatch: 'full'}
];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(routes);
