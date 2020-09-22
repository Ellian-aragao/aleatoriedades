import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {

  mostraMenu = false;

  constructor(private auth: AuthService) {}

  ngOnInit(): void {
    this.auth.mostrarMenuEmitter.subscribe(mostra => this.mostraMenu = mostra);
  }
}
