import {Component, inject} from '@angular/core';
import {BookService} from '../book.service';
import {Book} from '../book';
import {ActivatedRoute} from '@angular/router';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-book-manage',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './book-manage.component.html',
  styleUrl: './book-manage.component.css'
})
export class BookManageComponent {

  route: ActivatedRoute = inject(ActivatedRoute);
  bookService: BookService = inject(BookService);
  book: Book | null = null;

  constructor() {
    this.bookService.getBookById(this.route.snapshot.params['id']).then(book => {
      this.book = book;
    })
  }

  updateForm = new FormGroup({
    bookTitle: new FormControl(''),
    bookAuthor: new FormControl(''),
  });

  async submitForm() {
    await this.bookService.submitUpdateBookForm(
      this.route.snapshot.params['id'],
      this.updateForm.value.bookTitle!,
      this.updateForm.value.bookAuthor!,
    );
  }

  async deleteBook() {
    await this.bookService.deleteBook(this.route.snapshot.params['id']);
  }

}
