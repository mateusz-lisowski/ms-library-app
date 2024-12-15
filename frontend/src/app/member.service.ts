import { Injectable } from '@angular/core';
import {Member} from './member';
import {Rent} from './rent';

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  url = 'http://localhost:8222/api/v1/members';
  rentsUrl = 'http://localhost:8222/api/v1/rents';

  async getMembers(): Promise<Member[]> {
    const data = await fetch(this.url);
    return await data.json() ?? [];
  }

  async getMemberById(id: string): Promise<Member | null> {
    const data = await fetch(`${this.url}/${id}`);
    return await data.json() ?? null;
  }

  async getPendingMemberRents(memberId: string): Promise<Rent[]> {
    const data = await fetch(`${this.rentsUrl}/check/due/member/${memberId}`);
    return await data.json() ?? [];
  }

  async getAllMemberRents(memberId: string): Promise<Rent[]> {
    const data = await fetch(`${this.rentsUrl}/check/member/${memberId}`);
    return await data.json() ?? [];
  }

  async getReturnedMemberRents(memberId: string): Promise<Rent[]> {
    const allRents = await this.getAllMemberRents(memberId);
    const filterRents = await this.getPendingMemberRents(memberId);
    return allRents.filter(rent =>
      !filterRents.some(filterRent => filterRent.id === rent.id)
    );
  }

  async submitAddMemberForm(id: string, firstname: string, lastname: string) {
    await fetch(this.url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        id: id,
        firstname: firstname,
        lastname: lastname
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

  async submitUpdateMemberForm(id: string, firstname: string, lastname: string) {
    await fetch(`${this.url}/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        firstname: firstname,
        lastname: lastname,
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

  async deleteMember(id: string) {
    await fetch(`${this.url}/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      },
    })
      .then(response => response.json())
      .then(data => {
        console.log('Success, member deleted:', data);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
    window.location.href = '/members';
  }
}
