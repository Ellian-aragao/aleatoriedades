import { EventEmitter, Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Usuario } from '../shared/usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  mostrarMenuEmitter = new EventEmitter<boolean>();

  usuarioStateAuth = false;

  constructor(private router: Router) { }

  fazerLogin(usuario: Usuario): void {
    if (usuario.nome === 'usuario' && usuario.senha === '123456') {
      this.router.navigate(['/interpolacaoBiding']);
      this.usuarioStateAuth = true;
    }
    this.mostrarMenuEmitter.emit(this.usuarioStateAuth);
  }
}
