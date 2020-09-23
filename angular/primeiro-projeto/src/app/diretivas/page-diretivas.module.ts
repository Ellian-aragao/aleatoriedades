import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { FundoAmareloComponent } from './fundo-amarelo/fundo-amarelo.component';
import { NgStyleComponent } from './ng-style/ng-style.component';
import { NgSwitchComponent } from './ng-switch/ng-switch.component';
import { NgforComponent } from './ngfor/ngfor.component';
import { NgifComponent } from './ngif/ngif.component';
import { PageDiretivasComponent } from './page-diretivas.component';
import { SharedModule } from '../shared/shared.module';
import { CursosService } from '../services/cursos.service';
import { AuthGuardChildService } from '../services/guard/auth-guard-child.service';

const routes: Routes = [
  {
    path: '', component: PageDiretivasComponent,
    canActivateChild: [AuthGuardChildService],
    children: [
      { path: 'fundo-amarelo', component: FundoAmareloComponent },
      { path: 'ngstyle', component: NgStyleComponent },
      { path: 'ngswitch', component: NgSwitchComponent },
      { path: 'ngfor', component: NgforComponent },
      { path: 'ngif', component: NgifComponent }
    ]
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    SharedModule,
  ],
  declarations: [
    PageDiretivasComponent,
    FundoAmareloComponent,
    NgStyleComponent,
    NgSwitchComponent,
    NgforComponent,
    NgifComponent,
  ],
  providers: [
    CursosService,
    AuthGuardChildService]
})
export class DiretivasPageModule { }
