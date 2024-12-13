import { Injectable } from '@angular/core';
import {Book} from './book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  url = 'http://localhost:8222/api/v1/books';

  async getBooks(): Promise<Book[]> {
    const data = await fetch(this.url);
    return await data.json() ?? [];
  }
}
