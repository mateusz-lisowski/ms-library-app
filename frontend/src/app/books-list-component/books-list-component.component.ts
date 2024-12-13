import {Component, inject} from '@angular/core';
import {BookService} from '../book.service';
import {Book} from '../book';
import {BookDetailsComponent} from '../book-details/book-details.component';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-books-list-component',
  imports: [
    BookDetailsComponent,
    NgForOf
  ],
  templateUrl: './books-list-component.component.html',
  styleUrl: './books-list-component.component.css'
})
export class BooksListComponentComponent {

  bookService: BookService = inject(BookService);
  booksList: Book[] = [];

  constructor() {
    this.bookService.getBooks().then(books => {
      this.booksList = books;
    })
  }

}
