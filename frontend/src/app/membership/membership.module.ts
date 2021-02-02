import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { EmployeeRegistrationComponent } from './employee-registration/employee-registration.component';
import { EmployeeLoginComponent } from './employee-login/employee-login.component';
import { HomeModule } from '../home/home.module';
import { FooterModule } from '../footer/footer.module';
import { NavigationModule } from '../navigation/navigation.module';



@NgModule({
  declarations: [LoginComponent, RegistrationComponent, LoginSuccessComponent, EmployeeRegistrationComponent, EmployeeLoginComponent],
  imports: [
    CommonModule, FormsModule, HttpClientModule, RouterModule,FooterModule, NavigationModule
  ],
  exports:[LoginComponent, RegistrationComponent, LoginSuccessComponent]
})
export class MembershipModule { }
