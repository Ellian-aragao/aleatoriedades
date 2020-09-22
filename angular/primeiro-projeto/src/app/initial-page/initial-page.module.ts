import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ClassStyleComponent } from './class-style/class-style.component';
import { InterpolationComponent } from './interpolation/interpolation.component';
import { TwoWayDataBindingComponent } from './two-way-data-binding/two-way-data-binding.component';
import { EventBindingComponent } from './event-binding/event-binding.component';
import { SharedModule } from '../shared/shared.module';
import { CursosService } from '../services/cursos.service';
import { PageEstructureComponent } from './page-estructure.component';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  {
    path: 'interpolacao', component: PageEstructureComponent,
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
  exports: [RouterModule],
  providers: [CursosService]
})
export class InitialPageModule { }
