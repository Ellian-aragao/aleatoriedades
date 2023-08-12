import { Component } from '@angular/core';

import { CursosService } from 'src/app/services/cursos.service';

@Component({
  selector: 'app-adiciona-curso',
  templateUrl: './adiciona-curso.component.html',
})
export class AdicionaCursoComponent {

  constructor(private cursosService: CursosService){}

  addCurso(curso: string): void {
    this.cursosService.addCursos(curso);
  }
}
