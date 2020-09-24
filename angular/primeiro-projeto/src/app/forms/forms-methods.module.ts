import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes,  } from '@angular/router';

import { TemplateFormComponent } from './template-form/template-form.component';
import { DataFormComponent } from './data-form/data-form.component';
import { FormsModule } from '@angular/forms';
import { FormsComponent } from './forms.component';

const routes: Routes = [
  {
    path: '', component: FormsComponent,
    children: [
      { path: 'templateForm', component: TemplateFormComponent },
      { path: 'dataForm', component: DataFormComponent }
    ]
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    FormsModule
  ],
  declarations: [
    TemplateFormComponent,
    DataFormComponent,
  ],
})
export class FormsMethodsModule { }
