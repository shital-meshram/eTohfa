import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { ProductServiceService } from '../product-service.service';
import { Products } from '../products.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  category_id:number;
  existingProduct=new Products();
  productIdUpdate: number;
  updateProduct=new Products();
  categoryList:Category[];
  newVal:any;
  category_id_for_getproductbyid:number;

  constructor(private service: ProductServiceService, private router:ActivatedRoute) { }

  ngOnInit(): void {
    console.log(this.router.snapshot.params.id);
    this.productIdUpdate=this.router.snapshot.params.id;
    this.getProductById(this.router.snapshot.params.id);
    this.getCategoryList();
  }

  getProductById(category_id_for_getproductbyid)
  {
    this.service.getProductById(category_id_for_getproductbyid).subscribe(
      data=>{
        this.existingProduct= data as Products;
        console.log(this.existingProduct.prodId);
        console.log("data received");
      },error=>{
        console.log("data not received");
      }
    );
    
  }

  onChange(event):any
  {
    this.newVal=event.target.value;
    console.log(this.newVal);
    this.category_id= this.newVal;
  }


  updateExistingProduct()
  {
    this.service.updateProductDetails(this.productIdUpdate, this.existingProduct).subscribe(
      data=>{
        this.updateProduct= data as Products;
        console.log(this.updateProduct)
        alert("Product Updated Successfully..!")
      },error=>
      {
        console.log("data updation cancled")
      }
      )
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
