import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { PageFormComponent } from './page-form.component';
import { DataFormComponent } from './data-form/data-form.component';
import { TemplateFormComponent } from './template-form/template-form.component';
import { ConsultaCepService } from '../services/consulta-cep.service.service';
import { HttpClientModule } from '@angular/common/http';
import { DropdownService } from '../services/dropdown.service';

const routes: Routes = [
  {
    path: '',
    component: PageFormComponent,
    children: [
      { path: '', component: DataFormComponent },
      { path: 'data-form', component: DataFormComponent },
      { path: 'template-form', component: TemplateFormComponent },
    ],
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    FormsModule,
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  declarations: [PageFormComponent, DataFormComponent, TemplateFormComponent],
  providers: [ConsultaCepService, DropdownService],
})
export class FormularioModule {}
