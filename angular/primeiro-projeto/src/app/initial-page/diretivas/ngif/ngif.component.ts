import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-ngif',
  templateUrl: './ngif.component.html',
})
export class NgifComponent {

  @Input() exibe = true;

  mudaEstado(): void {
    this.exibe = !this.exibe;
  }
}
