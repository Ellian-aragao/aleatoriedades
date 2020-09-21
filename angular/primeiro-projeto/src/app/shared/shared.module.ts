import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContadorComponent } from './contador/contador.component';
import { FundoAmareloDirective } from './fundo-amarelo.directive';
import { HighligthMouseDirective } from './highligth-mouse.directive';
import { NgElseDirective } from './ng-else.directive';

@NgModule({
  declarations: [
    ContadorComponent,
    FundoAmareloDirective,
    HighligthMouseDirective,
    NgElseDirective],
  imports: [
    CommonModule
  ],
  exports: [
    ContadorComponent,
    FundoAmareloDirective,
    HighligthMouseDirective,
    NgElseDirective
  ]
})
export class SharedModule { }
