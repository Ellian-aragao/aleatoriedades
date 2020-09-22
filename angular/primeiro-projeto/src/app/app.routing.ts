import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PageDiretivasComponent } from './diretivas/page-diretivas.component';
import { PageEstructureComponent } from './initial-page/page-estructure.component';

const routes: Routes = [
  { path: '', component: PageEstructureComponent },
  { path: 'diretivas', component: PageDiretivasComponent },
];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(routes);
