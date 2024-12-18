import {Component, inject} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms';
import {BookService} from '../book.service';
import {RentService} from '../rent.service';


@Component({
  selector: 'app-manage-rents',
  imports: [
    ReactiveFormsModule,
  ],
  templateUrl: './manage-rents.component.html',
  styleUrl: './manage-rents.component.css'
})
export class ManageRentsComponent {

  rentService: RentService = inject(RentService);

  rentBookForm = new FormGroup({
    bookId: new FormControl(''),
    memberId: new FormControl(''),
    dueDate: new FormControl(''),
  });

  returnBookForm = new FormGroup({
    rentId: new FormControl(''),
  });

  async submitBookRentForm() {
    await this.rentService.rentBook(
      this.rentBookForm.value.bookId!,
      this.rentBookForm.value.memberId!,
      this.rentBookForm.value.dueDate!,
    )
  }

  async submitReturnBookForm() {
    await this.rentService.returnBook(this.returnBookForm.value.rentId!)
  }

}
