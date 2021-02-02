import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';


import { HomeComponent } from './home/home.component';
import { NavigationModule } from '../navigation/navigation.module';
import { MembershipModule } from '../membership/membership.module';
import { FooterModule } from '../footer/footer.module';
import { ProductInventryModule } from '../product-inventry/product-inventry.module';


@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    NavigationModule,
    MembershipModule,
    RouterModule,
    FooterModule,
    ProductInventryModule
    
  ],
  exports:[HomeComponent]
})
export class HomeModule { }
