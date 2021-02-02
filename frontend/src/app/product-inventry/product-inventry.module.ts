import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';


import { GetAllProductComponent } from './get-all-product/get-all-product.component';
import { AddNewProductComponent } from './add-new-product/add-new-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { GetAllCategoryComponent } from './get-all-category/get-all-category.component';
import { FormsModule } from '@angular/forms';
import { CustomerViewProductComponent } from './customer-view-product/customer-view-product.component';
import { ViewProductComponent } from './view-product/view-product.component';
import { AddNewCategoryComponent } from './add-new-category/add-new-category.component';
import { ShowProductByCategoryComponent } from './show-product-by-category/show-product-by-category.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { OrderProductComponent } from './order-product/order-product.component';
import { DisplayAllOrdersComponent } from './display-all-orders/display-all-orders.component';
import { DeleteProductComponent } from './delete-product/delete-product.component';



@NgModule({
  declarations: [GetAllProductComponent, AddNewProductComponent, UpdateProductComponent, GetAllCategoryComponent, CustomerViewProductComponent, ViewProductComponent, AddNewCategoryComponent, ShowProductByCategoryComponent, ShoppingCartComponent, OrderProductComponent, DisplayAllOrdersComponent, DeleteProductComponent],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    RouterModule
   
  ],
  exports : [GetAllProductComponent,AddNewProductComponent, UpdateProductComponent, CustomerViewProductComponent, ViewProductComponent]
})
export class ProductInventryModule { }
