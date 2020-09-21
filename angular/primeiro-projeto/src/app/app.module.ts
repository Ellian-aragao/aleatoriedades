import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InitialPageModule } from './initial-page/initial-page.module';
import { routing } from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    InitialPageModule,
    routing
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
