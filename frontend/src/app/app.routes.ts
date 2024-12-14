import { Routes } from '@angular/router';
import {BooksListComponentComponent} from './books-list-component/books-list-component.component';
import {MembersListComponentComponent} from './members-list-component/members-list-component.component';
import {HomeComponent} from './home/home.component';
import {BookManageComponent} from './book-manage/book-manage.component';

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'Home Page',
  },
  {
    path: 'books',
    component: BooksListComponentComponent,
    title: 'Books Page',
  },
  {
    path: 'books/:id',
    component: BookManageComponent,
    title: 'Book Manage Page',
  },
  {
    path: 'members',
    component: MembersListComponentComponent,
    title: 'Members Page',
  }
];
