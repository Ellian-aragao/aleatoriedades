import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngfor',
  templateUrl: './ngfor.component.html',
})
export class NgforComponent {

  cursos: string[] = [
    'Git',
    'Github/Gitlab',
    'C/C++',
    'Java',
    'Python',
    'Spring Boot',
    'JDBC'
  ];
}
