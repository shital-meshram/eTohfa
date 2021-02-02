import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { GetAllProductComponent } from '../product-inventry/get-all-product/get-all-product.component';
import { ProductInventryModule } from '../product-inventry/product-inventry.module';


import { NavbarComponent } from './navbar/navbar.component';


@NgModule({
  declarations: [NavbarComponent],
  imports: [
    CommonModule, RouterModule,ProductInventryModule
  ],
  exports:[NavbarComponent]
})
export class NavigationModule { }
