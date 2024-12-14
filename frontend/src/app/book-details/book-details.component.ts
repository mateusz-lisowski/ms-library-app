import {Component, Input} from '@angular/core';
import {Book} from '../book';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-book-details',
  imports: [
    RouterLink
  ],
  templateUrl: './book-details.component.html',
  styleUrl: './book-details.component.css'
})
export class BookDetailsComponent {
  @Input() book!: Book;
}
