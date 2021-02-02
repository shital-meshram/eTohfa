import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactUsComponent } from './contact-us/contact-us/contact-us.component';
import { HomeComponent } from './home/home/home.component';
import { EmployeeLoginComponent } from './membership/employee-login/employee-login.component';
import { EmployeeRegistrationComponent } from './membership/employee-registration/employee-registration.component';
import { LoginSuccessComponent } from './membership/login-success/login-success.component';
import { LoginComponent } from './membership/login/login.component';
import { RegistrationComponent } from './membership/registration/registration.component';
import { AddNewCategoryComponent } from './product-inventry/add-new-category/add-new-category.component';
import { AddNewProductComponent } from './product-inventry/add-new-product/add-new-product.component';
import { CustomerViewProductComponent } from './product-inventry/customer-view-product/customer-view-product.component';
import { DeleteProductComponent } from './product-inventry/delete-product/delete-product.component';
import { DisplayAllOrdersComponent } from './product-inventry/display-all-orders/display-all-orders.component';
import { GetAllCategoryComponent } from './product-inventry/get-all-category/get-all-category.component';
import { GetAllProductComponent } from './product-inventry/get-all-product/get-all-product.component';
import { OrderProductComponent } from './product-inventry/order-product/order-product.component';
import { ShoppingCartComponent } from './product-inventry/shopping-cart/shopping-cart.component';
import { ShowProductByCategoryComponent } from './product-inventry/show-product-by-category/show-product-by-category.component';
import { UpdateProductComponent } from './product-inventry/update-product/update-product.component';
import { ViewProductComponent } from './product-inventry/view-product/view-product.component';

const routes: Routes = [
  {path:"", component:HomeComponent},
  {path:"loginform", component:LoginComponent},
  {path:"loginOnOrderPage", component:LoginComponent},
  {path:"loginSuccessfull", component:LoginSuccessComponent},
  {path:"UserRegistrationform", component:RegistrationComponent},
  {path:"getAllProducts", component:GetAllProductComponent},
  {path:"aboutus", component:AboutusComponent},
  {path:"addNewProduct", component:AddNewProductComponent},
  {path:"updateProduct/:id", component:UpdateProductComponent},
  {path:"customerviewproduct", component:CustomerViewProductComponent},
  {path:"employeeRegistration", component:EmployeeRegistrationComponent},
  {path:"viewProduct/:id",component:ViewProductComponent},
  {path:"addNewCategory",component:AddNewCategoryComponent},
  {path:"getAllCategories",component:GetAllCategoryComponent},
  {path:"showProductByCategory/:id",component:ShowProductByCategoryComponent},
  {path:"employeeLogin", component:EmployeeLoginComponent},
  {path:"shoppingCart", component:ShoppingCartComponent},
  {path:"getAllOrders", component:DisplayAllOrdersComponent},
  {path:"orderProduct",component:OrderProductComponent},
  {path:"deleteProduct/:id", component:DeleteProductComponent},
  {path:"contactUs",component:ContactUsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
