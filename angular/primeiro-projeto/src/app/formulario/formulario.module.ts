import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { PageFormComponent } from './page-form.component';
import { DataFormComponent } from './data-form/data-form.component';
import { TemplateFormComponent } from './template-form/template-form.component';

const routes: Routes = [
  {
    path: '', component: PageFormComponent,
    children: [
      { path: 'data-form', component: DataFormComponent },
      { path: 'template-form', component: TemplateFormComponent },
    ]
  },
];

@NgModule({
  declarations: [
    PageFormComponent,
    DataFormComponent,
    TemplateFormComponent
  ],
  imports: [
    RouterModule.forChild(routes),
    FormsModule,
    CommonModule,
  ]
})
export class FormularioModule { }
