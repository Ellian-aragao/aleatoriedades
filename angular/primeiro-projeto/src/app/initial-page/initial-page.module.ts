import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PageEstructureComponent } from './page-estructure/page-estructure.component';
import { ClassStyleComponent } from './class-style/class-style.component';
import { InterpolationComponent } from './interpolation/interpolation.component';
import { TwoWayDataBindingComponent } from './two-way-data-binding/two-way-data-binding.component';
import { FormsModule } from '@angular/forms';
import { EventBindingComponent } from './event-binding/event-binding.component';
import { SharedModule } from '../shared/shared.module';
import { NgifComponent } from './diretivas/ngif/ngif.component';
import { NgforComponent } from './diretivas/ngfor/ngfor.component';
import { NgSwitchComponent } from './diretivas/ng-switch/ng-switch.component';
import { NgStyleComponent } from './diretivas/ng-style/ng-style.component';
import { FundoAmareloComponent } from './diretivasCustomisadas/fundo-amarelo/fundo-amarelo.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule
  ],
  declarations: [
    PageEstructureComponent,
    ClassStyleComponent,
    InterpolationComponent,
    TwoWayDataBindingComponent,
    EventBindingComponent,
    NgifComponent,
    NgforComponent,
    NgSwitchComponent,
    NgStyleComponent,
    FundoAmareloComponent,
  ],
  exports: [
    PageEstructureComponent
  ]
})
export class InitialPageModule { }
