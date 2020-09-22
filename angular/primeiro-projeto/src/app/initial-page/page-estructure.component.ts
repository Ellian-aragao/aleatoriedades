import { Component } from '@angular/core';

import {  } from './initial-page.module';
import {  } from '../shared/shared.module';

@Component({
  selector: 'app-page-estructure',
  templateUrl: './page-estructure.component.html',
})
export class PageEstructureComponent {

  initialNumberContador = 10;

  alertValue(value: number): void {
    console.log(`o valor atual é ${value}`);
  }
}
