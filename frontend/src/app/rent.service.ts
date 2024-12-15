import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RentService {

  url = 'http://localhost:8222/api/v1/rents';

  async rentBook(bookId: string, memberId: string, dueDate: string) {
    await fetch(this.url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        bookId: bookId,
        memberId: memberId,
        dueDate: dueDate
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

  async returnBook(rentId: string) {
    await fetch(`${this.url}/${rentId}`);
    window.location.reload();
  }

}
