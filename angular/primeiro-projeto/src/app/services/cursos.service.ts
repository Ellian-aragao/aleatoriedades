import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  cursos: string[] = [
    'git',
    'github',
    'gitlab',
    'c',
    'c++',
    'java',
    'python',
    'spring boot',
    'JDBC',
    'JPA',
  ];

  getCursos(): string[] {
    return this.cursos;
  }

  addCursos(curso: string): void {
    this.cursos.push(curso);
  }
}
