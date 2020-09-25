import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-data-form',
  templateUrl: './data-form.component.html',
})
export class DataFormComponent implements OnInit {

  formulario: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.formulario = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.email]),
      nome: new FormControl(null, Validators.required),
    });

    // this.formulario = this.formBuilder.group({
    //   nome: [null, Validators.required],
    //   email: [null, [Validators.required, Validators.email]]
    // });
  }

  onSubmit(): void {
    console.log('submit');
    console.log(this.formulario.value);
  }
}
