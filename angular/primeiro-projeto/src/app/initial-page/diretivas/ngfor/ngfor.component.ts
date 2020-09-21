import { Component, OnInit } from '@angular/core';
import { CursosService } from '../../../services/cursos.service';

@Component({
  selector: 'app-ngfor',
  templateUrl: './ngfor.component.html',
})
export class NgforComponent implements OnInit {

  cursos: string[];

  constructor(private cursosService: CursosService) {}
  ngOnInit(): void {
    this.cursos = this.cursosService.getCursos();
  }
}
