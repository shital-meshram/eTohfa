import { Component, OnInit } from '@angular/core';
import { RegServiceService } from '../reg-service.service';
import { User } from '../user.model';
import {NgForm} from '@angular/forms';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {


  newuser=new User();

  data:any;
  constructor(private service:RegServiceService) { }

  ngOnInit(): void {
  }

 

    registerUser()
    {
      this.service.RegisterUserFromRAPI(this.newuser).subscribe(
      
        data=>{ 
          console.log("response received"+this.newuser.fname)
          alert("Registration Successfull")
      },error=>{
        console.log("enter corrected data")
      }
      
      )

  }
}

