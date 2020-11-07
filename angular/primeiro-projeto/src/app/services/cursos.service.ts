import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { delay, take, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CursosService {
  private readonly API = `${environment.API}cursos`;

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

  constructor(private http: HttpClient) {}

  list(): any {
    return this.http
      .get(this.API)
      .pipe(delay(0), tap(console.log));
  }

  getCursos(): string[] {
    return this.cursos;
  }

  addCursos(curso: string): void {
    this.cursos.push(curso);
  }

  private create(curso): Observable<object> {
    return this.http.post(this.API, curso).pipe(take(1));
  }
  loadById(id): Observable<object> {
    return this.http.get(`${this.API}/${id}`).pipe(take(1));
  }
  private update(curso): Observable<object> {
    return this.http
      .put(`${this.API}/${curso.id}`, curso)
      .pipe(take(1));
  }
  save(curso) {
    if (curso.id) {
      return this.update(curso);
    }
    return this.create(curso);
  }
  delete(curso) {
    return this.http.delete(`${this.API}/${curso.id}`).pipe(take(1));
  }
}
