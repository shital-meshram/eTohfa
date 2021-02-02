import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from '../products.model';
import { ProductServiceService } from '../product-service.service';
import { Customer } from 'src/app/membership/customer';

@Component({
  selector: 'app-customer-view-product',
  templateUrl: './customer-view-product.component.html',
  styleUrls: ['./customer-view-product.component.css']
})
export class CustomerViewProductComponent implements OnInit {

  products:Products[];
  cartProduct:Products;
  cartArray:Products[]=[];
  currentUser:string;
  productAmount:number[]=[];
  constructor(private service:ProductServiceService, private router:Router) { }

  ngOnInit(): void {
    this.getProductList();
  }

  getProductList() {
    this.service.getProductList().subscribe(
      data=>{
        this.products=data as Products[];
        console.log("Data Received");
      },error=>{
        console.log("data receiver fails..!!");
      }
    );
  }

  shoppingCart:number[]=[];

  AddToCart(prodId)
  {
    //console.log("shopping cart id "+prodId);
    //sessionStorage.setItem('shoppingCart', JSON.stringify({productId:prodId}));
    this.service.getProductById(prodId).subscribe(
      data=>{
        this.cartProduct= data as Products;
        this.cartArray.push(this.cartProduct);
        this.productAmount.push(this.cartProduct.price);
        //this.currentUser=sessionStorage.getItem('currentUser');
        sessionStorage.setItem('shoppingCart', JSON.stringify({products :this.cartArray}));
        sessionStorage.setItem('productPrice', JSON.stringify({amount :this.productAmount}));
        alert("Product Added Successfully..!!")
        
      },error=>console.log("Failed to add data into shopping cart")
    );
    //this.cartArray.push(this.cartProduct);
  }

}
