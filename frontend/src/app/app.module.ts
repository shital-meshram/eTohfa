import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MembershipModule } from './membership/membership.module';
import { NavigationModule } from './navigation/navigation.module';
import { HomeModule } from './home/home.module';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { AboutusComponent } from './aboutus/aboutus.component';
import { FooterModule } from './footer/footer.module';
import { AddNewProductComponent } from './product-inventry/add-new-product/add-new-product.component';
import { Products } from './product-inventry/products.model';
import { ProductInventryModule } from './product-inventry/product-inventry.module';

@NgModule({
  declarations: [
    AppComponent,
    AboutusComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    AppRoutingModule,
    MembershipModule,
    NavigationModule,
    HttpClientModule,
    HomeModule,
    RouterModule,
    NgbModule,
    FooterModule,
    ProductInventryModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
