import {Component, inject} from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgForOf} from '@angular/common';
import {Member} from '../member';
import {MemberService} from '../member.service';
import {MemberDetailsComponent} from '../member-details/member-details.component';

@Component({
  selector: 'app-members-list-component',
  imports: [
    FormsModule,
    NgForOf,
    ReactiveFormsModule,
    MemberDetailsComponent
  ],
  templateUrl: './members-list-component.component.html',
  styleUrl: './members-list-component.component.css'
})
export class MembersListComponentComponent {

  memberService: MemberService = inject(MemberService);
  membersList: Member[] = [];


  constructor() {
    this.memberService.getMembers().then(members => {
      this.membersList = members;
    })
  }

  addForm = new FormGroup({
    memberId: new FormControl(''),
    memberFirstname: new FormControl(''),
    memberLastname: new FormControl(''),
  });

  async submitForm() {
    await this.memberService.submitAddMemberForm(
      this.addForm.value.memberId!,
      this.addForm.value.memberFirstname!,
      this.addForm.value.memberLastname!,
    );
  }

}
