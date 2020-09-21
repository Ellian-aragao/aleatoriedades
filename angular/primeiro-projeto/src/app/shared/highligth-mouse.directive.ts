import { Directive, ElementRef, HostBinding, HostListener, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appHighligthMouse]'
})
export class HighligthMouseDirective {

  // private backgroundColor: string;
  // @HostBinding('style.backgroundColor') get setColor() {
  //   // código manipulando variável
  //   return this.backgroundColor;
  // }

  @HostBinding('style.backgroundColor') backgroundColor: string;
  @HostListener('mouseenter') onMouseOver() {
    this.backgroundColor = 'gray';
  }
  @HostListener('mouseleave') onMouseLeave() {
    this.backgroundColor = 'white';
  }
  constructor(
    // private renderer: Renderer2,
    // private elementeRef: ElementRef
  ) { }

  // @HostListener('mouseleave') onMouseLeave() {
  //   this.renderer.setStyle(
  //     this.elementeRef.nativeElement,
  //     'background-color',
  //     'white'
  //   );
  // }
  // @HostListener('mouseenter') onMouseOver() {
  //   this.backgroundColor = 'gray';
  //   this.renderer.setStyle(
  //     this.elementeRef.nativeElement,
  //     'background-color',
  //     'red'
  //   );
  // }
}
