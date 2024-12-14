import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MembersListComponentComponent } from './members-list-component.component';

describe('MembersListComponentComponent', () => {
  let component: MembersListComponentComponent;
  let fixture: ComponentFixture<MembersListComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MembersListComponentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MembersListComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
