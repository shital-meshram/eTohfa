import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { ProductServiceService } from '../product-service.service';
import { Products } from '../products.model';

@Component({
  selector: 'app-add-new-product',
  templateUrl: './add-new-product.component.html',
  styleUrls: ['./add-new-product.component.css']
})
export class AddNewProductComponent implements OnInit {

  product= new Products();
  category_id:number ;
  categoryList:Category[];
  newVal:number;
  constructor(private service:ProductServiceService) { }

  ngOnInit(): void {
    this.getCategoryList();
  }

  onChange(event):any
  {
    this.newVal=event.target.value;
    console.log(this.newVal);
    this.category_id= this.newVal;
  }

  addNewProduct()
  {
    console.log(this.category_id);
    this.service.addNewProduct(this.category_id, this.product).subscribe(
      data=>{
        console.log(data);
        alert("data added successfully..!!");
      },error=>console.log("unable to save product")
    );
  }

  getCategoryList()
  {
    this.service.getCategoriesList().subscribe(
      data=>{
        this.categoryList= data as Category[];
        console.log(this.categoryList);
      },error=>{
        console.log("unable to fetch data")
      }
    );
  }


}
