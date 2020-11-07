import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CursosService } from 'src/app/services/cursos.service';
import { PopupComponent } from 'src/app/shared/popup/popup.component';

interface Curso {
  id: number;
  curso: string;
}

@Component({
  selector: 'app-lista-cursos',
  templateUrl: './lista-cursos.component.html',
})
export class ListaCursosComponent implements OnInit {
  cursos$: Observable<Curso[]>;

  constructor(
    private serviceCurso: CursosService,
    private router: Router,
    private route: ActivatedRoute,
    private modal: PopupComponent
  ) {}
  ngOnInit(): void {
    this.cursos$ = this.serviceCurso.list();
  }

  onRefresh(): void {
    this.ngOnInit();
  }

  onEdit(id: number): void {
    this.router.navigate(['editar', id], { relativeTo: this.route });
  }

  onDelete(curso: any): void {
    this.serviceCurso
      .delete(curso)
      .subscribe(
        success => this.onRefresh(),
        error => console.error(error),
      );
  }
}
