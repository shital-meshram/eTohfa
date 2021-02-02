import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { interval, Subscription } from 'rxjs';
import { ProductServiceService } from 'src/app/product-inventry/product-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  greetings="";
  name:"";
  loginStatus:boolean=false;
  constructor(private _router:Router) { }

  ngOnInit(): void {
    this.checkStatus();
  }

  navigateToLoginPage()
  {
    this._router.navigate(['/login']);
  }

  currentUser()
  {
    this.name=JSON.parse(localStorage.getItem('currentUser'));
    
  }

  checkStatus()
  {
    if(sessionStorage.getItem('currentUser')!=null)
    {
      this.loginStatus=true;
    }
  }

  currentEmployee()
  {
    if(JSON.parse(localStorage.getItem('currentEmployee'))==null)
    {
      return 'user';
    }else{
      return 'admin';
    }
  }

  logoutUser()
  {
    if(sessionStorage.getItem("currentUser")!=null)
    {
    sessionStorage.removeItem("currentUser");
    sessionStorage.removeItem("shoppingCart");
    sessionStorage.removeItem("productPrice");
    alert("Logout successfull")
    }else{
      alert("you have'nt log in")
    }
  }


}
