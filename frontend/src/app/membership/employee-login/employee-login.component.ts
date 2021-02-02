import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { RegServiceService } from '../reg-service.service';

@Component({
  selector: 'app-employee-login',
  templateUrl: './employee-login.component.html',
  styleUrls: ['./employee-login.component.css']
})
export class EmployeeLoginComponent implements OnInit {

  msg:string = "";
  empName:string;
  employee = new Employee();
  constructor(private service : RegServiceService, private route : Router) { }

  ngOnInit(): void {
  }

  loginEmployee(){
    this.service.loginEmployeeFromRAPI(this.employee.email, this.employee.password).subscribe(
      data=>{ console.log("response received")
      this.employee= data as Employee;
      this.empName=this.employee.ename;
      localStorage.setItem('currentEmployee', JSON.stringify({name:this.empName}))
      console.log(data);
      this.route.navigate(['/getAllProducts'])

      if(data==null)
      {
        alert("bad credentials")
      }else{
        alert("login successfull")
      }
    },
     
      error=> {console.log("exception occured");
      alert("login fail");
      this.msg="bad credentials please reenter the credentials";
    }
      
    )
  }
}
