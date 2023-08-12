import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  // selector: 'p[appFundoAmarelo]'
  selector: '[appFundoAmarelo]'
})
export class FundoAmareloDirective {
  constructor(
    private elementeRef: ElementRef,
    private renderer: Renderer2) {
    this.renderer.setStyle(
      this.elementeRef.nativeElement,
      'background-color',
      'yellow'
    );
  }
}
