import { Component, OnInit, OnDestroy } from '@angular/core';

import { Post } from './models/post.model';
import { Comment } from './models/comment.model';
import { User } from './models/user.model';
import { PostService } from './services/post.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {

  name: string;
  x: number;
  y: number;

  nums: number[];
  showArry: boolean;
  showAddress: boolean;
  tempArray: number[];

  posts: Post[];
  commentDataArry: Comment[];
  postTitle: string;
  user: User;

  //constructors are used to inject the services...
  constructor(public postService: PostService) {

  }

  //Lifecycle Hook : Called when the component is about to initialize instance variables
  ngOnInit(): void {
    console.log('init called...');
    this.name = 'Harry Potter';
    this.x = 10;
    this.y = 20;

    this.nums = [1, 2, 3, 4, 5, 6, 7, 8];
    this.showArry = false;
    this.showAddress = false;
    this.tempArray = this.nums;

    //if i can reach out to service class and call getter???
    this.posts = this.postService.getPosts();
    this.commentDataArry = [];
    this.postTitle = '';
  }
  //Lifecycle Hooks 
  showArrayContent() {
    this.showArry = true;
  }

  showAddressContent = () => {
    this.showAddress = !this.showAddress;
  }

  showAllNumbers = () => {
    this.tempArray = this.nums;
  }

  showAllEvenNumbers = () => {
    this.tempArray = this.nums.filter(e => e % 2 === 0);
  }

  showAllOddNumbers = () => {
    this.tempArray = this.nums.filter(e => e % 2 === 1);
  }

  showComment = (postId: number) => {
    this.commentDataArry = this.postService.getCommentsByPostId(postId);
    this.postTitle = this.postService.getPostTitleById(postId);
  }

  showUserDetails = (postId: number, userId: number) => {
    this.user = this.postService.getUserById(userId);

  }

  //Lifecycle hook that gets called whenever the control moves away from this component
  //switching to another screen. 
  ngOnDestroy(): void {

  }
}
