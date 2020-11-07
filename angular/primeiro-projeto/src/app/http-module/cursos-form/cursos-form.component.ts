import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Location } from '@angular/common';

import { CursosService } from 'src/app/services/cursos.service';
import { ActivatedRoute } from '@angular/router';
import { map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-cursos-form',
  templateUrl: './cursos-form.component.html',
})
export class CursosFormComponent implements OnInit {
  form: FormGroup;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private service: CursosService,
    private location: Location,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // this.route.params
    //   .pipe(
    //     map((params) => params.id),
    //     switchMap((id) => this.service.loadById(id))
    //   )
    //   .subscribe((curso: { id: number; curso: string }) => {
    //     this.form.patchValue({
    //       id: curso.id,
    //       curso: curso.curso,
    //     });
    //   });

    const curso = this.route.snapshot.data.curso;

    this.form = this.formBuilder.group({
      id: [curso.id],
      curso: [
        curso.curso,
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(250),
        ],
      ],
    });
  }

  onSubmit(): void {
    this.submitted = true;
    if (!this.form.get('curso').errors) {
      console.log('submitted');
      this.service.save(this.form.value).subscribe(
        (success) => {
          console.log(success);
          this.location.back();
        },
        (error) => console.log(error),
        () => console.log('complete')
      );
    }
  }

  onCancel(): void {
    this.submitted = false;
    this.form.reset();
    console.log('cancel');
  }
}
