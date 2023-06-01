import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthRegisterRequest, AuthRequest } from 'app/models/auth';
import {environment} from '../../environments/environment';

const prefix = '/auth';
const host = environment.backendEndpoint;
const TOKEN_NAME = 'TOKEN_BIEDA_MPK'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private readonly http: HttpClient) { }

  signIn = (requestBody: AuthRequest): Observable<String> => this.http.post<string>(`${host}${prefix}/authenticate`, requestBody);

  signUp = (requestBody: AuthRegisterRequest): Observable<String> => this.http.post<string>(`${host}${prefix}/passenger/register`, requestBody);

  getAuthorizationToken = () => localStorage.getItem(TOKEN_NAME);


}
