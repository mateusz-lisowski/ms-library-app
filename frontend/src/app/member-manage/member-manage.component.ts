import {Component, inject} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ActivatedRoute} from '@angular/router';
import {BookService} from '../book.service';
import {Book} from '../book';
import {MemberService} from '../member.service';
import {Member} from '../member';
import {Rent} from '../rent';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-member-manage',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    NgForOf
  ],
  templateUrl: './member-manage.component.html',
  styleUrl: './member-manage.component.css'
})
export class MemberManageComponent {

  route: ActivatedRoute = inject(ActivatedRoute);
  memberService: MemberService = inject(MemberService);
  member: Member | null = null;
  pendingMemberRents: Rent[] = [];
  returnedMemberRents: Rent[] = [];

  constructor() {
    this.memberService.getMemberById(this.route.snapshot.params['id']).then(member => {
      this.member = member;
    })
    this.memberService.getPendingMemberRents(this.route.snapshot.params['id']).then(members => {
      this.pendingMemberRents = members;
    });
    this.memberService.getReturnedMemberRents(this.route.snapshot.params['id']).then(members => {
      this.returnedMemberRents = members;
    });
  }

  updateForm = new FormGroup({
    memberFirstname: new FormControl(`${this.member?.firstname}`),
    memberLastname: new FormControl(`${this.member?.lastname}`),
  });

  async submitForm() {
    await this.memberService.submitUpdateMemberForm(
      this.route.snapshot.params['id'],
      this.updateForm.value.memberFirstname!,
      this.updateForm.value.memberLastname!,
    );
  }

  async deleteMember() {
    await this.memberService.deleteMember(this.route.snapshot.params['id']);
  }

}
