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

  async getBookById(id: string): Promise<Book | null> {
    const data = await fetch(`${this.url}/${id}`);
    return await data.json() ?? null;
  }

  async submitAddBookForm(id: string, title: string, author: string) {
    await fetch(this.url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        id: id,
        title: title,
        author: author
      })
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
    window.location.reload();
  }

  async submitUpdateBookForm(id: string, title: string, author: string) {
    await fetch(`${this.url}/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        title: title,
        author: author
      })
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', data);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
    window.location.reload();
  }

  async deleteBook(id: string) {
    await fetch(`${this.url}/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      },
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success, book deleted:', data);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
    window.location.href = '/books';
  }
}
