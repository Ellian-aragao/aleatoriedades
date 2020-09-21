import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  cursos: string[] = [
    'Git',
    'Github/Gitlab',
    'C/C++',
    'Java',
    'Python',
    'Spring Boot',
    'JDBC'
  ];

  getCursos(): string[] {
    return this.cursos;
  }

  addCursos(curso: string): void {
    this.cursos.push(curso);
  }
}
