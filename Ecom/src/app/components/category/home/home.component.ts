import { Component, OnInit } from '@angular/core';
import { Category } from '../model/category.model';
import { Post } from '../model/post.model';
import { CategoryService } from '../service/category.service';

@Component({
  selector: 'app-category-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class CategoryHomeComponent implements OnInit {

  /*
    Reach out to service(CategoryService) which will provide the data.
  */
 categories: Category[];
 errorMsg:string;

  constructor(private categoryService: CategoryService ) { }

  ngOnInit(): void {
    this.categoryService.getAllCategories().subscribe(data=>{
      this.categories = data;
    },
    error=>{
      this.errorMsg="Error in Loading Categories, Please contact Administrator";
    });
  }

}
