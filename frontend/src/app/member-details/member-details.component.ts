import {Component, Input} from '@angular/core';
import {Member} from '../member';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-member-details',
  imports: [
    RouterLink
  ],
  templateUrl: './member-details.component.html',
  styleUrl: './member-details.component.css'
})
export class MemberDetailsComponent {
  @Input() member!: Member;
}
