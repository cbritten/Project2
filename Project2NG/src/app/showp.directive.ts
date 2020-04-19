import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appShowp]'
})
export class ShowpDirective {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }
  toggleFlag =false;

  @HostListener('click')
  performTask(){
    this.toggleFlag = (this.toggleFlag==true)? false : true;
    if(this.toggleFlag){
      this.renderer.setAttribute(this.elRef.nativeElement,'type','text');
      this.renderer.setStyle(this.elRef.nativeElement,'font-size','large');
    }else{
      this.renderer.setAttribute(this.elRef.nativeElement,'type','password');
    }
  }

}
