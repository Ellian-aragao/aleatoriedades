import { Component } from '@angular/core';

@Component({
  selector: 'app-template-form',
  templateUrl: './template-form.component.html',
})
export class TemplateFormComponent {

  onSubmit(form): void {
    console.log(form);
  }
}
