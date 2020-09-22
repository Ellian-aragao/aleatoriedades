import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-fundo-amarelo',
  templateUrl: './fundo-amarelo.component.html',
})
export class FundoAmareloComponent {

  @Input() exibe = true;

  mudaEstado(): void {
    this.exibe = !this.exibe;
  }
}
