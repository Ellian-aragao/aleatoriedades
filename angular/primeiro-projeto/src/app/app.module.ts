import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { InitialPageModule } from './initial-page/initial-page.module';
import { routing } from './app.routing.module';
import { DiretivasPageModule } from './diretivas/page-diretivas.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    InitialPageModule,
    DiretivasPageModule,
    routing
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
