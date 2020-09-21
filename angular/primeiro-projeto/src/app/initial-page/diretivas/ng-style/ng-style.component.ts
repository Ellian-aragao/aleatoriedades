import { Component } from '@angular/core';

@Component({
  selector: 'app-ng-style',
  templateUrl: './ng-style.component.html',
})
export class NgStyleComponent {

  ativo = false;

  mudarAtivo(): void {
    this.ativo = !this.ativo;
  }
}
