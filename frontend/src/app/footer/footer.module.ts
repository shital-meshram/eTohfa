import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterpageComponent } from './footerpage/footerpage.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [FooterpageComponent],
  imports: [
    CommonModule, RouterModule
  ],
  exports:[FooterpageComponent]
})
export class FooterModule { }
