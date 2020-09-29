import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListaCursosComponent } from './lista-cursos/lista-cursos.component';
import { RouterModule, Routes } from '@angular/router';
import { CursosService } from '../services/cursos.service';
import { CursosFormComponent } from './cursos-form/cursos-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CursoResolverGuard } from './guards/curso-resolver.guard';
import { SharedModule } from '../shared/shared.module';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: '', component: ListaCursosComponent },
      {
        path: 'novo',
        component: CursosFormComponent,
        resolve: {
          curso: CursoResolverGuard,
        },
      },
      {
        path: 'editar/:id',
        component: CursosFormComponent,
        resolve: {
          curso: CursoResolverGuard,
        },
      },
    ],
  },
];

@NgModule({
  declarations: [ListaCursosComponent, CursosFormComponent],
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    ReactiveFormsModule,
    SharedModule
  ],
  providers: [CursosService],
})
export class HttpModuleModule {}
