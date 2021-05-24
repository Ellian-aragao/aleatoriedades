import { ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './services/guard/auth-guard.service';

const routes: Routes = [
  {
    path: 'interpolacaoBinding',
    loadChildren: () =>
      import(
        'src/app/interpolation-binding/interpolation-binding.module'
      ).then((m) => m.InterpolationBindingModule),
    canActivate: [AuthGuardService],
    canLoad: [AuthGuardService],
  },
  {
    path: 'diretivas',
    loadChildren: () =>
      import('./diretivas/page-diretivas.module').then(
        (m) => m.DiretivasPageModule
      ),
    canActivate: [AuthGuardService],
    canLoad: [AuthGuardService],
  },
  {
    path: 'forms',
    loadChildren: () =>
      import('./formulario/formulario.module').then(
        (m) => m.FormularioModule
      ),
    canActivate: [AuthGuardService],
    canLoad: [AuthGuardService],
  },
  {
    path: 'cursos',
    loadChildren: () =>
      import('./http-module/http-module.module').then(
        (m) => m.HttpModuleModule
      ),
    // canActivate: [AuthGuardService],
    // canLoad: [AuthGuardService],
  },
  {
    path: 'login',
    loadChildren: () =>
      import('./login/login.module').then((m) => m.LoginModule),
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full',
  },
  { path: '**', redirectTo: '/login', pathMatch: 'full' },
];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(
  routes
);
