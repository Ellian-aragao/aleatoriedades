import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { InterpolationBindingModule } from './interpolation-binding/interpolation-binding.module';
import { DiretivasPageModule } from './diretivas/page-diretivas.module';
import { LoginModule } from './login/login.module';
import { AuthService } from './services/auth.service';
import { AuthGuardService } from './services/guard/auth-guard.service';
import { AuthGuardChildService } from './services/guard/auth-guard-child.service';
import { FormularioModule } from './formulario/formulario.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    InterpolationBindingModule,
    DiretivasPageModule,
    LoginModule,
    FormularioModule,
    routing
  ],
  providers: [
    AuthService,
    AuthGuardService,
    AuthGuardChildService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
