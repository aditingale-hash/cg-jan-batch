import { Component, OnInit } from '@angular/core';
import { Post } from '../../models/post.model';
import { User } from '../../models/user.model';
import { Comment } from '../../models/comment.model';
import { PostService } from '../../services/post.service';

@Component({
  selector: 'app-post-grid',
  templateUrl: './post-grid.component.html',
  styleUrls: ['./post-grid.component.css']
})
export class PostGridComponent implements OnInit {

  posts: Post[];
  commentDataArry: Comment[];
  postTitle: string;
  user: User;

  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.posts = this.postService.getPosts();
    this.commentDataArry = [];
    this.postTitle = '';
  }

  showComment = (postId: number) => {
    this.commentDataArry = this.postService.getCommentsByPostId(postId);
    this.postTitle = this.postService.getPostTitleById(postId);
  }

  showUserDetails = (postId: number, userId: number) => {
    this.user = this.postService.getUserById(userId);
  }
}
