import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  // { path: '', component: PageEstructureComponent },
  // { path: 'diretivas', component: PageDiretivasComponent },
  { path: 'interpolacaoBiding' , loadChildren: 'src/app/initial-page/initial-page.module#InitialPageModule'},
  { path: 'diretivas' , loadChildren: 'src/app/diretivas/page-diretivas.module#DiretivasPageModule'}
];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(routes);
