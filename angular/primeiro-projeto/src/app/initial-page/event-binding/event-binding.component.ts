import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-binding',
  templateUrl: './event-binding.component.html',
})
export class EventBindingComponent{
  inputText: string;
  savedText: string;
  
  botaoClicado(): void {
    this.savedText = this.inputText;
  }

  enterDigitado():void {
    this.savedText = this.inputText;
  }

  digitando(event: KeyboardEvent): void {
    this.inputText = (event.target as HTMLInputElement).value;
  }
}
