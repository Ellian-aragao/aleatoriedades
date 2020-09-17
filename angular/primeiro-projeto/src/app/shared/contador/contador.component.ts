import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-contador',
  template: `
  <div class="mt-2">
    <button (click)="onDecrement()">-</button>
    <input type="number" [value]="value" readonly>
    <button (click)="onIncrement()">+</button>
  </div>`
})
export class ContadorComponent {

  @Input() value = 0;

  @Output() changedValue = new EventEmitter();

  onIncrement(): void {
    this.eventEmitter(++this.value);
  }

  onDecrement(): void {
    this.eventEmitter(--this.value);
  }

  eventEmitter(value:number):void {
    this.changedValue.emit({value});
  }
}
