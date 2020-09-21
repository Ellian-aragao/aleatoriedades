import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PageEstructureComponent } from './initial-page/page-estructure/page-estructure.component';
import { PageStructureComponent } from './login-page/page-structure/page-structure.component';

const routes: Routes = [
  { path: '', component: PageEstructureComponent },
  { path: 'login', component: PageStructureComponent }
];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(routes);
