import { postsArry } from '../data/data';
import { commentData } from '../data/data';
import { userData } from '../data/data';
import { Post } from '../models/post.model';
import { User } from '../models/user.model';
import { Comment } from '../models/comment.model';
import { Injectable } from '@angular/core';
@Injectable()
export class PostService {

    posts: Post[];
    comments: Comment[];
    users: User[];

    constructor() {
        this.posts = postsArry;
        this.comments = commentData;
        this.users = userData;
    }

    public getPosts(): Post[] {
        return this.posts;
    }

    public getComments(): Comment[] {
        return this.comments;
    }

    public getUsers(): User[] {
        return this.users;
    }

    public getCommentsByPostId(postId: number): Comment[] {
        return this.comments.filter(e => e.postId === postId);
    }

    public getPostTitleById(postId: number): string {
        return this.posts.find(e => e.id === postId).title;
    }

    getUserById(userId: number): User {
        return this.users.find(u => u.id === userId);
    }
}