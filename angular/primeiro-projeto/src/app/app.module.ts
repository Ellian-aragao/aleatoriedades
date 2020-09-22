import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { InitialPageModule } from './initial-page/initial-page.module';
import { routing } from './app.routing';
import { DiretivasPageModule } from './diretivas/page-diretivas.module';
import { LoginModule } from './login/login.module';
import { AuthService } from './services/auth.service';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    InitialPageModule,
    DiretivasPageModule,
    LoginModule,
    routing
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
