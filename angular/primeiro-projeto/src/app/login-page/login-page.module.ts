import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageStructureComponent } from './page-structure/page-structure.component';



@NgModule({
  declarations: [PageStructureComponent],
  imports: [
    CommonModule
  ],
  exports: [PageStructureComponent]
})
export class LoginPageModule { }
