import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { AuthService } from './services/auth.service';
import { AuthGuardService } from './services/guard/auth-guard.service';
import { AuthGuardChildService } from './services/guard/auth-guard-child.service';
import { CursosService } from './services/cursos.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    routing
  ],
  providers: [
    AuthService,
    AuthGuardService,
    AuthGuardChildService,
    CursosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
