import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Category } from '../category/model/category.model';
import { CategoryService } from '../category/service/category.service';
import { Product } from '../product/model/product.model';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  categories: Category[];
  errorMsg:string;
  product: Product[];
  count: number;
  username: string;
  loggedIn: boolean;
  constructor(private categoryService: CategoryService, private appService: AppService) { }

  ngOnInit(): void {
    this.appService.loggedIn.subscribe(data=>{

        let status = localStorage.getItem('isLoggedIn');
          if(status){
              this.loggedIn = true;
              let token = localStorage.getItem('token');
              token = atob(token);
              this.username = token.split(":")[0];
          }
          else{
              this.loggedIn = false;
          }
    });

    //subscribe to cart_product subject
    this.appService.cart_product.subscribe(data=>{
      this.product = data;
      this.count = this.product.length;
    });

    this.categoryService.getAllCategories().subscribe(data=>{
      this.categories = data;
    },
    error=>{
      this.errorMsg="Error in Loading Categories, Please contact Administrator";
    });
  }

  onLogOut(){
    localStorage.removeItem('token');
    localStorage.removeItem('isLoggedIn');
    this.loggedIn = false;
  }
}
