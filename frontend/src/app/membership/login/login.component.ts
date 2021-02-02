import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import {NgForm} from '@angular/forms';
import { RegServiceService } from '../reg-service.service';
import { User } from '../user.model';
import { Employee } from '../employee';
import { EmployeeRegistrationComponent } from '../employee-registration/employee-registration.component';
import { interval, Observable } from 'rxjs';
import { Customer } from '../customer';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  employeeList : Observable<Employee[]>;
  admin : Employee;
  greetings="";
  customer=new Customer();
  userName:string;
  msg:string = "";
  loginStatus:boolean=false;
  buttonText:any;
  constructor(private service : RegServiceService, private route : Router) { }

  ngOnInit(): void {
    this.service.getUsers();

  }

  loginUser()
  {
    this.service.loginUserFromRAPI(this.customer.email, this.customer.password).subscribe(
      data=>{ console.log("response received")
      this.customer=data as Customer;
      sessionStorage.setItem('currentUser', JSON.stringify({customer:this.customer}))
      console.log(data)
      
      this.loginStatus=true;

      if(data==null)
      {
        alert("bad credentials");
      }else{
        alert("Login Successfull");
      }
      
      if(this.route.url=='/loginOnOrderPage')
      {
        this.route.navigate(['orderProduct'])
      }else{
        this.route.navigate([''])
      }
      
    },
      error=> {console.log("exception occured");
      this.msg="bad credentials please reenter the credentials";
    } 
    )
  }
  currentUser()
  {
    this.greetings="Welcome "+localStorage.getItem('currentUser');
  } 

}
