import { Component } from '@angular/core';

import { AuthService } from '../services/auth.service';
import { Usuario } from '../shared/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent {

  usuario: Usuario = {
    nome: '',
    senha: ''
  };

  constructor(private authService: AuthService) { }

  loginUsuario(usuarioForm: Usuario): void {
    console.log(this.authService.fazerLogin(usuarioForm));
  }
}
