import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { SharedModule } from '../shared/shared.module';
import { CursosService } from '../services/cursos.service';
import { ClassStyleComponent } from './class-style/class-style.component';
import { InterpolationComponent } from './interpolation/interpolation.component';
import { TwoWayDataBindingComponent } from './two-way-data-binding/two-way-data-binding.component';
import { EventBindingComponent } from './event-binding/event-binding.component';
import { PageEstructureComponent } from './page-estructure.component';
import { AuthGuardChildService } from '../services/guard/auth-guard-child.service';


const routes: Routes = [
  {
    path: '', component: PageEstructureComponent,
    canActivateChild: [AuthGuardChildService],
    canLoad: [AuthGuardChildService],
    children: [
      { path: 'two-way-data-binding', component: TwoWayDataBindingComponent },
      { path: 'interpolacao', component: InterpolationComponent },
      { path: 'binding-component', component: EventBindingComponent },
      { path: 'class-style', component:  ClassStyleComponent},
    ]
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    FormsModule,
    SharedModule,
  ],
  declarations: [
    PageEstructureComponent,
    ClassStyleComponent,
    InterpolationComponent,
    TwoWayDataBindingComponent,
    EventBindingComponent,
  ],
  providers: [CursosService]
})
export class InterpolationBindingModule { }
