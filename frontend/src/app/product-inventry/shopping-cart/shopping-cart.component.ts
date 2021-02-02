import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductServiceService } from '../product-service.service';
// import { threadId } from 'worker_threads';
import { Products } from '../products.model';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  cartArray:Products[]=[];
  productId:number;
  i:number;
  data:JSON;
  constructor(private  route: Router) { }

  ngOnInit(): void {
    this.getSelectedProduct();
  }

  getSelectedProduct(){
    this.cartArray=JSON.parse(sessionStorage.getItem('shoppingCart'));
    console.log(JSON.parse(sessionStorage.getItem('shoppingCart')));
   
    console.log(this.cartArray);
    
  }

  checkUserLoginStatus()
  {
    if(sessionStorage.getItem("currentUser")==null)
    {
      this.route.navigate(['/loginOnOrderPage']);
    }else{
      this.route.navigate(['orderProduct']);
    }
  }

}
