export interface Rent {
  id: string;
  lendDate: string;
  dueDate: string;
  returnDate: string | null;
  bookId: string;
  memberId: string;
}
