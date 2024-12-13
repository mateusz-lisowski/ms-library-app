import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BooksListComponentComponent } from './books-list-component.component';

describe('BooksListComponentComponent', () => {
  let component: BooksListComponentComponent;
  let fixture: ComponentFixture<BooksListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BooksListComponentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BooksListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
